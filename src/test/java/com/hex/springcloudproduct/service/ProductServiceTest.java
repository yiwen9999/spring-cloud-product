package com.hex.springcloudproduct.service;

import com.hex.springcloudproduct.SpringCloudProductApplicationTests;
import com.hex.springcloudproduct.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceTest extends SpringCloudProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAll() throws Exception {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

}