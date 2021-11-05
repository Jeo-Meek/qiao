package com.qiaoqiao.dao;

import com.qiaoqiao.pojo.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {
     List<ShopCategory> quaryShopCategory(@Param("shopCategoryCondition") ShopCategory shopCategoryCondition);
}
