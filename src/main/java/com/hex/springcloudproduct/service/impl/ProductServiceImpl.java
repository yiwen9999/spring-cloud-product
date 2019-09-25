package com.hex.springcloudproduct.service.impl;

import com.hex.springcloudproduct.dataobject.ProductInfo;
import com.hex.springcloudproduct.enums.ProductStatusEnum;
import com.hex.springcloudproduct.repository.ProductInfoRepository;
import com.hex.springcloudproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 2:23 PM
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

}
