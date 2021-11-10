package com.qiaoqiao.pojo;

public class FormAction {
    // 主键Id
    private Long FormId;
    // 用户名
    private String UserName;
    // 密码
    private String UserPassword;

    public Long getFormId() {
        return FormId;
    }

    public void setFormId(Long formId) {
        FormId = formId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
}
