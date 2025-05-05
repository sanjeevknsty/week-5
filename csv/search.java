import java.io.*;

public class search {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String searchName = "abhi"; // 要搜索的员工姓名
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            if ((line = br.readLine()) != null) { // 跳过表头行
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String name = data[1];
                    if (name.equals(searchName)) {
                        String department = data[2];
                        int salary = Integer.parseInt(data[3]);
                        System.out.printf("Name: %s, Department: %s, Salary: %d%n", name, department, salary);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
