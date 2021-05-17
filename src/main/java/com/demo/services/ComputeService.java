package com.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.entities.Cart;
import com.demo.entities.Offer;
import com.demo.entities.Product;
import com.demo.pojo.CartPojo;
import com.demo.pojo.ProductPojo;

@Service
public class ComputeService {
	
	public CartPojo getCartWithSuggestedOffer(List<Cart> orders) {	
		List<ProductPojo> productPojoList = new ArrayList<>();
		CartPojo cartPojo = new CartPojo();
		
		int totalAmount = 0;
		
		for(Cart order: orders) {
			ProductPojo productPojo = new ProductPojo();
			productPojo.setProductId(order.getProductId().getProductId());
			productPojo.setOffer(order.getProductId().getOffer());
			productPojo.setProductName(order.getProductId().getProductName());
			productPojo.setPrice(order.getProductId().getPrice());
			productPojo.setQuantity(order.getQuantity());
			Offer suggestedOffer = suggetOffer(order.getProductId().getOffer(), productPojo.getPrice(), productPojo.getQuantity());
			productPojo.setOfferApplied(suggestedOffer.getOfferId());
			productPojoList.add(productPojo);
			totalAmount += getProductAmountAfterOffer(order.getProductId(), suggestedOffer, productPojo.getQuantity());
		}
		cartPojo.setProducts(productPojoList);
		cartPojo.setTotalAmount(totalAmount);
		return cartPojo;
	}

	private Offer suggetOffer(List<Offer> offers, int price, int quantity) {
		int maxProfit = 0;
		Offer suggestedOffer = new Offer();
		int savedAmount;
		for(Offer offer : offers) {
			savedAmount = amountSavedByoffer(offer, price, quantity);
			if(offer.getValid() == 1 && offer.getOfferTypeId().getWhenToGet() <= quantity && maxProfit < savedAmount) {
				maxProfit = savedAmount;
				suggestedOffer = offer;
			}
		}
		return suggestedOffer;
	}
	
	private int amountSavedByoffer(Offer offer, int price, int quantity) {
		int profit = 0;
		int sellingPrice = price * quantity;
		if(offer.getOfferTypeId().getOfferType().equalsIgnoreCase("discount")) {
			profit = sellingPrice * offer.getOfferTypeId().getGain() / 100;
		} else if(offer.getOfferTypeId().getOfferType().equalsIgnoreCase("buyOneGetOne")) {
			profit = price * offer.getOfferTypeId().getGain();
		}
		return profit;
	}
	
	private int getProductAmountAfterOffer(Product product, Offer offer, int quantity) {
		int sellingPrice = quantity * product.getPrice();
		if( offer.getOfferTypeId().getOfferType().equalsIgnoreCase("discount")) {
			sellingPrice = sellingPrice - (sellingPrice * offer.getOfferTypeId().getGain() / 100);
		}
		return sellingPrice;
	}
}
