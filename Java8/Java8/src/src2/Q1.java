package src2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Employee{
	int id;
	String name;
	String department;
	int salary;
	public Employee(int id,String name,String department,int salary) {
		this.id = id;
		this.department = department;
		this.name = name;
		this.salary = salary;
	}
	
	public String getDepartemnt() {
		return department;
	}
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
	
	public int getSalary() {
		return salary;
	}
	
	@Override
	public String toString() {
		return "Id " + id + " Name " + name + " Department " + department + " Salary " + salary;
	}
	
}


class EmployeeManager{
	
	List <Employee> arr = new ArrayList<>();
	Map<String,List<Employee>> grouped = new HashMap<>(); 
	
	
	public void add(Employee emp) {
		arr.add(emp);
	}
	
	public void filter() {
		
		List<Employee> res = arr.stream().filter(i -> i.getDepartemnt().equalsIgnoreCase("engineering") && i.getSalary() >= 80000).collect(Collectors.toList());
		res.forEach(System.out :: println);
		
	}
	
	public void sortDescend() {
		List<Employee> res = arr.stream().sorted(Comparator.comparing(Employee :: getSalary).reversed()).collect(Collectors.toList());
//		System.out.println(res);
		
		res.forEach(System.out :: println);
		
	}
	
	public void groupByDepartment() {
		grouped =  arr.stream()
				.collect(Collectors.groupingBy(Employee :: getDepartemnt));
	
		grouped.forEach((dept,emp)->{
			System.out.println(dept);
			emp.forEach(System.out:: println);
		});
	
	}
	
	public void aggregate() {
		Map<String,Double> aggregate = grouped.entrySet().stream()
				.collect(Collectors.toMap(
						   Map.Entry :: getKey, 
					       entry -> entry.getValue().stream()
					       .mapToDouble(Employee :: getSalary).average().orElse(0)
		));
	    aggregate.forEach((dept, avgSalary) ->
        System.out.println(dept + " Average  " + avgSalary)
    );
		

	}
	
	
}




public class Q1 {

	public static void main(String[] args) {
		
		EmployeeManager emp = new EmployeeManager();
		emp.add(new Employee(101, "Micheal", "Engineering", 81000));
		emp.add(new Employee(102, "Berry", "Engineering", 90000));
		emp.add(new Employee(103, "Classic", "B.arch", 90000));
		emp.add(new Employee(104, "Geforce", "Engineering", 40000));
		emp.add(new Employee(105, "Core", "Engineering", 100000));
		emp.add(new Employee(106, "Predator", "B.arch", 100000));
		emp.add(new Employee(107, "Mufasa", "Doctor", 100000));
		emp.add(new Employee(108, "Balli", "Doctor", 50000));
		emp.add(new Employee(109, "Nvidia", "Doctor", 80000));




		
		System.out.println("------>Filtering<----------\n");
		emp.filter();
		
		System.out.println("\n------>Sorting<----------\n");
		emp.sortDescend();
		System.out.println("\n------>Grouping By Department<----------\n");
		emp.groupByDepartment();
		System.out.println("\n------>AGGREGATE<----------\n");
		emp.aggregate();
	}

}
