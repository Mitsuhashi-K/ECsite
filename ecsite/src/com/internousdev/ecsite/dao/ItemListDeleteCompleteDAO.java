package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	public int itemListDelete() throws SQLException{

		int deleteRow = 0;	//削除件数を格納する変数

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//item_info_transactionテーブルの全件を削除するSQL文(DELETE文)を変数sqlに代入
		String sql = "DELETE FROM item_info_transaction";

		try{
			//SQL文を実行してitem_info_transactionテーブルの全件を削除
			PreparedStatement ps = con.prepareStatement(sql);
			deleteRow = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return deleteRow;

	}

}
