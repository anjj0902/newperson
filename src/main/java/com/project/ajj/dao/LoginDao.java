package com.project.ajj.dao;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao implements LoginDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;

	@Override
	public HashMap<String, Object> selectLogin(HashMap<String, Object> map) {
		return session.selectOne("login.selectLogin", map);
	}
}
