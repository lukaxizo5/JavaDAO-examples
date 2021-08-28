package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeesDAO {
    private Connection connection;
    public EmployeesDAO(Connection connection) throws SQLException {
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

    public void add(Employees e) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into employees values (?,?,?,?,?,?)");
        statement.setInt(1,e.getEmp_no());
        statement.setDate(2, (Date) e.getBirth_date());
        statement.setString(3,e.getFirst_name());
        statement.setString(4,e.getLast_name());
        statement.setString(5,e.getGender());
        statement.setDate(6, (Date) e.getHire_date());
        statement.execute();
        statement.close();
    }

    public void delete(int emp_no) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from employees where emp_no="+emp_no);
        statement.execute();
        statement.close();
    }
}
