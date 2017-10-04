package br.com.example.domain.product.query;

import java.math.BigDecimal;

public class ProductQuery {

	private String productId;
	private String name;
	private String description;
	private BigDecimal amount;
	private boolean reserved;
	
	public ProductQuery(String productId, String name, String description, BigDecimal amount, boolean reserved) {
		setProductId(productId);
		setName(name);
		setDescription(description);
		setAmount(amount);
		setReserved(reserved);
	};
	
	@SuppressWarnings("unused")
	private ProductQuery() {}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
}
