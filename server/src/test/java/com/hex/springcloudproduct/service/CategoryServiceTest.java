package com.hex.springcloudproduct.service;

import com.hex.springcloudproduct.SpringCloudProductApplicationTests;
import com.hex.springcloudproduct.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryServiceTest extends SpringCloudProductApplicationTests {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void findByCategoryTypeIn() throws Exception {
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(Arrays.asList(1, 2));
        Assert.assertTrue(productCategoryList.size() > 0);
    }

}