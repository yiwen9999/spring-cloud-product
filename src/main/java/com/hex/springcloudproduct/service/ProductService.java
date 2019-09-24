package com.hex.springcloudproduct.service;

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


}
