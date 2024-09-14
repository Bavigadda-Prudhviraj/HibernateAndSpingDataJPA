package com.prudhviraj.hibernateAndJpa;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.prudhviraj.hibernateAndJpa.entites.Product;
import com.prudhviraj.hibernateAndJpa.repository.ProductRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class HibernateAndJpaApplicationTests {
	@Autowired
	ProductRepo productRepo;

	@Test
	void contextLoads() {
	}
	@Test
	void productRepoTest(){
		Product product = Product.builder()
				.price(BigDecimal.valueOf(1234.12))
				.sku("test")
				.title("Test_Tile")
				.quantity(45)
				.build();
		Product savedProduct = productRepo.save(product);
		System.out.println(savedProduct.toString());
	}
	@Test
	void getAllProducts(){
		List<Product> products = productRepo.findAll();
		for (Product ele : products){
			System.out.println(ele);
		}
	}
	@Test
	void getAllProducteCreatedAfter(){
		List<Product> products = productRepo.findByCreatedAtAfter(LocalDateTime.now());
		System.out.println(products);
	}
	@Test
	void getAllProducteCreatedBefore(){
		List<Product> products = productRepo.findByCreatedAtBefore(LocalDateTime.now());
		System.out.println(products);
	}
	@Test
	void getAllProductsByPriceAndQuantity(){
		List<Product> products = productRepo.findByQuantityAndPrice(45,BigDecimal.valueOf(1234.12));
		System.out.println(products);
	}
	@Test
	void findByQuantityGreaterThanAndPriceLessThan(){
		List<Product> products = productRepo.findByQuantityGreaterThanAndPriceLessThan(1,BigDecimal.valueOf(1234.12));
		for (Product ele : products){
			System.out.println(ele);
		}
	}

	@Test
	void findByTitleLike(){
		List<Product> products = productRepo.findByTitleContainingIgnoreCase("a");
		for (Product ele : products){
			System.out.println(ele.getTitle());
		}
	}
	@Test
	void findByTitleAndPrice(){
		List<Product> products = productRepo.findByTitleAndPrice("Test_Tile",BigDecimal.valueOf(1234.12));
		if(products.size() == 0){
			System.out.println("empty List");
		}else {
			for (Product ele : products){
				System.out.println(ele);
			}
		}
	}
	@Test
	void findByTitleOrderByPrice(){
		List<Product> products = productRepo.findByTitleOrderByPrice("Mango");
		if(products.size() == 0){
			System.out.println("empty List");
		}else {
			for (Product ele : products){
				System.out.println(ele);
			}
		}

	}
}
