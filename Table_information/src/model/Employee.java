package model;



import lombok.Data;

import javax.print.DocFlavor;
import java.sql.Date;
import java.util.Objects;

@Data
public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private String family;
    private int salary;
    private int personalCode;
    private int date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && salary == employee.salary && personalCode == employee.personalCode && date == employee.date && Objects.equals(name, employee.name) && Objects.equals(family, employee.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, family, salary, personalCode, date);
    }


    @Override
    public String toString() {
        return
                 name + "   "+
                 family + "  "+
                 salary +"  "+
                personalCode +"  "+
              date
                ;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(salary,o.salary) ;
    }
}
