package com.project.ajj.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public interface MenuServiceInterface {
	  public int save(HttpServletRequest req) throws Exception;
	    public List<HashMap<String,Object>> getMenu(String menu_type);
	    public HashMap<String,Object> menuselect(HashMap<String,Object> param);
}
