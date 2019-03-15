package hu.absence.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import hu.absence.model.domain.Absence;
import hu.absence.model.domain.RegisterDate;

public class AbsenceFacade {

	private final List<Absence> absences;

	public AbsenceFacade(List<Absence> absences) {
		this.absences = absences;
	}

	public int getEntryCount() {
		return absences.size();
	}
	
	public String getSummary() {
		return String.format("Az igazolt hiányzások száma %d, az igazolatlanoké %d óra.", 
				getAbsenceTypeCount('X'), getAbsenceTypeCount('I'));
	}
	
	public String getDayOfWeek(int month, int day) {
		RegisterDate date = new RegisterDate(month, day);
		return date.getWeekDay();
	}
	
	public long  getAbsenceForCertainLesson(String dayOfWeek, int lesson) {
		return absences.stream()
				.filter(i -> i.isWeekDay(dayOfWeek))
				.filter(i -> i.isAbsence(lesson))
				.count();
	}
	
	
	private long getAbsenceTypeCount(char type) {
		return absences.stream().mapToLong(i -> i.count(type)).sum();
	}
	
	public String getMaxAbsenceStudentNames() {
		return getStudentAbsences().entrySet().stream()
				.filter(i -> i.getValue() == getMaxAbsenceCount())
				.map(Entry::getKey)
				.collect(Collectors.joining(" "));
	}

	private long getMaxAbsenceCount() {
		return getStudentAbsences().entrySet().stream().mapToLong(Entry::getValue).max().getAsLong();
	}
	
	private Map<String, Long> getStudentAbsences() {
		return absences.stream()
				.collect(Collectors.groupingBy(
						Absence::getName, 
						Collectors.summingLong(Absence::countAbsence)));
	}
	
}
