package com.eai.mybatis.dao;

import java.util.List;

import com.eai.springbatch.model.User;

public interface UserDao {
	
	public List<User> select(User user);

}
