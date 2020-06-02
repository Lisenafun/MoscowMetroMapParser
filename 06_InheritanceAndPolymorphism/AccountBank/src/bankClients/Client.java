package bankClients;

public abstract class Client {

    protected double account;

    public Client(double account) {
        this.account = account;
    }

    public double getAccount() {
        return account;
    }

    public abstract void putMoney(double money);

    public abstract void takeMoney(double money);
}
