package com.kgc.zhang.service;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.paid;
import com.kgc.zhang.entity.paidExample;

import java.util.List;

public interface paidService {
    List<paid> selectByExample(paidExample example);

    int deleteByPrimaryKey(Integer id);

    List<paid> fdokzhifu(paidExample example);
    /*终止合同删除删除保障*/
    int deleteByExample(paidExample example);

    /**
     * 求总价
     */
    Double selectSum(paidExample example);

    paid selectByPrimaryKey(Integer id);

}
