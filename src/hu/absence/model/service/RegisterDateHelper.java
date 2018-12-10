package hu.absence.model.service;

public class RegisterDateHelper {

	private static final String[] DAY_OF_WEEK = {"vasarnap", "hetfo", "kedd", "szerda", "csutortok",
			"pentek", "szombat"};
	private static final int[] COUNT_OF_DAY = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 335};
	
	public static String dayOfWeek(int month, int day) {
		return hetnapja(month, day);
	}
	
	private static String hetnapja(int honap, int nap) {
		int countOfDay = (COUNT_OF_DAY[honap - 1] + nap) % DAY_OF_WEEK.length;
		return DAY_OF_WEEK[countOfDay];
	}
}
