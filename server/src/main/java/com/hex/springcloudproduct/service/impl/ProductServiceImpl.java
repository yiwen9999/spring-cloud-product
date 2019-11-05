package com.hex.springcloudproduct.service.impl;

import com.hex.springcloudproduct.common.DecreaseStockInput;
import com.hex.springcloudproduct.common.ProductInfoOutPut;
import com.hex.springcloudproduct.dataobject.ProductInfo;
import com.hex.springcloudproduct.enums.ProductStatusEnum;
import com.hex.springcloudproduct.enums.ResultEnum;
import com.hex.springcloudproduct.exception.ProductException;
import com.hex.springcloudproduct.repository.ProductInfoRepository;
import com.hex.springcloudproduct.service.ProductService;
import com.hex.springcloudproduct.utils.JsonUtil;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 2:23 PM
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoOutPut> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList).stream()
                .map(e -> {
                    ProductInfoOutPut productInfoOutPut = new ProductInfoOutPut();
                    BeanUtils.copyProperties(e, productInfoOutPut);
                    return productInfoOutPut;
                }).collect(Collectors.toList());
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputList);

        // 发送mq消息
        List<ProductInfoOutPut> productInfoOutPutList = productInfoList.stream().map(e -> {
            ProductInfoOutPut productInfoOutPut = new ProductInfoOutPut();
            BeanUtils.copyProperties(e, productInfoOutPut);
            return productInfoOutPut;
        }).collect(Collectors.toList());

        amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutPutList));
    }

    @Transactional
    public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList) {
        List<ProductInfo> productInfoList = new ArrayList<>();
        for (DecreaseStockInput decreaseStockInput : decreaseStockInputList) {
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            // 判断商品是否存在
            if (!productInfoOptional.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();

            // 判断库存是否足够
            Integer result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if (result < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);

            productInfoList.add(productInfo);
        }

        return productInfoList;
    }
}
