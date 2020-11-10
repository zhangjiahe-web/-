package com.kgc.zhang.service;

import com.kgc.zhang.entity.user;

/**
 * @author shkstart
 * @create 2020-09-10 9:55
 */
public interface UserInfoService {
    user selectByUserName(String userName);

    int insert(user user);

}
