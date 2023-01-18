package org.example;

import javax.xml.transform.Result;
import java.sql.*;

public class java {
      public void update() {
        Connection connection = conn();

        String sql = "UPDATE public.learn\n" +
                "\tSET  first_name=?, last_name=?, email=?\n" +
                "\tWHERE \"ID\"= 2;";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,"Avraam");
            statement.setString(2,"Gidon");
            statement.setString(3,"avraam.gidon@gmail.com");

            int rows = statement.executeUpdate();
            if(rows > 0) {
                System.out.println("a new update done");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
      public void insert(){
          Connection connection = conn();

          String sql ="INSERT INTO public.learn( first_name, last_name, email) VALUES (?, ?, ?, ?);";

          try {
              PreparedStatement statement = connection.prepareStatement(sql);

              statement.setString(1,"Avraam");
              statement.setString(2,"Gidon");
              statement.setString(3,"avraam.gidon@gmail.com");

              int rows = statement.executeUpdate();
              if(rows > 0) {
                  System.out.println("a new update done");
              }

          } catch (SQLException e) {
              throw new RuntimeException(e);
          }

          try {
              connection.close();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
      }
      public void select(){
          Connection connection = conn();

        String sql = "SELECT *FROM learn";
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int ID = result.getInt("ID");
                String first_name = result.getString("first_name");
                String last_name = result.getString("last_name");
                String email = result.getString("email");
                System.out.printf("%d - %s - %s - %s\n ", ID, first_name, last_name, email);
            }
        }
        catch (SQLException e) {
            System.out.print("No Connection");
            throw new RuntimeException(e);
        }

          try {
              connection.close();
          } catch (SQLException e) {
              throw new RuntimeException(e);
          }
    }

     public Connection conn(){

              String jdbcURL = "jdbc:postgresql://localhost:5432/LearnGit";
              String userName = "postgres";
              String password = "oriori10";
              Connection connection = null;
              try{
                  connection = DriverManager.getConnection(jdbcURL, userName, password);
                  System.out.print("There is connection \n");
                  return connection;
              }
              catch(SQLException e) {
                  System.out.print("No Connection");
                  throw new RuntimeException(e);
              }
     }
}
