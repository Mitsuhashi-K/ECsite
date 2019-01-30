package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.ecsite.util.DBConnector;
import com.internousdev.ecsite.util.DateUtil;

public class ItemCreateCompleteDAO {

	public void createItem(String itemName, int itemPrice, int stock) throws SQLException{

		//日時データを取得するためDateUtilクラスをインスタンス化
		DateUtil dateUtil = new DateUtil();

		//DBに接続
		DBConnector dbConnector = new DBConnector();
		Connection con = dbConnector.getConnection();

		//sqlにSQL文(INSERT文)を代入
		String sql = "INSERT INTO item_info_transaction (item_name, item_price, item_stock, insert_date) VALUES (?,?,?,?)";

		try{
			//SQL文をPreparedStatementに格上げ
			PreparedStatement ps = con.prepareStatement(sql);

			//パラメータに各データを代入
			ps.setString(1, itemName);				//商品名（item_nameカラム）
			ps.setInt(2, itemPrice);				//価格（item_priceカラム）
			ps.setInt(3, stock);					//在庫数（item_stockカラム）
			ps.setString(4, dateUtil.getDate());	//現在の日時(insert_dateカラム)

			//SQL文を実行
			ps.execute();

		}catch (Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
	}

}
