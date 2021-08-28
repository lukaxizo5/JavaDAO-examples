package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dept_empDAO {
   private Connection connection;
   public Dept_empDAO(Connection connection) throws SQLException{
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
    public void add(Dept_emp d) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into dept_emp values (?,?,?,?)");
        statement.setInt(1,d.getEmp_no());
        statement.setInt(2,d.getSalary());
        statement.setDate(3, (Date) d.getFrom_date());
        statement.setDate(4, (Date) d.getTo_date());
        statement.execute();
        statement.close();
    }

    public void delete(int emp_no) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("delete from dept_emp where emp_no="+emp_no);
        statement.execute();
        statement.close();
    }
}
