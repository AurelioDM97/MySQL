package Exercise_3;

import java.sql.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) {
        ArrayList<String> surnames= new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "aureliodimarco97!");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {


            while(resultSet.next()) {
                surnames.add(resultSet.getString("last_name"));
            }
            for( String surname : surnames) {
                System.out.println(surname);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
