package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class PreviewDao implements PreviewDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session; 
	
	@Override
	public List<HashMap<String, Object>> prenotice() {
		System.out.println("dao~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~pre"+session.selectList("sql.prenotice"));
		return session.selectList("sql.prenotice");
	}

	@Override
	public List<HashMap<String, Object>> precusvoice() {
		
		return session.selectList("sql.precusvoice");
	}

}
