package com.qiaoqiao.dao;

import com.qiaoqiao.pojo.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductCategoryDao {
    /**
     * 通过shopid 查询
     * @param shopId
     * @return
     */
    List<ProductCategory> queryProductCategoryList (long shopId);

    /**
     * 批量添加商品类别
     * @param list
     * @return
     */
    int betchProductCategorys(List<ProductCategory> list);

    /**
     * 删除指定商品类别
     *
     * @param productCategoryId
     * @param shopId
     * @return effectedNum
     */
    int deleteProductCategory(@Param("productCategoryId") long productCategoryId, @Param("shopId") long shopId);

}
