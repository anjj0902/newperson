package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
@Repository
public class MenuDao implements MenuDaoInterface {
	  @Resource(name="sqlSession")
	   SqlSession session;
	@Override
	public void save(HashMap<String, Object> param) {
	      session.insert("menu.InsertMenu", param);
		
	}

	@Override
	public List<HashMap> getMenu(String menu_type) {
		  
	      return session.selectList("menu.SelectMenu", menu_type);
	}

	@Override
	public HashMap<String, Object> menuselect(HashMap<String, Object> param) {
		System.out.println("dao menu:"+ param);
		System.out.println("dao key :"+session.selectOne("menu.Selectkey",param));
		return session.selectOne("menu.Selectkey",param);
		
	}

}
