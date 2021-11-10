package com.qiaoqiao.dao;

import com.qiaoqiao.pojo.FormAction;
import org.apache.ibatis.annotations.Param;

public interface FormDao {

    int updateForm(@Param("form") FormAction form);
}
