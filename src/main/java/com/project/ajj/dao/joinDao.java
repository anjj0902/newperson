package com.project.ajj.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class joinDao implements joinDaointerface {

	@Resource(name="sqlSession")
	SqlSession session;
	@Override
	public int data(HashMap<String, Object> param) {
		
		return session.insert("login.insertJoin", param);
	}
	@Override
	public HashMap<String, Object> checkid(HashMap<String, Object> param) {
		HashMap<String, Object> map = new HashMap<String, Object>();
	      map.put("id", session.selectOne("login.overlapId", param));
	      
	      
	      return session.selectOne("login.overlapId", param);
	}

}
