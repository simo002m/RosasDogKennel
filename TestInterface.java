/*import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class TestInterface {

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

    public static void main(String[] args) {
        Connection conn1 = getConnection();
        System.out.println("Velkommen til Rosas Hundepension");

        //Variables
        int userChoice;


        Scanner input = new Scanner(System.in);

        //asks the User what he/she wants to do
        do{
            System.out.println("For at tilføje en hund tryk 1");
            System.out.println("For at få information omkring en hund tryk 2");
            System.out.println("For at se alle information om alle Hunde tryk 3");

            System.out.println("For at lukke prograammet tryk 0");

            while(!input.hasNextInt()){
                System.out.println("Ugyldigt input. Indtast det tal som henviser til den funktion du gerne vil gøre");
                input.next();//blocks the invalid input and waits for new input
            }

            userChoice = input.nextInt();

            switch(userChoice){
                case 1:
                    userInterfaceCreateDog();
                    break;

                case 2:
                    System.out.println("Indtast Hundens Id");
                    Scanner input = new Scanner(System.in);
                    int id = input.nextInt();
                    DogDao dao = new DogDaoImpl();
                    dao.readDog(id);
                    break;
                case 3:
                    userInterfaceReadAllDogs();
                    break;
                case 0:
                    System.out.println("Lukker programmet");
                    break;
                default:
                    System.out.println("Ugyldigt input.");
                    break;

            }
        }
        while(userChoice!=0);

    }

    //public static void userInterfaceReadDog(){

        System.out.println("Indtast Hundens Id");
        Scanner input = new Scanner(System.in);
        int id = input.nextInt();
        DogDao dao = new DogDaoImpl();
        dao.readDog(id);

    }
    public static void userInterfaceCreateDog(){

    }
    public static void userInterfaceReadAllDogs(){

    }

}*/
