package com.qiaoqiao.dao;

import com.qiaoqiao.BaseTest;
import com.qiaoqiao.pojo.Area;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void testQuary(){
        List<Area> areaList = areaDao.queryArea();
//        System.out.println("记得喝水呀~臭宝，Mua~（づ￣3￣）づ╭❤～");
        for(Area area:areaList){
            System.out.println(area);
        }
    }
}
