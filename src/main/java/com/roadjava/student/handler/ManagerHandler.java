package com.roadjava.student.handler;

import com.roadjava.student.bean.req.LoginReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.JwtManagerVO;
import com.roadjava.student.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

//管理员接口
@RestController
@RequestMapping("/manager")
@Slf4j
public class ManagerHandler {

    @Resource
    private ManagerService managerService;

    @PostMapping("/login")
    public Result<JwtManagerVO> login(@Validated LoginReq loginReq){
        log.info("login params{}",loginReq);
        return managerService.login(loginReq);
    }
}
