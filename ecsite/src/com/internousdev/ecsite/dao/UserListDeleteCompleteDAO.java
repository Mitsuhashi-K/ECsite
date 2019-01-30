package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class UserListDeleteCompleteDAO {

	public int userListDelete() throws SQLException {

		int deleteRow = 0;	//削除件数を格納する変数

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//login_user_transactionテーブルの全件を削除するSQL文(DELETE文)を変数sqlに代入
		String sql = "DELETE FROM login_user_transaction";

		//SQL文を実行し削除件数をdeleteRow変数に代入する
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			deleteRow = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		//戻り値としてdeleteRowを返す
		return deleteRow;
	}
}
