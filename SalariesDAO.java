package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class SalariesDAO {
    private Connection connection;
    public SalariesDAO(Connection connection) throws SQLException {
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

    public void add(Salaries s) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into salaries values (?,?,?,?)");
        statement.setInt(1,s.getEmp_no());
        statement.setInt(2,s.getSalary());
        statement.setDate(3, (Date) s.getFrom_date());
        statement.setDate(4, (Date) s.getTo_date());
        statement.execute();
        statement.close();
    }

    public void delete(int emp_no) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from salaries where emp_no="+emp_no);
        statement.execute();
        statement.close();
    }

}
