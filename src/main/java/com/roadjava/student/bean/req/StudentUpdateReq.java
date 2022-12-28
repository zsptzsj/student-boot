package com.roadjava.student.bean.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class StudentUpdateReq {
    @NotNull(message = "更新学生id必须指定")
    private Long id;

    @NotBlank
    private String no;
    @NotBlank
    private String realName;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date enrollTime;
}
