package bankClients;

abstract class Client {

    private double account;

    protected Client(double account) {
        this.account = account;
    }

    public double getAccount() {
        return account;
    }

    public void putMoney(double money) {
        account = account + money;
    }

    public void takeMoney(double money) {
        account = account - money;
    }
}
