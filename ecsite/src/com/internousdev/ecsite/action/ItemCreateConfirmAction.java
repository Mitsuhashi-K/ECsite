package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateConfirmAction extends ActionSupport implements SessionAware{

	private String itemName;
	private int itemPrice;
	private int stock;
	private String errorMessage;
	private Map<String, Object> session;

	public String execute(){

		//商品名、価格、在庫がすべて入力されている場合の処理
		if(!(itemName.equals(""))
				&& itemPrice != 0	//<input type=number>の空白チェックの仕方要確認
				&& stock != 0){

			//各データをsessionに格納する
			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("stock", stock);

			return SUCCESS;

		//商品名、価格、在庫いずれかが入力されていない場合の処理
		}else{
			//errorMessageにメッセージを代入する
			errorMessage = "未入力の項目があります。";
			return ERROR;
		}
	}

	//getter・setter
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	public void setItemPrice(int itemPrice){
		this.itemPrice = itemPrice;
	}
	public void setStock(int stock){
		this.stock = stock;
	}

	public String getErrorMessage(){
		return this.errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public Map<String, Object> getSession(){
		return this.session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
