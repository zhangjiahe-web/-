package com.kgc.zhang.service;

import com.kgc.zhang.entity.schedule;
import com.kgc.zhang.entity.scheduleExample;

import java.util.List;

public interface scheduleService {
    List<schedule> selectByExample(scheduleExample example);

    schedule selectByPrimaryKey(Integer id);
    int insertSelective(schedule record);
    int deleteByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(schedule record);
}
