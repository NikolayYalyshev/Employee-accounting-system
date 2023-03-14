package com.yalyshev.finaltest;

import java.util.*;

public class Top10PersonSalary {
	public static void Top10PersonSalary(List<Person> personList){
		
		Comparator<Person> comparator =
				(o1, o2) -> o1.getSalary() - o2.getSalary();
		
		Collections.sort(personList, Collections.reverseOrder(comparator));
		
		ListIterator<Person> personListIterator = personList.listIterator();
		
		
		while (personListIterator.hasNext()){
			System.out.println(personListIterator.next());
		}
		
		
	
	}
}
