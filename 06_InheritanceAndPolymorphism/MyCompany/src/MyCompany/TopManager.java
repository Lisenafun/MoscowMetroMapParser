package MyCompany;

public class TopManager extends AbstractEmployee {

    public TopManager(Company company, int salary) {
        super(company, salary);
    }

    @Override
    public int getMonthSalary() {
        if(company.getIncome() > 10000000) {
            return (int) Math.round(salary + (salary * 1.5));
        }
        return salary;
    }
}
