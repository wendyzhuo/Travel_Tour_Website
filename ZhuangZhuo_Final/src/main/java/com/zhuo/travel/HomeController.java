package com.zhuo.travel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhuo.travel.dao.AdminDao;
import com.zhuo.travel.dao.AgentDao;
import com.zhuo.travel.dao.CountryDao;
import com.zhuo.travel.dao.TripDao;
import com.zhuo.travel.dao.UserDao;
import com.zhuo.travel.model.Country;
import com.zhuo.travel.model.Trip;
import com.zhuo.travel.model.User;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/*
	 * Specify this useValidate will be injected
	 */
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private TripDao tripDao;
	

	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String initUserLoginForm(Model model,HttpServletRequest request) {
		
		try {
			
			HttpSession session =request.getSession();
			if(session.getAttribute("user")!=null){
				model.addAttribute("check","yes");
			}else{
				model.addAttribute("check","no");
			}
			
			ArrayList<Country> countryList = countryDao.queryCountry();
			model.addAttribute("countryList", countryList);
			
			ArrayList<String> date = new ArrayList<String>();
	        Calendar c = Calendar.getInstance();
	        int month = c.get(Calendar.MONTH)+1; 
	        date.add("Any Time");
			for(int i=0; i < 12; i++){
				if(month+i>12){
					int d = month+i-12;
					date.add(2016+" / "+d);
				}else{
					int d = month+i;
					date.add(2015+" / "+d);
				}	
			}
			model.addAttribute("date", date);
		
			ArrayList<Trip> tripList = tripDao.queryAllAgent();
			model.addAttribute("trip1", tripList.get(0));
			model.addAttribute("trip2", tripList.get(1));
			model.addAttribute("trip3", tripList.get(2));
			model.addAttribute("trip4", tripList.get(3));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String inithome(Model model,HttpServletRequest request) {
		
		
		try {
			
			HttpSession session =request.getSession();
			if(session.getAttribute("user")!=null){
				model.addAttribute("check","yes");
			}else{
				model.addAttribute("check","no");
			}
			
			ArrayList<Country> countryList = countryDao.queryCountry();
			model.addAttribute("countryList", countryList);
			
			ArrayList<String> date = new ArrayList<String>();
	        Calendar c = Calendar.getInstance();
	        int month = c.get(Calendar.MONTH)+1; 
	        date.add("Any Time");
			for(int i=0; i < 12; i++){
				if(month+i>12){
					int d = month+i-12;
					date.add(2016+" / "+d);
				}else{
					int d = month+i;
					date.add(2015+" / "+d);
				}	
			}
			model.addAttribute("date", date);
			
			
			ArrayList<Trip> tripList = tripDao.queryAllAgent();
			model.addAttribute("trip1", tripList.get(0));
			model.addAttribute("trip2", tripList.get(1));
			model.addAttribute("trip3", tripList.get(2));
			model.addAttribute("trip4", tripList.get(3));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	
	

	@RequestMapping(value="/results" ,method=RequestMethod.POST)
	public String replyMessage(Model model, HttpServletRequest request){
	
	
		String returnVal = "home";
		
			try {
				ArrayList<Country> countryList = countryDao.queryCountry();
				model.addAttribute("countryList", countryList);
				
				ArrayList<String> date = new ArrayList<String>();
		        Calendar c = Calendar.getInstance();
		        int month = c.get(Calendar.MONTH)+1; 
		        date.add("Any Time");
				for(int i=0; i < 12; i++){
					if(month+i>12){
						int d = month+i-12;
						date.add(2016+" / "+d);
					}else{
						int d = month+i;
						date.add(2015+" / "+d);
					}	
				}
				model.addAttribute("date", date);
				
				ArrayList<Trip> tripList = tripDao.queryAllAgent();
				model.addAttribute("trip1", tripList.get(0));
				model.addAttribute("trip2", tripList.get(1));
				model.addAttribute("trip3", tripList.get(2));
				model.addAttribute("trip4", tripList.get(3));
				
				return returnVal;		
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return "home";
		
	}
	
	@RequestMapping(value = "/backhome", method = RequestMethod.POST)
	public String backhome(Model model,HttpServletRequest request) {
		
		
		try {
			
			HttpSession session =request.getSession();
			if(session.getAttribute("user")!=null){
				model.addAttribute("check","yes");
			}else{
				model.addAttribute("check","no");
			}
			
			ArrayList<Country> countryList = countryDao.queryCountry();
			model.addAttribute("countryList", countryList);
			
			ArrayList<String> date = new ArrayList<String>();
	        Calendar c = Calendar.getInstance();
	        int month = c.get(Calendar.MONTH)+1; 
	        date.add("Any Time");
			for(int i=0; i < 12; i++){
				if(month+i>12){
					int d = month+i-12;
					date.add(2016+" / "+d);
				}else{
					int d = month+i;
					date.add(2015+" / "+d);
				}	
			}
			model.addAttribute("date", date);
		
			ArrayList<Trip> tripList = tripDao.queryAllAgent();
			model.addAttribute("trip1", tripList.get(0));
			model.addAttribute("trip2", tripList.get(1));
			model.addAttribute("trip3", tripList.get(2));
			model.addAttribute("trip4", tripList.get(3));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	@RequestMapping(value="/indexpage" ,method=RequestMethod.GET)
	public String submitdelr(Model model,HttpServletRequest request){
		
		String returnVal = "indexpage";	
		
		
		
		return returnVal;
		
	}
}
