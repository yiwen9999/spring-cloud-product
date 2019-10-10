package com.hex.springcloudproduct.service;

import com.hex.springcloudproduct.common.DecreaseStockInput;
import com.hex.springcloudproduct.common.ProductInfoOutPut;
import com.hex.springcloudproduct.dataobject.ProductInfo;

import java.util.List;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 2:22 PM
 */
public interface ProductService {

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询商品列表
     *
     * @return
     */
    List<ProductInfoOutPut> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param decreaseStockInputList
     */
    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);

}
