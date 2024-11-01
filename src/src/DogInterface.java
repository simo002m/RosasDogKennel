import java.sql.Connection;
import java.util.Scanner;

import java.sql.DriverManager;

public class DogInterface {

    //database connection variables
    private static final String URL = "jdbc:sqlserver://localhost;portNumber=1433;databaseName=dbRosasDogKennel";
    private static final String USERNAME = "sa";
    private static final String PASSWORD = "1234";

    //Makes the connection to the databse
    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    public static void dogInterface() throws Exception {
        // Variables
        int userChoice;
        Scanner input = new Scanner(System.in);

        // Ask the user which if they want to create, read or read all information about dogs
        do {
            System.out.println("For at tilføje en hund tryk 1");
            System.out.println("For at få informationer omkring en hund tryk 2");
            System.out.println("For at se alle information om alle hunde tryk 3");
            System.out.println("For at gå til menu tryk 0");

            //validating user input - only aacepts integers
            while (!input.hasNextInt()) {
                System.out.println("Ugyldigt input. Indtast det tal som henviser til den funktion du gerne vil bruge");
                input.next(); // Blocks invalid input and waits for new input
            }

            userChoice = input.nextInt();

            //directing the user to the method they wanted to go to

            switch (userChoice) {
                case 1:
                    Dog.userInterfaceCreateDog();
                    break;

                case 2:
                    Dog.userInterfaceReadDog();
                    break;

                case 3:
                    Dog.userInterfaceReadAllDogs();
                    break;

                case 0:
                    System.out.println("Går tilbage til menu");
                    break;

                default:
                    System.out.println("Ugyldigt input.");
                    break;
            }
        } while (userChoice != 0);//if the user types 0 the user will be directed to the menu
    }
}
