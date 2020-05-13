package app.Sql2;

import javax.xml.transform.Result;
import java.sql.*;

public class SqlMain {
  private final static String URL = "jdbc:postgresql://localhost:5432/iba-db-1";
  private final static String USER = "postgres";
  private final static String PASS = "xiaominote9";

  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USER, PASS);
    String SQL = "select * from users where username = ? and password = ?";
    PreparedStatement ps = conn.prepareStatement(SQL);

    String name = "User";
    String pw = "12345";

    ps.setString(1, name);
    ps.setString(2, pw);
    ResultSet rs = ps.executeQuery();

    while (rs.next()) {
      int id = rs.getInt("id");
      String un = rs.getString("username");
      String pass = rs.getString("password");

      System.out.printf("%d %5s %5s", id, un, pass);
    }
  }
}
