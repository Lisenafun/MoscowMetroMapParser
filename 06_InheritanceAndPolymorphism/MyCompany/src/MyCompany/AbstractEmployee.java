package MyCompany;

public abstract class AbstractEmployee implements Employee, Comparable<Employee> {

    protected Company company;
    protected int salary;

    protected AbstractEmployee(Company company, int salary) {
        this.company = company;
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getMonthSalary(), o.getMonthSalary());
    }
}
