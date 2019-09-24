package com.hex.springcloudproduct.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 2:50 PM
 */
@Data
public class ProductVO {

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
    @JsonProperty("name")
    private String categoryName;
    @JsonProperty("type")
    private Integer categoryType;
}
