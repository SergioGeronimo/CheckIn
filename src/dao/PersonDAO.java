package dao;
//PersonDAO by Sergio Geronimo on 29/04/2019

import models.Person;

import java.sql.*;

public interface PersonDAO {

    static Person selectPerson(String id) throws SQLException, NullPointerException {
        String query = "select * from person where PERSON_ID = ?";
        Connection conx = JConnector.connectDB();

        PreparedStatement statement = conx.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            return new Person(resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getInt(4));
        }
        else {
            return null;
        }
    }

}
