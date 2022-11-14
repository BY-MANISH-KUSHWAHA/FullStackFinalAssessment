package com.authentication.service.authentication;


import com.authentication.service.authentication.Entity.Category;
import com.authentication.service.authentication.Entity.Product;
import com.authentication.service.authentication.Repository.CatergoryRepository;
import com.authentication.service.authentication.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShopServiceApplication implements CommandLineRunner {
	@Autowired
	private CatergoryRepository catergoryRepository;

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ShopServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello");
		catergoryRepository.save(new Category(1,"food"));
		catergoryRepository.save(new Category(2,"electrical"));

		productRepository.save(new Product(1,"Banana","$1.1","fruit"));
		productRepository.save(new Product(2,"Cooker","Rs. 12000","kitchen appliance"));

	}
}
