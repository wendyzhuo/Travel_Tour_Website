package com.zhuo.travel;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.zhuo.travel.dao.CountryDao;
import com.zhuo.travel.dao.TripDao;
import com.zhuo.travel.dao.UserDao;
import com.zhuo.travel.model.Country;
import com.zhuo.travel.model.Order;
import com.zhuo.travel.model.Trip;
import com.zhuo.travel.model.User;


@Controller
public class RegisterController {
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CountryDao countryDao;
	
	@Autowired
	private TripDao tripDao;
	
	@InitBinder
	private void initBinder (WebDataBinder binder){
		binder.setValidator(validator);
	}
	
	@RequestMapping(value="/uregister" ,method=RequestMethod.POST)
	public String submituregister(Model model,HttpServletRequest request, @Validated User user,BindingResult result){
		 request.removeAttribute("user");
		String returnVal = "userRegister";
			return returnVal;	
	}
	
	
	
	@RequestMapping(value="/uregistered" ,method=RequestMethod.POST)
	public String submituregistered(Model model, HttpServletRequest request,@Validated User user, BindingResult result){
	
		String returnVal = "home";
		if (result.hasErrors()){
					
					return "userRegister";
				}
			try {
				
				 String userName = user.getUserName();
				 String pass =user.getPassword();
				String email =user.getEmail();
				String sr = pass;
				String[] pwd = sr.split(",");
				if(pwd.length<=0){
					return "userRegister";
				}else{
				if(pwd[0].equals(pwd[1])){
					boolean isu = userDao.addUser(userName, pwd[0], email);
					
					if (isu){
						model.addAttribute("result", "congratulation ! you are registered !");
					
					}else{
						model.addAttribute("result", "something wrong happened !");
					}
				}else{
					model.addAttribute("result", "2 passwords is not match");
				}
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "checkOut";	
	}
	
	
	
	
}
