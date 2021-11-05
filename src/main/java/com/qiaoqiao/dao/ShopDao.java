package com.qiaoqiao.dao;

import com.qiaoqiao.pojo.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /**
     * 分页查询店铺，可输入的条件有：店铺名（模糊查询），店铺状态，店铺类别，区域Id,owner
     * @param shopCondition 查询商店的条件
     * @param rowIndex 从第几行开始获取数据
     * @param pageSize 每页数据的大小
     * @return
     */
    List<Shop> shopList(@Param("shopCondition")Shop shopCondition
            ,@Param("rowIndex")int rowIndex, @Param("pageSize")int pageSize);

    /**
     * 返回 shopList 总数
     * @param shopCondition
     * @return
     */
    int quaryShopCount(@Param("shopCondition")Shop shopCondition);
    /**
     * 查询功能
     */
    Shop quaryById(Long shopId);
    /**
     * 新增店铺
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
