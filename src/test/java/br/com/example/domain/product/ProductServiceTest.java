package br.com.example.domain.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

		ProductId productId = service
				.register(new ProductCommand("Playstation 4", "500GB Hits Bundle", BigDecimal.valueOf(1799.00)));

		Product product = repository.getProductById(productId).orElseThrow(ProductNotFoundException::new);

		assertEquals(productId, product.productId());
		assertEquals("Playstation 4", product.name());
		assertEquals("500GB Hits Bundle", product.description());
		assertThat(BigDecimal.valueOf(1799.00), Matchers.comparesEqualTo(product.amount()));
		assertFalse(product.isReserved());
	}

}
