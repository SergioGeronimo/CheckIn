package dao;//dao.JConnector by Sergio Geronimo on 29/04/2019

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public interface JConnector {

    static Connection connectDB() {
        try{


            Class.forName("com.mysql.cj.jdbc.Driver");


            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "R567FYaM");


            return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/datedb", info);

        }catch (ClassNotFoundException classErr){
            System.out.println(classErr.getMessage());
            classErr.printStackTrace();

            return null;
        }catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ex.printStackTrace();
            return null;

        }

    }

}
