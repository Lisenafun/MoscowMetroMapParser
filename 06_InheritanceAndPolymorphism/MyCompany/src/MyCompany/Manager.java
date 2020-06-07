package MyCompany;

public class Manager extends AbstractEmployee {

    public Manager(Company company, int salary) {
        super(company, salary);
        company.addCount();
    }

    @Override
    public int getMonthSalary() {
        return salary + (int) Math.round(company.getIncome() / company.getCount() * 0.05);
    }
}