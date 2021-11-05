package com.qiaoqiao.service;

import com.qiaoqiao.pojo.ShopCategory;

import java.util.List;

public interface ShopCategoryService {
    List<ShopCategory> getShopCategoryList (ShopCategory shopCategoryCondition);
}
