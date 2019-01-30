package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.BuyItemDetailDAO;
import com.internousdev.ecsite.dto.BuyItemDetailDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemDetailAction extends ActionSupport{

	private int id;				//商品のID
	private String itemName;	//商品名
	private int itemPrice;		//値段

	public String execute(){

		//DAOをインスタンス化
		BuyItemDetailDAO dao = new BuyItemDetailDAO();

		try{
			//getItemDetailメソッドを実行し商品の詳細情報を入手する
			//入手した情報はBuyItemDetailDTOのインスタンスに格納する
			BuyItemDetailDTO dto = dao.getItemDetail(id);

			itemName = dto.getItemName();
			itemPrice = dto.getItemPrice();

		}catch(Exception e){
			e.printStackTrace();
		}

		return SUCCESS;
	}

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
