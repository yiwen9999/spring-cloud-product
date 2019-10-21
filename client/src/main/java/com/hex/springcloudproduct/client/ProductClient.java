package com.hex.springcloudproduct.client;

import com.hex.springcloudproduct.common.DecreaseStockInput;
import com.hex.springcloudproduct.common.ProductInfoOutPut;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * User: hexuan
 * Date: 2019/10/9
 * Time: 10:14 下午
 */
@FeignClient(name = "product")
public interface ProductClient {

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutPut> listForOrder(@RequestBody List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);

}
