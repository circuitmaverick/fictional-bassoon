import java.sql.*;

public class Driver {
    public static void main(String[] args) {

        String url = "jdbc:oracle:thin:@//localhost:1521/FREEPDB1";

        String username = "akash";
        String password = "4k45h";

        String query = "SELECT * " + "FROM STUDENT";

        Connection con = null;
        Statement st = null;

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            con = DriverManager.getConnection(url, username, password);

            st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            ResultSetMetaData rsmt = rs.getMetaData();

            System.out.println(rsmt.getColumnLabel(1) + "\t" + rsmt.getColumnLabel(2) + "\t" + rsmt.getColumnLabel(3));

            System.out.println("--------------------------------------------------------");

            while(rs.next())
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3));

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