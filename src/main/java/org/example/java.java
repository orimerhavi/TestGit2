package org.example;

import javax.xml.transform.Result;
import java.sql.*;

public class java {
    public void openConnection()
    {
        String jdbcURL = "jdbc:postgresql://localhost:5432/LearnGit";
        String userName = "postgres";
        String password = "oriori10";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.print("There is connection");

           /* String sql ="INSERT INTO learn (first_name, last_name, email) VALUES (?,?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,"Avraam");
            statement.setString(2,"Gidon");
            statement.setString(3,"avraam.gidon@gmail.com");
            int rows = statement.executeUpdate();
            if(rows > 0){
                System.out.println("A new contact has been inserted.");
            }*/
            /*
            String sql = "SELECT *FROM learn";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int ID = result.getInt("ID");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email = result.getString("email");
                System.out.printf("%d - %s - %s - %s\n ",ID ,first_name ,last_name ,email);
                }
            */
            String sql = "UPDATE  \"learn\" "+
                    "set \"first_name\" = 'Tigabo', \"email\" = 'tigabo.gidon@gmail.com'"+
                    "WHERE \"first_name\" = 'Avraam'";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);




            connection.close();
        } catch (SQLException e) {
            System.out.print("No Connection");
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
