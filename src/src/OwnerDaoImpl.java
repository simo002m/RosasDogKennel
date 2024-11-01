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
        return conn;
    }

    public void createOwner(Owner owner) throws Exception {
        String sql = "INSERT INTO tblOwner VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, owner.getFldOwnerId()); // Insert each column into row via corresponding ?
        pstmt.setString(2, owner.getFldOwnerName());
        pstmt.setString(3, owner.getFldDateOfBirth());
        pstmt.setString(4, owner.getFldEmail());
        pstmt.setString(5, owner.getFldPhoneNumber());
        pstmt.setString(6, owner.getFldZipCode());

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
            owner.setFldDateOfBirth(rs.getString(3));
            owner.setFldEmail(rs.getString(4));
            owner.setFldPhoneNumber(rs.getString(5));
            owner.setFldZipCode(rs.getString(6));

            //Print out all the rows
            System.out.println(owner.getFldOwnerId() + " " + owner.getFldOwnerName().trim() + " " + owner.getFldDateOfBirth().trim() + " " + owner.getFldEmail().trim() + " " + owner.getFldPhoneNumber().trim() + " " + owner.getFldZipCode().trim());
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

        // Nice formatting of table (display table, not SQl table) headers
        System.out.println("+" + "-".repeat(3) + "+" + "-".repeat(11) + "+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(11) + "+" + "-".repeat(14) + "+");
        System.out.println("ID\t|\tNavn\t|\tFødselsdato\t|\t\t\tEmail\t\t\t|\tTlf Nr\t|\tPost Nr    |");
        System.out.println("+" + "-".repeat(3) + "+" + "-".repeat(11) + "+" + "-".repeat(15) + "+" + "-".repeat(27) + "+" + "-".repeat(11) + "+" + "-".repeat(14) + "+");

        while (rs.next()) {
            hasOwners = true;
            Owner owner = new Owner();
            owner.setFldOwnerID(rs.getInt(1));
            owner.setFldOwnerName(rs.getString(2));
            owner.setFldDateOfBirth(rs.getString(3));
            owner.setFldEmail(rs.getString(4));
            owner.setFldPhoneNumber(rs.getString(5));
            owner.setFldZipCode(rs.getString(6));

            //Print out all the rows
            System.out.println(owner.getFldOwnerId() + "\t" + owner.getFldOwnerName().trim() + "  \t" + owner.getFldDateOfBirth().trim() + "  \t" + owner.getFldEmail().trim() + "     \t" + owner.getFldPhoneNumber().trim() + "  \t" + owner.getFldZipCode().trim());
        }
        if (!hasOwners) {
            System.out.println("Ingen ejere fundet");
        }
    }
}