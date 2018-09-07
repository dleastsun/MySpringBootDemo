package com.eai.mybatis.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eai.mybatis.dao.MybatisUserXMLMapper;
import com.eai.mybatis.domain.UserInfo;

/**
 * 
 * @author xudong.li
 *
 */
@Service
public class XMLService {

    @Autowired
    private MybatisUserXMLMapper mapper;


    public void updateUser(String id, String name) {
        mapper.updateUser(id,name);
    }

    public UserInfo getUser(Integer id) {
        return mapper.getUser(id);
    }

    public void deleteUserByUserId(UserInfo userInfo) {
        mapper.deleteUserByUserId(userInfo);
    }

    public void createUser(Map<String, Object> reqMap) {
        mapper.createUser(reqMap);
    }
}
