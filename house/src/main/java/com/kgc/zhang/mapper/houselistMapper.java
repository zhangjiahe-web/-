package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.houselist;
import com.kgc.zhang.entity.houselistExample;
import com.kgc.zhang.entity.houselistKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface houselistMapper {
    int countByExample(houselistExample example);

    int deleteByExample(houselistExample example);

    int deleteByPrimaryKey(houselistKey key);

    int insert(houselist record);

    int insertSelective(houselist record);

    List<houselist> selectByExample(houselistExample example);

    houselist selectByPrimaryKey(houselistKey key);

    int updateByExampleSelective(@Param("record") houselist record, @Param("example") houselistExample example);

    int updateByExample(@Param("record") houselist record, @Param("example") houselistExample example);

    int updateByPrimaryKeySelective(houselist record);

    int updateByPrimaryKey(houselist record);
	houselist selectByPrimaryKey(int id);
}