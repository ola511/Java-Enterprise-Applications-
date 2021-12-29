function getCalendar(id) {
	if (document.getElementById("calendar" + id).innerHTML == "") {

		fetch('http://localhost:8080/getCalendar/' + id)
			.then(calendar => calendar.json())
			.then(function(calendar) {
				var textToDisplay = "";
				textToDisplay += "ID: " + calendar.id + "<br>";
				//textToDisplay += "Name: " + calendar.title + "<br>";
				//textToDisplay += "Date: " + calendar.date + "<br>";
				textToDisplay += "Last Birthday Gift: " + calendar.lastGift + "<br>";
				textToDisplay += "Text: " + calendar.text + "<br>";
				textToDisplay += "Birthday: " + calendar.birthday + "<br>";



				document.getElementById("calendar" + id).innerHTML = textToDisplay;
			});
	} else {
		document.getElementById("calendar" + id).innerHTML = "";
	}
}