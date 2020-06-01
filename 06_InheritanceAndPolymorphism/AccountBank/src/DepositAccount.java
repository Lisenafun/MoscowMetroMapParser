import java.util.Calendar;

public class DepositAccount extends AccountBank {

    public DepositAccount(double account) {
        super(account);
    }

    //метод для проверки снятия средств спустя месяц
    public void putMoney(double countOfMoney, Calendar lastMoneyPut) {
        lastDatePut = lastMoneyPut;
        account = account + countOfMoney;
    }

    @Override
    public void withdrawMoney(double countOfMoney) {
        lastDatePut.add(Calendar.MONTH, 1);
        Calendar dateNow = Calendar.getInstance();
        if(lastDatePut.compareTo(dateNow) <= 0) {
            super.withdrawMoney(countOfMoney);
        } else {
            System.out.println("Невозможно снять средства, так как прошло меньше месяца после последнего пополнения счета " + number + ".");
        }
    }
}
