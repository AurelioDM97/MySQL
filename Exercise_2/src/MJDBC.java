import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MJDBC {
        public static void main(String[] args) {
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3303/newdb", "developer", "developer");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("first_name"));
                    System.out.println(resultSet.getString("last_name"))
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
