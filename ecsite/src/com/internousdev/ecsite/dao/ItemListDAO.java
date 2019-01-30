package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO{

	/**
	 * 商品情報の全件を取得するメソッド
	 * @return 商品情報の全件が格納されたitemInfoDTOList
	 * @throws SQLException
	 */
	public List<ItemInfoDTO> getItemList() throws SQLException{

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//ItemInfoDTOを格納するArrayListの準備
		List<ItemInfoDTO> itemInfoDTOList = new ArrayList<ItemInfoDTO>();

		//item_info_transactionテーブルの全件を取得するSQL文を変数sqlに代入する
		String sql = "SELECT item_name, item_price, item_stock, insert_date FROM item_info_transaction";

		try{
			//SQL文を実行し、ResultSetを変数rsに代入する
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//ResultSetの最後の行まで繰り返す処理
			while(rs.next()){
				//値の格納場所としてItemInfoDTOをインスタンス化
				ItemInfoDTO dto = new ItemInfoDTO();

				//取得した値をdtoインスタンスに格納する
				dto.setItemName(rs.getString("item_name"));		//商品名
				dto.setItemPrice(rs.getInt("item_price"));		//価格
				dto.setStock(rs.getInt("item_stock"));			//在庫
				dto.setInsertDate(rs.getString("insert_date"));	//登録日時

				//dtoインスタンスをitemInfoDTOListに格納する
				itemInfoDTOList.add(dto);
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		//itemInfoDTOListを戻り値として返す
		return itemInfoDTOList;
	}

}
