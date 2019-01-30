package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dto.UserInfoDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {

	public List<UserInfoDTO> getUserList() throws SQLException{

		//DBに接続
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//UserInfoDTOを格納するArrayListの準備
		List<UserInfoDTO> userInfoDTOList = new ArrayList<UserInfoDTO>();

		//login_user_transactionテーブルの全件を取得するSQL文を変数sqlに代入する
		String sql = "SELECT login_id, login_pass, user_name, insert_date FROM login_user_transaction";

		try{
			//SQL文を実行し、ResultSetを変数rsに代入する
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			//ResultSetの最後の行まで繰り返す処理
			while(rs.next()){
				//値の格納場所としてUserInfoDTOをインスタンス化
				UserInfoDTO dto = new UserInfoDTO();

				//取得した値をdtoインスタンスに格納する
				dto.setLoginUserId(rs.getString("login_id"));
				dto.setLoginPassword(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setInsertDate(rs.getString("insert_date"));

				//dtoインスタンスをitemInfoDTOListに格納する
				userInfoDTOList.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return userInfoDTOList;
	}

}
