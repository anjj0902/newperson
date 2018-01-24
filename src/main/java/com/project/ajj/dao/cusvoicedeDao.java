package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class cusvoicedeDao implements cusvoicedeDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	@Override
	public List<HashMap<String, Object>> cusvoicede(HashMap<String, Object> param) {
		
		return session.selectOne("cussql.cusvoicede",param);
	}
	@Override
	public List<HashMap<String, Object>> noticede(HashMap<String, Object> param) {
		
		return session.selectOne("sql.noticede",param);
	}

}
