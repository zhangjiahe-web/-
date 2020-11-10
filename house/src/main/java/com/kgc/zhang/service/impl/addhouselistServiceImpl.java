package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.houselist;
import com.kgc.zhang.mapper.houselistMapper;
import com.kgc.zhang.service.addhouselistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("addhouselistService")
public class addhouselistServiceImpl implements addhouselistService {
    @Resource
    houselistMapper houselistMapper;
    @Override
    public int addhouse(houselist houselist) {
        return houselistMapper.insertSelective(houselist);
    }
}
