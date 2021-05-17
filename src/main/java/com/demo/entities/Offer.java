package com.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "offer")
public class Offer {

	@Id
	@Column(name = "offerId")
    private int offerId;
	
	@JoinColumn(name = "productId")
	@ManyToOne
	@JsonBackReference
    private Product productId;

	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@OneToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "offerTypeId", nullable = false)
    private OfferType offerTypeId;
	
	@Column(name = "valid")
    private int valid;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public OfferType getOfferTypeId() {
		return offerTypeId;
	}

	public void setOfferTypeId(OfferType offerTypeId) {
		this.offerTypeId = offerTypeId;
	}

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}
	
}
