package bankSystem;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private final AtomicLong money;
    private final String accNumber;
    private final Bank bank;
    private boolean isBlocked;

    public Account(String accNumber, Bank bank) {
        this.accNumber = accNumber;
        this.money = new AtomicLong();
        this.bank = bank;
        this.bank.getAccounts().put(accNumber, this);
        isBlocked = false;
    }

    protected Long getMoney() {
        if(isBlocked) {
            System.out.println("Счет " + accNumber + " заблокирован.");
        }
        return money.longValue();
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void putMoney(long money) {
        if(isBlocked) {
            System.out.println("Счет " + accNumber + " заблокирован.");
        }
        this.money.addAndGet(money);
        bank.getAccounts().replace(this.accNumber, this);
        System.out.println("Остаток на счете " + accNumber + ": " + getMoney());
    }

    public void takeMoney(long money) {
        if(isBlocked) {
            System.out.println("Счет " + accNumber + " заблокирован.");
        }
        this.money.addAndGet(-(money));
        this.bank.getAccounts().replace(this.accNumber, this);
        System.out.println("Остаток на счете " + accNumber + ": " + getMoney());
    }

    protected void isBlocked() {
        isBlocked = true;
    }
}
