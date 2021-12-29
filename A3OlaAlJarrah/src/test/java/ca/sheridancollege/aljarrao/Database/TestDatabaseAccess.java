package ca.sheridancollege.aljarrao.Database;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import ca.sheridancollege.aljarrao.beans.Calendar;

@SpringBootTest
@AutoConfigureTestDatabase
public class TestDatabaseAccess {

	@Autowired
	private DatabaseAccess da;

	@Test
	public void whenInsertCalendar_getCalendarList() {
		// setup
		int size = da.getCalendarList().size();
		Calendar calendar = new Calendar();
		calendar.setTitle("Ola");
		calendar.setTime("11");
		calendar.setLastGift("Flower");
		calendar.setText("Hi");
		calendar.setBirthday("2021-11-1");

		// when
		da.insertCalendar(calendar);
		// then
		assertEquals(da.getCalendarList().size(), ++size);
	}

}
