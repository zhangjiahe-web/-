package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.paid;
import com.kgc.zhang.entity.paidExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface paidMapper {
    int countByExample(paidExample example);

    int deleteByExample(paidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(paid record);

    int insertSelective(paid record);

    List<paid> selectByExample(paidExample example);

    /*房东查看租客已缴费房租*/
    Double selectSum(paidExample example);

    List<paid> fdokzhifu(paidExample example);

    /**/
    paid selectByPrimaryKey(Integer id);


    int updateByExampleSelective(@Param("record") paid record, @Param("example") paidExample example);

    int updateByExample(@Param("record") paid record, @Param("example") paidExample example);

    int updateByPrimaryKeySelective(paid record);

    int updateByPrimaryKey(paid record);


}