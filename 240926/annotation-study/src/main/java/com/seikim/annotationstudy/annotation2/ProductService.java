package com.seikim.annotationstudy.annotation2;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

/**
 * 3.4. @Inherited
 */

@Transactional
abstract class CustomRepository<T> {
	AtomicInteger id = new AtomicInteger(1);
	ConcurrentHashMap<Integer, T> map = new ConcurrentHashMap<>();

	public T save(T entity) {
		return map.put(id.getAndIncrement(), entity);
	}
}

// `@Transactional`적용
@Repository
class ProductRepository extends CustomRepository<ProductEntity> {
}

/**
 * 2.1.3. 런타임에 특정 기능을 실행하도록 정보를 제공
 */

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository productRepository;

	public void save(String name, int quantity) {
		ProductEntity product = new ProductEntity(name, quantity);
		ProductEntity savedProductEntity = productRepository.save(product);
		// ETC...
	}
}