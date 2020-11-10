package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.entity.userlistExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userlistMapper {
    int countByExample(userlistExample example);

    int deleteByExample(userlistExample example);

    int deleteByPrimaryKey(userlist key);

    int insert(userlist record);

    int insertSelective(userlist record);

    List<userlist> selectByExample(userlistExample example);
    List<userlist> zhgl(String landlady);

    userlist selectByPrimaryKey(Integer key);

    int updateByExampleSelective(@Param("record") userlist record, @Param("example") userlistExample example);

    int updateByExample(@Param("record") userlist record, @Param("example") userlistExample example);

    int updateByPrimaryKeySelective(userlist record);

    int updateByPrimaryKey(userlist record);
}