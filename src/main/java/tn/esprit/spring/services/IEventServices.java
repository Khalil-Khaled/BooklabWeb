package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.DAO.entity.Category;
import tn.esprit.spring.DAO.entity.Event;



public interface IEventServices {

	public Event addEvent(Event e,Category c);
	public List<Event> showAllEvents();
	public List<Event> showEventByCustomer(int userId);
	public Event showEvent(int id);
	public void deleteEvent(Event e);
	public void updateEvent(Event e);
	public void participateInEvent(int userId, int eventId);
	public boolean participantExists(int eventId, int userId);
	public void retirerUserFromEvent(int userId, int eventId);
	public void deleteEvent(int id);
	public Event getEventById(int eventId) ;
	public void updateEventSemaineDuLivre();
	public void mettreAjourLocationByEventId(String location, int eventId);
	public void blackFriday();
	public String giftMostActiveUserInEventCreation();
	public List<String> mostActiveUserCategoryNames(int userId);
	public String chooseGiftCategory(int userId);
	public String chooseBookGift(int userId);
}
