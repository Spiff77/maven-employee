package com.mycompany.app;

import com.mycompany.app.dao.DepartmentDao;
import com.mycompany.app.dao.EmployeeDao;
import com.mycompany.app.factory.DaoType;
import com.mycompany.app.factory.DepartmentDaoFactory;
import com.mycompany.app.factory.EmployeeDaoFactory;
import com.mycompany.app.model.Department;
import com.mycompany.app.model.Employee;
import com.mycompany.app.utils.ConnectionManagement;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class Application {

    public void run(){


        EmployeeDaoFactory.setType(DaoType.JDBC);
        DepartmentDaoFactory.setType(DaoType.JDBC);

        EmployeeDao edao = EmployeeDaoFactory.getDao();
        DepartmentDao ddao = DepartmentDaoFactory.getDao();

        System.out.println("---------------- EMPLOYEE ----------------");
        System.out.println("Inserting emp:");
        Employee employee1 = new Employee(12344, "Jean", "IT", 7369, new Date(), 2030,20, 30);
        edao.insert(employee1);
        Employee employee = edao.findOne(12344);
        System.out.println("Now selecting, found:" + employee);
        employee = edao.findOne(12344);
        employee.setName("SuperJean");
        edao.update(employee);
        System.out.println("now updating, new value from db: " + employee);
        System.out.println("Deleting nom");
        edao.deleteById(12344);
        System.out.println("Checking if we gor null from db: " + edao.findOne(1234));


        System.out.println("---------------- DEPARTMENT ----------------");
        System.out.println("Inserting dep:");
        ddao.insert(new Department(12345, "CLEANING", "LA"));
        Department department = ddao.findOne(12345);
        System.out.println("Now selecting, found:" + department);
        department = ddao.findOne(12345);
        department.setName("MAXINCLEANING");
        ddao.update(department);
        System.out.println("now updating, new value from db: " + department);
        System.out.println("Deleting department");
        ddao.deleteById(12345);
        System.out.println("Checking if we gor null from db: " + ddao.findOne(1234));

        if(EmployeeDaoFactory.getType() == DaoType.JDBC)
            ConnectionManagement.getInstance().closeConnection();
    }
}
/*
dans un fichier db.conf mettre les clés suivantes:
mysql.username=root
mysql.port=<votre port>
mysql.dbname=<votre nom de db>
mysql.password=
mysql.url= <votre url sgbd>
 */
