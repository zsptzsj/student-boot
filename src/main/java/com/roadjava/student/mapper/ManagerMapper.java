package com.roadjava.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.roadjava.student.bean.entity.ManagerDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerMapper extends BaseMapper<ManagerDO> {
}
