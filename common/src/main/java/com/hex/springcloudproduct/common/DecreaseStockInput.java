package com.hex.springcloudproduct.common;

import lombok.Data;

/**
 * User: hexuan
 * Date: 2019/10/9
 * Time: 9:58 下午
 */
@Data
public class DecreaseStockInput {
    /**
     * 商品id
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

}
