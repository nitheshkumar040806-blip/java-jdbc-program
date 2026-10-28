
import java.sql.*;
import java.io.*;

public class EmployeeCSV {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "root";
        String password = "Jaga0524#";

        String sql = "SELECT * FROM employee";

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);
             PrintWriter pw = new PrintWriter(new FileWriter("employees.csv"))) {

            pw.println("ID,Name,Department,Salary");

            while (rs.next()) {
                pw.println(rs.getInt("id") + "," +
                           rs.getString("name") + "," +
                           rs.getString("department") + "," +
                           rs.getDouble("salary"));
            }

            System.out.println("Employee records exported successfully!");

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        }
    }
}
