package com.roadjava.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.roadjava.student.bean.entity.StudentDO;
import com.roadjava.student.bean.req.StudentAddReq;
import com.roadjava.student.ex.BizEx;
import com.roadjava.student.mapper.StudentMapper;
import com.roadjava.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(StudentAddReq addReq) {
        LambdaQueryWrapper<StudentDO> qw = new LambdaQueryWrapper<>();
        qw.eq(StudentDO::getNo,addReq.getNo());
        Long count = studentMapper.selectCount(qw);
        if(count > 0){
            throw new BizEx("学号已存在");
        }
        StudentDO studentDO = new StudentDO();
        BeanUtils.copyProperties(addReq,studentDO);
        studentMapper.insert(studentDO);
    }
}
