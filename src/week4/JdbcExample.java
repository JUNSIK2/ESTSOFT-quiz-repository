package week4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcExample {
    public static void main(String[] args) {
        String jdbc_driver = "com.mysql.cj.jdbc.Driver";
        String jdbc_url = "jdbc:mysql://127.0.0.1:3306/test_db?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
        String user = "root";
        String password = "0000";
        String sql = "SELECT NAME, age, address\n" +
                "FROM students\n" +
                "WHERE age BETWEEN 30 AND 40;";
        List<Student> studentList = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(jdbc_url, user, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql);) {
            Class.forName(jdbc_driver);

            while (rs.next()) {
                String name = rs.getString(1);
                int age = rs.getInt(2);
                String address = rs.getString(3);

                studentList.add(new Student(name, age, address));
            }

            for (Student student : studentList) {
                System.out.println(student);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
