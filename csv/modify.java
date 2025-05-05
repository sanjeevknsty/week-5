
    import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class modify {

    public static void main(String[] args) {
        String inputFilePath = "employees.csv";
        String outputFilePath = "updated_employees.csv";
        List<String> updatedLines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            if ((line = br.readLine()) != null) { // 跳过表头行
                updatedLines.add(line);
            }
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String department = data[2];
                int salary = Integer.parseInt(data[3]);
                if (department.equalsIgnoreCase("IT")) {
                    salary = (int) (salary * 1.1);
                }
                updatedLines.add(String.format("%s,%s,%s,%d", data[0], data[1], data[2], salary));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(outputFilePath)) {
            for (String updatedLine : updatedLines) {
                fw.append(updatedLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


