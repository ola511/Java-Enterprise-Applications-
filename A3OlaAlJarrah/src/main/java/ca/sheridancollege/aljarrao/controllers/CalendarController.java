package ca.sheridancollege.aljarrao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.aljarrao.Database.DatabaseAccess;

import ca.sheridancollege.aljarrao.beans.Calendar;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/calendars")
public class CalendarController {

	@Autowired
	private DatabaseAccess da;

	@GetMapping
	public List<Calendar> getCalendartCollection() {
		return da.findAll();

	}

	@GetMapping(value = "/{id}")
	public Calendar getIndividualCalendar(@PathVariable Long id) {
		return da.findById(id);
	}

	@PostMapping(consumes = "application/json")
	public String postCalendar(@RequestBody Calendar calendar) {
		return "http://localhost:8080/calendars/" + da.save(calendar);
	}

	@PutMapping(consumes = "application/json")
	public String putCalendarCollection(@RequestBody List<Calendar> calendarList) {
		da.deleteAll();
		da.saveAll(calendarList);
		return "Total Records: " + da.count();
	}

	@DeleteMapping(consumes = "application/json")
	public void deleteCalendarCollection(@RequestBody List<Calendar> calendarList) {
		da.deleteAll();

	}

}
