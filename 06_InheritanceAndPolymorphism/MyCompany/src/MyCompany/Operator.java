package MyCompany;

public class Operator extends AbstractEmployee {

    public Operator(Company company, int salary) {
        super(company, salary);
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}