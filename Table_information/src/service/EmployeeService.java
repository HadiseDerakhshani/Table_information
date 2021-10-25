package service;

import dataBase.EmployeeDao;
import model.Employee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeService() throws SQLException, ClassNotFoundException {
        employeeDao = new EmployeeDao();
    }

    public List<Employee> findInformation() throws SQLException {
        return employeeDao.select();
    }

    public List<Employee> findByYear(List<Employee> employee, int year) {
        List<Employee> employeeList = new ArrayList<>();
        for (Employee employees : employee) {
            if (employees.getDate() == year)
                employeeList.add(employees);
        }
        return employeeList;
    }

    public String rangeSalary(Employee employee) {
        if (employee.getSalary() >= 1000000 && employee.getSalary() < 5000000) {
            return "1-5 ";
        } else if (employee.getSalary() >= 5000000 && employee.getSalary() < 10000000) {
            return "5-10 ";
        } else if (employee.getSalary() >= 10000000) {
            return "more 10 ";
        }
        return null;
    }

    public String[] registerRangeSalary(List<Employee> employeeList) {
        int length = employeeList.size();
        String[] rangeSalary = new String[length];
        int i = 0;
        for (Employee employee : employeeList) {
            rangeSalary[i++] = rangeSalary(employee);
        }
        return rangeSalary;
    }
}
