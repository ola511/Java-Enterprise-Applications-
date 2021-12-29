package ca.sheridancollege.aljarrao.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import ca.sheridancollege.aljarrao.beans.Calendar;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class TestHomeController {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testLoadingIndex() throws Exception {
		this.mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	public void testLoadingInsertCalendar() throws Exception {

		this.mockMvc.perform(post("/insertCalendar").flashAttr("calendar", new Calendar())).andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

}
