package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.CusvoicewriteDaoInterface;
@Service
public class CusvoicewriteService implements CusvoicewriteServiceInterface {

	@Autowired
	CusvoicewriteDaoInterface cdi;
	
	@Override
	public HashMap<String, Object> cusinwriting(HashMap<String, Object> param) {
		HashMap<String,Object>map = new HashMap<String, Object>();
		map.put("list",cdi.cusinwriting(param));
		
		return map;
	}

}
