import java.util.Calendar;

public class AccountBank {

    public int number;
    public double account;
    public Calendar lastDatePut;
    public Calendar lastDateWithdraw;

    public AccountBank(double account) {
        number = 1000000 + (int) Math.round(Math.random() * 1000000);
        this.account = account;
        lastDatePut = Calendar.getInstance();
    }

    public void accountStatement() {
        System.out.println("На расчетном счету " + number + " находится: " + account + " рублей.");
    }

    public void putMoney(double countOfMoney) {
        lastDatePut = Calendar.getInstance();
        account = account + countOfMoney;
    }

    public void withdrawMoney(double countOfMoney) {
        if(account < countOfMoney) {
            System.out.println("Невозможно снять указанную сумму со счета " + number + ".");
        } else {
            lastDateWithdraw = Calendar.getInstance();
            account = account - countOfMoney;
        }
    }
}
