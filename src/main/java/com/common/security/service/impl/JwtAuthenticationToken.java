package com.common.security.service.impl;

import com.common.security.service.AuthenticationToken;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class JwtAuthenticationToken implements AuthenticationToken {
    private String token;
}
