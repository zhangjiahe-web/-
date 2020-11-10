package com.kgc.zhang.service;

import com.kgc.zhang.entity.hetong;

/**
 * @author shkstart
 * @create 2020-10-16 16:39
 */
public interface HeTongService {


    hetong selectByhouseId(String house_id);

    void delhetongByhouseId(String house_id);

    void insert(hetong hetonga, Integer userid);

    hetong selectById(Integer id);

    void update(hetong hetong);
}
