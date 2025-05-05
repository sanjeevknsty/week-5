import java.io.FileWriter;
import java.io.IOException;

public class students {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.append("ID,Name,Department,Salary\n");
            fw.append("1,abhi,cse,8000\n");
            fw.append("2,ram,mtech,7500\n");
            fw.append("3,charan,ece,7000\n");
            fw.append("4,kumar,m tech,6500\n");
            fw.append("5,abhiram,cse,8500\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
