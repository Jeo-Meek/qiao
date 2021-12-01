package com.qiaoqiao.pojo;

import java.util.Date;

public class ProductCategory {
    //商品类别id
    private Long ProductCategoryId;
    //商店id
    private Long shopId;
    //商品类别名称
    private String ProductCategoryName;
    //权重
    private Integer priority;
    //创建时间
    private Date createTime;

    public Long getProductCategoryId() {
        return ProductCategoryId;
    }

    public void setProductCategoryId(Long productCategoryId) {
        ProductCategoryId = productCategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shpoId) {
        this.shopId = shpoId;
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

    @Override
    public String toString() {
        return "ProductCategory{" +
                "ProductCategoryId=" + ProductCategoryId +
                ", shpoId=" + shopId +
                ", ProductCategoryName='" + ProductCategoryName + '\'' +
                ", priority=" + priority +
                ", createTime=" + createTime +
                '}';
    }
}
