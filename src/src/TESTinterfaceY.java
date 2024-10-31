import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class TESTinterfaceY {
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

    public static void TESTinterfaceY(String[] args) throws Exception {
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
                    userInterfaceCreatewalk();
                    
                    break;

                case 2:
                    System.out.println("Indtast gåturens Id");
                    int id = input.nextInt();
                    WalksDao dao = new WalksDaoImpl();
                    dao.readWalks(id);
                    break;

                case 3:
                    userInterfaceReadAllWalks();
                    int no = input.nextInt();
                    WalksDao dao2 = new WalksDaoImpl();
                    dao2.readWalks();
                    break;


                case 0:
                    System.out.println("Lukker programmet");

                    break;

                default:
                    System.out.println("Ugyldigt input.");
                    break;
            }
        } while (userChoice != 0);

        input.close(); // Close the scanner to avoid resource leak
    }

    private static void userInterfaceCreatewalk() {
    }

    // Method to add a new walk
    public static void userInterfaceCreateWalk() {
        System.out.println("Tilføjer en ny gåtur...");
        // Implement logic for creating a dog here
    }

    // Method to read all walks' information
    public static void userInterfaceReadAllWalks() {
        System.out.println("Viser alle gåture...");

    }
}

