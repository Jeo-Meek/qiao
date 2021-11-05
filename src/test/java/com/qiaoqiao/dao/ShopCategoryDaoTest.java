package com.qiaoqiao.dao;

import com.qiaoqiao.BaseTest;
import com.qiaoqiao.pojo.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    private ShopCategoryDao shopCategoryDao;
    @Test
    public void testQuaryshopCategory(){
        List<ShopCategory> shopCategoryList = shopCategoryDao.quaryShopCategory(new ShopCategory());
        System.out.println(shopCategoryList.size());
        ShopCategory parent = new ShopCategory();
        ShopCategory son = new ShopCategory();
        parent.setShopCategoryId(1L);
        son.setParent(parent);
        shopCategoryList = shopCategoryDao.quaryShopCategory(son);
        System.out.println(shopCategoryList.size());
    }


}
