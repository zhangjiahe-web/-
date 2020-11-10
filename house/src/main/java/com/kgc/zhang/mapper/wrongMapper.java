package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.wrong;
import com.kgc.zhang.entity.wrongExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface wrongMapper {
    int countByExample(wrongExample example);

    int deleteByExample(wrongExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(wrong record);

    int insertSelective(wrong record);

    List<wrong> selectByExampleWithBLOBs(wrongExample example);

    List<wrong> selectByExample(wrongExample example);

    wrong selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") wrong record, @Param("example") wrongExample example);

    int updateByExampleWithBLOBs(@Param("record") wrong record, @Param("example") wrongExample example);

    int updateByExample(@Param("record") wrong record, @Param("example") wrongExample example);

    int updateByPrimaryKeySelective(wrong record);

    int updateByPrimaryKeyWithBLOBs(wrong record);

    int updateByPrimaryKey(wrong record);
	 List<wrong> select(String landlady);
}