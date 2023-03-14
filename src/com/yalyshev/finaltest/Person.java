package com.yalyshev.finaltest;

import com.yalyshev.finaltest.csv.StringArrayDecoder;
import com.yalyshev.finaltest.csv.StringArrayEncoder;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
	private String name;
	private String surname;
	private String patronymic;
	private String dateOfBirth;
	private String sex;
	private long phoneNumber;
	private String jobPosition;
	private String departmentInWork;
	private String bossName; // информация о начальнике
	private String employmentDate;
	private int salary;
	
	public Person(String name, String surname, String patronymic,
				  String dateOfBirth, String sex, long phoneNumber,
				  String jobPosition, String departmentInWork, String bossName,
				  String employmentDate, int salary) {
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.dateOfBirth = dateOfBirth;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.jobPosition = jobPosition;
		this.departmentInWork = departmentInWork;
		this.bossName = bossName;
		this.employmentDate = employmentDate;
		this.salary = salary;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getPatronymic() {
		return patronymic;
	}
	
	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getJobPosition() {
		return jobPosition;
	}
	
	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}
	
	public String getDepartmentInWork() {
		return departmentInWork;
	}
	
	public void setDepartmentInWork(String departmentInWork) {
		this.departmentInWork = departmentInWork;
	}
	
	public String getBossName() {
		return bossName;
	}
	
	public void setBossName(String bossName) {
		this.bossName = bossName;
	}
	
	public String getEmploymentDate() {
		return employmentDate;
	}
	
	public void setEmploymentDate(String employmentDate) {
		this.employmentDate = employmentDate;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Person person = (Person) o;
		return phoneNumber == person.phoneNumber && salary == person.salary &&
				Objects.equals(name, person.name) &&
				Objects.equals(surname, person.surname) &&
				Objects.equals(patronymic, person.patronymic) &&
				Objects.equals(dateOfBirth, person.dateOfBirth) &&
				Objects.equals(sex, person.sex) &&
				Objects.equals(jobPosition, person.jobPosition) &&
				Objects.equals(departmentInWork, person.departmentInWork) &&
				Objects.equals(bossName, person.bossName) &&
				Objects.equals(employmentDate, person.employmentDate);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, surname, patronymic, dateOfBirth, sex,
				phoneNumber, jobPosition, departmentInWork, bossName,
				employmentDate, salary);
	}
	
	@Override
	public String toString() {
		return "com.yalyshev.finaltest.Person{" + "name='" + name + '\'' +
				", surname='" + surname + '\'' + ", patronymic='" + patronymic +
				'\'' + ", dateOfBirth" + "=" + dateOfBirth + ", sex='" + sex +
				'\'' + ", phoneNumber=" + phoneNumber + ", post='" +
				jobPosition + '\'' + ", departmentInWork='" + departmentInWork +
				'\'' + ", bossName='" + bossName + '\'' + ", employmentDate=" +
				employmentDate + ", salary=" + salary + '}';
	}
	
	public static class EncoderDecoder
			implements StringArrayEncoder<Person>, StringArrayDecoder<Person> {
		
		public static final EncoderDecoder INSTANCE = new EncoderDecoder();
		
		@Override
		public Person decodeFromStringArray(String[] strings) {
			return new Person(strings[0], strings[1], strings[2], strings[3],
					strings[4], Long.parseLong(strings[5]), strings[6],
					strings[7], strings[8], strings[9],
					Integer.parseInt(strings[10]));
		}
		
		@Override
		public String[] encodeToStringArray(Person object) {
			String[] strings = new String[11];
			strings[0] = object.name;
			strings[1] = object.surname;
			strings[2] = object.patronymic;
			strings[3] = object.dateOfBirth;
			strings[4] = object.sex;
			strings[5] = String.valueOf(object.phoneNumber);
			strings[6] = object.jobPosition;
			strings[7] = object.departmentInWork;
			strings[8] = object.bossName;
			strings[9] = object.employmentDate;
			strings[10] = String.valueOf(object.salary);
			return strings;
		}
	}
}
