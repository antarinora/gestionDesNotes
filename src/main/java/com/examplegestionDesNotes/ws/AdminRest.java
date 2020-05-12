package com.examplegestionDesNotes.ws;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.examplegestionDesNotes.bean.User;
import com.examplegestionDesNotes.dtos.UserWrapper;

@Controller
@CrossOrigin(origins = {"http://localhost:4200"})
public class AdminRest {
	@GetMapping("/login")
	public String loginPage() {
		// redirige vers la page de login qui s'appelle "login"
		return "login";
		}
	
	
	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	@ResponseBody
    public String loginError(Model model) {
        return "loginFailed";
    }
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/login";
    }
	
	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String postLogin(Model model, HttpSession session) {
		
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((UserWrapper) authentication.getPrincipal()).getUserDetails();
        
        return "redirect:/something";
	}
	

	
	@RequestMapping(value = "/something", method = RequestMethod.GET)
	@ResponseBody
    public String something(Model model) {
        return "sucess login";
    }
	
	private void validatePrinciple(Object principal) {
        if (!(principal instanceof UserWrapper)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }

}
