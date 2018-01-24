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

	@Override
	public List<HashMap<String, Object>> memberupdate(HashMap<String, Object> param) {
		System.out.println("dao~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~id :"+ param);
		System.out.println("return~~~~~~~~~~:"+session.selectOne("login.memberinfoup",param));
		return session.selectOne("login.memberinfoup",param);
	}

	@Override
	public List<HashMap<String, Object>> cusmemberboard(HashMap<String, Object> param) {
		
		return session.selectList("sql.cusmemberboard",param);
	}

}
