package com.qiaoqiao.service.impl;

import com.qiaoqiao.dao.ShopDao;
import com.qiaoqiao.dto.ShopExecution;
import com.qiaoqiao.enums.ShopStateEnum;
import com.qiaoqiao.exceptions.ShopOperationException;
import com.qiaoqiao.pojo.Shop;
import com.qiaoqiao.service.ShopService;
import com.qiaoqiao.util.ImageUtil;
import com.qiaoqiao.util.PageCalculator;
import com.qiaoqiao.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex,pageSize);
        List<Shop> shopList = shopDao.shopList(shopCondition,rowIndex,pageSize);
        int count = shopDao.quaryShopCount(shopCondition);
        ShopExecution shopExecution = new ShopExecution();
        if(shopList != null){
            shopExecution.setShopList(shopList);
            shopExecution.setCount(count);
        }else {
            shopExecution.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return shopExecution;
    }

    @Override
    public Shop getByShopId(long shopId) {
        return shopDao.quaryById(shopId);
    }

    @Override
    public ShopExecution modifyShop(Shop shop, InputStream shopImgInpuutStream, String fileName) throws ShopOperationException{
       try {
           if (shop == null || shop.getShopId() == null) {
               return new ShopExecution(ShopStateEnum.NULL_SHOP);
           } else {
               //1.判断是否需要处理照片
               if (shopImgInpuutStream != null && fileName != null && !"".equals(fileName)) {
                   Shop tempShop = shopDao.quaryById(shop.getShopId());
                   if (tempShop.getShopImg() != null) {
                       ImageUtil.deleteFileOrPath(tempShop.getShopImg());
                   }
                   addShopImg(shop, shopImgInpuutStream, fileName);
               }
               //2.更新店铺信息
               shop.setLastEditTime(new Date());
               int effectNum = shopDao.updateShop(shop);
               if (effectNum <= 0) {
                   return new ShopExecution(ShopStateEnum.INNER_ERROR);
               } else {
                   shop = shopDao.quaryById(shop.getShopId());
                   return new ShopExecution(ShopStateEnum.SUCCESS, shop);
               }
           }
       }catch (Exception e){
           throw new ShopOperationException("modifyShopErr:"+e.getMessage());
       }



    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream shopImgInpuutStream, String fileName) {
        //空值判断
        if(shop == null){
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try{
            //给店铺信息赋值初始化
            shop.setEnableStatus(0);
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            //影响的行数
            int effectNum = shopDao.insertShop(shop);
            if(effectNum <= 0){
                //事务终止回滚
                throw new ShopOperationException("店铺创建失败");
            }else{
                if(shopImgInpuutStream != null){
                    //存储图片
                   try{
                       addShopImg(shop,shopImgInpuutStream,fileName);
                   }catch (Exception e){
                       throw new ShopOperationException("addShopImgError"+e.getMessage());
                   }
                   //更新店铺的图片地址
                    effectNum  = shopDao.updateShop(shop);
                    if(effectNum <= 0){
                        throw new ShopOperationException("更新图片地址失败");
                    }
                }
            }
        }catch (Exception e){
            throw  new ShopOperationException("addShop erroe:"+e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK,shop);
    }

    private void addShopImg(Shop shop, InputStream shopImgInpuutStream,String fileName) {
        //获取shop 图片目录的相对值路径
        String dest = PathUtil.getShopImagePath(shop.getShopId());
        String shopImgAddr = ImageUtil.generateThumbnail(shopImgInpuutStream,fileName,dest);
        shop.setShopImg(shopImgAddr);
    }
}
