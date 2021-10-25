
import dataBase.EmployeeDao;
import model.Employee;
import service.EmployeeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        EmployeeService employeeService = new EmployeeService();
        System.out.println(printFrame(6));
        printLabel();
        System.out.println();
        System.out.println(printFrame(6));
        int length;
        List<Employee> employeeList;
        boolean check = false;
        int count = 1;
        for (int i = 1399; i > 1394; i--) {
            employeeList = employeeService.findByYear(employeeService.findInformation(), i);
            Collections.sort(employeeList);
            length = employeeList.size();
            String[] rangeSalary = employeeService.registerRangeSalary(employeeList);
            String range = null;
            int j = 0;
            for (Employee employees : employeeList) {
                while (j < length - 1) {
                    if (rangeSalary[j].equalsIgnoreCase(rangeSalary[j + 1]) && !check && j < length - 1) {
                        print(employees);
                        System.out.print(printSpace(""));
                        System.out.print(printSpace(""));
                        System.out.print(printSpace(""));
                        System.out.println();
                        System.out.println(printFrame(3));
                        check = true;
                    } else
                        selectPrint(employeeList, employees, length, i, count, check, rangeSalary[j]);
                    j++;
                }

                selectPrint(employeeList, employees, length, i, count, check, rangeSalary[j]);

                check = false;
            }
            count++;
        }
    }

    public static void print(Employee employee) {
        System.out.print("| " + employee.getName() + printSpace(employee.getName()));
        System.out.print(" " + employee.getFamily() + printSpace(employee.getFamily()));
        System.out.print(" " + employee.getPersonalCode() + printSpace("ps"));
    }

    public static String printSpace(String word) {
        int count = 11 - word.length();
        if (word.equalsIgnoreCase(""))
            count = 12;
        String space = "";
        for (int i = 0; i < count; i++)
            space += " ";
        return space + "|";
    }

    public static String printFrame(int count) {
        String frame = "";
        for (int i = 0; i < count; i++) {
            if (i == 2)
                frame += "--------------+";
            else if (i == 0)
                frame += "-------------+";
            else
                frame += "------------+";
        }
        return frame;
    }

    public static void printLabel() {
        String label = "|";
        System.out.print(label + "    Name    ");
        System.out.print(label + "   Family   ");
        System.out.print(label + " PersonalCode ");
        System.out.print(label + "   Salary   ");
        System.out.print(label + "    Year    ");
        System.out.print(label + "   Number   " + label);

    }

    public static void printSalary(String range) {
        System.out.print(" " + range + printSpace(range));
    }

    public static void printYear(int year) {
        System.out.print(" " + year + printSpace(String.valueOf(year)));
    }

    public static void printNumber(int number) {
        System.out.print(" " + number + printSpace(String.valueOf(number)));
    }

    public static Boolean printAllColumn(List<Employee> employeeList, Employee employees, int length,
                                         int year, int count, boolean check) throws SQLException, ClassNotFoundException {
        EmployeeService employeeService = new EmployeeService();
        if (employees == employeeList.get(length - 1) && !check) {
            print(employees);
            printSalary(employeeService.rangeSalary(employees));
            printYear(year);
            printNumber(count++);
            System.out.println();
            System.out.println(printFrame(6));
        }
        return check = true;
    }

    public static Boolean printNeedColumn(Employee employees, String rangeSalary, boolean check) throws SQLException, ClassNotFoundException {
        if (!check) {
            print(employees);
            printSalary(rangeSalary);
            System.out.print(printSpace(""));
            System.out.print(printSpace(""));
            System.out.println();
            System.out.println(printFrame(4));
        }
        return check = true;
    }

    public static void selectPrint(List<Employee> employeeList, Employee employees, int length,
                                   int year, int count, boolean check, String range) throws SQLException, ClassNotFoundException {
        if (check = printAllColumn(employeeList, employees, length, year, count, false)) {
        } else if (check = printNeedColumn(employees, range, false))
            check = false;
    }
}
