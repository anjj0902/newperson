package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.PreviewDaoInterface;
@Service
public class PreviewService implements PreviewServiceInterface {

	@Autowired
	PreviewDaoInterface pvdi;
	@Override
	public HashMap<String, Object> prenotice() {
		HashMap<String,Object> map = new HashMap<>();
		map.put("list",pvdi.prenotice());
		System.out.println("service~~~~~~ pre:"+map);
		return map;
	}
	@Override
	public HashMap<String, Object> precusvoice() {
		HashMap<String,Object> map = new HashMap<>();
		map.put("list",pvdi.precusvoice());
		return map;
	}

}
