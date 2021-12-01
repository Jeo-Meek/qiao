package com.qiaoqiao.service.impl;

import com.mysql.jdbc.StringUtils;
import com.qiaoqiao.dao.ProductCategoryDao;
import com.qiaoqiao.dao.ProductDao;
import com.qiaoqiao.dto.ProductCategoryExection;
import com.qiaoqiao.enums.ProductCategoryStateEnum;
import com.qiaoqiao.exceptions.ProductCategoryOperationException;
import com.qiaoqiao.pojo.ProductCategory;
import com.qiaoqiao.service.ProductCategoryService;
import org.apache.commons.io.output.StringBuilderWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> getProductCategory(long shopId) {
        List<ProductCategory> list = productCategoryDao.queryProductCategoryList(shopId);
        return list;
    }

    @Override
    public ProductCategoryExection batchAddProductCategory(List<ProductCategory> productCategoryList) {
        if(productCategoryList != null && productCategoryList.size()>0){
            try{
                int effectNum = productCategoryDao.betchProductCategorys(productCategoryList);
                if(effectNum <= 0){
                    throw new ProductCategoryOperationException("店铺创建失败");
                }else {
                    return new ProductCategoryExection(ProductCategoryStateEnum.SUCCESS);
                }
            }catch (Exception e){
                throw new ProductCategoryOperationException("batchAddProductCategory error:"+e.getMessage());
            }
        }else {
            return new ProductCategoryExection(ProductCategoryStateEnum.EMPTY_LIST);
        }
    }
    @Override
    @Transactional
    public ProductCategoryExection deleteProductCategory(long productCategoryId, long shopId)
            throws ProductCategoryOperationException {
        // 解除tb_product里的商品与该producategoryId的关联
        try {
            int effectedNum = productDao.updateProductCategoryToNull(productCategoryId);
            if (effectedNum < 0) {
                throw new ProductCategoryOperationException("商品类别更新失败");
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error: " + e.getMessage());
        }
        // 删除该productCategory
        try {
            int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
            if (effectedNum <= 0) {
                throw new ProductCategoryOperationException("商品类别删除失败");
            } else {
                return new ProductCategoryExection(ProductCategoryStateEnum.SUCCESS);
            }
        } catch (Exception e) {
            throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
        }
    }
}
