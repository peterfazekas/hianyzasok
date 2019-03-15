package hu.absence;

import hu.absence.controller.AbsenceFacade;
import hu.absence.model.service.DataReader;

public class App {

	private final AbsenceFacade absence;
	private final DataReader reader;
	
	public App() {
		reader = new DataReader();
		absence = new AbsenceFacade(reader.getData("naplo.txt"));
	}
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		System.out.println("2. feladat: A naplóban " + absence.getEntryCount() + " bejegyzés van.");
		System.out.println("3. feladat: " + absence.getSummary());
		System.out.println("5. feladat:");
		int month = reader.readInt("- a hónap sorszáma: ");
		int day = reader.readInt("- a nap sorszáma: ");
		System.out.println("Azon a napon " + absence.getDayOfWeek(month, day) + " volt.");
		System.out.println("6. feladat:");
		String dayOfWeek = reader.readText("- a nap neve: ");
		int lesson = reader.readInt("- az óra sorszáma: ");
		System.out.println("Ekkor összesen " + 
						   absence.getAbsenceForCertainLesson(dayOfWeek, lesson) + 
				           " óra hiányzás történt.");
		System.out.println("7. feladat: A legtöbbet hiányzó tanulók: " + absence.getMaxAbsenceStudentNames());
	}

}
