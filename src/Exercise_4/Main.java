package Exercise_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] arg) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "aureliodimarco97!");
             Statement statement = connection.createStatement()) {


            statement.executeUpdate("alter table students add column country varchar(30)");
            statement.executeUpdate("update students set country = 'italy' WHERE student_id = 1");
            statement.executeUpdate("update students set country = 'italy' WHERE student_id = 2");
            statement.executeUpdate("update students set country = 'germany' WHERE student_id = 3");
            statement.executeUpdate("update students set country = 'germany' WHERE student_id = 4");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("country"));  // Use "country" column name instead of country variable
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
