package com.company;

public class Departments {
    private int dept_no;
    private String dept_name;


    public Departments(int dept_no, String dept_name) {
        this.dept_no = dept_no;
        this.dept_name = dept_name;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public void printInfo(){
        System.out.println(dept_no+" "+dept_name);
    }
}
