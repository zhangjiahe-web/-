package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.zulist;
import com.kgc.zhang.entity.zulistExample;
import com.kgc.zhang.entity.zulistKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface zulistMapper {
    int countByExample(zulistExample example);

    int deleteByExample(zulistExample example);

    int deleteByPrimaryKey(zulistKey key);

    int insert(zulist record);

    int insertSelective(zulist record);

    List<zulist> selectByExample(zulistExample example);
    /**/
    List<zulist> zulin(zulistExample example);
    List<zulist> shouzu(String landlady);
    zulist shouzuaddcha(Integer zid);
    /**/

    zulist selectByPrimaryKey(zulistKey key);


    int updateByExampleSelective(@Param("record") zulist record, @Param("example") zulistExample example);

    int updateByExample(@Param("record") zulist record, @Param("example") zulistExample example);

    int updateByPrimaryKeySelective(zulist record);

    int updateByPrimaryKey(zulist record);

    List<zulist> select(String landlady);
}