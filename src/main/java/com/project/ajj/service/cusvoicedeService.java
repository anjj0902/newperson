package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.cusvoicedeDaoInterface;
@Service
public class cusvoicedeService implements cusvoicedeServiceInterface {
	@Autowired
	cusvoicedeDaoInterface cvdi;
	@Override
	public HashMap<String, Object> cusvoicede(HashMap<String, Object> param) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("list",cvdi.cusvoicede(param));
		return map;
	}
	@Override
	public HashMap<String, Object> noticede(HashMap<String, Object> param) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("list",cvdi.noticede(param));
		return map;
	}

}
