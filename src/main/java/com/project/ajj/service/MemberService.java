package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.MemberDaoInterface;
@Service
public class MemberService implements MemberServiceInterface {

	@Autowired
	MemberDaoInterface mbdi;
	@Override
	public HashMap<String, Object> memberinfo() {
		HashMap<String,Object> map = new HashMap<>();
		map.put("list",mbdi.memberinfo());
		return map;
	}
	@Override
	public HashMap<String, Object> memberupdate(HashMap<String, Object> param) {
		System.out.println("gggggggggggggggggggggggggggggggggggggg:service"+ param);
		HashMap<String,Object>map = new HashMap<>();
		map.put("list",mbdi.memberupdate(param));
		return map;
	}
	@Override
	public HashMap<String, Object> cusmemberboard(HashMap<String, Object> param) {
		HashMap<String,Object> map = new HashMap<>();
		map.put("list",mbdi.cusmemberboard(param));
		return map;
	}

}
