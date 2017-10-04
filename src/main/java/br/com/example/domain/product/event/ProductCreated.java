package br.com.example.domain.product.event;

import java.util.Date;

import br.com.example.domain.DomainEvent;
import br.com.example.domain.product.ProductId;

public class ProductCreated implements DomainEvent {

	private String aggregateId;
	private int eventVersion;
	private Date occorredOn;
	
	public ProductCreated(ProductId productId) {
		setAggregateId(productId.id());
		setEventVersion(1);
		setOccorredOn(new Date());
	}
	
	@SuppressWarnings("unused")
	private ProductCreated() {}

	@Override
	public String aggregateId() {
		return getAggregateId();
	}

	@Override
	public int eventVersion() {
		return getEventVersion();
	}

	@Override
	public Date occorredOn() {
		return getOccorredOn();
	}

	public String getAggregateId() {
		return aggregateId;
	}

	public void setAggregateId(String aggregateId) {
		this.aggregateId = aggregateId;
	}

	public int getEventVersion() {
		return eventVersion;
	}

	public void setEventVersion(int eventVersion) {
		this.eventVersion = eventVersion;
	}

	public Date getOccorredOn() {
		return occorredOn;
	}

	public void setOccorredOn(Date occorredOn) {
		this.occorredOn = occorredOn;
	}

	@Override
	public String toString() {
		return "ProductCreated [aggregateId=" + aggregateId + ", eventVersion=" + eventVersion + ", occorredOn="
				+ occorredOn + "]";
	}

}
