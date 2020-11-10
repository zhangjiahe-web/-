package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.schedule;
import com.kgc.zhang.entity.scheduleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface scheduleMapper {
    int countByExample(scheduleExample example);

    int deleteByExample(scheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(schedule record);

    int insertSelective(schedule record);

    List<schedule> selectByExampleWithBLOBs(scheduleExample example);

    List<schedule> selectByExample(scheduleExample example);

    schedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") schedule record, @Param("example") scheduleExample example);

    int updateByExampleWithBLOBs(@Param("record") schedule record, @Param("example") scheduleExample example);

    int updateByExample(@Param("record") schedule record, @Param("example") scheduleExample example);

    int updateByPrimaryKeySelective(schedule record);

    int updateByPrimaryKeyWithBLOBs(schedule record);

    int updateByPrimaryKey(schedule record);
}