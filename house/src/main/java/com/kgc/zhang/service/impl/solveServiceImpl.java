package com.kgc.zhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.solve;
import com.kgc.zhang.entity.solveExample;
import com.kgc.zhang.mapper.solveMapper;
import com.kgc.zhang.service.solveService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("solveService")
public class solveServiceImpl implements solveService {
    @Resource
    solveMapper solveMapper;

    @Override
    public List<solve> selectByExample(solveExample example) {
        return solveMapper.selectByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return solveMapper.deleteByPrimaryKey(id);
    }


    //刘学文
    @Override
    public void insert(solve solvea) {
        solveMapper.insertSelective(solvea);
    }

    @Override
    public PageInfo<solve> select(Integer pageNum, Integer pageSize, String landlady,String zuname,String id) {
        PageHelper.startPage(pageNum, pageSize);
        List<solve> select = solveMapper.select(landlady,zuname,id);
        PageInfo<solve> solvePageInfo = new PageInfo<>(select);
        return solvePageInfo;
    }

    @Override
    public void deleteById(int id) {
        solveExample solveExamplea=new solveExample();
        solveExample.Criteria criteria = solveExamplea.createCriteria();
        criteria.andIdEqualTo(id);
        solveMapper.deleteByExample(solveExamplea);
    }


}
