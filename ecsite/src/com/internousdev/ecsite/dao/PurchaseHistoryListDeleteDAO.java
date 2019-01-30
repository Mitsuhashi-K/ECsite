package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class PurchaseHistoryListDeleteDAO {

	public int purchaseHistoryDelete(String loginUserId) throws SQLException{

		//削除件数を格納する変数
		int deleteCount = 0;

		//ログイン中のユーザーの購入履歴を全て削除するSQL文を変数sqlに代入
		String sql = "DELETE FROM user_buy_item_transaction WHERE user_master_id = ?";

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		try{
			//SQL文のパラメータにログイン中のユーザーIDを代入
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);

			//SQL文を実行し、削除件数を変数deleteCountに代入
			deleteCount = ps.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return deleteCount;

	}

}
