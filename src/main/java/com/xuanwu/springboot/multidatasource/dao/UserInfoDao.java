package com.xuanwu.springboot.multidatasource.dao;

import java.util.List;

import com.xuanwu.springboot.multidatasource.domin.UserInfo;

public interface UserInfoDao {
	
	public int addUserInfo(UserInfo userInfo);
	
	public List<UserInfo> selectUserInfos();
	
	public Integer selectUserinfoCount();

}
