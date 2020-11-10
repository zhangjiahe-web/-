package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.houselist;
import com.kgc.zhang.entity.houselistExample;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.mapper.houselistMapper;
import com.kgc.zhang.service.houselistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("houselist")
public class houselistServiceImpl implements houselistService {
    @Resource
    houselistMapper houselistMapper;

    @Override
    public List<houselist> getAll(houselistExample example) {

        return houselistMapper.selectByExample(example);
    }
/*查看房源信息*/
    @Override
    public houselist houListCHA(houselist key) {
        return houselistMapper.selectByPrimaryKey(key);
    }
/*申请看房*/
public int houlistKAN(houselist key){
    return  houselistMapper.updateByPrimaryKeySelective(key);
}

    @Override
    public int updateByPrimaryKeySelective(houselist record) {
        return houselistMapper.updateByPrimaryKeySelective(record);
    }

//刘学文
 @Override
    public houselist select(int id) {
        houselist houselist = houselistMapper.selectByPrimaryKey(id);
        return houselist;
    }

    @Override
    public void update(houselist houselista) {
        houselistMapper.updateByPrimaryKeySelective(houselista);
    }

    @Override
    public void delete(int id) {
    houselistExample houselistExamplea=new houselistExample();
        houselistExample.Criteria criteria = houselistExamplea.createCriteria();
        criteria.andIdEqualTo(id);
        houselistMapper.deleteByExample(houselistExamplea);
    }

    @Override
    public houselist selectByHouseId(String house_id) {
        houselistExample houselistExamplea=new houselistExample();
        houselistExample.Criteria criteria = houselistExamplea.createCriteria();
        criteria.andHouseidEqualTo(house_id);
        List<houselist> houselists = houselistMapper.selectByExample(houselistExamplea);
        houselist houselista=new houselist();
        houselista=houselists.get(0);
        return houselista;
    }

    @Override
    public void updateByHouseList(houselist houselist) {
        houselistMapper.updateByPrimaryKeySelective(houselist);
    }

}
