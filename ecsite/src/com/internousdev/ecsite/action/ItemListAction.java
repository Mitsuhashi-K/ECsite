package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.List;

import com.internousdev.ecsite.dao.ItemListDAO;
import com.internousdev.ecsite.dto.ItemInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport{

	private List<ItemInfoDTO> itemInfoDTOList;

	public String execute() throws SQLException{

		ItemListDAO dao = new ItemListDAO();
		itemInfoDTOList = dao.getItemList();

		return SUCCESS;
	}

	public List<ItemInfoDTO> getItemInfoDTOList(){
		return this.itemInfoDTOList;
	}

}
