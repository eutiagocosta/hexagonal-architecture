package br.com.example.domain.product;

import java.math.BigDecimal;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.example.domain.DomainRegister;
import br.com.example.domain.product.event.ProductCreated;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Embedded
	private ProductId productId;
	private String name;
	private String description;
	private BigDecimal amount;
	private boolean reserved;

	@SuppressWarnings("unused")
	private Product() {}
	
	public Product(ProductId productId, String name, String description, BigDecimal amount) {
		setProductId(productId);
		setName(name);
		setDescription(description);
		setAmount(amount);
		setReserved(false);
		//Publicando eventos de dominio
		DomainRegister.domainEventPublisher().publish(new ProductCreated(productId));
	}
	
	public void flagToReserved() {
		setReserved(true);
	}

	public ProductId productId() {
		return getProductId();
	}
	
	public String name() {
		return getName();
	}
	
	public String description() {
		return getDescription();
	}
	
	public BigDecimal amount() {
		return getAmount();
	}

	private ProductId getProductId() {
		return productId;
	}

	private void setProductId(ProductId productId) {
		this.productId = productId;
	}

	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = description;
	}

	private BigDecimal getAmount() {
		return amount;
	}

	private void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public boolean isReserved() {
		return reserved;
	}

	public void setReserved(boolean reserved) {
		this.reserved = reserved;
	}
	
}
