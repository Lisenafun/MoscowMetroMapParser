package bankClients;

public class Individuals extends Client {

    public Individuals(double account) {
        super(account);
    }

    @Override
    public void putMoney(double money) {
        account = account + money;
    }

    @Override
    public void takeMoney(double money) {
        account = account - money;
    }
}
