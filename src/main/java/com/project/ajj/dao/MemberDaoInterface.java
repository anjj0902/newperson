package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

public interface MemberDaoInterface {
	public List<HashMap<String,Object>>memberinfo();
	public List<HashMap<String,Object>>memberupdate(HashMap<String,Object>param);
	public List<HashMap<String,Object>>cusmemberboard(HashMap<String,Object>param);
}
