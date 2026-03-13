import java.sql.*;
import java.util.*;

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

            // insert
            st = con.prepareStatement("insert into student values(?,?,?)");
            Scanner sc = new Scanner(System.in);
            System.out.println("INSERT-----");
            System.out.println("Enter the roll no: ");
            st.setInt(1, sc.nextInt()); sc.nextLine();
            System.out.println("Enter the name: ");
            st.setString(2, sc.nextLine());
            System.out.println("Enter the CGPA: ");
            st.setDouble(3, sc.nextDouble());
            st.executeUpdate();

            Statement show = con.createStatement();
            ResultSet rs = show.executeQuery("SELECT * FROM STUDENT");
            ResultSetMetaData rsmt = rs.getMetaData();

            System.out.println(rsmt.getColumnLabel(1) + "\t" + rsmt.getColumnLabel(2) + "\t" + rsmt.getColumnLabel(3));

            System.out.println("--------------------------------------------------------");

            while(rs.next())
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));

            // update
            st = con.prepareStatement("update student set cgpa=? where rollno=?");
            System.out.println("Enter roll no.:");
            st.setInt(2, sc.nextInt());
            System.out.println("Enter new cgpa: ");
            st.setDouble(1, sc.nextDouble());
            st.executeUpdate();

            rs = show.executeQuery("SELECT * FROM STUDENT");
            rsmt = rs.getMetaData();

            System.out.println(rsmt.getColumnLabel(1) + "\t" + rsmt.getColumnLabel(2) + "\t" + rsmt.getColumnLabel(3));

            System.out.println("--------------------------------------------------------");

            while(rs.next())
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));

            // delete
            st = con.prepareStatement("delete from student where rollno=?");
            System.out.println("Enter roll no to delete: ");
            st.setInt(1, sc.nextInt());

            rs = show.executeQuery("SELECT * FROM STUDENT");
            rsmt = rs.getMetaData();

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


/*(
MAKE ROLL NO PRIMARY KEY AND COMPLETE THE PROGRAM
) */