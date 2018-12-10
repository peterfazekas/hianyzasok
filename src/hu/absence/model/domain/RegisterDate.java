package hu.absence.model.domain;

import hu.absence.model.service.RegisterDateHelper;

public class RegisterDate {

	private final int month;
	private final int day;
	
	public RegisterDate(int month, int day) {
		this.month = month;
		this.day = day;
	}
	
	public String getWeekDay() {
		return RegisterDateHelper.dayOfWeek(month, day);
	}
}
