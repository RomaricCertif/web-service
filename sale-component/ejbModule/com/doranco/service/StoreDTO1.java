package com.doranco.service;

import java.io.Serializable;


public class StoreDTO1 implements Serializable{
	
	

	private String storeCd;
    
    

	private String description;
	
	public StoreDTO1() {
		
	}

	public String getStoreCd() {
		return storeCd;
	}

	public void setStoreCd(String storeCd) {
		this.storeCd = storeCd;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return "StoreDTO1 [storeCd=" + storeCd + ", description=" + description + "]";
	}

}
