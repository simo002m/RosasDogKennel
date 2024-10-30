import java.sql.*;

public class DogDaoImpl implements DogDao {

    private static final String URL = "jdbc:sqlserver://localhost;instanceName=Mads;portNumber=1433;databaseName=dbRosasDogKennel";
    private static final String USERNAME = "sa"; // replace with your username
    private static final String PASSWORD = "1234"; // replace with your password

    public static Connection getConnection() throws Exception {
        Connection conn = null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        System.out.println("Connected to the database.");
        return conn;
    }

    public void createdog(Dog dog) throws Exception {
        String sql = "INSERT INTO tblDog VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dog.getFldDogId());
        pstmt.setString(2, dog.getFldDogName());
        pstmt.setString(3, dog.getFldDogBreed());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void readDog(int DogId) throws Exception{
        String sql = "SELECT * FROM tblDog WHERE fldDogId  = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, DogId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setFldDogId(rs.getInt(1));
            dog.setFldDogName(rs.getString(2));
            dog.setFldDogBreed(rs.getString(3));
            System.out.println(dog.getFldDogId() + " "+ dog.getFldDogName()+ " "+ dog.getFldDogBreed());
        } else {
            System.out.println("No Dog found with ID: " + DogId);
        }
    }

    @Override
    public void readAllDogs() throws Exception{
        String sql = "SELECT * FROM tblDog";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogs = false;
        while (rs.next()) {
            hasDogs = true;
            Dog dog = new Dog();
            dog.setFldDogId(rs.getInt(1));
            dog.setFldDogName(rs.getString(2));
            dog.setFldDogBreed(rs.getString(3));
            System.out.println(dog.getFldDogId()+" "+ dog.getFldDogName()+dog.getFldDogBreed());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }
}