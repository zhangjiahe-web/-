package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.paid;
import com.kgc.zhang.entity.topaid;
import com.kgc.zhang.entity.topaidExample;
import com.kgc.zhang.mapper.paidMapper;
import com.kgc.zhang.mapper.topaidMapper;
import com.kgc.zhang.service.topaidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("topaidService")
public class topaidServiceImpl implements topaidService {
    @Resource
    topaidMapper topaidMapper;
    @Resource
    paidMapper paidMapper;
    @Override
    public List<topaid> zkdaijiaozujin(topaidExample example) {
        return topaidMapper.selectByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return topaidMapper.deleteByPrimaryKey(id);
    }

    @Override
    public topaid selectByPrimaryKey(Integer id) {
        return topaidMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(paid record) {
        return paidMapper.insertSelective(record);
    }

    @Override
    public List<topaid> fdzujinweijiao(String landlady) {
        return topaidMapper.fdzujinweijiao(landlady);
    }

    //刘学文
    @Override
    public void insert(topaid topaida) {
        topaidMapper.insertSelective(topaida);
    }
}
