package MyCompany;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {

    private final List<AbstractEmployee> employees = new ArrayList<>();
    private final int income;
    private int count = 0;

    public Company(int income) {
        this.income = income;
    }

    public List<AbstractEmployee> getEmployees() {
        return employees;
    }

    public int getIncome() {
        return income;
    }

    public int getCount() {
        return count;
    }

    public void addCount() {
        count++;
    }

    public void hire(AbstractEmployee employee) {
        employees.add(employee);
    }

    public void fire(AbstractEmployee employee) {
        employees.remove(employee);
    }

    public void hireAll(List<AbstractEmployee> list) {
        employees.addAll(list);
    }

    public List<AbstractEmployee> getTopSalaryStaff(int count) {
        Collections.sort(employees);
        Collections.reverse(employees);
        if(count > employees.size()) {
            return employees;
        }
        return employees.subList(0, count);
    }

    public List<AbstractEmployee> getLowestSalaryStaff(int count) {
        Collections.sort(employees);
        if(count > employees.size()) {
            return employees;
        }
        return employees.subList(0, count);
    }
}
