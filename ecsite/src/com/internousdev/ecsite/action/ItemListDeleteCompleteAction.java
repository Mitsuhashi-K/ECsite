package com.internousdev.ecsite.action;

import java.sql.SQLException;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport{

	private int deleteRow = 0;	//削除件数を格納する変数

	public String execute() throws SQLException{

		ItemListDeleteCompleteDAO dao = new ItemListDeleteCompleteDAO();

		try{
			deleteRow = dao.itemListDelete();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public int getDeleteRow(){
		return this.deleteRow;
	}
}
