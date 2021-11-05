package com.qiaoqiao.service.impl;

import com.qiaoqiao.dao.AreaDao;
import com.qiaoqiao.pojo.Area;
import com.qiaoqiao.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
