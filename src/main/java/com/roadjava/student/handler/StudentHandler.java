package com.roadjava.student.handler;

import com.roadjava.student.bean.req.StudentAddReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/student")
public class StudentHandler {

    @Resource
    private StudentService studentService;

    @PostMapping("/add")
    public Result<String> add(@Validated StudentAddReq addReq){
        studentService.add(addReq);
        return Result.buildSuccess("添加成功");
    }

    @GetMapping("/selectById")
    public String selectById(Long id){
        return "idxxx";
    }
}
