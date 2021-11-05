package com.qiaoqiao.service.impl;

import com.qiaoqiao.dao.ShopCategoryDao;
import com.qiaoqiao.pojo.ShopCategory;
import com.qiaoqiao.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Override
    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
        return shopCategoryDao.quaryShopCategory(shopCategoryCondition);
    }
}
