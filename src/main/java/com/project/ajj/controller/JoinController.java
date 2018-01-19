package com.project.ajj.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.ajj.service.joinServiceInterface;
import com.project.ajj.util.HttpUtil;



@Controller
public class JoinController {
   
   @Autowired
   joinServiceInterface jsi;

   @RequestMapping(value="Userjoin", method = RequestMethod.POST)
      public ModelAndView Userjoin(HttpServletResponse resp, HttpServletRequest req){
	   System.out.println("회원가입");
         
	   HashMap<String, Object> param = HttpUtil.getParameterMap(req);
         
         	
		HashMap<String, Object> createUser = new HashMap<String, Object>();
         createUser = jsi.data(param);
         System.out.println("param:"+param);
         return HttpUtil.makeHashToJsonModelAndView(createUser);
      }
   @RequestMapping("/join")
	public String join(){
		return "join";
	}
   
   @RequestMapping(value="CheckId", method = RequestMethod.POST)
      public void checkid(HttpServletResponse resp, HttpServletRequest req){
         
         String id = req.getParameter("id");
         
         HashMap<String, Object> checkid = new HashMap<String, Object>();
         
         checkid.put("id", id);
         
         checkid = jsi.checkid(checkid);

         HttpUtil.sendResponceToJson(resp, checkid);
      }
   
   /*@RequestMapping(value = "/download", method = RequestMethod.POST)
	public ModelAndView download(HttpServletRequest req){
		HashMap<String, Object> map = new HashMap<String, Object>();
		String path = req.getParameter("path");
		String name = req.getParameter("name");
		String id = req.getParameter("id");
		System.out.println(req.getAttribute(id));
		if(("uploadc").equals(id)){
			map.put("path", path);
			map.put("file", name);
			map.put("name", name);
			map.put("status", 1);
		}else{
			map.put("status", 0);
		}
		return HttpUtil.makeHashToJsonModelAndView(map);
	}*/
}