package com.project.ajj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.ajj.service.PreviewServiceInterface;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

@Controller
public class PreviewController {

	@Autowired
	PreviewServiceInterface pvsi;
	
	@RequestMapping(value = "prenotice", method = RequestMethod.POST)
	public ModelAndView prenotice(ModelAndView mav){
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(pvsi.prenotice()));
		System.out.println("controller :" +pvsi.prenotice());
		mav.addObject("message", jsonObject.toString());		
		mav.setViewName("json");
		return mav;
	}
	
	@RequestMapping(value = "precusvoice", method = RequestMethod.POST)
	public ModelAndView precusvoice(ModelAndView mav){
		
		
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSONObject.fromObject(JSONSerializer.toJSON(pvsi.precusvoice()));
		System.out.println("controller :" +pvsi.prenotice());
		mav.addObject("message", jsonObject.toString());		
		mav.setViewName("json");
		return mav;
	}
	
}
