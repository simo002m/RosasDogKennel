
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

        /*
        DogDao dao = new DogDaoImpl();

        //dao.readDepartment("d1");

        //Department d = new Department("d4","fishing","New York");
        //dao.createDog(d);

        dao.readAllDogs();


        */
        WalksDao dao = new WalksDaoImpl();

       // Walks walk1 = new Walks(3, "10:00", 80, 3,1 ,"15-07-2023");
        //dao.createWalks(walk1);

        dao.readAllWalks();


        System.out.println("slut");
    }
}