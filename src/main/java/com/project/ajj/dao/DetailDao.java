package com.project.ajj.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class DetailDao implements DetailDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	@Override
	public HashMap<String, Object> Detail(HashMap<String, Object> param) {
		return session.selectOne("sql.selectDetail", param);
		
		
	}

}
