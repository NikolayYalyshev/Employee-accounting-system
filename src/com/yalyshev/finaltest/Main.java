package com.yalyshev.finaltest;

import com.yalyshev.finaltest.csv.CSVReaderWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		List<Person> personArrayList = personList();
//		CSVReaderWriter.writeToCSVFile(personArrayList,
//				Person.EncoderDecoder.INSTANCE, CSVReaderWriter.PERSONS_CSV_FILE);

		personArrayList =
				CSVReaderWriter.readFromCSVFile(Person.EncoderDecoder.INSTANCE, CSVReaderWriter.PERSONS_CSV_FILE);
		
		PrintConsole.printInformation();
		int numberAboutInformation = PersonFactory.switchConsole();
		//	switch (numberAboutInformation){
		//		case 1:
		//			PrintConsole.printAboutAddNewPerson(personArrayList);
		//			break;
		//		case 2:
		//			PrintConsole.printAboutDeletePerson(personArrayList);
		//			break;
		//	}
		Top10PersonSalary.Top10PersonSalary(personArrayList);
		
		
	}
	
	public static ArrayList<Person> personList() {
		ArrayList<Person> people = new ArrayList<>();
		people.add(new Person("Александр", "Занегин", "Александрович",
				"16-08" + "-1993", "Мужской", 89105443056L, "Бармен",
				"Работник зала", "Ялышев Н.Д.", "22-02-2017", 31000));
		people.add(
				new Person("Игорь", "Дувалин", "Викторович", "21-01" + "-1998",
						"Мужской", 89205423451L, "Официант", "Работник зала",
						"Ялышев Н.Д.", "03-04-2019", 24000));
		people.add(new Person("Юлия", "Кириллова", "Александровна",
				"22-08" + "-1996", "Женчкий", 89536240013L, "Официант",
				"Работник зала", "Ялышев Н.Д.", "20-12-2021", 21000));
		return people;
	}
	
}