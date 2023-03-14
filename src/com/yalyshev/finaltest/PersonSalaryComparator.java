package com.yalyshev.finaltest;

import java.util.Comparator;

public class PersonSalaryComparator implements Comparator<Person> {
	@Override
	public int compare(Person o1, Person o2) {
		return o1.getSalary() - o2.getSalary();
	}
}
