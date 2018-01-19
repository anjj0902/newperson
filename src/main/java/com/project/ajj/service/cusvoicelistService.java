package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.cusvoicelistDaointerface;
@Service
public class cusvoicelistService implements cusvoicelistServiceInterface {
@Autowired
cusvoicelistDaointerface cldi;
HashMap<String,Object> map;
	@Override
	public HashMap<String, Object> cusgetNewsList(HashMap<String, Object> param) {
		System.out.println("service -------------------------~~~~~~~~~~~~~~~~~~~~~~~~~param: "+param);
		map = new HashMap<String,Object>();
		map.put("list", cldi.cusgetNewsList(param));
		
		HashMap<String, Object> totCnt = cldi.totCnt();
		map.put("totCnt", totCnt);
		 System.out.println("------------------------------------------service tot:"+map);
		return map;
	}

}
