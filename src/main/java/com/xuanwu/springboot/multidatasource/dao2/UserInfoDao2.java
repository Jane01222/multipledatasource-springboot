package com.xuanwu.springboot.multidatasource.dao2;

import java.util.List;

import com.xuanwu.springboot.multidatasource.domin.UserInfo;

public interface UserInfoDao2 {
	
	public int addUserInfo(UserInfo userInfo);
	
	public List<UserInfo> selectUserInfos();
	
	public Integer selectUserinfoCount();

}
