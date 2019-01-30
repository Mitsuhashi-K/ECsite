package com.internousdev.ecsite.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.ecsite.dao.BuyItemListDAO;
import com.internousdev.ecsite.dto.BuyItemListDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemListAction extends ActionSupport{

	private List<BuyItemListDTO> buyItemList = new ArrayList<BuyItemListDTO>();

	public String execute(){

		BuyItemListDAO dao = new BuyItemListDAO();

		try{
			buyItemList = dao.getBuyItemList();
		}catch(Exception e){
			e.printStackTrace();
		}

		return SUCCESS;
	}

	// getter
	public List<BuyItemListDTO> getBuyItemList(){
		return buyItemList;
	}

}
