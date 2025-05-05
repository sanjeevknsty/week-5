import java.io.*;

public class Read {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            if (br.readLine() != null) { // Skip the header row
                while (br.readLine() != null) {
                    rowCount++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Number of records: " + rowCount);
    }

}
