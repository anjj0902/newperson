package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

public interface cusvoicelistDaointerface {
	public List<HashMap<String,Object>> cusgetNewsList(HashMap<String,Object> param);
	public HashMap<String,Object> totCnt();
}
