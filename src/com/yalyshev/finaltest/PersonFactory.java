package com.yalyshev.finaltest;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

public class PersonFactory {
	static Scanner scanner = new Scanner(System.in);
	
	public static int switchConsole(){
		int numberAboutConsole = scanner.nextInt();
		return numberAboutConsole;
	}
	
	public static Person setPerson(){
		Supplier<Person> userFactory = () -> {
			System.out.println("Введите имя: ");
			String name = scanner.nextLine();
			System.out.println("Введите фамилию: ");
			String surname = scanner.nextLine();
			System.out.println("Введите отчество: ");
			String patronymic = scanner.nextLine();
			System.out.println("Введите дату рождения: ");
			String dateOfBirth = scanner.nextLine();
			System.out.println("Пол человека: ");
			String sex = scanner.nextLine();
			System.out.println("Номер телефона: ");
			long phoneNumber = scanner.nextLong();
			System.out.println("Должность сотрудника: ");
			String post = scanner.nextLine();
			System.out.println("Отдел, в котором работает сотрудник: ");
			String departmentInWork = scanner.nextLine();
			System.out.println("Руководитель: ");
			String bossName = scanner.nextLine();
			System.out.println("Дата приема на работу: ");
			String employmentDate = scanner.nextLine();
			System.out.println("Укажите зарплату сотрудника: ");
			int salary = scanner.nextInt();
			return new Person(name, surname, patronymic, dateOfBirth, sex,
					phoneNumber, post, departmentInWork,bossName,
					employmentDate, salary);
		};
		return userFactory.get();
	}
	
	public static void deletePerson(ArrayList<Person> personList){
		System.out.println("Под каким номером необходимо уволить сотрудника");
		int num = 1;
		for (Person person : personList) {
			System.out.println(num + "." + person);
			num++;
		}
		int numberIndexDelete = scanner.nextInt();
		personList.remove(numberIndexDelete-1);
		
	}
}
