package com.internousdev.ecsite.dto;

public class ItemInfoDTO {

	private String itemName;
	private int itemPrice;
	private int stock;
	private String insertDate;

	//getter setter
	public String getItemName(){
		return this.itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public int getItemPrice(){
		return this.itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}

	public int getStock(){
		return this.stock;
	}
	public void setStock(int stock){
		this.stock = stock;
	}

	public String getInsertDate(){
		return this.insertDate;
	}
	public void setInsertDate(String insertDate){
		this.insertDate = insertDate;
	}

}
