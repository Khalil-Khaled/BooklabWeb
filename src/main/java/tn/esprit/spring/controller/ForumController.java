package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.services.IForumServices;

@RestController
public class ForumController {
	
	@Autowired
	IForumServices iForumServices;
}
