package com.qiaoqiao.web.shopadmin;

import com.qiaoqiao.pojo.FormAction;
import com.qiaoqiao.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/formaction",method = {RequestMethod.POST})
public class FormController {
    @Autowired
    private FormService formService;
    @RequestMapping(value = "/submit")
    public FormAction shopOperation(FormAction formAction){

        formService.add(formAction);
        return formAction;
    }
}
