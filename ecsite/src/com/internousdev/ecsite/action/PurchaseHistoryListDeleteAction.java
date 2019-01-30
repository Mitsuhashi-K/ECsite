package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.PurchaseHistoryListDeleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryListDeleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute(){

		String result;			//戻り値を格納する変数
		int deleteCount = 0;	//削除件数を格納する変数

		//sessionからログイン中のユーザーIDを取り出し、文字列に変換してloginUserIdに代入
		String loginUserId = session.get("login_user_id").toString();

		//PurchaseHistoryListDeleteDAOをインスタンス化
		PurchaseHistoryListDeleteDAO dao = new PurchaseHistoryListDeleteDAO();

		try{
			//ログイン中のユーザーの購入履歴を削除し、deleteCountに削除件数を代入
			deleteCount = dao.purchaseHistoryDelete(loginUserId);
		}catch (Exception e){
			e.printStackTrace();
		}

		//削除件数が0以外なら戻り値にsuccessを代入
		if(deleteCount != 0){
			result = SUCCESS;
		//削除件数が0なら戻り値にerrorを代入
		}else{
			result = ERROR;
		}

		return result;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}



}
