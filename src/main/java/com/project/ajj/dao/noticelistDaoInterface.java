package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

public interface noticelistDaoInterface {
	public List<HashMap<String,Object>> getNewsList(HashMap<String,Object> param);
	public HashMap<String,Object> totCnt();
}
