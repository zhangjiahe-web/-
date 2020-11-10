package com.kgc.zhang.service;

import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.entity.userlistExample;

import java.util.List;

public interface userlistService {
    int userlistAdd(userlist userlist);
    //查询是否绑定身份证
    List<userlist> UserListID(Integer user_id);
    List<userlist> GetAll(userlistExample example);

/*账户管理*/
List<userlist> zhgl(String landlady);
    //刘学文
    userlist selectById(Integer userid);

    userlist selectByUserId(Integer id);
}
