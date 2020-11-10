package com.kgc.zhang.mapper;

import com.kgc.zhang.entity.checkout;
import com.kgc.zhang.entity.checkoutExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface checkoutMapper {
    int countByExample(checkoutExample example);

    int deleteByExample(checkoutExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(checkout record);

    int insertSelective(checkout record);

    List<checkout> selectByExample(checkoutExample example);

    checkout selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") checkout record, @Param("example") checkoutExample example);

    int updateByExample(@Param("record") checkout record, @Param("example") checkoutExample example);

    int updateByPrimaryKeySelective(checkout record);

    int updateByPrimaryKey(checkout record);

    List<checkout> select(String landlady);
}