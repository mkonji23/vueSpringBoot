package com.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.common.security.service.AuthenticationTokenProvider;
import com.ds.service.userInfoService;
import com.ds.vo.userInfoVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenAuthenticationFilter  extends OncePerRequestFilter{

	@Autowired
	private AuthenticationTokenProvider authenticationTokenProvider;
	
	@Autowired
	private userInfoService userService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		log.info("token: {}",request.getHeader("Authorization"));
		String token = authenticationTokenProvider.parseTokenString(request);
		if (authenticationTokenProvider.validateToken(token)) {
			String userId = authenticationTokenProvider.getTokenOwnerNo(token);
			try {
				userInfoVO param = new userInfoVO();
				param.setUserId(userId);
				userInfoVO member = userService.getUserInfo(param);
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(member,
						member.getPassword());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				authentication.setAuthenticated(true);
				log.info("authentication: {}", authentication);
				SecurityContextHolder.getContext().setAuthentication(authentication);
			} catch (UsernameNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
