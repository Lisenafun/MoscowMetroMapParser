import bankSystem.Account;
import bankSystem.Bank;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Account account1 = new Account("1", bank);
        Account account2 = new Account("2", bank);
        Account account3 = new Account("3", bank);

        account1.putMoney(10000000);
        account2.putMoney(10000000);
        account3.putMoney(10000000);

        bank.transfer("1", "2", 5000);
        bank.transfer("2", "1", 5000);
        bank.transfer("3", "1", 55000);

        System.out.println("Остаток на счете: " + account1.getAccNumber() + ": " + bank.getBalance("1"));
        System.out.println("Остаток на счете: " + account2.getAccNumber() + ": " + bank.getBalance("2"));
        System.out.println("Остаток на счете: " + account3.getAccNumber() + ": " + bank.getBalance("3"));
    }
}
