package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.ecsite.dto.BuyItemDetailDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDetailDAO {

	public BuyItemDetailDTO getItemDetail(int id) throws SQLException{

		//商品情報を格納するためにBuyItemDetailDTOクラスをインスタンス化
		BuyItemDetailDTO dto = new BuyItemDetailDTO();

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//商品情報を抽出するSQL文を変数sqlに代入
		String sql = "SELECT id, item_name, item_price FROM item_info_transaction WHERE id = ?";

		try{
			//SQL文のパラメータに選択された商品のidを代入
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			//SQL文を実行しResultSetを変数rsに代入
			ResultSet rs = ps.executeQuery();

			//SQL文の実行結果が存在する場合の処理
			if(rs.next()){
				//各データをdtoインスタンスに格納する
				dto.setId(rs.getInt("id"));						//商品のID
				dto.setItemName(rs.getString("item_name"));		//商品名
				dto.setItemPrice(rs.getInt("item_price"));		//値段
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return dto;
	}

}
