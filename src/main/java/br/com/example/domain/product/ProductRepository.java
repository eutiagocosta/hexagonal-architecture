package br.com.example.domain.product;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository {

	default ProductId nextIdentity() {
		return new ProductId(UUID.randomUUID().toString().toUpperCase());
	}

	void save(Product product);

	Optional<Product> getProductById(ProductId productId);

}
