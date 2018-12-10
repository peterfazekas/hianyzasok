package hu.absence.model.domain;

public class Absence {

	private final String familyName;
	private final String givenName;
	private final RegisterDate date;
	private final String absences;
	
	public Absence(String familyName, String givenName, RegisterDate date, String absences) {
		this.familyName = familyName;
		this.givenName = givenName;
		this.date = date;
		this.absences = absences;
	}
	
	public String getName() {
		return familyName + " " + givenName;
	}
	
	public boolean isWeekDay(String weekDay) {
		return date.getWeekDay().equals(weekDay);
	}
	
	public long count(char type) {
		return absences.chars().filter(i -> i == (int) type).count();
	}
	
	public boolean isAbsence(int lessonCount) {
		return absences.charAt(lessonCount - 1) == 'X' || absences.charAt(lessonCount - 1) == 'I';
	}
	
	
}
