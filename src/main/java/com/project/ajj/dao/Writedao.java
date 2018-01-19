package com.project.ajj.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class Writedao implements WritedaoInterface {

	@Resource(name = "sqlSession")
	SqlSession session;
	@Override
	public int inwriting(HashMap<String, Object> param) {
//		System.out.println("notice dao :"+ param);
		return session.insert("sql.InsertNews",param);
		 
	}

}
