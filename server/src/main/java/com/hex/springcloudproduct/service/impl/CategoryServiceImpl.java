package com.hex.springcloudproduct.service.impl;

import com.hex.springcloudproduct.dataobject.ProductCategory;
import com.hex.springcloudproduct.repository.ProductCategoryRepository;
import com.hex.springcloudproduct.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 2:41 PM
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }

}
