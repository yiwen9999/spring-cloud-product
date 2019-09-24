package com.hex.springcloudproduct.service;

import com.hex.springcloudproduct.dataobject.ProductCategory;

import java.util.List;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 2:36 PM
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
