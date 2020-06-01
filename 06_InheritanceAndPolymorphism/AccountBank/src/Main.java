import bank.AccountBank;
import bank.CardAccount;
import bank.DepositAccount;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {

        //Проверяем работу методов родительского класса
        AccountBank accountBank = new AccountBank(1000);
        accountBank.putMoney(1000);
        accountBank.accountStatement();
        accountBank.withdrawMoney(500);
        accountBank.accountStatement();
        System.out.println();

        //Проверяем можно ли снять больше средств, чем находится на счету.
        accountBank.withdrawMoney(1700);
        System.out.println();

        //Проверка работы класса с депозитным счетом
        DepositAccount depositAccount = new DepositAccount(1000);
        depositAccount.accountStatement();
        System.out.println("Дата последнего пополнения: " + depositAccount.getLastDatePut().getTime());
        depositAccount.withdrawMoney(500);
        System.out.println();

        //Создаем иллюзию того, что прошло больше месяца со дня последнего пополнения
        Calendar lastMoneyPut = new GregorianCalendar(2020, Calendar.APRIL, 4);
        depositAccount.setLastDatePut(lastMoneyPut);
        depositAccount.accountStatement();
        System.out.println("Дата последнего пополнения: " + depositAccount.getLastDatePut().getTime());
        depositAccount.withdrawMoney(500);
        depositAccount.accountStatement();
        System.out.println();

        //Проверка работы класса с карточным счетом
        CardAccount cardAccount = new CardAccount(1000);
        cardAccount.accountStatement();
        cardAccount.withdrawMoney(100);
        cardAccount.accountStatement();
    }
}
