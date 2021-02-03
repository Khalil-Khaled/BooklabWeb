package tn.esprit.spring.controller;

import java.util.List;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.DAO.entity.*;
import tn.esprit.spring.DAO.repository.*;
import tn.esprit.spring.services.EventServices;

@RestController
public class EventController {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ParticipantRepository participantRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private EventServices eventServices;
	
	//valide
	@GetMapping(value = "/")
	public void updateEventSemaineDuLivre() {
		eventServices.updateEventSemaineDuLivre();
	}
	
	//valide
	@GetMapping(value = "/BlackFriday")
	public void updateEventBlackFriday() {
		eventServices.blackFriday();
	}

	// valide
	@GetMapping(value = "/participants/{eventId}")
	@ResponseBody
	public List<User> participantsByEvent(@PathVariable("eventId") int eventId) {
		Event event = eventServices.getEventById(eventId);
		return eventRepository.participantsByEvent(event);
	}

	// valide
	@GetMapping(value = "/nbParticipants/{eventId}")
	public int NombreParticipantsByEvent(@PathVariable("eventId") int eventId) {
		Event event = eventServices.getEventById(eventId);
		return eventRepository.nombreParticipantsByEvent(event);
	}

	// valide
	@GetMapping(value = "/nbevents/{userId}")
	public int nombreDeEvenements(@PathVariable("userId") int eventId) {
		return eventRepository.countEventsByUserThisYear(eventId);
	}

	// valide
	@PostMapping("/ajouterEvent/{userId}/{categoryId}")
	public Event ajouterEvent(@RequestBody Event event, @PathVariable("userId") int userId, @PathVariable("categoryId") int categoryId) {
		User u = participantRepository.findById(userId).get();
		Category c = categoryRepository.findById(categoryId).get();
		event.ListUser(u);
		eventServices.addEvent(event,c);
		return event;
	}

	// valide
	@GetMapping("/admin/{userId}/MyEvents")
	public List<Event> getEventByCustomer(@PathVariable int userId) {
		return eventServices.showEventByCustomer(userId);
	}

	// valide
	@GetMapping("/eventNames")
	public List<String> getEventNames() {
		return eventRepository.getEventNames();
	}

	// valide
	@GetMapping("/NbEvents")
	public List<String> getNbEventsByUser() {
		return eventRepository.getNbEventsByUser();
	}

	@GetMapping("/chooseGiftCategory/{userId}")
	public String chooseGiftCategory(@PathVariable("userId") int userId) {
		return eventServices.chooseGiftCategory(userId);
	}

	// valide
	@GetMapping("/gifted")
	public String giftMostActiveUser() {
		return eventServices.giftMostActiveUserInEventCreation();
	}

	// valide
	@RequestMapping("/AllEvents")
	public List<Event> getAllEvents() {
		return eventServices.showAllEvents();
	}

	// valide
	@PutMapping(value = "/modifyEventLocation/{eventId}/{location}")
	public void mettreAjourEmailByEmployeId(@PathVariable("location") String location,
			@PathVariable("eventId") int eventId) {
		eventServices.mettreAjourLocationByEventId(location, eventId);
	}

	// valide
	@DeleteMapping(value = "/admin/{userId}/DeleteEvent/events/{eventId}")
	public void deleteEventByUser(@PathVariable("userId") int userId, @PathVariable int eventId) {
		Event e = eventRepository.findById(eventId).get();
		if (userId == e.getUser().getUserid())
			eventServices.deleteEvent(e);
		else
			return;
	}

	@PostMapping(value = "/participateInEvent/{userId}/{eventId}")
	public String participateInEvent(@PathVariable("userId") int userId, @PathVariable("eventId") int eventId) {
		if (!eventServices.participantExists(eventId, userId)) {
			eventServices.participateInEvent(userId, eventId);
			return "you are now a participant";
		} else
			return "you are already a participant";
	}

	@Modifying
	@PutMapping(value = "/retirerUserFromEvent/{userId}/{eventId}")
	public String retirerUserFromEvent(@PathVariable("userId") int userId, @PathVariable("eventId") int eventId) {
		if (eventServices.participantExists(eventId, userId)) {
			eventServices.retirerUserFromEvent(userId, eventId);
			return "you are no longer a participant";
		} else
			return "you have never been a participant";
	}

	// valide
	@GetMapping("/gifted/{userId}")
	public List<String> mostActiveUserCategoryNames(@PathVariable("userId") int userId) {
		return eventServices.mostActiveUserCategoryNames(userId);
	}

	// valide
	@GetMapping("/participantEvents/{userId}")
	public List<Event> participantEvents(@PathVariable("userId") int userId) {
		User user = participantRepository.findById(userId).get();
		System.out.println(eventRepository.participantEvents(user));
		return eventRepository.participantEvents(user);
	}

	// valide
	@GetMapping("/chooseBookGift/{userId}")
	public String chooseBookGift(@PathVariable("userId") int userId) {
		User user = participantRepository.findById(userId).get();
		return eventServices.chooseBookGift(userId);
	}
	
	
}
