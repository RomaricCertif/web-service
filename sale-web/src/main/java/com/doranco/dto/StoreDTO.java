package com.doranco.dto;

public class StoreDTO {
	
	private String storeCd;
	
	private String description;
	
	public StoreDTO() {
		//TODO Auto-generated constructor stub
	}
	
	

	public StoreDTO(String storeCd, String description) {
		super();
		this.storeCd = storeCd;
		this.description = description;
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
	
	

}
