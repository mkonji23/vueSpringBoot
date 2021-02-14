package com.ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.mapper.userInfoMapper;
import com.ds.service.userInfoService;
import com.ds.vo.userInfoVO;


@Service
public class userInfoServiceImpl implements userInfoService {

	//@Resource 사용가능
	// autowried 사용시 mapperjava에서 @Mapper 어노테이션 사용함
	@Autowired
	private userInfoMapper mapper;
	
	@Override
	public List<userInfoVO> getUserInfoList() throws Exception {
		// TODO Auto-generated method stub
		return mapper.getUserInfoList();
	}

}
