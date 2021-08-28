package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentsDAO {
    private Connection connection;
    public DepartmentsDAO(Connection connection) throws SQLException{
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

    public void add(Departments d) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into departments values (?,?)");
        statement.setInt(1,d.getDept_no());
        statement.setString(2,d.getDept_name());
        statement.execute();
        statement.close();
    }

    public void delete(int dept_no) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from departments where dept_no="+dept_no);
        statement.execute();
        statement.close();
    }
}
