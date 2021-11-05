package com.qiaoqiao.util;

import com.google.code.kaptcha.Constants;

import javax.servlet.http.HttpServletRequest;

/**
 * 校验用户输入验证码是否一样
 */
public class CodeUtil {
    public static boolean checkVerifyCode(HttpServletRequest request){
        String verifyCodeExpected = (String)request.getSession()
                .getAttribute(Constants.KAPTCHA_SESSION_KEY);
        String verifyCodeActual = HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if(verifyCodeActual== null || !verifyCodeActual.equals(verifyCodeExpected)){
            return false;
        }
        return true;
    }
}
