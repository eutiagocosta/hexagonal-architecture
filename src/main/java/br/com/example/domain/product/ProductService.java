package br.com.example.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.example.domain.product.command.ProductCommand;
import br.com.example.domain.product.exception.ProductNotFoundException;
import br.com.example.domain.product.query.ProductQuery;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Autowired
	private StockApiService apiService;

	public ProductId register(ProductCommand command) {

		Product product = new Product(ProductId.newIdentity(), 
				command.getName(), 
				command.getDescription(),
				command.getAmount());

		repository.save(product);

		return product.productId();
	}

	public ProductQuery getProduct(ProductId productId) {
		return repository.getProductById(productId)
				.map(p -> new ProductQuery(p.productId().id(), p.name(), p.description(), p.amount(), p.isReserved()))
				.orElseThrow(ProductNotFoundException::new);
	}

	public void reserveProduct(ProductId productId) {

		Product product = repository.getProductById(productId).orElseThrow(ProductNotFoundException::new);

		if (apiService.productIsAvailable(productId)) {
			product.flagToReserved();
			repository.save(product);
		}
		
	}

}
