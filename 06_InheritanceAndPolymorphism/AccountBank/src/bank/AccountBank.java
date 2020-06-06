package bank;

import java.util.Calendar;

public class AccountBank {

    private final int number;
    private double account;
    private Calendar lastDatePut;
    private Calendar lastDateWithdraw;

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

    public double getAccount() {
        return account;
    }

    public Calendar getLastDatePut() {
        return lastDatePut;
    }

    //Оставила метод для проверки класса с депозитным счетом, иначе этот метод необходимо удалить
    public void setLastDatePut(Calendar lastDatePut) {
        this.lastDatePut = lastDatePut;
    }

    public Calendar getLastDateWithdraw() {
        return lastDateWithdraw;
    }

    public int getNumber() {
        return number;
    }
}
