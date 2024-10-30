
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


    public static void main(String args[]) throws Exception {
        System.out.println("start");

        Connection conn = getConnection();


        DogDao dao = new DogDaoImpl();

        //dao.readDepartment("d1");

        //Department d = new Department("d4","fishing","New York");
        //dao.createDog(d);
        //Dog f = new Dog(1,3,"Fido", 2020, 5, "Puddel", "Ingen", "2024-08-29", 3, "Yes", "Yes", "Yes", "Doktor Oetker", "Luksus Tørfoder", 80);

        //dao.createdog(f);
        dao.readAllDogs();



        System.out.println("slut");
    }
}