package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.joinDaointerface;
@Service
public class joinService implements joinServiceInterface {

	@Autowired
	joinDaointerface jdi;
	public HashMap<String,Object> map;
	
	@Override
	public HashMap<String, Object> data(HashMap<String, Object> param) {
		map = new HashMap<String, Object>();
		map.put("join",jdi.data(param));
		return map;
	}

	@Override
	public HashMap<String, Object> checkid(HashMap<String, Object> param) {
		System.out.println("param:###################"+param); 
		
		map = new HashMap<String, Object>();
         map.put("checkid", jdi.checkid(param));
         System.out.println("map:~~~~~~~~~~~~~~~~~~~~:"+map);
         
         return map;
	}

}
