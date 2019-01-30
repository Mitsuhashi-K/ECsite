package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.BuyItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemListDAO {

	private List<BuyItemListDTO> buyItemList = new ArrayList<BuyItemListDTO>();

	public List<BuyItemListDTO> getBuyItemList() throws SQLException{

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//商品情報を抽出するSQL文を変数sqlに代入
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction "
				+ "ORDER BY id asc";

		try{
			//SQL文を実行しResultSetを変数rsに代入
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//ResultSetの最後の行まで繰り返す処理
			while(rs.next()){
				//BuyItemDTOクラスをインスタンス化
				BuyItemListDTO dto = new BuyItemListDTO();

				//dtoインスタンスに各データを格納
				dto.setId(rs.getInt("id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getInt("item_price"));

				//buyItemListにdtoインスタンスを格納
				buyItemList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return buyItemList;
	}



}
