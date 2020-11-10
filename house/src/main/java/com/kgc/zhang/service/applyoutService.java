package com.kgc.zhang.service;

import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.applyout;
import com.kgc.zhang.entity.applyoutExample;

import java.util.List;

public interface applyoutService {
    int insertSelective(applyout record);
    /*租客查看解除租赁列表*/
    List<applyout> tuizulist(applyoutExample example);
    /*租客查看删除解除租赁信息*/
    int deleteByPrimaryKey(Integer aoid);
	
	
	//刘学文
	 void insert(applyout applyouta);

    PageInfo<applyout> select(Integer pageNum, Integer pageSize, String landlady);

    void deleteById(Integer id);

    void updateTongYi(Integer id);

    void updateJuJue(Integer id);

    applyout selectById(Integer id);
}
