package com.hex.springcloudproduct.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * User: hexuan
 * Date: 2019/9/17
 * Time: 2:11 PM
 */
@Data
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

}
