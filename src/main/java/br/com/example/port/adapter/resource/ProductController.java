package br.com.example.port.adapter.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beblue.utils.web.Return;

import br.com.example.domain.product.ProductService;
import br.com.example.domain.product.command.ProductCommand;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public Return newProduct(ProductCommand command) {
		return new Return(service.register(command));
	}
}
