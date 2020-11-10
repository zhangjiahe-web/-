package com.kgc.zhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.wrong;
import com.kgc.zhang.entity.wrongExample;
import com.kgc.zhang.mapper.wrongMapper;
import com.kgc.zhang.service.wrongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("wrongService")
public class wrongServiceImpl implements wrongService {
    @Resource
    wrongMapper wrongMapper;

    @Override
    public int insertSelective(wrong record) {
        return wrongMapper.insertSelective(record);
    }

    @Override
    public List<wrong> selectByExample(wrongExample example) {
        return wrongMapper.selectByExample(example);
    }

    //刘学文
    @Override
    public PageInfo<wrong> select(Integer pageNum, Integer pageSize, String landlady) {
        PageHelper.startPage(pageNum, pageSize);
        List<wrong> select = wrongMapper.select(landlady);
        PageInfo<wrong> wrongPageInfo = new PageInfo<>(select);
        return wrongPageInfo;
    }

    @Override
    public wrong selectById(Integer id) {
        wrong wronga = wrongMapper.selectByPrimaryKey(id);
        return wronga;
    }

    @Override
    public void deleteById(Integer id) {
        wrongMapper.deleteByPrimaryKey(id);
    }
}
