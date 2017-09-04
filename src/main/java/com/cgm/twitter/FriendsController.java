package com.cgm.twitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.data.ArtefactBuilder;

@Controller
public class FriendsController {
	
	@RequestMapping(value = "/friends", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView("redirect:/home");
		if (request.getSession().getAttribute("userName") != null) {
			System.out.println("Session in GET : " + request.getSession().getAttribute("userName").toString());
			model = new ModelAndView("friends");
			model.addObject("friend", ArtefactBuilder.getFriends());
		}

		return model;
	}
	
}
