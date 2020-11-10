package com.kgc.zhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.zhang.entity.applyout;
import com.kgc.zhang.entity.applyoutExample;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.entity.userlistExample;
import com.kgc.zhang.mapper.applyoutMapper;
import com.kgc.zhang.mapper.userlistMapper;
import com.kgc.zhang.service.applyoutService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("applyoutService")
public class applyoutServiceImpl implements applyoutService {
    @Resource
    applyoutMapper applyoutMapper;
	
	@Resource
    userlistMapper userlistMappera;

    @Override
    public int insertSelective(applyout record) {
        return applyoutMapper.insertSelective(record);
    }

    @Override
    public List<applyout> tuizulist(applyoutExample example) {
        return applyoutMapper.tuizulist(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer aoid) {
        return applyoutMapper.deleteByPrimaryKey(aoid);
    }
	//刘学文
	
	 @Override
    public void insert(applyout applyouta) {
         applyoutMapper.insertSelective(applyouta);
    }

    @Override
    public PageInfo<applyout> select(Integer pageNum, Integer pageSize,String landlady) {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("aoid  desc");
        List<applyout> applyouts = applyoutMapper.select(landlady);
        PageInfo<applyout> applyoutPageInfo = new PageInfo<>(applyouts);
        return applyoutPageInfo;
    }

    @Override
    public void deleteById(Integer id) {
        applyoutMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateTongYi(Integer id) {
        applyout applyouta = new applyout();
        applyouta.setAoid(id);
        applyouta.setStatus("已同意");
        applyoutMapper.updateByPrimaryKeySelective(applyouta);
    }

    @Override
    public void updateJuJue(Integer id) {
        applyout applyouta = new applyout();
        applyouta.setAoid(id);
        applyouta.setStatus("已拒绝");
        applyoutMapper.updateByPrimaryKeySelective(applyouta);
    }

    @Override
    public applyout selectById(Integer id) {
        applyout applyout = applyoutMapper.selectByPrimaryKey(id);
        return applyout;
    }
}
