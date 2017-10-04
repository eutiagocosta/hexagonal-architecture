package br.com.example.domain.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;

import br.com.example.HexagonalArchitectureApplicationTests;

public class ProductTest extends HexagonalArchitectureApplicationTests {

	@Test
	public void newProduct() {
		
		Product product = new Product(new ProductId("1234567"),
				"Geladeira", 
				"Brastemp Frost Free Clean BRM39", 
				BigDecimal.valueOf(1300.00));
		
		assertEquals(new ProductId("1234567"), product.productId());
		assertEquals("Geladeira", product.name());
		assertEquals("Brastemp Frost Free Clean BRM39", product.description());
		assertThat(BigDecimal.valueOf(1300.00),  Matchers.comparesEqualTo(product.amount()));
	}
}
