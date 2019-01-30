package com.internousdev.ecsite.action;

import com.internousdev.ecsite.dao.UserListDeleteCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListDeleteCompleteAction extends ActionSupport{

	private int deleteRow = 0;	//削除件数を格納する変数

	public String execute(){

		UserListDeleteCompleteDAO dao = new UserListDeleteCompleteDAO();

		try{
			deleteRow = dao.userListDelete();
		}catch(Exception e){
			e.printStackTrace();
		}

		return SUCCESS;
	}

	//getter
	public int getDeleteRow(){
		return this.deleteRow;
	}

}
