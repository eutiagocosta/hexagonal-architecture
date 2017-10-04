package br.com.example.domain.product.command;

import java.math.BigDecimal;

public class ProductCommand {

	private String name;
	private String description;
	private BigDecimal amount;
	
	public ProductCommand(String name, String description, BigDecimal amount) {
		this.name = name;
		this.description = description;
		this.amount = amount;
	}
	
	@SuppressWarnings("unused")
	private ProductCommand() {}
	
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
	
}
