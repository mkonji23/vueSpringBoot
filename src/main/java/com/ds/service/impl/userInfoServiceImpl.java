package com.ds.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ds.mapper.userInfoMapper;
import com.ds.service.userInfoService;
import com.ds.vo.userInfoVO;


@Service
public class userInfoServiceImpl implements userInfoService {

	//@Resource 사용가능
	// autowried 사용시 mapperjava에서 @Mapper 어노테이션 사용함
	@Autowired
	private userInfoMapper mapper;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public List<userInfoVO> getUserInfoList() throws Exception {
		return mapper.getUserInfoList();
	}
	
	@Override
	public int registUserInfo(userInfoVO user) throws Exception {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return mapper.registUserInfo(user);
	}

	@Override
	public userInfoVO getUserInfo(userInfoVO user) throws Exception {
		return mapper.getUserInfo(user);
	}

}
