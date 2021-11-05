package com.qiaoqiao.pojo;

import java.util.Date;

public class ProductCategory {
    private Long ProductCategoryId;
    private Long shpoId;
    private String ProductCategoryName;
    private Integer priority;
    private Date createTime;

    public Long getProductCategoryId() {
        return ProductCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        ProductCategoryId = productCategoryId;
    }

    public Long getShpoId() {
        return shpoId;
    }

    public void setShpoId(Long shpoId) {
        this.shpoId = shpoId;
    }

    public String getProductCategoryName() {
        return ProductCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        ProductCategoryName = productCategoryName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
