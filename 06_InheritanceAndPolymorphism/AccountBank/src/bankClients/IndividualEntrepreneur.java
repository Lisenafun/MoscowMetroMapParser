package bankClients;

public class IndividualEntrepreneur extends Client {

    public IndividualEntrepreneur(double account) {
        super(account);
    }

    @Override
    public void putMoney(double money) {
        double moneyMinusPercent;
        if(money < 1000) {
            moneyMinusPercent = money - (money * 0.01);
        } else {
            moneyMinusPercent = money - (money * 0.005);
        }
        super.putMoney(moneyMinusPercent);
    }
}
