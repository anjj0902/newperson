package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.WritedaoInterface;
@Service
public class WriteService implements WriteServiceInterface {

	@Autowired
	WritedaoInterface wdi;
	
	public HashMap<String,Object> map;
	@Override
	public HashMap<String, Object> inwriting(HashMap<String, Object> param) {
		HashMap<String,Object>map = new HashMap<String, Object>();
		map.put("list",wdi.inwriting(param));
		return map;
	}
	

}
