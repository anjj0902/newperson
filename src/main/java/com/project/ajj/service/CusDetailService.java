package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.CusDetailDaointerface;
@Service
public class CusDetailService implements CusDetailServiceInterface {

	@Autowired
	CusDetailDaointerface cddi;
	@Override
	public HashMap<String, Object> Detail(HashMap<String, Object> param) {
		HashMap<String, Object> map = new HashMap<String, Object>();
	    System.out.println("sevice!! param~~~~~~~~~~~~~~@@@@@@@@@@@@@@@@@@@@" + param); 
		
		map.put("data",cddi.Detail(param));
	    System.out.println("service map!!!!!!!!!!!!!!!!!!" + map);
	      
	      return map; 
	}

}
