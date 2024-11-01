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
        String sql = "INSERT INTO tblDog VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, dog.getFldOwnerID());
        pstmt.setInt(2, dog.getFldDogId());
        pstmt.setString(3, dog.getFldDogName());
        pstmt.setInt(4, dog.getFldYearBorn());
        pstmt.setDouble(5, dog.getFldWeight());
        pstmt.setString(6, dog.getFldDogBreed());
        pstmt.setString(7, dog.getFldSpecialNeeds());
        pstmt.setString(8, dog.getFldDateArrived());
        pstmt.setInt(9, dog.getFldExpectedStayDays());
        pstmt.setString(10, dog.getFldVaccinated());
        pstmt.setString(11, dog.getFldFleeTreatment());
        pstmt.setString(12, dog.getFldInsured());
        pstmt.setString(13, dog.getFldPrefferedVet());
        pstmt.setString(14, dog.getFldFoodType());
        pstmt.setInt(15, dog.getFldRecAmountInGram());

        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Dog added successfully.");
        } else {
            System.out.println("Failed to add the dog.");
        }
    }

    @Override
    public void readDog(int DogId) throws Exception {
        String sql = "SELECT * FROM tblDog  WHERE fldDogId  = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, DogId);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Dog dog = new Dog();
            dog.setFldOwnerID(rs.getInt(1));
            dog.setFldDogId(rs.getInt(2));
            dog.setFldDogName(rs.getString(3));
            dog.setFldYearBorn(rs.getInt(4));
            dog.setFldWeight(rs.getDouble(5));
            dog.setFldDogBreed(rs.getString(6));
            dog.setFldSpecialNeeds(rs.getString(7));
            dog.setFldDateArrived(rs.getString(8));
            dog.setFldExpectedStayDays(rs.getInt(9));
            dog.setFldVaccinated(rs.getString(10));
            dog.setFldFleeTreatment(rs.getString(11));
            dog.setFldInsured(rs.getString(12));
            dog.setFldPrefferedVet(rs.getString(13));
            dog.setFldFoodType(rs.getString(14));
            dog.setFldRecAmountInGram(rs.getInt(15));


            System.out.println(dog.getFldOwnerID() + " " + dog.getFldDogId() + " " + dog.getFldDogName().trim() + " " + dog.getFldYearBorn() + " " + dog.getFldWeight() +
                    " " + dog.getFldDogBreed() + " " + dog.getFldSpecialNeeds() + " " + dog.getFldDateArrived() + " " + dog.getFldExpectedStayDays() +
                    " " + dog.getFldVaccinated() + " " + dog.getFldFleeTreatment() + " " + dog.getFldInsured() + " " + dog.getFldPrefferedVet() + " " + dog.getFldFoodType() +
                    " " + dog.getFldRecAmountInGram());
        } else {
            System.out.println("No Dog found with ID: " + DogId);
        }
    }

    @Override
    public void readAllDogs() throws Exception {
        String sql = "SELECT * FROM tblDog";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasDogs = false;
        while (rs.next()) {
            hasDogs = true;
            Dog dog = new Dog();
            dog.setFldOwnerID(rs.getInt(1));
            dog.setFldDogId(rs.getInt(2));
            dog.setFldDogName(rs.getString(3));
            dog.setFldYearBorn(rs.getInt(4));
            dog.setFldWeight(rs.getDouble(5));
            dog.setFldDogBreed(rs.getString(6));
            dog.setFldSpecialNeeds(rs.getString(7));
            dog.setFldDateArrived(rs.getString(8));
            dog.setFldExpectedStayDays(rs.getInt(9));
            dog.setFldVaccinated(rs.getString(10));
            dog.setFldFleeTreatment(rs.getString(11));
            dog.setFldInsured(rs.getString(12));
            dog.setFldPrefferedVet(rs.getString(13));
            dog.setFldFoodType(rs.getString(14));
            dog.setFldRecAmountInGram(rs.getInt(15));

            System.out.println(dog.getFldOwnerID() + " " + dog.getFldDogId() + " " + dog.getFldDogName() + " " + dog.getFldYearBorn() + " " + dog.getFldWeight() + " " + dog.getFldDogBreed() + " " + dog.getFldSpecialNeeds() + " " + dog.getFldDateArrived() + " " + dog.getFldExpectedStayDays() + " " + dog.getFldVaccinated() + " " + dog.getFldFleeTreatment() + " " + dog.getFldInsured() + " " + dog.getFldPrefferedVet() + " " + dog.getFldFoodType() + " " + dog.getFldRecAmountInGram());
        }
        if (!hasDogs) {
            System.out.println("No dogs found.");
        }
    }
}
