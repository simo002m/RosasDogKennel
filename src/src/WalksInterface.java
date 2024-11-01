import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class WalksInterface {
    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=dbRosasDogKennel";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "1234"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    public static void walksInterfaceMain() throws Exception {
        System.out.println("Velkommen til Rosas Hundepension");

        // Variables
        int userChoice;
        Scanner input = new Scanner(System.in);

        // Ask the User what they want to do
        do {
            System.out.println("For at tilføje gåtur tryk 1");
            System.out.println("For at få information omkring en gåtur tryk 2");
            System.out.println("For at se alle information om alle gåture tryk 3");
            System.out.println("For at lukke programmet tryk 0");

            while (!input.hasNextInt()) {
                System.out.println("Ugyldigt input. Indtast det tal som henviser til den funktion du gerne vil bruge");
                input.next(); // Blocks invalid input and waits for new input
            }

            userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    Walks.userInterfaceCreateWalk();
                    break;
                case 2:
                    Walks.userInterfaceReadWalk();
                    break;
                case 3:
                    Walks.userInterfaceReadAllWalks();
                    break;
                case 0:
                    System.out.println("Gå tilbage til hovedmenuen");
                    break;
                default:
                    System.out.println("Ugyldigt input.");
                    break;
            }
        } while (userChoice != 0);

    }


}