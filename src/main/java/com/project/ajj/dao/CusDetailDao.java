package com.project.ajj.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class CusDetailDao implements CusDetailDaointerface {

	@Resource(name="sqlSession")
	SqlSession session;
	@Override
	public HashMap<String, Object> Detail(HashMap<String, Object> param) {
		System.out.println("daoparams:~~~~~~~~~~~~~~~~~~~~~~~~"+param);
		System.out.println("dao~~~~~~~~~~~~~~~~~~~~~~~params"+ session.selectOne("cussql.selectDetail", param));
		return session.selectOne("cussql.selectDetail", param);
	}

}
