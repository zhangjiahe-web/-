package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.user;
import com.kgc.zhang.entity.userExample;
import com.kgc.zhang.mapper.userMapper;
import com.kgc.zhang.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-10 9:55
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    userMapper userMapper;

    @Override
    public user selectByUserName(String userName) {
        user user=null;
        userExample userExample=new userExample();
        userExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(userName);
        List<user> users = userMapper.selectByExample(userExample);
        if (users!=null&&users.size()>0){
            user=users.get(0);
        }
        return user;
    }

    @Override
    public int insert(user user) {
        int i = userMapper.insertSelective(user);
        return i;
    }

}
