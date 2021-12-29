package ca.sheridancollege.aljarrao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import ca.sheridancollege.aljarrao.Database.DatabaseAccess;
import ca.sheridancollege.aljarrao.beans.Calendar;

@Controller
public class HomeController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping("/")
	public String index(Model model, RestTemplate restTemplate) {
		ResponseEntity<Calendar[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/calendars",
				Calendar[].class);
		model.addAttribute("calendar", new Calendar());
		model.addAttribute("calendarList", responseEntity.getBody());

		return "index";
	}

	@GetMapping(value = "/getCalendar/{id}", produces = "application/json")
	@ResponseBody
	public Calendar getCalendar(@PathVariable int id, RestTemplate restTemplate) {
		ResponseEntity<Calendar> responseEntity = restTemplate.getForEntity("http://localhost:8080/calendars/" + id,
				Calendar.class);
		return responseEntity.getBody();
	}

	@PostMapping("/insertCalendar")
	public String insertCalendar(Model model, @ModelAttribute Calendar calendar) {

		da.insertCalendar(calendar);

		model.addAttribute("Calendar", new Calendar());
		model.addAttribute("CalendarList", da.getCalendarList());

		return "redirect:/";

	}

}
