import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

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


    public static void main(String[] args) throws Exception {
        System.out.println("Velkommen til Rosas Hundepension");


        // Variables
        int userChoiceFirstMenu;
        Scanner input = new Scanner(System.in);

        // Ask the User what they want to do
        do {
            System.out.println("1: Tilgå Hund");
            System.out.println("2: Tilgå Ejer");
            System.out.println("3: tilgå Gåtur");
            System.out.println("0: Afslut");

            while (!input.hasNextInt()) {
                System.out.println("Ugyldigt input. Indtast det tal som henviser til den funktion du gerne vil bruge");
                input.next(); //Blocks invalid input and waits for new input
            }


            userChoiceFirstMenu = input.nextInt();


            switch (userChoiceFirstMenu) {
                case 1:
                    DogInterface.dogInterface();
                    break;


                case 2:
                    break;

                case 3:
                    break;

                case 0:
                    System.out.println("Lukker programmet.");
                    break;

                default:
                    break;

            }

        } while (userChoiceFirstMenu != 0);

    }


}



