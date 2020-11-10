package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.schedule;
import com.kgc.zhang.entity.scheduleExample;
import com.kgc.zhang.mapper.scheduleMapper;
import com.kgc.zhang.service.scheduleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("scheduleService")
public class scheduleServiceImpl implements scheduleService {
    @Resource
    scheduleMapper scheduleMapper;
    @Override
    public List<schedule> selectByExample(scheduleExample example) {
        return scheduleMapper.selectByExample(example);
    }

    @Override
    public schedule selectByPrimaryKey(Integer id) {
        return scheduleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertSelective(schedule record) {
        return scheduleMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return scheduleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(schedule record) {
        return scheduleMapper.updateByPrimaryKeySelective(record);
    }
}
