package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Dept_managerDAO {
    private Connection connection;
    public Dept_managerDAO(Connection connection) throws SQLException{
        this.connection=connection;
        PreparedStatement statement=null;
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

    public void add(Dept_manager d) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into dept_manager values (?,?,?,?)");
        statement.setInt(1,d.getDept_no());
        statement.setInt(2,d.getEmp_no());
        statement.setDate(3, (Date) d.getFrom_date());
        statement.setDate(4, (Date) d.getTo_date());
        statement.execute();
        statement.close();
    }

    public void delete(int dept_no) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from dept_manager where dept_no="+dept_no);
        statement.execute();
        statement.close();
    }

}
