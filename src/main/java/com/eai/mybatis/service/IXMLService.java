package com.eai.mybatis.service;

import java.util.Map;

import com.eai.mybatis.domain.UserInfo;

public interface IXMLService {

	void updateUser(String id, String name);

	UserInfo getUser(Integer id);

	void deleteUserByUserId(UserInfo userInfo);

	void createUser(Map<String, Object> reqMap);

}