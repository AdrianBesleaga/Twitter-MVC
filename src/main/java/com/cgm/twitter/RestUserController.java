package com.cgm.twitter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgm.twitter.data.ArtefactBuilder;
import com.cgm.twitter.data.User;

@RestController
public class RestUserController {
	@RequestMapping(value = "/users/{name}", method = RequestMethod.GET)
	public User getUser(@PathVariable String name) throws Exception {

		return ArtefactBuilder.anUser();
	}
}
