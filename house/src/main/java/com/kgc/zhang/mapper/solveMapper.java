package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.solve;
import com.kgc.zhang.entity.solveExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface solveMapper {
    int countByExample(solveExample example);

    int deleteByExample(solveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(solve record);

    int insertSelective(solve record);

    List<solve> selectByExampleWithBLOBs(solveExample example);

    List<solve> selectByExample(solveExample example);

    solve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") solve record, @Param("example") solveExample example);

    int updateByExampleWithBLOBs(@Param("record") solve record, @Param("example") solveExample example);

    int updateByExample(@Param("record") solve record, @Param("example") solveExample example);

    int updateByPrimaryKeySelective(solve record);

    int updateByPrimaryKeyWithBLOBs(solve record);

    int updateByPrimaryKey(solve record);

    List<solve> select(@Param("landlady") String landlady, @Param("zuname") String zuname, @Param("id") String id);

}