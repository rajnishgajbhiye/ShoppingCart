package com.demo.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offerType")
public class OfferType {

	@Id
	@Column(name = "offerTypeId")
    private int offerTypeId;
	
	@Column(name = "offerType")
    private String offerType;
	
	@Column(name = "gain")
    private int gain;
	
	@Column(name = "whenToGet")
    private int whenToGet;

	public int getOfferTypeId() {
		return offerTypeId;
	}

	public void setOfferTypeId(int offerTypeId) {
		this.offerTypeId = offerTypeId;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public int getGain() {
		return gain;
	}

	public void setGain(int gain) {
		this.gain = gain;
	}

	public int getWhenToGet() {
		return whenToGet;
	}

	public void setWhenToGet(int whenToGet) {
		this.whenToGet = whenToGet;
	}
}
