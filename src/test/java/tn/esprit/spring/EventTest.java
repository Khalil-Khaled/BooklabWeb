package tn.esprit.spring;


import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.services.EventServices;

public class EventTest {
	
	@Autowired
	EventServices eventServices;
//
//@Test
//public void mettreAjourLocationByEventId() {
//assertEquals(1, eventServices.mettreAjourLocationByEventId("", 1));
//}
//
//@Test
//public void giftMostActiveUserInEventCreation() {
//assertNotEquals("It's not gifts day yet ! Hopefuly you win sir", eventServices.giftMostActiveUserInEventCreation());
//}
//
//@Test
//public void chooseBookGift() {
//assertNotEquals("", eventServices.chooseBookGift(4));
//}
}
