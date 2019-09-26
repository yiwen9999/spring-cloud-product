package com.hex.springcloudproduct.service;

import com.hex.springcloudproduct.dataobject.ProductInfo;
import com.hex.springcloudproduct.dto.CartDTO;

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
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     *
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

}
