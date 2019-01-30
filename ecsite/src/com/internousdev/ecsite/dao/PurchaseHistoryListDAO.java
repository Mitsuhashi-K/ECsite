package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.PurchaseHistoryListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class PurchaseHistoryListDAO {

	public List<PurchaseHistoryListDTO> getPurchaseHistoryList(String loginUserId) throws SQLException{

		//購入履歴(PurchaseHistoryListDTOのインスタンス)を格納するリストを宣言
		List<PurchaseHistoryListDTO> phList = new ArrayList<PurchaseHistoryListDTO>();

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//購入履歴を抽出するSQL文を変数sqlに代入
		String sql = "SELECT iit.item_name, iit.item_price, ubit.total_count, ubit.total_price "
				+ "FROM user_buy_item_transaction ubit "
				+ "LEFT JOIN item_info_transaction iit "
				+ "ON ubit.item_transaction_id = iit.id "
				+ "WHERE ubit.user_master_id = ? "			//購入者のログインIDがログインしているユーザーと等しい
				+ "ORDER BY ubit.insert_date DESC";			//購入日時の降順

		try{
			//SQL文のパラメータにログイン中のユーザーIDを設定
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginUserId);

			ResultSet rs = ps.executeQuery();

			//ResultSetの最後の行まで繰り返す処理
			while(rs.next()){
				//PurchaseHistoryListDTOクラスをインスタンス化
				PurchaseHistoryListDTO dto = new PurchaseHistoryListDTO();

				//dtoインスタンスに各データを格納する
				dto.setItemName(rs.getString("item_name"));		//商品名
				dto.setItemPrice(rs.getInt("item_price"));		//値段
				dto.setPurchaseCount(rs.getInt("total_count"));	//購入個数
				dto.setTotalPrice(rs.getInt("total_price"));	//合計金額

				//dtoインスタンスをリストに格納する
				phList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return phList;

	}

}
