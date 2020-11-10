package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.hetong;
import com.kgc.zhang.entity.hetongExample;
import com.kgc.zhang.entity.zulist;
import com.kgc.zhang.mapper.hetongMapper;
import com.kgc.zhang.mapper.zulistMapper;
import com.kgc.zhang.service.HeTongService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-10-16 16:40
 */
@Service("heTongService")
public class HeTongServiceImpl implements HeTongService {
    @Resource
    hetongMapper hetongMappera;

    @Resource
    zulistMapper zulistMappera;

    //刘学文
    @Override
    public hetong selectByhouseId(String house_id) {
        hetongExample hetongExamplea = new hetongExample();
        hetongExample.Criteria criteria = hetongExamplea.createCriteria();
        criteria.andHouseIdEqualTo(house_id);
        List<hetong> hetongs = hetongMappera.selectByExample(hetongExamplea);
        hetong hetonga = hetongs.get(0);
        return hetonga;
    }

    @Override
    public void delhetongByhouseId(String house_id) {
        hetongExample hetongExamplea = new hetongExample();
        hetongExample.Criteria criteria = hetongExamplea.createCriteria();
        criteria.andHouseIdEqualTo(house_id);
        int i = hetongMappera.deleteByExample(hetongExamplea);
    }

    @Override
    public void insert(hetong hetonga, Integer userid) {
        hetongMappera.insertSelective(hetonga);
        hetongExample hetongExamplea = new hetongExample();
        hetongExample.Criteria criteria = hetongExamplea.createCriteria();
        criteria.andHouseIdEqualTo(hetonga.getHouseId());
        List<hetong> hetongs = hetongMappera.selectByExample(hetongExamplea);
        hetong hetongb = new hetong();
        hetongb = hetongs.get(0);
        zulist zulista = new zulist();
        zulista.setHouseId(hetongb.getHouseId());
        zulista.setUserlistId(userid);
        zulista.setAddress(hetongb.getAddress());
        zulista.setPrice(hetongb.getPrice());
        zulista.setContractId(hetongb.getId());
        System.out.println(hetongb.getAddress());
        zulistMappera.insertSelective(zulista);
    }

    @Override
    public hetong selectById(Integer id) {
        hetong hetong = hetongMappera.selectByPrimaryKey(id);
        return hetong;
    }

    @Override
    public void update(hetong hetong) {
        hetongMappera.updateByPrimaryKeySelective(hetong);
    }
}
