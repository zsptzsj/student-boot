package com.roadjava.student.bean.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StudentVO {
    private Long id;
    private String no;
    private String realName;
    private Date enrollTime;
}
