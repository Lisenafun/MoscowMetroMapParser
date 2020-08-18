package bankSystem;

import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private final AtomicLong money;
    private final String accNumber;
    private final Bank bank;
    private boolean block;

    protected Account(String accNumber, Bank bank) {
        this.accNumber = accNumber;
        this.money = new AtomicLong();
        this.bank = bank;
        this.bank.getAccounts().put(accNumber, this);
        block = false;
    }

    protected Long getMoney() {
        if(block) {
            System.out.println("Счет " + accNumber + " заблокирован.");
        }
        return money.longValue();
    }

    public String getAccNumber() {
        return accNumber;
    }

    public boolean isBlock() {
        return block;
    }

    protected void setBlock(boolean block) {
        this.block = block;
    }

    protected void isBlocked() {
        block = true;
    }

    protected void putMoney(long money) {
        bank.putIntoFund(money);
        if(block) {
            System.out.println("Счет " + accNumber + " заблокирован.");
        }
        this.money.addAndGet(money);
        bank.getAccounts().replace(this.accNumber, this);
        System.out.println("Остаток на счете " + accNumber + ": " + getMoney());
    }

    protected void takeMoney(long money) {
        bank.takeFromFund(money);
        if(block) {
            System.out.println("Счет " + accNumber + " заблокирован.");
        }
        this.money.addAndGet(-(money));
        this.bank.getAccounts().replace(this.accNumber, this);
        System.out.println("Остаток на счете " + accNumber + ": " + getMoney());
    }
}
