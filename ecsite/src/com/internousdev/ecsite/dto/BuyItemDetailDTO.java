package com.internousdev.ecsite.dto;

public class BuyItemDetailDTO {

	private int id;				//商品のid
	private String itemName;	//商品名
	private int itemPrice;		//値段

	//getter setter
	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	public int getItemPrice(){
		return itemPrice;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}

}
