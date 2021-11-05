package com.qiaoqiao.service;

import com.qiaoqiao.BaseTest;
import com.qiaoqiao.dto.ShopExecution;
import com.qiaoqiao.enums.ShopStateEnum;
import com.qiaoqiao.exceptions.ShopOperationException;
import com.qiaoqiao.pojo.Area;
import com.qiaoqiao.pojo.PersonInfo;
import com.qiaoqiao.pojo.Shop;
import com.qiaoqiao.pojo.ShopCategory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService ;
    @Test
    @Ignore
    public void TestAddShop(){
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
        shop.setShopAddr("TEST3");
        shop.setShopDesc("test3");
        shop.setAdvice("shenhe3");
        shop.setCreateTime(new Date());
        shop.setPhone("test3");
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setShopName("test3");
        File shopImg = new File("F:/upload/images/item/shop/6/huang.jpg");
        InputStream is = null;
        try {
            is = new FileInputStream(shopImg);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ShopExecution se = shopService.addShop(shop,is,shopImg.getName());
        assertEquals(ShopStateEnum.CHECK.getState(),se.getState());
    }
    @Test
    public void TestModifyShop() throws ShopOperationException ,FileNotFoundException {
        Shop shop = new Shop();
        shop.setShopId(1L);
        shop.setShopName("修改后的店铺");
        File shopImg = new File("F:/images/item/shop/12/111.png");
        InputStream is = new FileInputStream(shopImg);
        ShopExecution shopExecution = shopService.modifyShop(shop,is,"111.png");
        System.out.println(shopExecution.getShop().getShopImg());
    }
    }


