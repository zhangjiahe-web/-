package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.apply;
import com.kgc.zhang.entity.applyExample;
import com.kgc.zhang.entity.applyKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface applyMapper {
    int countByExample(applyExample example);

    int deleteByExample(applyExample example);

    int deleteByPrimaryKey(applyKey key);

    int insert(apply record);
    /**/
     List<apply> findapplylist(String username) ;
     List<apply> jujueapplylist(String username) ;
     List<apply> selectapplyanduserlist(applyExample example) ;
/**/
    int insertSelective(apply record);

    List<apply> selectByExample(applyExample example);

    apply selectByPrimaryKey(applyKey key);

    int updateByExampleSelective(@Param("record") apply record, @Param("example") applyExample example);

    int updateByExample(@Param("record") apply record, @Param("example") applyExample example);

    int updateByPrimaryKeySelective(apply record);

    int updateByPrimaryKey(apply record);
}