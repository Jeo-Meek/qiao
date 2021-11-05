package com.qiaoqiao.service;

import com.qiaoqiao.dto.ShopExecution;
import com.qiaoqiao.exceptions.ShopOperationException;
import com.qiaoqiao.pojo.Shop;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
   /**
    * 查询店铺列表
    * @param shopCondition
    * @param pageIndex
    * @param pageSize
    * @return
    */
   ShopExecution getShopList(Shop shopCondition,int pageIndex,int pageSize);
   /**
    * 通过店铺 Id 获取店铺信息
    * @param shopId
    * @return
    */
   Shop getByShopId(long shopId);

   /**
    * 更新店铺信息，包括对图片的处理
    * @param shop
    * @param shopImgInpuutStream
    * @param fileName
    * @return
    */
   ShopExecution modifyShop(Shop shop, InputStream shopImgInpuutStream,String fileName) throws ShopOperationException;
   /**
    * 注册店铺信息，包括对图片的处理
    * @param shop
    * @param shopImgInpuutStream
    * @param fileName
    * @return
    */
    ShopExecution addShop(Shop shop, InputStream shopImgInpuutStream,String fileName);
}
