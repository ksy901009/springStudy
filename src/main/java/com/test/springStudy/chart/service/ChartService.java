package com.test.springStudy.chart.service;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.test.springStudy.shop.model.dao.CartDAO;
import com.test.springStudy.shop.model.dto.CartDTO;

public class ChartService {
	public ChartService() {
		
	}
	
	public JSONObject getChartData() {
		CartDAO cartDao = new CartDAO();
		List<CartDTO> items = cartDao.getListCartProductGroup();
		JSONObject data = new JSONObject();
		JSONObject col1 = new JSONObject();
		JSONObject col2 = new JSONObject();
		JSONArray title = new JSONArray();
		
		col1.put("label", "상품명");
		col1.put("type", "string");
		col2.put("label", "금액");		//컬럼 이름
		col2.put("type", "number");		//컬럼 자료형
		
		title.add(col1);
		title.add(col2);
		data.put("cols", title); 		//컬럼에 객체 추가
		
		JSONArray body = new JSONArray();	//실제 데이터
		for(CartDTO dto : items) {
			JSONObject name = new JSONObject();
			name.put("v", dto.getProduct_name());
			JSONObject money = new JSONObject();
			money.put("v", dto.getBuy_money());
			JSONArray row = new JSONArray();
			row.add(name);
			row.add(money);
			JSONObject cell = new JSONObject();
			cell.put("c", row); 		//셀 추가
			body.add(cell);				//row(레코드) 1개 추가
		}
		data.put("rows", body);
		
		return data;
	}
}