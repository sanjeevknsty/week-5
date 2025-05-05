import java.util.HashMap;
import java.util.Map;
import java.io.*;
class Employee {
    private int id;
    private String name; 
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

class EmployeeManagement {
    private Map<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(int id, String name, String department, double salary) {
        if (employeeMap.containsKey(id)) {
            throw new IllegalArgumentException("Employee with ID " + id + " already exists.");
        }
        employeeMap.put(id, new Employee(id, name, department, salary));
    }

    public void removeEmployee(int id) {
        if (!employeeMap.containsKey(id)) {
            throw new IllegalArgumentException("Employee with ID " + id + " not found.");
        }
        employeeMap.remove(id);
    }

    public void displaySalaryGreaterThan50000() {
        for (Employee employee : employeeMap.values()) {
            if (employee.getSalary() > 50000) {
                System.out.println(employee);
            }
        }
    }

    public double calculateAverageSalary() {
        if (employeeMap.isEmpty()) {
            throw new IllegalArgumentException("No employees to calculate average salary.");
        }
        double totalSalary = 0;
        for (Employee employee : employeeMap.values()) {
            totalSalary += employee.getSalary();
        }
        return totalSalary / employeeMap.size();
    }

    public void saveToFile(String filename) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Employee employee : employeeMap.values()) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getDepartment() + "," + employee.getSalary());
                writer.newLine();
            }
        }
    }

    public void loadFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String department = parts[2];
                double salary = Double.parseDouble(parts[3]);
                addEmployee(id, name, department, salary);
            }
        }
    }

    public void sortEmployeesBySalary() {
        employeeMap.values().stream()
                .sorted((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
                .forEach(System.out::println);
    }
}

public class Abhi {
    public static void main(String[] args) {
        EmployeeManagement management = new EmployeeManagement();
        try {
            management.addEmployee(1, "Alice", "HR", 60000);
            management.addEmployee(2, "Bob", "IT", 45000);
            management.addEmployee(3, "Charlie", "Finance", 70000);
            management.addEmployee(4, "David", "HR", 40000);

            management.displaySalaryGreaterThan50000();
            System.out.println("Average Salary: " + management.calculateAverageSalary());

            management.saveToFile("employees.txt");
            management.loadFromFile("employees.txt");

            management.sortEmployeesBySalary();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
