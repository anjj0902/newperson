package com.project.ajj.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class CusvoicewriteDao implements CusvoicewriteDaoInterface {

	@Resource(name= "sqlSession")
	SqlSession session;
	@Override
	public int cusinwriting(HashMap<String, Object> param) {
	
		
		 return session.insert("cussql.InsertNews1",param);
		
	}

}
