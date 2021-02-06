package tn.esprit.spring.services;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.DAO.entity.*;
import tn.esprit.spring.DAO.repository.*;

@Service
public class EventServices implements IEventServices {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private IItemDAO itemRepository;

	@Autowired
	private CouponAdminService couponService;
	
	@Autowired
	private ShoppingCartImp shoppingCartService;
	
	@Autowired
	private Cart_ActionImp cartAction;

	@Override
	public Event addEvent(Event e, Category c) {
		if (e.getCategories() == null) {
			List<Category> categories = new ArrayList<>();
			categories.add(c);
			e.setCategories(categories);
		} else {
			e.getCategories().add(c);
		}
		return eventRepository.save(e);
	}

	@Override
	public List<Event> showAllEvents() {
		List<Event> allEvents = new ArrayList<Event>();
		eventRepository.findAll().forEach(allEvents::add);
		return allEvents;
	}

	@Override
	public List<Event> showEventByCustomer(int userId) {
		List<Event> eventsByCustomer = new ArrayList<Event>();
		User user = userRepository.findById(userId);
		eventRepository.getAllEventsByCustomer(user).forEach(eventsByCustomer::add);
		return eventsByCustomer;
	}

	@Override
	public Event showEvent(int id) {
		return eventRepository.findById(id).get();
	}

	@Override
	public void deleteEvent(Event e) {
		if (showAllEvents().contains(e))
			eventRepository.delete(e);
	}

	@Override
	public void deleteEvent(int id) {
		eventRepository.deleteById(id);
	}

	@Override
	public void updateEvent(Event e) {
		eventRepository.save(e);
	}

	@Override
	public Event getEventById(int eventId) {
		return eventRepository.findById(eventId).get();
	}

	@Override
	public void mettreAjourLocationByEventId(String location, int eventId) {
		Event event = eventRepository.findById(eventId).get();
		event.ListLocation(location);
		eventRepository.save(event);

	}

	@Override
	public void participateInEvent(int userId, int eventId) {
		Event event = eventRepository.findById(eventId).get();
		User user = userRepository.findById(userId);
		event.getUsers().add(user);
		eventRepository.save(event);
	}

	@Transactional
	@Override
	public void retirerUserFromEvent(int userId, int eventId) {
		Event event = eventRepository.findById(eventId).get();

		int nbParticipants = event.getUsers().size();
		for (int index = 0; index < nbParticipants; index++) {
			if (event.getUsers().get(index).getUserid() == userId) {
				event.getUsers().remove(index);
			}
		}
	}

	@Override
	public boolean participantExists(int eventId, int userId) {
		Event event = eventRepository.findById(eventId).get();
		User user = userRepository.findById(userId);

		if (event.getUsers() != null) {
			for (User u : event.getUsers())
				if (u.equals(user)) {
					return true;
				} else
					return false;
		}
		return false;

	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateEventSemaineDuLivre() {
		Calendar now = Calendar.getInstance();
		TimeZone tunisia = TimeZone.getTimeZone("Tunisia");
		now.setTimeZone(tunisia);
		Event event = eventRepository.findByName("Semaine du Livre");
		Date bd = event.getBegin_date();
		Date ed = event.getEnd_date();
		Calendar march = Calendar.getInstance();
		march.setTimeZone(tunisia);
		march.set(Calendar.MONTH, 0);
		march.set(Calendar.DAY_OF_MONTH, 15);
		System.out.println(now);
		System.out.println(march);
		if (now.after(march)) {
			bd.setYear(bd.getYear() + 1);
			ed.setYear(ed.getYear() + 1);
			now.add(Calendar.YEAR, 1);
			march.add(Calendar.YEAR, 1);
		}
		eventRepository.save(event);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void blackFriday() {
		Calendar now = Calendar.getInstance();
		TimeZone tunisia = TimeZone.getTimeZone("Tunisia");
		now.setTimeZone(tunisia);
		Event event = eventRepository.findByName("Black Friday");
		Date bd = event.getBegin_date();
		Date ed = event.getEnd_date();
		Calendar march = Calendar.getInstance();
		march.setTimeZone(tunisia);
		march.set(Calendar.MONTH, 0);
		march.set(Calendar.DAY_OF_MONTH, 31);
		System.out.println(now);
		System.out.println(march);
		if (now.after(march)) {
			bd.setYear(bd.getYear() + 1);
			ed.setYear(ed.getYear() + 1);
			now.add(Calendar.YEAR, 1);
			march.add(Calendar.YEAR, 1);
		}
		eventRepository.save(event);
	}

	@SuppressWarnings("deprecation")
	@Override
	public String giftMostActiveUserInEventCreation() {
		Date d = new Date();
		if (d.getDate() == 05) {
			List<String> eventByUser = new ArrayList<>();
			eventByUser = eventRepository.getNbEventsByUser();
			String ch = eventByUser.get(0);
			int userId = new Scanner(ch).useDelimiter("\\D+").nextInt();
			User u = userRepository.findById(userId);
			CouponAdmin c = new CouponAdmin();
			c.setDuration(Duration.ONCE);
			c.setName(u.getLastname());
			Date expritationDate = new Date();
			expritationDate.setDate(d.getDate()+30);
			c.setExpiration_date(expritationDate);
			couponService.addCoupon(c);
			return "The user : " + u.getUsername() + " has won the coupon with the code " + c.getName()
					+ " that will expire within a MONTH :"+c.getExpiration_date();
		} else
			return "It's not gifts day yet";
	}

	@Override
	public List<String> mostActiveUserCategoryNames(int userId) {
		List<Category> categories = new ArrayList<>();
		List<String> categoriesNames = new ArrayList<>();
		User user = userRepository.findById(userId);
		List<Event> events = eventRepository.participantEvents(user);
		if (events != null) {
			for (Event e : events)
				categories.addAll(e.getCategories());
		}
		if (categories != null) {
			for (Category c : categories)
				categoriesNames.add(c.getCategoryName());
		}
		return categoriesNames;
	}

	@Override
	public String chooseGiftCategory(int userId) {
		List<String> categoriesPerParticipantNames = mostActiveUserCategoryNames(userId);
	//List<String> categoriesNames = categoryRepository.names();
		Map<String, Integer> mostLovedCategory = new HashMap<>();
		int i = 0;
		/*if (categoriesNames != null) {
			for (String c : categoriesNames) {
				i = categoryOccurence(c, categoriesPerParticipantNames);
				mostLovedCategory.put(c, i);
			}
		}*/
		String chosenCat = "";
		int max = 0;
		for (Map.Entry<String, Integer> map : mostLovedCategory.entrySet())
			if (map.getValue() >= max) {
				max = map.getValue();
				chosenCat = map.getKey();
			}
		return chosenCat;
	}

	public int categoryOccurence(String cat, List<String> list) {
		int i = 0;
		for (String s : list)
			if (s.equals(cat))
				i++;
		return i;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String chooseBookGift(int userId) {
		Date d = new Date();
		if (d.getDate() == 05) {
			String cat = chooseGiftCategory(userId);
			User u = userRepository.findById(userId);
			List<Item> booksSelected = new ArrayList<>();
			//List<Item> booksFromBase = itemRepository.getBooksGifts();
			int index = (int) (Math.random() * (1 - 0));
			/*for (Item b : booksFromBase)
				if (b.getCategory().getCategoryName().equals(cat)) {
					booksSelected.add(b);
				}*/
			Item book = new Item();
			if(booksSelected != null){
			book = booksSelected.get(index);
			book.setPrice(0f);
//			shoppingCartService.getLatestSC(userId);
//			Cart_Action ca = new Cart_Action();
//			ca.setItemID(book);
//			cartAction.save(ca);
			}
			return "You have won the book " + book.getItemName() + " go check your cart";
		} else
			return "not gifts day yet";
	}
}
