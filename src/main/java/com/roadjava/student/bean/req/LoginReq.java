package com.roadjava.student.bean.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

//登录请求参数
@Data
public class LoginReq {
    @NotBlank//参数校验
    private String userName;
    @NotBlank
    private String pwd;
}
