package tn.esprit.spring;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.services.EventServices;
import tn.esprit.spring.services.IForumServices;

@RunWith (SpringRunner.class)
@SpringBootTest
class BooklabApplicationTests {

	@Autowired
	IForumServices iForumServices;
	
	@Autowired
	EventServices eventServices;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testGetValidatedForums () {
		iForumServices.getValidatedForums();
	}
	
	@Test
	public void chooseBookGift() {
	assertNotEquals("", eventServices.chooseBookGift(4));
	}

	@Test
	public void giftMostActiveUserInEventCreation() {
	assertNotEquals("It's not gifts day yet ! Hopefuly you win sir", eventServices.giftMostActiveUserInEventCreation());
	}
}
