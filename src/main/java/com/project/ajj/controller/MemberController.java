package com.project.ajj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@RequestMapping(value="memberupdate",method = RequestMethod.POST)
	public ModelAndView memberupdate(HttpServletRequest req ,ModelAndView mav){
		System.out.println("upid : ~!~~~~~~~~~~~~~~~~~;"+req.getParameter("upid"));
		HashMap<String,Object> param = new HashMap<>();
		param.put("upid",req.getParameter("upid"));
		System.out.println("param~~~~~~~~~~~~~~~~~:"+param);
		
		
		JSONObject jsonObject = new JSONObject();
        jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(mbsi.memberupdate(param)));
        mav.addObject("message", jsonObject.toString());      
        mav.setViewName("json");
        System.out.println("controller member"+ mav);
		return mav;
	}
	@RequestMapping(value="cusmemberboard",method = RequestMethod.POST)
	public ModelAndView cusmemberboard(HttpServletRequest req,ModelAndView mav,HttpSession session){
		HashMap<String, HashMap<String, Object>> user = (HashMap<String, HashMap<String, Object>>) session.getAttribute("user");
		HashMap<String,Object> param = new HashMap<>();
		param.put("id",user.get("id"));
		System.out.println("controller~~~~~~~~~~~~~~~~~~~~:param:"+param);
		
		JSONObject jsonObject = new JSONObject();
        jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(mbsi.cusmemberboard(param)));
        mav.addObject("message", jsonObject.toString());      
        mav.setViewName("json");
		return mav;
	}
	
}
