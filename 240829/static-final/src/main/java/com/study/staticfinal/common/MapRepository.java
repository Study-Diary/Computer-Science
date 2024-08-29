package com.study.staticfinal.common;

import java.util.List;

public interface MapRepository<T> {
	T save(T entity);

	T findById(long id);

	List<T> findAll();

	boolean deleteById(long id);
}
