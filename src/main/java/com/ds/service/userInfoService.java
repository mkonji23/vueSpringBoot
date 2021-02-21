package com.ds.service;

import java.util.List;

import com.ds.vo.userInfoVO;

public interface userInfoService {
	
	List<userInfoVO> getUserInfoList() throws Exception;
	
	int registUserInfo(userInfoVO user) throws Exception;
	
	userInfoVO getUserInfo(userInfoVO user) throws Exception;
}
