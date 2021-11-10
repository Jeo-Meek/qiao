package com.qiaoqiao.service.impl;

import com.qiaoqiao.dao.FormDao;
import com.qiaoqiao.pojo.FormAction;
import com.qiaoqiao.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {
    @Autowired
    private FormDao formDao;

    @Override
    public FormAction add(FormAction form) {
        formDao.updateForm(form);
        return form;
    }
}
