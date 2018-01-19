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

import com.project.ajj.service.CusvoicewriteServiceInterface;
import com.project.ajj.service.LoginServiceInterface;
import com.project.ajj.service.WriteServiceInterface;
import com.project.ajj.util.HttpUtil;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;



@Controller
public class LoginController {
   
   @Autowired
   LoginServiceInterface lsi;
   
   @Autowired
   WriteServiceInterface wsi;
   
   @Autowired
   CusvoicewriteServiceInterface csi;
   
   @RequestMapping("/loginData")
   public ModelAndView loginData(HttpServletRequest req, HttpServletResponse response, HttpSession session){
	  HashMap<String, Object> map = new HashMap<String, Object>();
	  map.put("id", req.getParameter("id"));
	  map.put("pw", req.getParameter("pw"));
      map = lsi.selectLogin(map);
      System.out.println("controller : "+map);
      if(Integer.parseInt(map.get("stat").toString())==1){
    	  System.out.println("login"+map);
    	  session.setAttribute("user", map);
      }
      
      return HttpUtil.makeHashToJsonModelAndView(map);
   }
   
   @RequestMapping(value="/checkLogin",method = RequestMethod.POST)
	public ModelAndView checkLogin(HttpSession session, HttpServletResponse resp){
		HashMap<String, HashMap<String, Object>> user = (HashMap<String, HashMap<String, Object>>) session.getAttribute("user");
		HashMap<String, Object> data = new HashMap<String, Object> ();
		if(user == null){
			data.put("state", 0);
		}else{
			data.put("id", user.get("id"));
			data.put("auth", user.get("auth"));
			data.put("state", 1);
		}
		return HttpUtil.makeHashToJsonModelAndView(data);
	}
	@RequestMapping("/logout")
	 public void logout(HttpSession session, HttpServletResponse resp){
		System.out.println("로그아웃!");
		session.invalidate();
		HttpUtil.sendResponceToJson(resp, new HashMap<String,Object>());
	}
	
	@RequestMapping(value="/noticewrite",method = RequestMethod.POST )
	public ModelAndView noticewrite(HttpServletRequest req, ModelAndView mav ,HttpSession session){
		HashMap<String,Object> param = new HashMap<String, Object>();
		HashMap<String, HashMap<String, Object>> user = (HashMap<String, HashMap<String, Object>>) session.getAttribute("user");
		param.put("title",req.getParameter("title"));
		param.put("contents",req.getParameter("contents"));
		param.put("id", user.get("id"));
		System.out.println("controller : "+  user.get("id"));
		
		System.out.println("controller : param" + param);
		
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(wsi.inwriting(param)));
		mav.addObject("message", jsonObject.toString());		
		mav.setViewName("json");
		return mav;
		
		
		
	}
	@RequestMapping(value="/cusvoicewrite",method = RequestMethod.POST )
	public ModelAndView cusvoicewrite(HttpServletRequest req, ModelAndView mav ,HttpSession session){
		HashMap<String,Object> param = new HashMap<String, Object>();
		HashMap<String, HashMap<String, Object>> user = (HashMap<String, HashMap<String, Object>>) session.getAttribute("user");
		param.put("title",req.getParameter("title"));
		param.put("contents",req.getParameter("contents"));
		param.put("id", user.get("id"));
		
		
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(csi.cusinwriting(param)));
		mav.addObject("message", jsonObject.toString());		
		mav.setViewName("json");
		return mav;
		
		
		
	}

}