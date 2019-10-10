package com.hex.springcloudproduct.exception;

import com.hex.springcloudproduct.enums.ResultEnum;

/**
 * User: hexuan
 * Date: 2019/9/26
 * Time: 10:33 上午
 */
public class ProductException extends RuntimeException {

    private Integer code;

    public ProductException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
