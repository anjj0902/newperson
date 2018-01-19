package com.project.ajj.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ajj.dao.LoginDaoInterface;
@Service
public class LoginService implements LoginServiceInterface {

	@Autowired 
	LoginDaoInterface ldi;
	
	@Override
	public HashMap<String, Object> selectLogin(HashMap<String, Object> param) {
		 HashMap<String, Object> data = ldi.selectLogin(param);
	      
	      if(data == null){
	         data = new HashMap<String, Object>();
	         data.put("stat", 0);//0일때 null
	      }else {
	         data.put("stat", 1);//1일때 데이터가 보여지게 된다.
	      }
	      return data;
	}

}
