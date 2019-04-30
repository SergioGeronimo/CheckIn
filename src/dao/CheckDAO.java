package dao;
//CheckDAO by Sergio Geronimo on 29/04/2019

import java.sql.*;
import models.Check;

public interface CheckDAO {

    static Check insertCheck (Check check) throws NullPointerException, SQLException {
        Connection conx = JConnector.connectDB();
        String query = "insert into check_in(CHECK_DATE, CHECK_TIME, WORKER_ID, ATTENDANCE) values("
                + " ?, ?, ?, ? )";


        PreparedStatement stmt = conx.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);


        stmt.setDate(1, check.getDate());
        stmt.setTime(2, check.getTime());
        stmt.setString(3, check.getWorkerID());
        stmt.setBoolean(4, check.isAttendance());

        stmt.executeUpdate();

        ResultSet result = stmt.getGeneratedKeys();
        result.first();
        check.setId(result.getInt(1));
        return check;
    }

    static int numUnattendances(String id) throws NullPointerException, SQLException{
        Connection conx = JConnector.connectDB();
        String query ="SELECT * FROM check_in where WORKER_ID = ? AND ATTENDANCE = 0";

        PreparedStatement stmt = conx.prepareStatement(query);
        stmt.setString(1, id);

        ResultSet result = stmt.executeQuery();
        result.last();
        return result.getRow();
    }

    static int numAllChecks(String id) throws NullPointerException, SQLException{
        Connection conx = JConnector.connectDB();
        String query ="SELECT * FROM check_in where WORKER_ID = ?";

        PreparedStatement stmt = conx.prepareStatement(query);
        stmt.setString(1, id);

        ResultSet result = stmt.executeQuery();
        result.last();
        return result.getRow();
    }
}
