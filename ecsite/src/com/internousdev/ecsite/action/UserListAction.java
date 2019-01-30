package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.List;

import com.internousdev.ecsite.dao.UserListDAO;
import com.internousdev.ecsite.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UserListAction extends ActionSupport{

	private List<UserInfoDTO> userInfoDTOList;

	public String execute() throws SQLException{

		UserListDAO dao = new UserListDAO();
		userInfoDTOList = dao.getUserList();

		return SUCCESS;
	}

	public List<UserInfoDTO> getUserInfoDTOList(){
		return this.userInfoDTOList;
	}



}
