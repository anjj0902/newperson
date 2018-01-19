package com.project.ajj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.ajj.service.MemberServiceInterface;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class MemberController {
	
	@Autowired
	MemberServiceInterface mbsi;
	
	@RequestMapping(value="memberinfo", method = RequestMethod.POST)
	public ModelAndView memberinfo(ModelAndView mav){
		
		 JSONObject jsonObject = new JSONObject();
         jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(mbsi.memberinfo()));
         mav.addObject("message", jsonObject.toString());      
         mav.setViewName("json");
         System.out.println("controller member"+ mav);

		return mav;
	}
	
}
