package util.db;

import java.sql.*;

public class DBSample {

    public static void main(String[] args) {

        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rs = null;

        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String userNm = "scott";
        String userPw = "1234";

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url, userNm, userPw);
            psmt = con.prepareStatement("SELECT id, name, message FROM guestbook WHERE name = ?");
            psmt.setString(1, "choi");
            rs = psmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("id") + ", "
                        + rs.getString("name") + ", "
                        + rs.getString("message")); // 1, choi, hello
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                psmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}