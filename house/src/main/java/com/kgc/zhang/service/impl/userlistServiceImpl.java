package com.kgc.zhang.service.impl;

import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.entity.userlistExample;
import com.kgc.zhang.mapper.userlistMapper;
import com.kgc.zhang.service.userlistService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userlistService")
public class userlistServiceImpl implements userlistService {
    @Resource
    userlistMapper userlistMapper;


    @Override
    public int userlistAdd(userlist userlist) {
        return userlistMapper.insert(userlist);
    }
    //查询是否绑定身份证
    @Override
    public List<userlist> UserListID(Integer user_id) {
        userlistExample example=new userlistExample();
        userlistExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(user_id);
        List<userlist> userlists = userlistMapper.selectByExample(example);

        return userlists;
    }

    @Override
    public List<userlist> GetAll(userlistExample example) {
        return userlistMapper.selectByExample(example);
    }

    @Override
    public List<userlist> zhgl(String landlady) {
        return userlistMapper.zhgl(landlady);
    }


    //刘学文
	 @Override
    public userlist selectById(Integer userid) {
        userlistExample example=new userlistExample();
        userlistExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userid);
        List<userlist> userlists = userlistMapper.selectByExample(example);
        userlist userlista=new userlist();
        userlista=userlists.get(0);
        return userlista;
    }

    @Override
    public userlist selectByUserId(Integer id) {
        userlistExample userlistExample=new userlistExample();
        com.kgc.zhang.entity.userlistExample.Criteria criteria = userlistExample.createCriteria();
        criteria.andUserIdEqualTo(id);
        List<userlist> userlists = userlistMapper.selectByExample(userlistExample);
        userlist userlist=userlists.get(0);
        return userlist;
    }

}
