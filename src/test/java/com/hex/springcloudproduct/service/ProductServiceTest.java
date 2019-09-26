package com.hex.springcloudproduct.service;

import com.hex.springcloudproduct.SpringCloudProductApplicationTests;
import com.hex.springcloudproduct.dataobject.ProductInfo;
import com.hex.springcloudproduct.dto.CartDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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

    @Test
    public void findList() throws Exception {
        List<ProductInfo> productInfoList = productService.findList(Arrays.asList("157875196366160022", "157875227953464068"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStock() throws Exception{
        CartDTO cartDTO = new CartDTO("157875196366160022",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }

}