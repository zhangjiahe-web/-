package com.kgc.zhang.service;

import com.kgc.zhang.entity.houselist;
import com.kgc.zhang.entity.houselistExample;
import com.kgc.zhang.entity.userlist;
import com.kgc.zhang.entity.userlistExample;

import java.util.List;

public interface houselistService {
    //显示所有房东出租得房屋
    List<houselist> getAll(houselistExample example);
    /*房子信息查看*/
    houselist houListCHA(houselist key);
    /*申请看房*/
    int houlistKAN(houselist key);
    /*申请拒绝改成未租赁*/
    int updateByPrimaryKeySelective(houselist record);

	//刘学文
	houselist select(int id);

    void update(houselist houselista);

    void delete(int id);

    houselist selectByHouseId(String house_id);

    void updateByHouseList(houselist houselist);
}
