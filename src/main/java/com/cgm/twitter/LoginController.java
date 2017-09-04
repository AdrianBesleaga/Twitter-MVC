package com.cgm.twitter;

import java.text.DateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.data.LoginBean;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView displayLogin(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("redirect:/home");

		// LoginBean loginBean = new LoginBean();
		// model.addObject("loginBean", loginBean);
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String executeLogin(Model model, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginBean") LoginBean loginBean) {
		String page = "redirect:/home";
		try {
			boolean isValidUser = loginBean.getPassword().equals("123");

			System.out.println(loginBean.getUsername());

			if (isValidUser) {
				System.out.println("User Login Successful");
				request.setAttribute("loggedInUser", loginBean.getUsername());
				request.getSession().setAttribute("userName", loginBean.getUsername());
				String sessionName = request.getSession().getAttribute("userName").toString();
				System.out.println("Session in POST : " + sessionName);
				model.addAttribute("userName", loginBean.getUsername().toString());
				model.addAttribute("online", true);
				page = "redirect:/user";
			} else {
				System.out.println("User Error Login");
				// page = "redirect:/";

				Date date = new Date();
				DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

				String formattedDate = dateFormat.format(date);

				model.addAttribute("serverTime", formattedDate);

				model.addAttribute("loginBean", loginBean);
				model.addAttribute("status", "Invalid credentials");
				request.setAttribute("message", "Invalid credentials");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return page;
	}
}