package br.com.example;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.example.domain.product.ProductRepository;
import br.com.example.domain.product.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class HexagonalArchitectureApplicationTests {

	@Autowired
	protected ProductService service;
	
	@Autowired
	protected ProductRepository repository;
}
