package com.mycompany.app;

import com.mycompany.app.dao.DepartmentDao;
import com.mycompany.app.dao.EmployeeDao;
import com.mycompany.app.factory.DaoType;
import com.mycompany.app.factory.DepartmentDaoFactory;
import com.mycompany.app.factory.EmployeeDaoFactory;
import com.mycompany.app.model.Department;
import com.mycompany.app.model.Employee;
import com.mycompany.app.utils.ConnectionManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class MyEntry {


    public static void main(String[] args) {
        new Application().run();
    }
}
