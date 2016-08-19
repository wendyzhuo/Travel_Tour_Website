package com.zhuo.travel;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhuo.travel.dao.CountryDao;
import com.zhuo.travel.dao.OrderDao;
import com.zhuo.travel.dao.TravellerDao;
import com.zhuo.travel.dao.TripDao;
import com.zhuo.travel.dao.UserDao;
import com.zhuo.travel.model.Agent;
import com.zhuo.travel.model.Country;
import com.zhuo.travel.model.Order;
import com.zhuo.travel.model.Traveller;
import com.zhuo.travel.model.Trip;
import com.zhuo.travel.model.User;

@Controller
public class UserController {

	@Autowired
		private UserDao userDao;
	@Autowired
	private OrderDao orderDao;
		
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private TripDao tripDao;
	
	@Autowired
	private TravellerDao travellerDao;
	
		/*
		 * Process From request
		 */
		@RequestMapping(value="/userlogin" ,method=RequestMethod.POST)
		public String submituLogin(Model model, HttpServletRequest request){
			
			String returnVal = "home";
			
				try {
					String page = request.getParameter("page");
					System.out.println("log"+page);
					if(page.equals("1")){
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
					
					}else if(page.equals("2")){
						String destination = request.getParameter("sdes");
						 String dates =request.getParameter("sdate");
						 String year =request.getParameter("syear");
						 Integer date = Integer.parseInt(dates);
						 Integer y = Integer.parseInt(year);
						 ArrayList<Trip> tripList= tripDao.querySearch(destination, date,y); 
						 model.addAttribute("tripList", tripList);
							model.addAttribute("sdes", destination);
							model.addAttribute("sdate", date);
							model.addAttribute("syear", year);
							 returnVal = "search";
					}else if(page.equals("3")){
						 String id = request.getParameter("tripID");
							System.out.println(id);
							int t = Integer.parseInt(id);
							Trip trip= tripDao.queryTrip(t);  
							model.addAttribute("atrip", trip);
							 returnVal = "searchResult";
					}
					
					 String userName = request.getParameter("name");
					 String password = request.getParameter("pass");
					
					
					
					User u = userDao.queryUserByNameAndPassword(userName, password);
					
					if (u!=null){
						model.addAttribute("user",u);
						HttpSession session=request.getSession();
						session.setAttribute("user", u);
						model.addAttribute("check","yes");
							
						return returnVal;
					
					}else{
						model.addAttribute("check","no");
						model.addAttribute("result", "something wrong happened !");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.addAttribute("result", "User Login error !");
				return "checkOut";
		}
		
		@RequestMapping(value="/userlogout" ,method=RequestMethod.POST)
		public String submituLogout(Model model, HttpServletRequest request){
			
			String returnVal = "home";
			
				try {
					String page = request.getParameter("page");
					if(page.equals("1")){
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
					
					}else if(page.equals("2")){
						String destination = request.getParameter("sdes");
						 String dates =request.getParameter("sdate");
						 String year =request.getParameter("syear");
						 Integer date = Integer.parseInt(dates);
						 Integer y = Integer.parseInt(year);
						 ArrayList<Trip> tripList= tripDao.querySearch(destination, date,y); 
						 model.addAttribute("tripList", tripList);
							model.addAttribute("sdes", destination);
							model.addAttribute("sdate", date);
							model.addAttribute("syear", year);
							 returnVal = "search";
					}else if(page.equals("3")){
						 String id = request.getParameter("tripID");
							System.out.println(id);
							int t = Integer.parseInt(id);
							Trip trip= tripDao.queryTrip(t);  
							model.addAttribute("atrip", trip);
							 returnVal = "searchResult";
					}
					
					
						HttpSession session=request.getSession();
						session.invalidate();
					
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return returnVal;
		}
		
		@RequestMapping(value="/ulogined" ,method=RequestMethod.POST)
		public String submituLogined(Model model, HttpServletRequest request){
			
			String returnVal = "userLogined";
				try {
					
					 String userName = ((User)request.getSession().getAttribute("user")).getUserName();
					User u = userDao.queryUserByName(userName);
					
					if (u!=null){
						ArrayList<Order> orderList = orderDao.queryOrder(u.getUserId());
						model.addAttribute("order",orderList);
						return returnVal;
					
					}else{
						model.addAttribute("check","no");
						model.addAttribute("result", "something wrong happened !");
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				model.addAttribute("result", "login error !");
				return "checkOut";
		}
		
		
		
		
		
		@RequestMapping(value="/addOrder" ,method=RequestMethod.POST)
		public String submitorder(Model model,HttpServletRequest request){
			
			String returnVal = "addOrder";	
				try {
					HttpSession session =request.getSession();
					if(session.getAttribute("user")!=null){
						model.addAttribute("check","yes");
						
				 String tnum = request.getParameter("travellernum");
					String id = request.getParameter("id");
					int t = Integer.parseInt(id);
					Trip trip= tripDao.queryTrip(t);  
					model.addAttribute("atrip", trip);
					session.setAttribute("selectid", id);
					model.addAttribute("number",tnum);
					return returnVal;		
					}else{
						
					}
						
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				model.addAttribute("result", "add orrder error !");
				return "checkOut";
			
		}
		
		@RequestMapping(value="/checkOut" ,method=RequestMethod.POST)
		public String submitcheckout(Model model,HttpServletRequest request){
			
			String returnVal = "checkOut";	
				try {
					HttpSession session =request.getSession();
					
					if(session.getAttribute("user")!=null){
						model.addAttribute("check","yes");
						User u =(User)session.getAttribute("user");	
					String tid=(String) session.getAttribute("selectid");
					int id = Integer.parseInt(tid);
					String destination=request.getParameter("destination");
					String pnums=request.getParameter("pnum");
					int pnum = Integer.parseInt(pnums);
					String avail=request.getParameter("avail");
					String[] firstname = request.getParameterValues("firstname");
			        String[] lastname = request.getParameterValues("lastname");
			        String[] email = request.getParameterValues("email");
			        String[] cnumber = request.getParameterValues("cnumber");
			        String[] month = request.getParameterValues("month");
			        String[] year = request.getParameterValues("year");
			        String[] date = request.getParameterValues("date");
			        String[] gender =  new String[firstname.length];
					for(int i =0; i<firstname.length; i++){
						int j =i+1;
						if(firstname[i].trim().equals("")||lastname[i].trim().equals("")||email[i].trim().equals("")){
							model.addAttribute("result","please enter informations !");
							return "checkOut";
						}
						
					}
					
					
					int addorder = orderDao.addOrder(pnum, id, u.getUserId(), destination);
				
					if(addorder!=0){
				boolean uavail = tripDao.queryavail(id, avail);
				System.out.println("avail update:"+uavail);
				
		
		for(int i =0; i<firstname.length; i++){
			int j =i+1;
			 gender[i]= request.getParameter("gender"+j);
		}
		boolean travellr = travellerDao.addTraveller(addorder,u.getUserId(),id,firstname, lastname, cnumber, gender, month, year,date,email);
						
			if(travellr){
				model.addAttribute("result","Order Placed Successfully !");
			}else{
				model.addAttribute("result","Something wrong happen !");
			}
						
					return returnVal;	
					}
					}	
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				model.addAttribute("result", "check out error !");
				return "checkOut";
			
		}
		
		
		@RequestMapping(value="/viewOrder" ,method=RequestMethod.POST)
		public String submitvieworder(Model model,HttpServletRequest request){
			
			String returnVal = "viewOrder";	
				try {
					HttpSession session =request.getSession();
					if(session.getAttribute("user")!=null){
						model.addAttribute("check","yes");
						User u = (User)session.getAttribute("user");
						
				 String tid = request.getParameter("tid");
					int t = Integer.parseInt(tid);
					Trip trip= tripDao.queryTrip(t); 
					model.addAttribute("trip",trip);
					
					 String oid = request.getParameter("oid");
						int o = Integer.parseInt(oid);
					ArrayList<Traveller> travellerList = travellerDao.queryTraveller(u.getUserId(),o);
					model.addAttribute("travel",travellerList);
					
					
					return returnVal;		
					}else{
						
					}
						
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				model.addAttribute("result", "view order error !");
				return "checkOut";
		}
		
		
	}

