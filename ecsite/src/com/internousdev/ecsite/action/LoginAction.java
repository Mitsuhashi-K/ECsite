package com.internousdev.ecsite.action;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	private String loginUserId;			//ログインID
	private String loginPassword;		//パスワード
	private String errMsg = "";				//エラーメッセージ(初期値は空文字)
	public Map<String, Object> session;	//セッション中に保持する値を格納するMAP

	private LoginDAO loginDAO = new LoginDAO();			//ログイン認証をするDAOをインスタンス化
	private LoginDTO loginDTO = new LoginDTO();			//ユーザー情報を格納するDTOをインスタンス化
	private BuyItemDAO buyItemDAO = new BuyItemDAO();	//商品情報を取得するDAOをインスタンス化

	public String execute(){

		String result;	//戻り値を格納する変数

		/*入力されたログインID、パスワードを元にユーザー情報を取得し、
		 *loginDTOインスタンスに格納*/
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);

		//loginDTOインスタンスをsessionスコープに格納
		session.put("loginUser", loginDTO);

		//ログインしたユーザーが管理者だった場合の処理
		if(loginDTO.getAdminFlg()){

			//戻り値にadminを設定
			result = "admin";

			//各データをsessionに格納
			session.put("login_user_id", loginDTO.getLoginId());	//ユーザーID
			session.put("admin_flg", loginDTO.getAdminFlg());		//管理者フラグ

			//adminを返す(以降の処理は実行しない)
			return result;
		}

		//ログインに成功した(loginDTOのloginFlgがtrue)場合の処理
		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){

			//戻り値にsuccessを設定
			result = SUCCESS;

			//商品情報を取得し、buyItemDTOインスタンスに格納
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();

			//各データをsessionに格納
			session.put("login_user_id", loginDTO.getLoginId());		//ユーザーID
			session.put("id", buyItemDTO.getId());						//商品ID
			session.put("buyItem_name", buyItemDTO.getItemName());		//商品名
			session.put("buyItem_price", buyItemDTO.getItemPrice());	//価格

		//ログインに失敗した(loginDTOのloginFlgがfalse)場合の処理
		}else{
			//戻り値にerrorを設定
			result = ERROR;
			//errMsgを設定(login.jspに表示する)
			errMsg = "ログインID、パスワードが違います。";
		}
		return result;
	}

	/* loginUserIdのgetter / setter */
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	/* loginPasswordのgetter / setter */
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword = loginPassword;
	}

	/* errMsgのgetter / setter */
	public String getErrMsg(){
		return errMsg;
	}

	/* sessionのgetter / setter */
	public Map<String, Object> getSession(){
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
