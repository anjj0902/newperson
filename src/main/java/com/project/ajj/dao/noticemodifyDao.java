package com.project.ajj.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class noticemodifyDao implements noticemodifyDaoInterface {
	@Resource(name="sqlSession")
	SqlSession session;
	@Override
	public int fileUpdate(HashMap<String, Object> param) {
		 return session.update("sql.updateNews", param);
	}

}
