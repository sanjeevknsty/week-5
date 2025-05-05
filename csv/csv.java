import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class csv {
    public static void main(String[] args) {
        String filePath = "students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                int marks = Integer.parseInt(data[3]);
                System.out.printf("ID: %d, Name: %s, Age: %d, Marks: %d%n", id, name, age, marks);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}