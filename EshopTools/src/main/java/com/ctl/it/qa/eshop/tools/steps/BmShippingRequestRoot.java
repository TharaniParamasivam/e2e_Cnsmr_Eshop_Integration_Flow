package com.ctl.it.qa.eshop.tools.steps;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BmShippingRequestRoot {
	@SerializedName("BMShippingRequest")
	@Expose
	private BMShippingRequest bMShippingRequest;
	@SerializedName("transactionId")
	@Expose
	private String transactionId;

	public BMShippingRequest getBMShippingRequest() {
		return bMShippingRequest;
	}

	public void setBMShippingRequest(BMShippingRequest bMShippingRequest) {
		this.bMShippingRequest = bMShippingRequest;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}