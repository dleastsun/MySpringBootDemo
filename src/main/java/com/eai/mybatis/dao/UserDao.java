package com.eai.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.eai.springbatch.model.User;

@Mapper
@Repository
public interface UserDao {
	
	public List<User> select(User user);

}
