public class CardAccount extends AccountBank {

    public CardAccount(double account) {
        super(account);
    }

    @Override
    public void withdrawMoney(double countOfMoney) {
        super.withdrawMoney(countOfMoney);
        double percent = countOfMoney / 100;
        account = account - percent;
    }
}
