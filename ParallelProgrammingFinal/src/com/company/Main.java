import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Thread {
    public static final String PERSON_URL = "person.txt";
    public static final String SECRET_URL = "secret.txt";

    // Get username information
    public String getUserInfos() {
        Scanner scanner = new Scanner(System.in);
        String userName, password, email;

        System.out.println("Enter username info: ");
        userName = scanner.nextLine();

        System.out.println("Enter password: ");
        password = scanner.nextLine();

        System.out.println("Enter email: ");
        email = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Username: ").append(userName).append("\n");
        stringBuilder.append("Password: ").append(password).append("\n");
        stringBuilder.append("Email:  ").append(email);

        return stringBuilder.toString();
    }

    // Save username information to file
    public void saveUserInfoToFile(String userInfo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PERSON_URL))) {
            writer.write(userInfo);
            System.out.println("Username information saved to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {
        Main main = new Main();
        String userInfo = main.getUserInfos();
        main.saveUserInfoToFile(userInfo);
    }
}
