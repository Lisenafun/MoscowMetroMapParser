package bankClients;

public class Legals extends Client {

    public Legals(double account) {
        super(account);
    }

    @Override
    public void takeMoney(double money) {
        super.takeMoney(money + (money * 0.01));
    }
}
