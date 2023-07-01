package Exercise_4View;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) {
        ArrayList<Student> italianStudent = new ArrayList<>();
        ArrayList<Student> germanyStudent = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root", "aureliodimarco97!");
             Statement statement = connection.createStatement()) {

            statement.executeUpdate("create view italian_students as select first_name, last_name from students where country = 'italy'");
            statement.executeUpdate("create view german_students as select first_name, last_name from students where country = 'german'");

            ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name FROM italian_students");
            while(resultSet.next()) {
                String name = resultSet.getString("first_name");
                String surname = resultSet.getString("last_name");
                italianStudent.add(new Student(name, surname));
            }

            ResultSet _resultSet = statement.executeQuery("SELECT first_name, last_name FROM german_students");
            while(_resultSet.next()) {
                String name = _resultSet.getString("first_name");
                String surname = _resultSet.getString("last_name");
                germanyStudent.add(new Student(name, surname));
            }

            for(Student student : italianStudent) {
                System.out.println(student.getName());
                System.out.println(student.getSurname());
            }

            for(Student student : germanyStudent) {
                System.out.println(student.getSurname());
                System.out.println(student.getSurname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}