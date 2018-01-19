package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class MemberDao implements MemberDaoInterface {

	@Resource(name="sqlSession")
	SqlSession session;
	
	@Override
	public List<HashMap<String, Object>> memberinfo() {
		
		System.out.println("dap@@#@@@@@@@@@@@@@@@@@@@@@@@@@"+session.selectList("login.memberlist"));
		return session.selectList("login.memberlist");
	}

}
