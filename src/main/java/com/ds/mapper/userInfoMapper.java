package com.ds.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ds.vo.userInfoVO;


@Mapper
public interface userInfoMapper {
	public List<userInfoVO> getUserInfoList();
	
	public userInfoVO getUserInfo(userInfoVO user);
	
	public int registUserInfo(userInfoVO user);
	
	public userInfoVO loginUser(userInfoVO user);
}
