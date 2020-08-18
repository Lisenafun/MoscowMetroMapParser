package bankSystem;

import java.util.*;

public class Bank {
    private final HashMap<String, Account> accounts;
    private long fund;
    private final Random random = new Random();

    public Bank() {
        accounts = new HashMap<>();
    }

    public long getFund() {
        return fund;
    }

    public void putIntoFund(long amount) {
        this.fund += amount;
    }

    public void takeFromFund(long amount) {
        this.fund -= amount;
    }

    public synchronized boolean isFraud() throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        long fromMoney;
        synchronized(accounts) {
            fromMoney = accounts.get(fromAccountNum).getMoney();
        }
        if(fromMoney < amount) {
            System.out.println("Не хватает средств.");
        }

        synchronized(accounts) {
            accounts.get(fromAccountNum).takeMoney(amount);
            accounts.get(toAccountNum).putMoney(amount);
        }

        if(amount > 50000) {
            try {
                if(isFraud()) {
                    synchronized(accounts) {
                        accounts.get(fromAccountNum).isBlocked();
                        accounts.get(toAccountNum).isBlocked();
                    }
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

    public Account createAccount(long money) {
        Account account = new Account(getRandomNumber(), this);
        account.putMoney(money);
        return account;
    }

    public String getRandomNumber() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        return (int) (1 + Math.random() * 9) + letters[(int) (Math.random() * letters.length - 1)] + (int) (1000 + Math.random() * 9999) + letters[(int) (Math.random() * letters.length - 1)] + (int) (1000 + Math.random() * 9999);
    }

    public String getRandomNumber(String accNumber) {
        String numberNew = null;
        for(Map.Entry<String, Account> entry : accounts.entrySet()) {
            if(random.nextBoolean()) {
                numberNew = entry.getKey();
                if(numberNew.equals(accNumber)) {
                    numberNew = null;
                }
            }
        }
        return numberNew;
    }
}
