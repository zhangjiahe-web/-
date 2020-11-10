package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.topaid;
import com.kgc.zhang.entity.topaidExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface topaidMapper {
    int countByExample(topaidExample example);

    int deleteByExample(topaidExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(topaid record);

    int insertSelective(topaid record);

    List<topaid> selectByExample(topaidExample example);

    topaid selectByPrimaryKey(Integer id);
    /**/
    List<topaid> fdzujinweijiao(String landlady);
    /**/

    int updateByExampleSelective(@Param("record") topaid record, @Param("example") topaidExample example);

    int updateByExample(@Param("record") topaid record, @Param("example") topaidExample example);

    int updateByPrimaryKeySelective(topaid record);

    int updateByPrimaryKey(topaid record);
}