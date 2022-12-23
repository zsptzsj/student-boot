package com.roadjava.student.bean.vo;

import com.roadjava.student.bean.dto.JwtManagerDTO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class JwtManagerVO extends JwtManagerDTO {
    private String token;
}
