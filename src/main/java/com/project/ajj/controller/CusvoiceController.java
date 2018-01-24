package com.project.ajj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.ajj.service.CusDetailServiceInterface;
import com.project.ajj.service.cusmodifyServiceInterface;
import com.project.ajj.service.cusvoicedeServiceInterface;
import com.project.ajj.service.cusvoicelistServiceInterface;
import com.project.ajj.util.HttpUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller


public class CusvoiceController {

	@Autowired
	cusvoicelistServiceInterface clsi;
	
	@Autowired
	CusDetailServiceInterface cdsi;
	
	@Autowired
	cusmodifyServiceInterface cmsi;
	@Autowired
	cusvoicedeServiceInterface cvsi;
	@RequestMapping(value = "cusnewsData", method = RequestMethod.POST)
	public ModelAndView cusnewsData(HttpServletRequest req, ModelAndView mav){
//		System.out.println("---------------------- : " +req.getParameter("start"));
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

		System.out.println("2");
		// 디비에서 받아 온 hashmap 데이터를 json으로 변경하여 model 값으로 넣어 준다.
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(clsi.cusgetNewsList(param)));
		mav.addObject("message", jsonObject.toString());		
		mav.setViewName("json");
		return mav;
	}
	 @RequestMapping("/cusvoiceDetail")
	   public ModelAndView cusvoiceDetail(HttpServletRequest req, HttpSession session, HttpServletResponse resp){
			HashMap<String, HashMap<String, Object>> user = (HashMap<String, HashMap<String, Object>>) session.getAttribute("user");
		 HashMap<String, Object> param = new HashMap<String, Object>();
		 
		   param.put("no", req.getParameter("no"));
		   param.put("id",user.get("id"));
		   System.out.println("controller~~~~~~~~~~~~~~~~~~~~~~~~~~upda:"+param);
		  
			HashMap<String, Object> map = new HashMap<String, Object>();
			
	         map = cdsi.Detail(param);
	         map.put("id",user.get("id"));
	         System.out.println("cusvoice:service11 :"+ map);
	         HashMap<String, Object> data = new HashMap<String, Object>();
	         data = (HashMap<String, Object>)map.get("data");
	         System.out.println("cusvoice:service :"+ data.get("id"));
	         System.out.println("controller 데이터"+data);
	        
	      return HttpUtil.makeHashToJsonModelAndView(map);
	   }
	 @RequestMapping("/cusupdatewrite")
	 public ModelAndView cusupdatewrite(HttpServletRequest req,ModelAndView mav){
		
		 HashMap<String,Object> param = new HashMap<String, Object>();
		 param.put("title", req.getParameter("title"));
		 param.put("contents", req.getParameter("contents"));
		 param.put("no",req.getParameter("no"));
		 
         System.out.println("controllerupdate :" + param);
		 JSONObject jsonObject = new JSONObject();
			jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(cmsi.fileUpdate(param)));
			mav.addObject("message", jsonObject.toString());		
			mav.setViewName("json");
		 return mav;
	   }
	 @RequestMapping("/cusvoicede")
	 public ModelAndView cusvoicede(HttpServletRequest req,ModelAndView mav){
		 System.out.println("req~~~~~~"+ req.getParameter("chid"));
		 HashMap<String,Object> param = new HashMap<>();	
		
		 param.put("chid", req.getParameter("chid"));	 
		 JSONObject jsonObject = new JSONObject();
	        jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(cvsi.cusvoicede(param)));
	        mav.addObject("message", jsonObject.toString());      
	        mav.setViewName("json");
	        
		 
		 return mav;
	 }
	 @RequestMapping("/noticede")
	 public ModelAndView noticede(HttpServletRequest req,ModelAndView mav){
		 System.out.println("req~~~~~~"+ req.getParameter("noid"));
		 HashMap<String,Object> param = new HashMap<>();	
		
		 param.put("noid", req.getParameter("noid"));	 
		 JSONObject jsonObject = new JSONObject();
	        jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(cvsi.noticede(param)));
	        mav.addObject("message", jsonObject.toString());      
	        mav.setViewName("json");
	        
		 
		 return mav;
	 }
}
