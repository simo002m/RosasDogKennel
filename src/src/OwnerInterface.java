import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class OwnerInterface {
    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=dbRosasDogKennel";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "1234"; // replace with your password

    // Connect to database
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        return conn;
    }

    public static void ownerInterfaceMain() throws Exception {
        Connection conn = getConnection();

        Scanner choice = new Scanner(System.in);

        // declare variable for later user
        int actionChoice;

        System.out.println("Velkommen til ejer oversigten!\n\nHer er dine valgmuligheder:");

        do {
            // Menu
            System.out.println("\n1. Udskriv alle ejere\n2. Udskriv specifik ejer\n3. Lav ny ejer");

            // Check if other datatype than int has been typed into Scanner object choice
            while (!choice.hasNextInt()) {
                System.out.println("\nVenligst indtast en gyldig værdi (et tal mellem 1 - 3)");
                choice.next();
            }

            actionChoice = choice.nextInt();

            // Pick a menu item based on input of actionChoice
            switch (actionChoice) {
                case 1:
                    Owner.dao.readAllOwners();
                    break;
                case 2:
                    Owner.interfaceReadOwner();
                    break;
                case 3:
                    Owner.interfaceCreateOwner();
                    break;
                default:
                    break;
            }

        } while (actionChoice != 0); // run do while as long as actionChoice is not 0

    }
}