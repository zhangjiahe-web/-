package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.apply;
import com.kgc.zhang.entity.applyExample;
import com.kgc.zhang.entity.applyKey;
import com.kgc.zhang.mapper.applyMapper;
import com.kgc.zhang.service.applyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("applyService")
public class applyServiceImpl implements applyService {
    @Resource
    applyMapper applyMapper;
	
    @Override
    public List<apply> getAll(applyExample example) {
        return applyMapper.selectByExample(example);
    }

    @Override
    public List<apply> selectapplyanduserlist(applyExample example) {
        return applyMapper.selectapplyanduserlist(example);
    }

    @Override
    public int addapply(apply apply) {
        return applyMapper.insertSelective(apply);
    }

    @Override
    public List<apply> findapplylist(String username) {
        return applyMapper.findapplylist(username);
    }

    @Override
    public List<apply> jujueapplylist(String username) {
        return applyMapper.jujueapplylist(username);
    }

    @Override
    public int updateByPrimaryKeySelective(apply record) {
        return applyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(applyKey key) {
        return applyMapper.deleteByPrimaryKey(key);
    }
	
	 @Override
    public void deleteByHouserID(String houseId) {
        applyExample applyExamplea = new applyExample();
        applyExample.Criteria criteria = applyExamplea.createCriteria();
        criteria.andHouseIdEqualTo(houseId);
        applyMapper.deleteByExample(applyExamplea);
    }
}
