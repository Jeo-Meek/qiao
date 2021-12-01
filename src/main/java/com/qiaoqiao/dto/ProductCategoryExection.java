package com.qiaoqiao.dto;

import com.qiaoqiao.enums.ProductCategoryStateEnum;
import com.qiaoqiao.pojo.ProductCategory;

import java.util.List;

public class ProductCategoryExection {
    //结果状态
    private int state;
    //状态标识
    private String stateInfo;
    //商品类别列表
    private List<ProductCategory> productCategoryList;

    public ProductCategoryExection() {
    }
    //失败时生成的构造器
    public  ProductCategoryExection(ProductCategoryStateEnum stateEnum){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }
    //成功时使用的构造器
    public  ProductCategoryExection(ProductCategoryStateEnum stateEnum,List<ProductCategory> productCategoryList){
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.productCategoryList = productCategoryList;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public List<ProductCategory> getProductCategoryList() {
        return productCategoryList;
    }

    public void setProductCategoryList(List<ProductCategory> productCategoryList) {
        this.productCategoryList = productCategoryList;
    }
}
