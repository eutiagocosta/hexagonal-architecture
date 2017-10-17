package br.com.example.adapter.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.example.domain.product.ProductId;
import br.com.example.domain.product.ProductService;
import br.com.example.domain.product.command.ProductCommand;
import br.com.example.domain.product.query.ProductQuery;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> newProduct(@RequestBody ProductCommand command) {
		ProductId productId = service.register(command);
		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{productId}")
				.buildAndExpand(productId).toUri()).build();
	}
	
	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public ResponseEntity<ProductQuery> getProduct(@PathVariable String productId){
		return ResponseEntity.ok(service.getProduct(new ProductId(productId)));
	}
	
	@RequestMapping(value = "/{productId}/reserve", method = RequestMethod.POST)
	public ResponseEntity<Void> reserve(@PathVariable String productId){
		service.reserveProduct(new ProductId(productId));
		return ResponseEntity.ok().build();
	}
}
