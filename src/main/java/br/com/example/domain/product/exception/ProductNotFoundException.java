package br.com.example.domain.product.exception;

public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6743772036853265878L;
	private static final String MSG = "Produto informado não encontrado";
	
	public ProductNotFoundException() {
		super(MSG);
	}
	
}
