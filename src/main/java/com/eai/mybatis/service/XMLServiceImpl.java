package com.eai.mybatis.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.eai.mybatis.dao.MybatisUserXMLMapper;
import com.eai.mybatis.domain.UserInfo;

/**
 * 
 * @author xudong.li
 * 
 */
@Service("xmlService")
@CacheConfig(cacheNames = "myCache") 
public class XMLServiceImpl implements IXMLService {

    @Autowired
    private MybatisUserXMLMapper mapper;
    
    /**
	 * 对数据进行增删改时清空缓存, 查询时使用缓存, 其中value为缓存区,
	 * allEntries表示清空缓存中所有的数据
	 */

    /* (non-Javadoc)
	 * @see com.eai.mybatis.service.IXMLService#updateUser(java.lang.String, java.lang.String)
	 */
    @Override
    @CachePut(value="user",key = "#p0")
	public void updateUser(String id, String name) {
        mapper.updateUser(id,name);
    }

    /* (non-Javadoc)
	 * @see com.eai.mybatis.service.IXMLService#getUser(java.lang.Integer)
	 */
//    @Override
//    @Cacheable(value="user",key = "#p0")
	public UserInfo getUser(Integer id) {
        return mapper.getUser(id);
    }

    /* (non-Javadoc)
	 * @see com.eai.mybatis.service.IXMLService#deleteUserByUserId(com.eai.mybatis.domain.UserInfo)
	 */
    @Override
    @CacheEvict(value="user",key = "#p0",allEntries=true) 
	public void deleteUserByUserId(UserInfo userInfo) {
        mapper.deleteUserByUserId(userInfo);
    }

    /* (non-Javadoc)
	 * @see com.eai.mybatis.service.IXMLService#createUser(java.util.Map)
	 */
    //使用#"user.id + '方法名'"做为key.
    @Override
    @CacheEvict(value = "user", key = "#id + 'create'")
	public void createUser(Map<String, Object> reqMap) {
        mapper.createUser(reqMap);
    }
}
