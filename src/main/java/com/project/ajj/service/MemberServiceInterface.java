package com.project.ajj.service;

import java.util.HashMap;

public interface MemberServiceInterface {
	public HashMap<String,Object> memberinfo();
	public HashMap<String,Object> memberupdate(HashMap<String,Object>param);
	public HashMap<String,Object> cusmemberboard(HashMap<String,Object>param);
}
