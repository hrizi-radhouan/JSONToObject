package com.mass.mvc;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Locale;

import org.codehaus.jackson.JsonParseException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
//
//		String json = "{\"firstName\":\"Lokesh Gupta\",\"lastName\":\"BenSaleh\"}";
//
////		String json = "firstName=LokeshGupta&lastName=BenSaleh";
//		org.codehaus.jackson.map.ObjectMapper mapper = new org.codehaus.jackson.map.ObjectMapper();
//
//		Person emp;
//		try {
//			emp = mapper.readValue(json, Person.class);
//			System.out.println(emp);
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (org.codehaus.jackson.map.JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//


		return "home";
	}

	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody String send(@RequestBody String PersonJSON) {
		
		String json = "";
		
		try {
			json = URLDecoder.decode(PersonJSON, "UTF-8");
			System.out.println(" Hola"+URLDecoder.decode(PersonJSON, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		

//		String json = "firstName=LokeshGupta&lastName=BenSaleh";
		org.codehaus.jackson.map.ObjectMapper mapper = new org.codehaus.jackson.map.ObjectMapper();

		Person emp;
		try {
			emp = mapper.readValue(json, Person.class);
			System.out.println(emp);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (org.codehaus.jackson.map.JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("send", " : the report is saved");
		return jsonObj.toString();
	}

}
