package com.zhuo.travel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhuo.travel.dao.AgentDao;
import com.zhuo.travel.dao.CountryDao;
import com.zhuo.travel.dao.TripDao;
import com.zhuo.travel.model.Agent;
import com.zhuo.travel.model.Country;
import com.zhuo.travel.model.Order;
import com.zhuo.travel.model.Traveller;
import com.zhuo.travel.model.Trip;
import com.zhuo.travel.model.User;

@Controller
public class AgentController {
	
	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private TripDao tripDao;
	
	@Autowired
	private CountryDao countryDao;
	/*
	 * Process From request
	 */
	@RequestMapping(value="/agentLogin" ,method=RequestMethod.POST)
	public String submitForm(Model model, HttpServletRequest request){
		
		String returnVal = "agentLogin";
			try {
				 String userName = request.getParameter("username");
				 String password = request.getParameter("password");
				
				 model.addAttribute("userName", userName);
				
				
				Agent u = agentDao.queryUserByNameAndPassword(userName, password);
				
				if (u!=null){
					if(u.getApprove().equals("YES")){
					 HttpSession session=request.getSession();
						session.setAttribute("agent", u);
						ArrayList<Trip> orderList = tripDao.queryAgent(u.getAgentID());
						model.addAttribute("tripList",orderList);
						return returnVal;
					}else{
						model.addAttribute("result", "please wait until you are approved!");
					}
				
				}else{
					model.addAttribute("result", "something wrong happened !");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "checkOut";	
	}
	
	@RequestMapping(value="/addtrip" ,method=RequestMethod.POST)
	public String submitorder(Model model,HttpServletRequest request){
		
		String returnVal = "addTrip";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("agent")!=null){
					ArrayList<Country> countryList = countryDao.queryCountry();
					model.addAttribute("countryList", countryList);
				return returnVal;		
				}else{
					model.addAttribute("result", "agent do not login!");
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			model.addAttribute("result", "add trip error !");
			return "checkOut";
		
	}
	
	@RequestMapping(value="/addaTrip" ,method=RequestMethod.POST)
	public String submitatirp(Model model,HttpServletRequest request){
		
		String returnVal = "checkOut";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("agent")!=null){
					Agent agent = (Agent)session.getAttribute("agent");
					 String title = request.getParameter("title");
					 String overview = request.getParameter("overview");
					 String destination = request.getParameter("destination");
					 String fyear = request.getParameter("fyear");
					 String fmon = request.getParameter("fmon");
					 String price = request.getParameter("price");
					 String fdate = request.getParameter("fdate");
					 String tyear = request.getParameter("tyear");
					 String tmonth = request.getParameter("tmonth");
					 String tdate = request.getParameter("tdate");
					 String avail = request.getParameter("avail");
					 String maxage = request.getParameter("maxage");
					 String minage = request.getParameter("minage");
					 String picurl = request.getParameter("picurl");
					 String itinerarys = request.getParameter("itinerarys");
					 if(title.trim().equals("")||overview.trim().equals("")||
							 destination.trim().equals("")||price.trim().equals("")||
							 avail.trim().equals("")||maxage.trim().equals("")||
							 minage.trim().equals("")){
						 model.addAttribute("result", "Check out error ! Be care for the information");
						 return "addTrip";
						 }else{
					 String a = fyear+"-"+fmon+"-"+fdate;
					 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					 Date d1 = format.parse(a);
					 String b = tyear+"-"+tmonth+"-"+tdate;
					 Date d2 = format.parse(b);
					 
					 int m = Integer.parseInt(fmon);
					 int y = Integer.parseInt(fyear);
					 int m1 = Integer.parseInt(maxage);
					 int m2 = Integer.parseInt(minage);
					 float p = Float.parseFloat(price);
					 int tt=Integer.parseInt(avail);
					 if(d1.before(d2)){
					boolean result = tripDao.addTrip(agent.getAgentID(), m1, m2, avail, destination, itinerarys, overview, picurl, title, d1, d2, m, y, p);
					 }else{
						 model.addAttribute("result", "Data picker error");
							
					 }
					return returnVal;	
					 }
				}else{
					
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			model.addAttribute("result", "Check out error ! Be care for the information");
			return "addTrip";
		
	}
	
	@RequestMapping(value="/deletetr" ,method=RequestMethod.POST)
	public String submitdelr(Model model,HttpServletRequest request){
		
		String returnVal = "agentLogin";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("agent")!=null){
					
				String[] messageSet=request.getParameterValues("delete");
				tripDao.deleteTrip(messageSet);
				Agent agent = (Agent)session.getAttribute("agent");
				ArrayList<Trip> orderList = tripDao.queryAgent(agent.getAgentID());
				session.setAttribute("tripList",orderList);
			    return returnVal;	
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			model.addAttribute("result", "delete error !");
			return "checkOut";
		
	}
	
	@RequestMapping(value="/viewTrip" ,method=RequestMethod.POST)
	public String submitvieworder(Model model,HttpServletRequest request){
		
		String returnVal = "viewTrip";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("agent")!=null){
					Agent u = (Agent)session.getAttribute("agent");
					
					ArrayList<Trip> orderList = tripDao.queryAgent(u.getAgentID());
					model.addAttribute("tripList",orderList);
			
				

				return returnVal;		
				}else{
					
				}
					
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
			model.addAttribute("result", "view trip error !");
			return "checkOut";
		
	}
	
	@RequestMapping(value="/viewTripWeb" ,method=RequestMethod.POST)
	public String submitsearchr(Model model,HttpServletRequest request){
		
		String returnVal = "searchResult";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("user")!=null){
					model.addAttribute("check","yes");
					}
				 String id = request.getParameter("tripid");
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
			
		
			model.addAttribute("result", "something wrong happened !");
			return "checkOut";
		
	}
	
	@RequestMapping(value="/tregister" ,method=RequestMethod.POST)
	public String submituregister(Model model,HttpServletRequest request){
		 request.removeAttribute("user");
		String returnVal = "agentRegister";
			return returnVal;	
	}
	
	
	
	@RequestMapping(value="/aregistered" ,method=RequestMethod.POST)
	public String submituregistered(Model model, HttpServletRequest request,@Validated User user, BindingResult result){
	
		String returnVal = "home";
			try {
				
				 String userName = request.getParameter("name");
				 String pass1 =request.getParameter("password1");
				 String pass2 =request.getParameter("password2");
				String ein =request.getParameter("ein");
				if(userName.trim().equals("") || ein.trim().equals("")||pass1.trim().equals("")){
					model.addAttribute("result", "Invaild information !");
						return "agentRegister";
					
				}else{
				
				if(!pass1.equals(pass2)){
					model.addAttribute("result", "Invaild information !");
					return "agentRegister";
				}else{
	
				   boolean isu = agentDao.addAgent(userName, pass1, ein);
					
					if (isu){
						model.addAttribute("result", " you are registered ! please wait for approved!");
					return "checkOut";
					}
				}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			model.addAttribute("result", "something wrong happened !");
			return "checkOut";	
	}
	
}
