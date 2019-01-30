package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemCreateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemCreateCompleteAction extends ActionSupport implements SessionAware{

	private String itemName;	//商品名
	private int itemPrice;		//価格
	private int stock;			//在庫
	private Map<String, Object> session;

	public String execute() throws SQLException{

		//sessionに格納されているObject型のデータを元のデータ型に変換
		itemName = session.get("itemName").toString();						//String型
		itemPrice = Integer.parseInt(session.get("itemPrice").toString());	//int型
		stock = Integer.parseInt(session.get("stock").toString());			//int型

		//DBに接続するためItemCreateCompleteDAOクラスをインスタンス化
		ItemCreateCompleteDAO dao = new ItemCreateCompleteDAO();

		//daoインスタンスのcreateItemメソッドを実行し商品情報をDBに登録する
		dao.createItem(itemName, itemPrice, stock);

		return SUCCESS;
	}

	//getter setter
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}