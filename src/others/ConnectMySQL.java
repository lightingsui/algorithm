package others;

import java.sql.*;

/**
 * 连接数据库
 *
 * @author ：隋亮亮
 * @since ：2020/8/10 21:17
 */
public class ConnectMySQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        final String URL = "jdbc:mysql://39.106.81.183:3306/fd_item";
        final String username = "root";
        final String password = "xxxxxxxxxx";

        try {
            Connection conn = DriverManager.getConnection(URL, username, password);

            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from fd_person");

            while(resultSet.next()) {
                String string = resultSet.getString(1);
                String string1 = resultSet.getString(2);
                String string2 = resultSet.getString(3);
                String string3 = resultSet.getString(4);

                System.out.println(string + "    " + string1 + "  " + string2 + "  " + string3);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
