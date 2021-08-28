package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class TitlesDAO {
    private Connection connection;
    public TitlesDAO(Connection connection) throws SQLException {
        this.connection=connection;
        PreparedStatement statement = null;
        try {
            statement=connection.prepareStatement("use employees");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        try {
            statement.execute();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void add(Titles t) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into titles values (?,?,?,?)");
        statement.setInt(1,t.getEmp_no());
        statement.setString(2,t.getTitle());
        statement.setDate(3, (Date) t.getFrom_date());
        statement.setDate(4, (Date) t.getTo_date());
        statement.execute();
        statement.close();
    }

    public void delete(int emp_no) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from titles where emp_no="+emp_no);
        statement.execute();
        statement.close();
    }


}
