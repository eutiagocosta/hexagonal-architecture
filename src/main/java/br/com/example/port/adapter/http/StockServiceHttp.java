package br.com.example.port.adapter.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.example.domain.product.ProductId;
import br.com.example.domain.product.StockService;

@Service
public class StockServiceHttp implements StockService{

	@Autowired
	private RestTemplate template;
	
	@Value("${stockUrl}")
	private String stockUrl;

	@Override
	public boolean productIsAvailable(ProductId productId) {
		return template.getForObject(stockUrl, Boolean.class);
	}
	
}
