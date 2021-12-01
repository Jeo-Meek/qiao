package com.qiaoqiao.service;

import com.qiaoqiao.dto.ProductCategoryExection;
import com.qiaoqiao.exceptions.ProductCategoryOperationException;
import com.qiaoqiao.pojo.ProductCategory;

import java.util.List;

public interface ProductCategoryService {
    /**
     * 根据商店id 获取商品类别
     * @param shopId
     * @return
     */
    List<ProductCategory> getProductCategory(long shopId);

    /**
     * 批量添加商品类别
     * @param productCategoryList
     * @return
     * @throws
     */
    ProductCategoryExection batchAddProductCategory(List<ProductCategory> productCategoryList);

    /**
     * 将此类别下的商品里的类别id置为空，再删除掉该商品类别
     * @param productCategoryId
     * @param shopId
     * @return
     * @throws RuntimeException
     */
    ProductCategoryExection deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException;
}

