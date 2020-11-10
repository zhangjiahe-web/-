package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.applyout;
import com.kgc.zhang.entity.applyoutExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface applyoutMapper {
    int countByExample(applyoutExample example);

    int deleteByExample(applyoutExample example);

    int deleteByPrimaryKey(Integer aoid);

    int insert(applyout record);

    int insertSelective(applyout record);

    List<applyout> selectByExample(applyoutExample example);
    /**/
    List<applyout> tuizulist(applyoutExample example);

    applyout selectByPrimaryKey(Integer aoid);

    int updateByExampleSelective(@Param("record") applyout record, @Param("example") applyoutExample example);

    int updateByExample(@Param("record") applyout record, @Param("example") applyoutExample example);

    int updateByPrimaryKeySelective(applyout record);

    int updateByPrimaryKey(applyout record);

    List<applyout> select(String landlady);
}