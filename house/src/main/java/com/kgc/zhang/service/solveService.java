package com.kgc.zhang.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.solve;
import com.kgc.zhang.entity.solveExample;

import java.util.List;

public interface solveService {
    List<solve> selectByExample(solveExample example);
    int deleteByPrimaryKey(Integer id);
    /**/
	
	//刘学文
	void insert(solve solvea);

    PageInfo<solve> select(Integer pageNum, Integer pageSize, String landlady, String zuname, String id);

    void deleteById(int id);
}
