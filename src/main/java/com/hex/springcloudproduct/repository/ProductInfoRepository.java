package com.hex.springcloudproduct.repository;

import com.hex.springcloudproduct.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 1:57 PM
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);

}
