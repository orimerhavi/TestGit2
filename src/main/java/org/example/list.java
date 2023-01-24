package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class list {
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
    public List<person> select(){
        List<person> dani = new ArrayList<>();
        Connection connection = conn();
        try{
            String sql = "SELECT *FROM learn order by \"ID\" asc";
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                person person = new person(result.getInt("ID"),result.getString("first_name"),
                        result.getString("last_name"),result.getString("email"));
                dani.add(person);
                System.out.println();
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
        return dani;
    }
    public void update( String fname, String lname,String email,int ID) {
        Connection connection = conn();

        String sql = "UPDATE public.learn\n" +
                "\tSET  first_name=?, last_name=?, email=?\n" +
                "\tWHERE \"ID\" = ?;";

        try {

            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,fname);
            statement.setString(2,lname);
            statement.setString(3,email);
            statement.setInt(4,ID);
            doesexist( fname, lname, email, ID);
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
    public void doesexist(String fname, String lname,String email, int ID){
        List<person> itzhak = select();
        for (person ID_column:itzhak) {
            if (ID_column.getID()== ID){
                return;
            }

        }
        insert(fname,lname,email);
    }
    public void insert(String fname,String lname,String email){
        Connection connection = conn();

        String sql ="INSERT INTO public.learn( first_name, last_name, email) VALUES (?, ?, ?);";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1,fname);
            statement.setString(2,lname);
            statement.setString(3,email);

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
}