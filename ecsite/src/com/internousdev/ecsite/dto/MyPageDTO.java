package com.internousdev.ecsite.dto;

public class MyPageDTO {
	public String itemName;
	public String totalPrice;
	public String totalCount;
	public String payment;
	public String userName;
	public String id;
	public String insert_date;

	/* itemNameのgetter / setter */
	public String getItemName(){
		return itemName;
	}
	public void setItemName(String itemName){
		this.itemName = itemName;
	}

	/* totalPriceのgetter / setter */
	public String getTotalPrice(){
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice){
		this.totalPrice = totalPrice;
	}

	/* totalCountのgetter / setter */
	public String getTotalCount(){
		return totalCount;
	}
	public void setTotalCount(String totalCount){
		this.totalCount = totalCount;
	}

	/* paymentのgetter / setter */
	public String getPayment(){
		return payment;
	}
	public void setPayment(String payment){
		this.payment = payment;
	}

	/* userNameのgetter / setter */
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	/* idのgetter / setter */
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}

	/* insert_dateのgetter / setter */
	public String getInsert_date(){
		return insert_date;
	}
	public void setInsert_date(String insert_date){
		this.insert_date = insert_date;
	}

}
