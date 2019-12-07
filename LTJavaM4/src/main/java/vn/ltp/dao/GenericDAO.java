package vn.ltp.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<ID extends Serializable, T>{
	List<T> findAll();
	int save(T entity);
	T findById(Serializable id);
	T update(T entity);
	Integer delete(List<Integer> ids);
	int count();
	List<T> search(String properties, String value, int index, int size);
}
