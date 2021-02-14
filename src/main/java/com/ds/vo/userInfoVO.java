package com.ds.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Data
@Alias("userInfoVO")
public class userInfoVO {
	 private String userid;
	 private String password;
	 private String name;
	 private String address;
}
