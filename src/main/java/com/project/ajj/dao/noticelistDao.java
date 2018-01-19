package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class noticelistDao implements noticelistDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public List<HashMap<String, Object>> getNewsList(HashMap<String, Object> param) {
		return session.selectList("sql.selectList",param);
	}

	@Override
	public HashMap<String, Object> totCnt() {
		return session.selectOne("sql.totCnt");
	}

}
