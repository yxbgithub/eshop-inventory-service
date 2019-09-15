package com.yxb.eshop.inventory.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api
public class ProductInventoryRequest {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("value")
    private Integer value;
    @ApiModelProperty("商品id")
    private Long productId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getValue() {
        return value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
