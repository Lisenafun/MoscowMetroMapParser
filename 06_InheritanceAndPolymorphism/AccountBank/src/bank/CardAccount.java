package bank;

public class CardAccount extends AccountBank {

    public CardAccount(double account) {
        super(account);
    }

    @Override
    public void withdrawMoney(double countOfMoney) {
        super.withdrawMoney(countOfMoney + (countOfMoney * 0.01));
    }
}
