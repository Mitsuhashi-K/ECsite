package com.internousdev.ecsite.dto;

public class PurchaseHistoryListDTO {

	private String itemName;	//商品名
	private int itemPrice;	//値段
	private int purchaseCount;	//購入個数
	private int totalPrice;		//合計金額

	//getter setter
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

	public int getPurchaseCount(){
		return purchaseCount;
	}
	public void setPurchaseCount(int purchaseCount){
		this.purchaseCount = purchaseCount;
	}

	public int getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}
}
