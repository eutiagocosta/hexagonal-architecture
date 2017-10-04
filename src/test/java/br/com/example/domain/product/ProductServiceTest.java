package br.com.example.domain.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.hamcrest.Matchers;
import org.junit.Test;

import br.com.example.HexagonalArchitectureApplicationTests;
import br.com.example.domain.product.command.ProductCommand;
import br.com.example.domain.product.exception.ProductNotFoundException;

public class ProductServiceTest extends HexagonalArchitectureApplicationTests {
	
	@Test
	public void shouldRegisterAproduct() {
		
		String id = service.register(new ProductCommand("Playstation 4", "500GB Hits Bundle", BigDecimal.valueOf(1799.00)));
		
		Product product = repository.getProductById(new ProductId(id))
				.orElseThrow(ProductNotFoundException::new);
		
		assertEquals(new ProductId(id), product.productId());
		assertEquals("Playstation 4", product.name());
		assertEquals("500GB Hits Bundle", product.description());
		assertThat(BigDecimal.valueOf(1799.00),  Matchers.comparesEqualTo(product.amount()));
	
	}

}
