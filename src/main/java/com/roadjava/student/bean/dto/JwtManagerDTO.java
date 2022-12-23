package com.roadjava.student.bean.dto;

import lombok.Data;
//定义了返回给前端的token是由那些信息构成的
@Data
public class JwtManagerDTO {
    private Long id;
    private String userName;
}
