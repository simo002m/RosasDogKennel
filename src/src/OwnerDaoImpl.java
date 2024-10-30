import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OwnerDaoImpl implements OwnerDao {

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

    public void createOwner(Owner owner) throws Exception {
        String sql = "INSERT INTO tblOwner VALUES (?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, owner.getFldOwnerId());
        pstmt.setString(2, owner.getFldOwnerName());
        pstmt.setDate(3, owner.getFldDateOfBirth());

        int affectedRows = pstmt.executeUpdate();

        if (affectedRows > 0) {
            System.out.println("Owner added successfully");
        } else {
            System.out.println("Failed to add the Owner");
        }
    }

    @Override
    public void readOwner(int ownerID) throws Exception{
        String sql = "SELECT * FROM tblOwner WHERE fldOwnerID  = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, ownerID);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Owner owner = new Owner();
            owner.setFldOwnerID(rs.getInt(1));
            owner.setFldOwnerName(rs.getString(2));
            owner.setFldDateOfBirth(rs.getDate(3));
            System.out.println(owner.getFldOwnerId() + " " + owner.getFldOwnerName() + " " + owner.getFldDateOfBirth());
        } else {
            System.out.println("No owner found with ID: " + ownerID);
        }
    }

    @Override
    public void readAllOwners() throws Exception{
        String sql = "SELECT * FROM tblOwner";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasOwners = false;
        while (rs.next()) {
            hasOwners = true;
            Owner owner = new Owner();
            owner.setFldOwnerID(rs.getInt(1));
            owner.setFldOwnerName(rs.getString(2));
            owner.setFldDateOfBirth(rs.getDate(3));
            System.out.println(owner.getFldOwnerId()+" "+ owner.getFldOwnerName() + "" + owner.getFldDateOfBirth());
        }
        if (!hasOwners) {
            System.out.println("No owners found.");
        }
    }
}