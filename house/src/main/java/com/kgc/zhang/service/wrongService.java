package com.kgc.zhang.service;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.wrong;
import com.kgc.zhang.entity.wrongExample;

import java.util.List;

public interface wrongService {
    int insertSelective(wrong record);

    List<wrong> selectByExample(wrongExample example);
    /**/

    //刘学文
    PageInfo<wrong> select(Integer pageNum, Integer pageSize, String landlady);

    wrong selectById(Integer id);

    void deleteById(Integer id);
}
