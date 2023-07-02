package Exercise_2;

import java.sql.*;


public class MJDBC {
    public static void main(String[] args) {

        String tableCreation = "CREATE TABLE students (" +
                "student_id INT NOT NULL AUTO_INCREMENT,"+
                "first_name varchar(30)," +
                "last_name varchar(30)," +
                "CONSTRAINT student_pk PRIMARY KEY (student_id))";

        String fillStudentTable = "INSERT INTO students (first_name, last_name)" +
                "VALUES ('Paolo', 'Albergadori'),"+
                "('Pio', 'Fratta'),"+
                "('Giovanni', 'Malocchio'),"+
                "('Tullio', 'Colirio')";



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
