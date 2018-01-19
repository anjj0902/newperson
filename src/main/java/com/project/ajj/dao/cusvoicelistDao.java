package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class cusvoicelistDao implements cusvoicelistDaointerface {

	@Resource(name="sqlSession")
	SqlSession session;
	@Override
	public List<HashMap<String, Object>> cusgetNewsList(HashMap<String, Object> param) {
		return session.selectList("cussql.selectList",param);
	}

	@Override
	public HashMap<String, Object> totCnt() {
		System.out.println("------------------------------------------tot:"+session.selectOne("cussql.totCnt"));
		return session.selectOne("cussql.totCnt");
		
	}

}
