package com.yalyshev.finaltest;

import java.util.ArrayList;

public class PrintConsole {
	public static void printInformation(){
		System.out.println("Добро пожаловать в приложение \"Система учета " +
				"сотрудников\"");
		System.out.println("1. Принять на работу нового сотрудника;");
		System.out.println("2. Уволить имеющегося сотрудника");
		
	}
	
	
	public static void printAboutAddNewPerson(ArrayList<Person> personList){
		System.out.println("Добавить нового сотрудника в список");
		Person newPerson = PersonFactory.setPerson();
		personList.add(newPerson);
		int num = 1;
		for (Person person : personList) {
			System.out.println(num + "." + person);
			num++;
		}
	}
	
	public static void printAboutDeletePerson(ArrayList<Person> personList){
		System.out.println("Уволить сотрудника");
		PersonFactory.deletePerson(personList);
		int num = 1;
		for (Person person : personList) {
			System.out.println(num + "." + person);
			num++;
		}
	}
}
