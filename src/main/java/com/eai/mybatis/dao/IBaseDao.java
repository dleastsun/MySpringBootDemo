package com.eai.mybatis.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, PK extends Serializable> {

	public T findEntityById(PK id);

	public List<T> findEntity(Object... obj);

	public List<T> findLikeEntity(Object... obj);

	public void insertEntity(T t);

	public void updateEntityById(T entity);

	public void deleteById(PK id);

	public void deleteByCondition(Object param);

//	public PageMyBatis<T> queryByVo(int i, int c, Object... obj);

//	public PageMyBatis<T> LikequeryByVo(int i, int c, Object... obj);

}
