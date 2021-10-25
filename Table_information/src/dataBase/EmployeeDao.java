package dataBase;

import model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private Connection connection = null;

    public EmployeeDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maktab58", "root",
                "SAMAseven@7");
    }

    public Connection getConnection() {
        return connection;
    }

    public List<Employee> select() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        if (connection != null) {

            String sqlQuery = String.format("select * from  information where date >= ?");
            PreparedStatement findId = getConnection().prepareStatement(sqlQuery);
            findId.setInt(1, 1395);
            ResultSet resultSet = findId.executeQuery();
            while (resultSet.next()) {
                  Employee employee=setEmployee(resultSet);
                employeeList.add(employee);
            }

        }
        return employeeList;
    }

    public Employee setEmployee(ResultSet resultSet) throws SQLException {

        Employee employee = new Employee();
        employee.setName(resultSet.getString(2));
        employee.setFamily(resultSet.getString(3));
        employee.setPersonalCode(resultSet.getInt(4));
        employee.setSalary(resultSet.getInt(5));
        employee.setDate(resultSet.getInt(6));
        return employee;
    }
}
