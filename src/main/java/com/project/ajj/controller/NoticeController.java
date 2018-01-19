package com.project.ajj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.ajj.service.DetailServiceInterface;
import com.project.ajj.service.noticelistServiceInterface;
import com.project.ajj.service.noticemodifyServiceInterface;
import com.project.ajj.util.HttpUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class NoticeController {

	@Autowired 
	noticelistServiceInterface nlsi;
	@Autowired 
	DetailServiceInterface dtsi;
	@Autowired 
	noticemodifyServiceInterface nmsi;
	
	@RequestMapping("/newsData")
	public ModelAndView newsData(HttpServletRequest req, ModelAndView mav){

		HashMap<String, Object> param = new HashMap<String, Object>();
		if(req.getParameter("start") != null){
			param.put("start", Integer.parseInt(req.getParameter("start")));
		}else{
			param.put("start", 0);
		}
		if(req.getParameter("viewRow") != null){
			param.put("viewRow", Integer.parseInt(req.getParameter("viewRow")));
		}else {
			param.put("viewRow", 10);
		}

		
		// 디비에서 받아 온 hashmap 데이터를 json으로 변경하여 model 값으로 넣어 준다.
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(nlsi.getNewsList(param)));
		mav.addObject("message", jsonObject.toString());		
		mav.setViewName("json");
		return mav;
	}
	 @RequestMapping("/newsDetail")
	   public ModelAndView newsDetail(HttpServletRequest req, HttpSession session, HttpServletResponse resp){
		 HashMap<String, Object> param = new HashMap<String, Object>();
		   param.put("no", req.getParameter("no"));
		   
			HashMap<String, Object> map = new HashMap<String, Object>();
	         map = dtsi.Detail(param);
      
	      return HttpUtil.makeHashToJsonModelAndView(map);
	   }
	 @RequestMapping("/updatewrite")
	 public ModelAndView updatewrite(HttpServletRequest req,ModelAndView mav){
		
		 HashMap<String,Object> param = new HashMap<String, Object>();
		 param.put("title", req.getParameter("title"));
		 param.put("contents", req.getParameter("contents"));
		 param.put("no",req.getParameter("no"));
		 

		 JSONObject jsonObject = new JSONObject();
			jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(nmsi.fileUpdate(param)));
			mav.addObject("message", jsonObject.toString());		
			mav.setViewName("json");
		 return mav;
	   }
	
}
