package db;

import Constants.CommonConstants;

import java.sql.*;

public class MyJDBC {
    public static boolean register(String username, String password){
        // check if the username already exists, if not register the new user.
        if(!checkUser(username)){
            try{
                // use the Connection class that comes from the Jar file to connect to the db
                Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                        CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
                // user Prepared statement to create our sql query
                PreparedStatement UserInsert = connection.prepareStatement(
                        "INSERT INTO " +CommonConstants.DB_USERS_TABEL_NAME+" (username, password) VALUES(?,?)"
                );
                UserInsert.setString(1,username);
                UserInsert.setString(2,password);
                UserInsert.executeUpdate();
                return true;
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    // a method to check if the username is already in the database.
    public static boolean checkUser(String username){
        try{
            // use the Connection class that comes from the Jar file to connect to the db
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            // user Prepared statement to create our sql query
            PreparedStatement checkUserExists = connection.prepareStatement(
                    "SELECT * from " +CommonConstants.DB_USERS_TABEL_NAME+" WHERE Username= ?"
            );
            // add the username instead of the variable
            checkUserExists.setString(1,username);
            ResultSet resultSet = checkUserExists.executeQuery();
            if(!resultSet.isBeforeFirst()){
                // no data
                return false;
            }

        }


        catch (SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    // validate login
    public static boolean validate(String username, String password){
        try{
            // use the Connection class that comes from the Jar file to connect to the db
            Connection connection = DriverManager.getConnection(CommonConstants.DB_URL,
                    CommonConstants.DB_USERNAME, CommonConstants.DB_PASSWORD);
            // user Prepared statement to create our sql query
            PreparedStatement Validate = connection.prepareStatement(
                    "SELECT * FROM " +CommonConstants.DB_USERS_TABEL_NAME+" WHERE username= ? AND password= ?"
            );
            Validate.setString(1,username);
            Validate.setString(2,password);
            ResultSet resultSet = Validate.executeQuery();
            if (resultSet.isBeforeFirst()){
                return true; // doesn't exists
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
