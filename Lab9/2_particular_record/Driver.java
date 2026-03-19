import java.sql.*;
import java.util.Scanner;
public class Driver {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

        String username = "akash";
        String password = "4k45h";

        Connection con = null;
        PreparedStatement st = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection(url, username, password);

            st = con.prepareStatement("SELECT * FROM STUDENT WHERE ROLLNO=?");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the roll no: ");
            st.setInt(1, sc.nextInt());
            ResultSet rs = st.executeQuery();

            ResultSetMetaData rsmt = rs.getMetaData();

            System.out.println(rsmt.getColumnLabel(1) + "\t" + rsmt.getColumnLabel(2) + "\t" + rsmt.getColumnLabel(3));

            System.out.println("--------------------------------------------------------");

            while(rs.next())
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));

            rs.close();
        } catch (ClassNotFoundException e) {
            System.out.println("CLASS NOT FOUND ERROR");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("SQL EXCEPTION OCCURRED");
            System.out.println(e);
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {}
        }
    }
}