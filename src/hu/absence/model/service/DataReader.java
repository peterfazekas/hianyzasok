package hu.absence.model.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import hu.absence.model.domain.Absence;
import hu.absence.model.domain.RegisterDate;

public class DataReader {

	private final Scanner scanner = new Scanner(System.in);
	private RegisterDate registerDate;
	
	
	public int readInt(String text) {
		System.out.print(text);
		return scanner.nextInt();
	}
	
	public String readText(String text) {
		System.out.print(text);
		return scanner.next();
	}
	
	public List<Absence> getData(String fileName) {
		return parse(read(fileName));
	}
	
	private List<Absence> parse(List<String> lines) {
		return lines.stream().map(this::createAbsence).filter(i -> i != null).collect(Collectors.toList());
	}
	
	private Absence createAbsence(String line) {
		String[] items = line.split(" ");
		Absence absence = null;
		if ("#".equals(items[0])) {
			registerDate = createDate(items[1], items[2]);
		} else {
			absence = new Absence(items[0], items[1], registerDate, items[2]);
		}
		return absence;
	}
	
	private RegisterDate createDate(String month, String day) {
		return new RegisterDate(Integer.parseInt(month), Integer.parseInt(day));
	}
	
	private List<String> read(String fileName) {
		List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			lines = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
}
