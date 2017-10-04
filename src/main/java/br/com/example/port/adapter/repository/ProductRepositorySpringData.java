package br.com.example.port.adapter.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.example.domain.product.Product;
import br.com.example.domain.product.ProductId;

public interface ProductRepositorySpringData extends CrudRepository<Product, Long> {

	Optional<Product> findByProductId(ProductId productId);

}
