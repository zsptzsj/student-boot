package com.roadjava.student.bean.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("score")
public class ScoreDO {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long studentId;
    private String examName;
    private Double cnScore;
    private Double enScore;
    private Double mathScore;
}
