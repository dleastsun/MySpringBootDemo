package com.eai.mybatis.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.eai.mybatis.domain.UserInfo;

/**
 * 
 * @author xudong.li
 *
 */
@Mapper
@Repository
public interface MybatisUserXMLMapper {

    void createUser(Map<String, Object> reqMap);

    UserInfo getUser(@Param("id") Integer id);

    void updateUser(@Param("id") String user_id, @Param("name") String name);

    void deleteUserByUserId(UserInfo userInfo);
}
