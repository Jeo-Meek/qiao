package com.qiaoqiao.dao;

import com.qiaoqiao.BaseTest;
import com.qiaoqiao.pojo.FormAction;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class FormDaoTest extends BaseTest {
    @Autowired
    private FormDao formDao;
    @Test
    public void testForm(){
        FormAction formAction = new FormAction();
        formAction.setFormId(1L);
        formAction.setUserName("qiao");
        int u = formDao.updateForm(formAction);
        System.out.println(u);
    }
}
