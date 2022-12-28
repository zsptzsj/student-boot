package com.roadjava.student.handler;

import com.roadjava.student.bean.entity.ScoreDO;
import com.roadjava.student.bean.req.*;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.ScoreVO;
import com.roadjava.student.bean.vo.StudentVO;
import com.roadjava.student.service.ScoreService;
import com.roadjava.student.service.StudentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/score")
public class ScoreHandler {

    @Resource
    private ScoreService scoreService;

    @PostMapping("/add")
    public Result<String> add(@Validated ScoreAddReq addReq){
        scoreService.add(addReq);
        return Result.buildSuccess("添加成功");
    }

    @PostMapping("/selectPage")
    public Result<List<ScoreVO>> selectPage(@Validated CommonSearchReq searchReq){
        return scoreService.selectPage(searchReq);
    }
    @GetMapping("/deleteById")
    public Result<String> deleteById(Long id){
        if(id==null){
            return Result.buildFailure("Id不能为空");
        }
        scoreService.deleteById(id);
        return Result.buildSuccess("删除成功");
    }
    @GetMapping("/selectById")
    public Result<ScoreVO> selectById(Long id){
        if(id==null){
            return Result.buildFailure("Id不能为空");
        }
        return scoreService.selectById(id);
    }

    @PostMapping("/updateById")
    public Result<String> updateById(@Validated ScoreUpdateReq updateReq){
        scoreService.updateById(updateReq);
        return Result.buildSuccess("更新成功");
    }

}
