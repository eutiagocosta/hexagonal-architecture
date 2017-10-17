package br.com.example.adapter.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.domain.product.Product;
import br.com.example.domain.product.ProductId;
import br.com.example.domain.product.ProductRepository;

@Repository
@Transactional
public class ProductRepositoryJpa implements ProductRepository {

	@Autowired
	private ProductRepositorySpringData repository;
	
	@Override
	public void save(Product product) {
		repository.save(product);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Product> getProductById(ProductId productId) {
		return repository.findByProductId(productId);
	}

}
