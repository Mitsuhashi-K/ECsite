package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String loginUserId;
	private String loginPassword;
	private String userName;
	private boolean adminAssign;
	public Map<String, Object> session;
	private String errorMessage;

	public String execute(){

		String result = SUCCESS;

		//全ての項目が入力されている場合の処理
		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(userName.equals(""))){

			//sessionにユーザー情報を格納
			session.put("loginUserId", loginUserId);
			session.put("loginPassword", loginPassword);
			session.put("userName", userName);

			/*「管理者として登録する」のチェック有無によって下記をsessionに格納
			 * チェックがある→true、
			 * チェックがない→false */
			session.put("adminAssign", adminAssign);

		//入力漏れがある場合の処理
		}else{
			//errorMessageを設定してERRORを返す
			setErrorMessage("未入力の項目があります。");
			result = ERROR;
		}
		return result;
	}

	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}

	public boolean getAdminAssign(){
		return adminAssign;
	}
	public void setAdminAssign(boolean adminAssign){
		this.adminAssign = adminAssign;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public String getErrorMessage(){
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage){
		this.errorMessage = errorMessage;
	}

}
