package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;


public class LoginDAO {

	/* DBに接続する */
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	/* ユーザー情報の格納場所としてLoginDTOをインスタンス化する */
	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * 入力されたログインID、パスワードと
	 * DBのユーザー情報を照合するメソッド
	 * @param loginUserId ログインID
	 * @param loginPassword パスワード
	 * @return ユーザー情報が格納されたloginDTOインスタンス
	 */

	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword){

		/* login_user_transactionから
		 * 入力されたログインID、パスワードと一致する行を抽出するための
		 * SQL文(SELECT文)を代入する */
		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try{
			/* SQL文をPreparedStatementに格上げ */
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			/* パラメータにログインID、パスワードを代入する */
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			/* SQL文を実行し、ResultSetを受け取る */
			ResultSet resultSet = preparedStatement.executeQuery();

			/* 抽出されたデータが存在する(ログインに成功した)場合の処理 */
			if(resultSet.next()){

				/* ユーザー情報をloginDTOインスタンスに格納する */
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));

				/* loginDTOインスタンスのLoginFlgをtrueにする */
				if(!(resultSet.getString("login_id").equals(null))){
					loginDTO.setLoginFlg(true);
				}

				/* ログインIDが管理者のものであれば、loginDTOインスタンスのadminFlgをtrueにする */
				if(resultSet.getString("admin_flg").equals("1")){
					loginDTO.setAdminFlg(true);
				}
			}
		}catch (Exception e){
			e.printStackTrace();
		}

		/* DBとの接続を閉じる */
		try{
			connection.close();
		}catch (Exception e){
			e.printStackTrace();
		}

		/* ユーザー情報が格納されたloginDTOインスタンス */
		return loginDTO;
	}

	/* loginDTOのgetter */
	public LoginDTO getLoginDTO(){
		return loginDTO;
	}

}
