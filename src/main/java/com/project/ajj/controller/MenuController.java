package com.project.ajj.controller;



import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.ajj.service.MenuServiceInterface;
import com.project.ajj.service.noticelistServiceInterface;
import com.project.ajj.service.noticemodifyServiceInterface;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class MenuController {

	 @Autowired 
	   noticelistServiceInterface nlsi;
	   @Autowired 
	   MenuServiceInterface dtsi;
	   @Autowired 
	   noticemodifyServiceInterface nmsi;
	 @RequestMapping("/menuregister")
	   public String menuregister(HttpServletRequest req, ModelAndView mav){
	      return "menuregister";
	   }
	  @RequestMapping("/addMenu")
	   public String addMenu(HttpServletRequest req, ModelAndView mav) throws Exception{
	      dtsi.save(req);
	      return "redirect:/#!/spagetti";
	   }
	  @RequestMapping("/getMenu")
	   public @ResponseBody String getMenu(HttpServletRequest req, ModelAndView mav) throws Exception{
	     System.out.println("controller param $$$$$$$$$$$$$$$$$$$$$$$$$"+req.getParameter("menu_type"));
		  String menu_type = req.getParameter("menu_type");
	      HashMap<String,Object> param = new HashMap<String, Object>();
	      param.put("name",req.getParameter("name"));
	      System.out.println("~~~~~~~~~~~~~getmenu controller:"+param);
	      System.out.println("getmenu controller1 :"+menu_type);
	      List<HashMap<String,Object>> list = dtsi.getMenu(menu_type);
	      
	      JSONArray json_arr=new JSONArray();
	      
	      json_arr.addAll(list);
//	       System.out.println("controller"+json_arr.toString());
//	       System.out.println("controller list :" +list.get(0).get("key"));
	      
	      return json_arr.toString();
	   }
	  @RequestMapping(value = "selectmenu", method = RequestMethod.POST)
	  public ModelAndView selectmenu(ModelAndView mav ,HttpServletRequest req){
		  
		  HashMap<String,Object> param = new HashMap<String, Object>();
		  param.put("key",req.getParameter("key"));
		  
		  System.out.println("menucontroller" + param);
		  
		// 디비에서 받아 온 hashmap 데이터를 json으로 변경하여 model 값으로 넣어 준다.
			JSONObject jsonObject = new JSONObject();
			jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(dtsi.menuselect(param)));
			mav.addObject("message", jsonObject.toString());		
			mav.setViewName("json");
			return mav;
		
	  }



}
