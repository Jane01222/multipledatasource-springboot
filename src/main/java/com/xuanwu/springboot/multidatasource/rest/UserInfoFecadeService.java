package com.xuanwu.springboot.multidatasource.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xuanwu.springboot.multidatasource.dao.UserInfoDao;
import com.xuanwu.springboot.multidatasource.dao2.UserInfoDao2;
import com.xuanwu.springboot.multidatasource.dao3.UserInfoDao3;
import com.xuanwu.springboot.multidatasource.domin.JsonResp;
import com.xuanwu.springboot.multidatasource.domin.UserInfo;

@RestController
public class UserInfoFecadeService {
	
	@Autowired
	private UserInfoDao mainUserinfoDao;
	@Autowired
	private UserInfoDao2 secondUserinfoDao;
	@Autowired
	private UserInfoDao3 thirdUserinfoDao;
	
	@ResponseBody
	@RequestMapping(value="demoapi/userinfo",method=RequestMethod.POST)
	public JsonResp testMultiDatasource(){
		List<UserInfo> userinfos = mainUserinfoDao.selectUserInfos();
		return JsonResp.success(userinfos);
	}
	
	@ResponseBody
	@RequestMapping(value="demoapi/userinfo2",method=RequestMethod.POST)
	public JsonResp secondMultiDatasource(){
		List<UserInfo> userinfos = secondUserinfoDao.selectUserInfos();
		return JsonResp.success(userinfos);
	}
	
	@ResponseBody
	@RequestMapping(value="demoapi/userinfo3",method=RequestMethod.POST)
	public JsonResp thirdMultiDatasource(){
		List<UserInfo> userinfos = thirdUserinfoDao.selectUserInfos();
		return JsonResp.success(userinfos);
	}

}
