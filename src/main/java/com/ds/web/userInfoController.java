package com.ds.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ds.service.userInfoService;
import com.ds.vo.userInfoVO;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value="/api/user")
public class userInfoController {
	
	@Autowired
 	private userInfoService userInfoService;
	
	@ApiOperation(value="사용자 정보", notes ="사용자 정보를 조회합니다.")
	@GetMapping(value="/getList")
	public List<userInfoVO> userInfo() throws Exception {
		List<userInfoVO> userList = new ArrayList<userInfoVO>();
		userList = userInfoService.getUserInfoList();
		log.info("abcdef");
		return userList;
	}
	
	@GetMapping(value="/userList/test")
	public userInfoVO test(){
		userInfoVO user = new userInfoVO();
		user.setUserid("test123");
		return user;
	}

}
