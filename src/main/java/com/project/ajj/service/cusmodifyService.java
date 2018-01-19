package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.cusmodifyDaoInterface;

@Service
public class cusmodifyService implements cusmodifyServiceInterface {

	@Autowired
	cusmodifyDaoInterface cddi;
	@Override
	public HashMap<String, Integer> fileUpdate(HashMap<String, Object> param) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("status", cddi.fileUpdate(param));
		return map;
	}

}
