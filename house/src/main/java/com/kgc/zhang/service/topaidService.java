package com.kgc.zhang.service;

import com.kgc.zhang.entity.paid;
import com.kgc.zhang.entity.topaid;
import com.kgc.zhang.entity.topaidExample;

import java.util.List;

public interface topaidService {
    /*租客查看代缴租金*/
    List<topaid> zkdaijiaozujin(topaidExample example);
    /*支付租金后删除原本记录*/
    int deleteByPrimaryKey(Integer id);
    topaid selectByPrimaryKey(Integer id);
    int insertSelective(paid record);
    /**/
    List<topaid> fdzujinweijiao(String landlady);
	//刘学文
	void insert(topaid topaida);
}
