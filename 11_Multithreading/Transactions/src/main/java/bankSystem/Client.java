package bankSystem;

public class Client implements Runnable {

    private final Account account;
    private final Bank bank;
    private final String accountNumber;

    public Client(Bank bank, long amount) {
        this.bank = bank;
        this.account = bank.createAccount(amount);
        this.accountNumber = account.getAccNumber();
    }

    @Override
    public void run() {
        while(!account.isBlock()) {
            transfer(getAmountOfMoney());
            checkBalance();
        }
    }

    public void transfer(long money) {
        if(account.getMoney() > money && !account.isBlock()) {
            String number = bank.getRandomNumber(accountNumber);
            if(number == null) {
                account.setBlock(true);
            } else {
                bank.transfer(accountNumber, number, money);
            }
        } else if(account.getMoney() < 0) {
            account.setBlock(true);
        }
    }

    private long getAmountOfMoney() {
        return (long) ((Math.random() * (52650)) + 0);
    }

    public void checkBalance() {
        bank.getBalance(account.getAccNumber());
    }
}
