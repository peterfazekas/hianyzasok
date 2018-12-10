package hu.absence;

import hu.absence.controller.AbsenceFacade;
import hu.absence.model.service.DataReader;

public class App {

	private final AbsenceFacade absence;
	
	public App() {
		DataReader reader = new DataReader();
		absence = new AbsenceFacade(reader.getData("naplo.txt"));
	}
	
	public static void main(String[] args) {
		new App().run();
	}

	private void run() {
		System.out.println("2. feladat: A naplóban " + absence.getEntryCount() + " bejegyzés van.");
		System.out.println("3. feladat: " + absence.getSummary());
	}

}
