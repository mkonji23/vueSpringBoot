package com.ds.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ds.vo.userInfoVO;


@Mapper
public interface userInfoMapper {
	public List<Map<String,Object>> getUserInfoList();
	
	public userInfoVO getUserInfo(userInfoVO user);
	
	public int registUserInfo(userInfoVO user);
	
	public Map<String,Object> loginUser(Map<String,Object> user);
}
	