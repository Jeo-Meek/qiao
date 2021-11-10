package com.qiaoqiao.dao;

import com.qiaoqiao.BaseTest;
import com.qiaoqiao.pojo.Area;
import com.qiaoqiao.pojo.PersonInfo;
import com.qiaoqiao.pojo.Shop;
import com.qiaoqiao.pojo.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;
    @Test
    @Ignore
    public void testQuaryList(){
        Shop shopCondition = new Shop();
        PersonInfo personInfo = new PersonInfo();
        personInfo.setUserId(1L);
        shopCondition.setOwner(personInfo);
        ShopCategory shopCategory = new ShopCategory();
        shopCategory.setShopCategoryId(3L);
        shopCondition.setShopCategory(shopCategory);
        int count = shopDao.quaryShopCount(shopCondition);
        List<Shop> shopList = shopDao.shopList(shopCondition,0,6);
        for(Shop shop:shopList){
            System.out.println(shop);
        }
        System.out.println(count);



    }
    @Test
    @Ignore
    public void testQuary(){
        Long shopId = 1L;
        Shop shop = shopDao.quaryById(shopId);
        System.out.println(shop.getArea().getAreaId());
        System.out.println(shop.getArea().getAreaName());
    }
    @Test
    @Ignore
    public void testInsert(){
        Shop shop = new Shop();
        Area area = new Area();
        PersonInfo personInfo = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        personInfo.setUserId(1L);
        area.setAreaId(2);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(personInfo);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopAddr("TEST");
        shop.setShopDesc("test");
        shop.setAdvice("shenhe");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setPhone("test");
        shop.setEnableStatus(1);
        shop.setShopName("test");
        int effectrdNum = shopDao.insertShop(shop);
        assertEquals(1,effectrdNum);
    }
    @Test

    public void testUpdate(){
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopAddr("测试");
        shop.setShopDesc("测试");
        shop.setAdvice("测试");
        shop.setShopImg("测试");
        shop.setCreateTime(new Date());
        shop.setPhone("test");
        shop.setEnableStatus(1);
        shop.setLastEditTime(new Date());
        shop.setShopName("test");
        int effectrdNum = shopDao.updateShop(shop);
        assertEquals(1,effectrdNum);
    }

}
