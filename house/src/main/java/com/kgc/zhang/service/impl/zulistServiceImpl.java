package com.kgc.zhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.*;
import com.kgc.zhang.mapper.hetongMapper;
import com.kgc.zhang.mapper.userlistMapper;
import com.kgc.zhang.mapper.zulistMapper;
import com.kgc.zhang.service.zulistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("zulistService")
public class zulistServiceImpl implements zulistService {
    @Resource
    zulistMapper zulistMapper;
    @Resource
    hetongMapper hetongMapper;
	
	@Resource
    userlistMapper userlistMapper1;
	
    @Override
    public List<zulist> zulin(zulistExample example) {
        return zulistMapper.zulin(example);
    }

    @Override
    public int deleteByPrimaryKey(zulistKey key) {
        return zulistMapper.deleteByPrimaryKey(key);
    }

    @Override
    public zulist selectByPrimaryKey(zulistKey key) {
        return zulistMapper.selectByPrimaryKey(key);
    }

    @Override
    public hetong chahetong(Integer id) {
        return hetongMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<zulist> shouzu(String landlady) {
        return zulistMapper.shouzu(landlady);
    }

    @Override
    public zulist shouzuaddcha(Integer zid) {
        return zulistMapper.shouzuaddcha(zid);
    }


    //刘学文
	@Override
    public PageInfo<zulist> select(Integer pageNum, Integer pageSize,String landlady) {
        List<zulist> zulists = zulistMapper.select(landlady);
        PageInfo<zulist> pageInfo = new PageInfo<>(zulists);
        return pageInfo;
    }

    @Override
    public void delzuList(String house_id) {
        zulistExample zulistExamplea=new zulistExample();
        zulistExample.Criteria criteria = zulistExamplea.createCriteria();
        criteria.andHouseIdEqualTo(house_id);
        zulistMapper.deleteByExample(zulistExamplea);
    }

}
