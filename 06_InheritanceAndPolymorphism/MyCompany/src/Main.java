import MyCompany.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Company myCompany = new Company(50000000);

        //Проверка начисления зарплат
        Operator operator = new Operator(myCompany, 30000);
        System.out.println(operator.getMonthSalary());
        Manager manager = new Manager(myCompany, 10000);
        System.out.println(manager.getMonthSalary());
        TopManager topManager = new TopManager(myCompany, 250000);
        System.out.println(topManager.getMonthSalary());

        //Добавляем сотрудников в компанию
        ArrayList<AbstractEmployee> operators = new ArrayList<>();
        for(int i = 0; i < 180; i++) {
            operators.add(new Operator(myCompany, 30000 + (int) Math.round(Math.random() * 20000)));
            myCompany.hire(operators.get(i));
        }

        ArrayList<AbstractEmployee> managers = new ArrayList<>();
        for(int i = 0; i < 80; i++) {
            managers.add(new Manager(myCompany, 10000 + (int) Math.round(Math.random() * 15000)));
        }
        myCompany.hireAll(managers);

        ArrayList<AbstractEmployee> topManagers = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            topManagers.add(new TopManager(myCompany, 250000 + (int) Math.round(Math.random() * 100000)));
        }
        myCompany.hireAll(topManagers);

        System.out.println("Сотрудников в компании: " + myCompany.getEmployees().size());

        //Вывод списка самых высоких зарплат
        int topCount = 10;
        List<AbstractEmployee> listHigh = myCompany.getTopSalaryStaff(topCount);

        System.out.println("Список " + topCount + " самых высоких зарплат: ");
        for(int i = 0; i < topCount; i++) {
            System.out.println(i + 1 + ". " + listHigh.get(i).getMonthSalary() + " руб.");
        }

        //Вывод списка самых низких зарплат
        int lowCount = 30;
        List<AbstractEmployee> listLowest = myCompany.getLowestSalaryStaff(lowCount);

        System.out.println("Список " + lowCount + " самых низких зарплат: ");
        for(int i = 0; i < lowCount; i++) {
            System.out.println(i + 1 + ". " + listLowest.get(i).getMonthSalary() + " руб.");
        }

        //Увольняем 50% сотрудников
        int countHalfCompany = myCompany.getEmployees().size() / 2;
        for(int i = 0; i < countHalfCompany; i++) {
            myCompany.fire(myCompany.getEmployees().get(i));
        }
        System.out.println("Сотрудников в компании: " + myCompany.getEmployees().size());

        //Вывод списка самых высоких зарплат
        listHigh = myCompany.getTopSalaryStaff(topCount);

        System.out.println("Список " + topCount + " самых высоких зарплат: ");
        for(int i = 0; i < topCount; i++) {
            System.out.println(i + 1 + ". " + listHigh.get(i).getMonthSalary() + " руб.");
        }

        //Вывод списка самых низких зарплат
        listLowest = myCompany.getLowestSalaryStaff(lowCount);

        System.out.println("Список " + lowCount + " самых низких зарплат: ");
        for(int i = 0; i < lowCount; i++) {
            System.out.println(i + 1 + ". " + listLowest.get(i).getMonthSalary() + " руб.");
        }
    }
}
