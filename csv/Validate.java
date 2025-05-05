import java.io.*;

public class Validate {
    public static void main(String[] args) {
        String filePath = "students.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            if ((line = br.readLine()) != null) { 
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    String email = data[4];
                    String phone = data[5];

                    if (!isValidEmail(email)) {
                        System.out.println("Invalid email format: " + email + " in row: " + line);
                    }
                    if (!isValidPhone(phone)) {
                        System.out.println("Invalid phone number format: " + phone + " in row: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    private static boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }

}
