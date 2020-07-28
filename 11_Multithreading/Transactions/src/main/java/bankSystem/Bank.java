package bankSystem;

import java.util.HashMap;
import java.util.Random;

public class Bank {
    private final HashMap<String, Account> accounts;
    private final Random random = new Random();

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized boolean isFraud() throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        long fromMoney = accounts.get(fromAccountNum).getMoney();
        if(fromMoney < amount) {
            System.out.println("Не хватает средств.");
        }

        accounts.get(fromAccountNum).takeMoney(amount);
        accounts.get(toAccountNum).putMoney(amount);

        if(amount > 50000) {
            try {
                if(isFraud()) {
                    accounts.get(fromAccountNum).isBlocked();
                    accounts.get(toAccountNum).isBlocked();
                    System.out.println("Перевод средств признан мошеннической операцией, счета, участвующие в операции заблокированы.");
                } else {
                    System.out.println("Перевод со счета " + fromAccountNum + " на счет " + toAccountNum + " прошел успешно.");
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        return account.getMoney();
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }
}
