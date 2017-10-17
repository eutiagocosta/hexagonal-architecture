package br.com.example.domain.product;

import java.util.Optional;

public interface ProductRepository {

	void save(Product product);

	Optional<Product> getProductById(ProductId productId);

}
