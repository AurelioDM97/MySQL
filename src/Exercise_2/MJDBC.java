package Exercise_2;

import java.sql.*;


public class MJDBC {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "aureliodimarco97!");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {

            while (resultSet.next()) {
                System.out.print(resultSet.getString("first_name") + " " +
                        resultSet.getString("last_name") + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
