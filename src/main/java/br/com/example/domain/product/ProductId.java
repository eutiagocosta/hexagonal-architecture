package br.com.example.domain.product;

import javax.persistence.Embeddable;

@Embeddable
public class ProductId {

	private String productId;

	@SuppressWarnings("unused")
	private ProductId() {}
	
	public ProductId(String productId) {
		setProductId(productId);
	}
	
	public String id() {
		return getProductId();
	}
	
	private String getProductId() {
		return productId;
	}

	private void setProductId(String productId) {
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductId other = (ProductId) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return productId;
	}
	
}
