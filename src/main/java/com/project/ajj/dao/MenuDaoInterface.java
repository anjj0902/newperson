package com.project.ajj.dao;

import java.util.HashMap;
import java.util.List;

public interface MenuDaoInterface {
	public void save(HashMap<String, Object> param);
    public List<HashMap> getMenu(String menu_type);
    public HashMap<String,Object> menuselect(HashMap<String,Object>param);
}
