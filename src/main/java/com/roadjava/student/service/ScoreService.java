package com.roadjava.student.service;

import com.roadjava.student.bean.req.CommonSearchReq;
import com.roadjava.student.bean.req.ScoreAddReq;
import com.roadjava.student.bean.req.ScoreUpdateReq;
import com.roadjava.student.bean.req.StudentAddReq;
import com.roadjava.student.bean.res.Result;
import com.roadjava.student.bean.vo.ScoreVO;

import java.util.List;

public interface ScoreService {
    Result<List<ScoreVO>> selectPage(CommonSearchReq searchReq);

    void add(ScoreAddReq addReq);

    void deleteById(Long id);

    Result<ScoreVO> selectById(Long id);

    void updateById(ScoreUpdateReq updateReq);
}
