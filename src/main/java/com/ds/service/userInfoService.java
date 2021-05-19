package com.ds.service;

import java.util.List;
import java.util.Map;

import com.ds.vo.userInfoVO;

public interface userInfoService {
	
	List<Map<String,Object>> getUserInfoList() throws Exception;
	
	int registUserInfo(userInfoVO user) throws Exception;
	
	userInfoVO getUserInfo(userInfoVO user) throws Exception;
	
	Map<String,Object> loginUser(Map<String,Object> map) throws Exception;
}
