package com.multi.spring.b_message.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.multi.spring.b_message.Beverage;
import com.multi.spring.b_message.Bread;
import com.multi.spring.b_message.Product;
import com.multi.spring.b_message.ShoppingCart;

@Configuration
@PropertySource("product-info.properties")
public class ContextConfiguration {
	
	// 치환자 (placeholder) 문법을 활용해서 프로퍼티즈 파일의 키 값으로 밸류 값을 얻어올 수 있다.
	@Value("${bread.carpbread.name:붕어빵}")	// :붕어빵 == 초기값 지정
	private String carpBreadName;
	// ${bread.carpbread.name:붕어빵} 중괄호 안에 띄어쓰기를 넣으면 인식이 안됨.
	@Value("${bread.carpbread.name:붕어빵}")	// :붕어빵 == 초기값 지정
	private String carpBreadName2;

	@Value("${bread.carpbread.name:붕어빵}")	// :붕어빵 == 초기값 지정
	private String carpBreadName3;
	
	@Value("${bread.carpbread.price:0}")	// :붕어빵 == 초기값 지정
	private int carpBreadPrice;
	
	private String milkName;
	private int milkPrice;
	private int milkCapacity;

	@Bean
	public Product carpBread() {
		return new Bread(carpBreadName, carpBreadPrice, new java.util.Date());
	}
	
	@Bean
	public Product milk() {
		
		return new Beverage(milkName, milkPrice, milkCapacity);
	}
	
	@Bean
	public Product water(@Value("${beverage.water.name:}") String waterName, 
			@Value("${beverage.water.price:0}") int waterPrice,
			@Value("${beverage.water.capacity:0}") int waterCapacity) {
		
		return new Beverage(waterName, waterPrice, waterCapacity);
	}
	
	@Bean
	//@Scope("prototype")
	public ShoppingCart cart() {
		
		return new ShoppingCart();
	}

}
