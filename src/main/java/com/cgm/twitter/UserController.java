package com.cgm.twitter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.twitter.data.ArtefactBuilder;
import com.cgm.twitter.data.Message;
import com.cgm.twitter.data.User;


@Controller
public class UserController {
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	protected ModelAndView getUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView model = new ModelAndView("redirect:/home");
		if (request.getSession().getAttribute("userName") != null) {
			System.out.println("Session in GET : " + request.getSession().getAttribute("userName").toString());
			model = new ModelAndView("user");
			if (ArtefactBuilder.getMessages().size() > 0) {
				model.addObject("messageText", ArtefactBuilder.getMessages());
				System.out.println(ArtefactBuilder.getMessages().get(0).getText());
			}

		}

		return model;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView messagePost(HttpServletRequest request, @ModelAttribute("messageBean") Message message) {
		ModelAndView model = new ModelAndView("redirect:/home");
		if (request.getSession().getAttribute("userName") != null) {
			ArtefactBuilder.getMessages().add(message);
			model = new ModelAndView("user");
			// model.addObject("messageText", ArtefactBuilder.getMessages());
		}
		return model;

	}
	

}
