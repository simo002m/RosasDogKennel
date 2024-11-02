package walks;

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
        pstmt.setInt(5, walks.getFldDogId());
        pstmt.setString(6, walks.getFldDateOfWalk());
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

        System.out.println("+" + "-".repeat(11) + "+" + "-".repeat(15) + "+" + "-".repeat(23) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+");
        System.out.println("Gåtur ID\t|\tTidspunkt\t|\tLængde (minutter)\t|\tKM Gået\t|\tHund ID\t|\tDato\t|");
        System.out.println("+" + "-".repeat(11) + "+" + "-".repeat(15) + "+" + "-".repeat(23) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+");

        if (rs.next()) {
            Walks walks = new Walks();
            walks.setFldWalksID(rs.getInt(1));
            walks.setFldStartWalkTime(rs.getString(2));
            walks.setFldTimeWalked(rs.getInt(3));
            walks.setFldKMwalked(rs.getInt(4));
            walks.setFldDogID(rs.getInt(5));
            walks.setFldDateOfWalk(rs.getString(6));


            System.out.printf("%d %20s %20d %15d %10d %17s\n", walks.getFldWalksID(), walks.getFldStartWalkTime().trim(), walks.getFldTimeWalked(), walks.getFldKMwalked(), walks.getFldDogId(), walks.getFldDateOfWalk().trim());
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

        System.out.println("+" + "-".repeat(11) + "+" + "-".repeat(15) + "+" + "-".repeat(23) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+");
        System.out.println("Gåtur ID\t|\tTidspunkt\t|\tLængde (minutter)\t|\tKM Gået\t|\tHund ID\t|\tDato\t|");
        System.out.println("+" + "-".repeat(11) + "+" + "-".repeat(15) + "+" + "-".repeat(23) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+" + "-".repeat(11) + "+");

        while (rs.next()) {
            hasWalks = true;
            Walks walks = new Walks();
            walks.setFldWalksID(rs.getInt(1));
            walks.setFldStartWalkTime(rs.getString(2));
            walks.setFldTimeWalked(rs.getInt(3));
            walks.setFldKMwalked(rs.getInt(4));
            walks.setFldDogID(rs.getInt(5));
            walks.setFldDateOfWalk(rs.getString(6));

            System.out.printf("%d %20s %20d %15d %10d %17s\n", walks.getFldWalksID(), walks.getFldStartWalkTime().trim(), walks.getFldTimeWalked(), walks.getFldKMwalked(), walks.getFldDogId(), walks.getFldDateOfWalk().trim());
        }
        if (!hasWalks) {
            System.out.println("No walks found.");
        }
    }
}