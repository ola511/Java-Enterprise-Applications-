package ca.sheridancollege.aljarrao.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Calendar {

	private Long id;
	@NonNull
	private String title;
	private String time;
	private String lastGift;
	private String text;
	private String birthday;

	private String assignLastGift(String birthday) {
		if (birthday == "1")
			return "Jan";
		else if (birthday == "2")
			return "Feb";
		else if (birthday == "3")
			return "March";
		return "Birthday";

	}

	public Calendar(String title, String birthday, String text) {
		this.title = title;
		this.birthday= birthday;
		lastGift = assignLastGift(birthday);
		this.text = text;

	}

	public void setDate(String birthday) {
		this.birthday = birthday;
		lastGift = assignLastGift(birthday);
	}
}
