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
		System.out.println("2. feladat: A napl�ban " + absence.getEntryCount() + " bejegyz�s van.");
		System.out.println("3. feladat: " + absence.getSummary());
		System.out.println("5. feladat:");
		int month = reader.readInt("- a h�nap sorsz�ma: ");
		int day = reader.readInt("- a nap sorsz�ma: ");
		System.out.println("Azon a napon " + absence.getDayOfWeek(month, day) + " volt.");
		System.out.println("6. feladat:");
		String dayOfWeek = reader.readText("- a nap neve: ");
		int lesson = reader.readInt("- az �ra sorsz�ma: ");
		System.out.println("Ekkor �sszesen " + 
						   absence.getAbsenceForCertainLesson(dayOfWeek, lesson) + 
				           " �ra hi�nyz�s t�rt�nt.");
		System.out.println("7. feladat: A legt�bbet hi�nyz� tanul�k: " + absence.getMaxAbsenceStudentNames());
	}

}
