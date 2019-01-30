package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.PurchaseHistoryListDAO;
import com.internousdev.ecsite.dto.PurchaseHistoryListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryListAction extends ActionSupport implements SessionAware{

	private List<PurchaseHistoryListDTO> phList = new ArrayList<PurchaseHistoryListDTO>();
	private Map<String, Object> session;

	public String execute(){

		//PurchaseHistoryListDAOをインスタンス化
		PurchaseHistoryListDAO dao = new PurchaseHistoryListDAO();

		try{
			//sessionからログイン中のユーザーIDを取り出し、String型の変数loginUserIdに代入
			String loginUserId = session.get("login_user_id").toString();

			//購入履歴のリストをphListに代入
			phList = dao.getPurchaseHistoryList(loginUserId);

		}catch(Exception e){
			e.printStackTrace();
		}

		return SUCCESS;
	}

	//getter setter
	public List<PurchaseHistoryListDTO> getPhList(){
		return phList;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
