package com.zhuo.travel;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhuo.travel.dao.AdminDao;
import com.zhuo.travel.dao.AgentDao;
import com.zhuo.travel.model.Admin;
import com.zhuo.travel.model.Agent;
import com.zhuo.travel.model.Trip;

@Controller
public class AdminController {

	@Autowired
	private AgentDao agentDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@RequestMapping(value="/adminlog" ,method=RequestMethod.POST)
	public String submitdelr(Model model,HttpServletRequest request){
		
		String returnVal = "adminLogin";	
			try {
				
				 String name = request.getParameter("username");
				 String password = request.getParameter("password");
			
				Admin u = adminDao.queryAdminByNameAndPassword(name, password);
				if (u != null){
					 HttpSession session=request.getSession();
						session.setAttribute("admin", u);
					List<Agent> m = agentDao.queryUser();
					if (m != null){
					model.addAttribute("message", m);
					}
					return returnVal;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			model.addAttribute("result", "admin login error !");
		return "checkOut";
		
	}
	
	@RequestMapping(value="/lock" ,method=RequestMethod.POST)
	public String submitlock(Model model,HttpServletRequest request){
		
		String returnVal = "adminLogin";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("admin")!=null){
				String[] messageSet=request.getParameterValues("lock");
				agentDao.lockAgent(messageSet);;
				Agent agent = (Agent)session.getAttribute("agent");
				ArrayList<Agent> orderList = agentDao.queryUser();
				model.addAttribute("message", orderList);
			    return returnVal;	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			model.addAttribute("result", "admin lock error !");
			return "checkOut";
}
	
	@RequestMapping(value="/approve" ,method=RequestMethod.POST)
	public String submitApprove(Model model,HttpServletRequest request){
		
		String returnVal = "adminLogin";	
			try {
				HttpSession session =request.getSession();
				if(session.getAttribute("admin")!=null){
				String[] messageSet=request.getParameterValues("approve");
				agentDao.approveAgent(messageSet);;
				Agent agent = (Agent)session.getAttribute("agent");
				ArrayList<Agent> orderList = agentDao.queryUser();
				model.addAttribute("message", orderList);
			    return returnVal;	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			model.addAttribute("result", "admin approve error !");
			return "checkOut";
}
	
	
	
	
}