package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.noticelistDaoInterface;
@Service
public class noticelistService implements noticelistServiceInterface {

	@Autowired
	noticelistDaoInterface nldi;
	HashMap<String,Object> map;
	@Override
	public HashMap<String, Object> getNewsList(HashMap<String, Object> param) {
		map = new HashMap<String,Object>();
		map.put("list", nldi.getNewsList(param));
		
		HashMap<String, Object> totCnt = nldi.totCnt();
		map.put("totCnt", totCnt);
		 
		return map;
	}

}
