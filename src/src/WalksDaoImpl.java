import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WalksDaoImpl implements WalksDao {

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

    public void createWalks(Walks walks) throws Exception {

        String sql = "INSERT INTO tblWalks VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, walks.getFldWalksID());
        pstmt.setString(2, walks.getFldStartWalkTime());
        pstmt.setInt(3, walks.getFldTimeWalked());
        pstmt.setInt(4, walks.getFldKMwalked());
        int affectedRows = pstmt.executeUpdate();
        if (affectedRows > 0) {
            System.out.println("Walks added successfully.");
        } else {
            System.out.println("Failed to add the Walks.");
        }
    }

    @Override
    public void readWalks(int WalksID) throws Exception{
        String sql = "SELECT * FROM tblWalks WHERE fldWalksID  = ?";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, WalksID);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            Walks walks = new Walks();
            walks.setFldWalksID(rs.getInt(1));
            walks.setFldStartWalkTime(rs.getString(2));
            walks.setFldTimeWalked(rs.getInt(3));
            System.out.println(walks.getFldWalksID() + " "+ walks.getFldStartWalkTime()+ " "+ walks.getFldTimeWalked());
        } else {
            System.out.println("No Walks found with ID: " + WalksID);
        }
    }

    @Override
    public void readAllWalks() throws Exception{
        String sql = "SELECT * FROM tblWalks";
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        boolean hasWalks = false;
        while (rs.next()) {
            hasWalks = true;
            Walks walks = new Walks();
            walks.setFldWalksID(rs.getInt(1));
            walks.setFldStartWalkTime(rs.getString(2));
            walks.setFldTimeWalked(rs.getInt(3));
            System.out.println(walks.getFldWalksID()+" "+ walks.getFldStartWalkTime()+walks.getFldTimeWalked()+" "+ walks.getFldTimeWalked()+" "+ walks.getFldKMwalked()+" "+ walks.getFldDogID() +" "+ walks.getFldDateOfWalk());
        }
        if (!hasWalks) {
            System.out.println("No walks found.");
        }
    }
}