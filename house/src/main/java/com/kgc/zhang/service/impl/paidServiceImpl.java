package com.kgc.zhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.paid;
import com.kgc.zhang.entity.paidExample;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.entity.userlistExample;
import com.kgc.zhang.mapper.paidMapper;
import com.kgc.zhang.mapper.userlistMapper;
import com.kgc.zhang.mapper.zulistMapper;
import com.kgc.zhang.service.paidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("paidService")
public class paidServiceImpl implements paidService {
    @Resource
    paidMapper paidMapper;

    @Resource
    userlistMapper userlistMappera;

    @Resource
    zulistMapper zulistMappera;


    @Override
    public List<paid> selectByExample(paidExample example) {
        return paidMapper.selectByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return paidMapper.deleteByPrimaryKey(id);
    }


    @Override
    public List<paid> fdokzhifu(paidExample example) {
        return paidMapper.fdokzhifu(example);
    }

    @Override
    public int deleteByExample(paidExample example) {
        return paidMapper.deleteByExample(example);
    }

    @Override
    public Double selectSum(paidExample example) {

        return paidMapper.selectSum(example);
    }


    @Override
    public paid selectByPrimaryKey(Integer id) {
        return paidMapper.selectByPrimaryKey(id);
    }



}
