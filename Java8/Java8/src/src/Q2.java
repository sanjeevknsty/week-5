package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	private int age;
	private String name;
	private double salary;
	
	public Employee(String name,int age, double salary) {
		this.name = name;
		this.age= age;
		this.salary = salary;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Name " + name + " age " + age + " salary " + salary;
	}
	
}


public class Q2 {
	public static void main(String[] args) {
		Employee emp1 = new Employee("ram", 34,22000); 	
		Employee emp2 = new Employee("raj",43,30000);
		Employee emp3 = new Employee("ravi", 23,62000); 	
		Employee emp4 = new Employee("munda", 12,10000); 	
		
		List<Employee> arr = new ArrayList();
		arr.add(emp1);
		arr.add(emp2);
		arr.add(emp3);
		arr.add(emp4);
		
//		Collections.sort(arr,(e1,e2)-> Integer.compare(e1.getAge(),e2.getAge()) );
//		System.out.println(arr);
		
		List arr1 = arr.stream().sorted((i,j)-> Integer.compare(i.getAge(), j.getAge())).collect(Collectors.toList());
		
		System.out.println(arr1);


		
	}

}
