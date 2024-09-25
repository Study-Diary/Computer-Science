package com.seikim.annotationstudy.annotation2;

import java.text.MessageFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 2.1.2. 소프트웨어 개발 환경이 빌드나 배포시 코드를 자동으로 생성할 수 있도록 정보 제공
 */

@AllArgsConstructor
@Getter
public class ProductEntity {
	private String name;
	private int quantity;

	public static void main(String[] args) {
		ProductEntity productEntity = new ProductEntity("과자", 10);
		System.out.println(
				MessageFormat.format("제품 이름: {0}, 수량: {1}",
						productEntity.getName(), productEntity.getQuantity()));
	}
}
