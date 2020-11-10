package com.kgc.zhang.service;

import com.kgc.zhang.entity.apply;
import com.kgc.zhang.entity.applyExample;
import com.kgc.zhang.entity.applyKey;

import java.util.List;

public interface applyService {
    //查询租客申请房屋
    List<apply> getAll(applyExample example);
    List<apply> selectapplyanduserlist(applyExample example);

    /*添加申请*/
    int addapply(apply apply);
    //房东查看申请房租
    public List<apply> findapplylist(String username);
    /*查看拒绝申请房子*/
    List<apply> jujueapplylist(String username) ;
    /*房东拒绝租客申请*/
    int updateByPrimaryKeySelective(apply record);
    /*租客删除拒绝申请信息*/
    int deleteByPrimaryKey(applyKey key);
	
	//刘学文
	void deleteByHouserID(String houseId);
}
