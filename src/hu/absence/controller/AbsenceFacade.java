package hu.absence.controller;

import java.util.List;

import hu.absence.model.domain.Absence;

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
	
	private long getAbsenceTypeCount(char type) {
		return absences.stream().mapToLong(i -> i.count(type)).sum();
	}
	
}
