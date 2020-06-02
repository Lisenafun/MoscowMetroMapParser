package bankClients;

public class Legals extends Client {

    public Legals(double account) {
        super(account);
    }

    @Override
    public void putMoney(double money) {
        account = account + money;
    }

    @Override
    public void takeMoney(double money) {
        double moneyPlusPercent = money + (money * 0.01);
        account = account - moneyPlusPercent;
    }
}
