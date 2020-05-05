package app.SqlIntro;

import java.sql.*;

public class SqlMain {
  private final static String URL = "jdbc:postgresql://localhost:5432/iba-db-1";
  private final static String USER = "postgres";
  private final static String PASS = "xiaominote9";


  public static void main(String[] args) throws SQLException {
    Connection conn = DriverManager.getConnection(URL, USER, PASS);
    String sql = "select * from users order by id asc";
    PreparedStatement stmt = conn.prepareStatement(sql);
    ResultSet rset = stmt.executeQuery();

    while (rset.next()) {
      int id = rset.getInt("id");
      String name = rset.getString("username");
      String pass = rset.getString("password");

      System.out.printf("%d %15s %15s \n", id, name, pass);

    }
  }
}
