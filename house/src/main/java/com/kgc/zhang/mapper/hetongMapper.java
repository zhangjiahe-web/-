package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.hetong;
import com.kgc.zhang.entity.hetongExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface hetongMapper {
    int countByExample(hetongExample example);

    int deleteByExample(hetongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(hetong record);

    int insertSelective(hetong record);

    List<hetong> selectByExample(hetongExample example);

    hetong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") hetong record, @Param("example") hetongExample example);

    int updateByExample(@Param("record") hetong record, @Param("example") hetongExample example);

    int updateByPrimaryKeySelective(hetong record);

    int updateByPrimaryKey(hetong record);
}