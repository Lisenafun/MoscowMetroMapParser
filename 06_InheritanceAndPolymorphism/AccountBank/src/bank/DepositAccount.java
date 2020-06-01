package bank;

import java.util.Calendar;

public class DepositAccount extends AccountBank {

    public DepositAccount(double account) {
        super(account);
    }

    @Override
    public void withdrawMoney(double countOfMoney) {
        Calendar datePlusMonth = getLastDatePut();
        datePlusMonth.add(Calendar.MONTH, 1);
        Calendar dateNow = Calendar.getInstance();
        if(datePlusMonth.compareTo(dateNow) <= 0) {
            super.withdrawMoney(countOfMoney);
        } else {
            System.out.println("Невозможно снять средства, так как прошло меньше месяца после последнего пополнения счета " + getNumber() + ".");
        }
    }
}
