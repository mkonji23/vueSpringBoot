package com.ds.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Map<String,Object>> getUserInfoList() throws Exception {
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

	@Override
	public Map<String,Object> loginUser(Map<String,Object> map) throws Exception {
		Map<String,Object> userInfo = mapper.loginUser(map);
		String encodedPassword = (String) userInfo.get("password");
		String rawPassword = (String) map.get("password");
		// 비밀번호 일치여부
		boolean flag =  passwordEncoder.matches(rawPassword, encodedPassword);
		if(!flag) {
			return null;
		}
		return userInfo;
	}

}
