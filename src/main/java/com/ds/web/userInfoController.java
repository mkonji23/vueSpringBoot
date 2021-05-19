package com.ds.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.common.ApiResponseMessage;
import com.common.security.service.AuthenticationToken;
import com.common.security.service.AuthenticationTokenProvider;
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
	
	@Autowired
	private AuthenticationTokenProvider tokenProvider;
	
	@ApiOperation(value="사용자 정보", notes ="사용자 정보를 조회합니다.")
	@GetMapping(value="/getList")
	public ResponseEntity<List<Map<String,Object>>> userInfo() throws Exception {
		List<Map<String,Object>> userList  = userInfoService.getUserInfoList();
		log.info("abcdef");
		ApiResponseMessage msg = new ApiResponseMessage("200", "성공했다", null, null);
        return new ResponseEntity<List<Map<String,Object>>>(userList, HttpStatus.OK);
	}
	
	@GetMapping(value="/userList/test")
	public userInfoVO test(){
		userInfoVO user = new userInfoVO();
		user.setUserId("test123");
		return user;
	}
	
	@ApiOperation(value="사용자 등록", notes ="사용자를 등록합니다.")
	@PostMapping(value="/regist")
	public ResponseEntity<userInfoVO> registUser(@RequestBody userInfoVO user) throws Exception {
		log.info("pawword: {}", user.getPassword());
		int abcd = userInfoService.registUserInfo(user);
		ApiResponseMessage msg = new ApiResponseMessage("200", "성공했다", null, null);
        return new ResponseEntity<userInfoVO>(user, HttpStatus.OK);
	}
	
	@ApiOperation(value="사용자 로그인", notes ="사용자를 로그인 및 토큰")
	@PostMapping(value="/loginUser")
	public ResponseEntity<?> loginUser(
			@RequestParam("userId") String userId, @RequestParam("password") String pwd
			) throws Exception {
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("userId", userId);
		param.put("password", pwd);
		Map<String,Object> userInfo = userInfoService.loginUser(param);
		if(userInfo != null) {
			AuthenticationToken tokenService = tokenProvider.issue(userId);
			String token = "Bearer " + tokenService.getToken();
//			userInfo.setToken(token);
			userInfo.put("token", token);
		}
		
        return new ResponseEntity<Map<String,Object>>(userInfo, HttpStatus.OK);
	}
	
	@ApiOperation(value="토큰 발급받기", notes ="토큰을 발급합니다.")
	@GetMapping(value="/getToken")
	public ResponseEntity<String> getUserToken(@RequestParam String userId) throws Exception {
		AuthenticationToken tokenService = tokenProvider.issue(userId);
		String token = "Bearer " + tokenService.getToken();
		log.info("토큰발급현황: {}" , token);
        return new ResponseEntity<String>(token, HttpStatus.OK);
	}

}
