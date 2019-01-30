package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;

	public String execute(){
		/* 戻り値の初期値としてloginを設定 */
		String result = "login";

		/* 管理者がログイン済みの場合の処理 */
		if(session.containsKey("admin_flg")){
			//戻り値としてadminを返す(以降の処理は実行しない)
			result = "admin";
			return result;
		}

		/* ログイン済みの場合の処理 */
		if(session.containsKey("login_user_id")){
			BuyItemDAO buyItemDAO = new BuyItemDAO();
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());

			result = SUCCESS;
		}

		/* ログインしていない場合→loginを返してlogin.jspに遷移
		 * ログイン済の場合→successを返してbuyItem.jspに遷移 */
		return result;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
