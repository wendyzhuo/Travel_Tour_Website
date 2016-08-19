package com.zhuo.travel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhuo.travel.dao.AgentDao;
import com.zhuo.travel.dao.CountryDao;
import com.zhuo.travel.dao.TripDao;
import com.zhuo.travel.model.Agent;
import com.zhuo.travel.model.Country;
import com.zhuo.travel.model.Trip;

@Controller
public class SearchController {
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private TripDao tripDao;
	
	@Autowired
	private CountryDao countryDao;
	/*
	 * Process From request
	 */
	
	@RequestMapping(value="/search" ,method=RequestMethod.POST)
	public String submitFormsearch(Model model,HttpServletRequest request,HttpServletResponse response){
		

		String returnVal = "search";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("user")!=null){
				model.addAttribute("check","yes");
				}
				 String destination = request.getParameter("destination");
				 String dates =request.getParameter("date");
				 Integer date = Integer.parseInt(dates);
				 Calendar c = Calendar.getInstance();
			        int month = c.get(Calendar.MONTH); 
				if(date==0){
					
					ArrayList<Trip> tripList= tripDao.querySearch(destination, date,2015);  
					model.addAttribute("tripList", tripList);
					model.addAttribute("sdes", destination);
					model.addAttribute("sdate", date);
					model.addAttribute("syear", 2015);
				}else if(date+month<12){
					int a=date+month;
					ArrayList<Trip> tripList= tripDao.querySearch(destination, a,2015);
					model.addAttribute("tripList", tripList);
					model.addAttribute("sdes", destination);
					model.addAttribute("sdate", a);
					model.addAttribute("syear", 2015);
				}else{
					int a = date+month-12;
					ArrayList<Trip> tripList= tripDao.querySearch(destination, a,2016);
					model.addAttribute("tripList", tripList);
					model.addAttribute("sdes", destination);
					model.addAttribute("sdate", a);
					model.addAttribute("syear", 2016);
				}
			
				
				
				
				
				
				
					return returnVal;		
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			model.addAttribute("result", "search result error !");
			return "checkOut";
		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/searchResult" ,method=RequestMethod.GET)
	public String submitsearchr(Model model,HttpServletRequest request){
		
		String returnVal = "searchResult";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("user")!=null){
					model.addAttribute("check","yes");
					}
				 String id = request.getParameter("tripID");
				System.out.println(id);
				int t = Integer.parseInt(id);
				Trip trip= tripDao.queryTrip(t); 
				String mystr = trip.getItinerarys();
				mystr   =   mystr.replace("\n\r","<br>");   
				  mystr   =   mystr.replace("\r","<br>");   
				  mystr   =   mystr.replace("\t","　　"); 
				  trip.setItinerarys(mystr);
				model.addAttribute("atrip", trip);
					return returnVal;		
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			model.addAttribute("result", "search result error !");
			return "checkOut";
		
	}
	
}
