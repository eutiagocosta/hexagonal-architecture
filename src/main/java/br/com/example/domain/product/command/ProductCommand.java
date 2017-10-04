package br.com.example.domain.product.command;

import java.math.BigDecimal;

public class ProductCommand {

	private String name;
	private String description;
	private BigDecimal amount;

	public ProductCommand(String name, String description, BigDecimal amount) {
		setName(name);
		setDescription(description);
		setAmount(amount);
	}
	
	@SuppressWarnings("unused")
	private ProductCommand() {}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
