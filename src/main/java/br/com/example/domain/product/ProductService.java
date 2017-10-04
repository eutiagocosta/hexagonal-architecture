package br.com.example.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.example.domain.product.command.ProductCommand;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repository;

	public String register(ProductCommand command) {

		Product product = new Product(repository.nextIdentity(), 
				command.getName(), 
				command.getDescription(),
				command.getAmount());

		repository.save(product);

		return product.productId().id();
	}

}
