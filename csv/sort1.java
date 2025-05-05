
    import java.io.*;
    import java.util.*;

    public class sort1 {
        public static void main(String[] args) {
            String filePath = "employees.csv";
            List<Employee> employees = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String line;
                if ((line = br.readLine()) != null) { // 跳过表头行
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(",");
                        int id = Integer.parseInt(data[0]);
                        String name = data[1];
                        String department = data[2];
                        int salary = Integer.parseInt(data[3]);
                        employees.add(new Employee(id, name, department, salary));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            employees.sort((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()));

            for (int i = 0; i < 5 && i < employees.size(); i++) {
                Employee employee = employees.get(i);
                System.out.printf("ID: %d, Name: %s, Department: %s, Salary: %d%n", employee.getId(), employee.getName(), employee.getDepartment(), employee.getSalary());
            }
        }

        static class Employee {
            private int id;
            private String name;
            private String department;
            private int salary;

            public Employee(int id, String name, String department, int salary) {
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

            public int getSalary() {
                return salary;
            }
        }
    }

