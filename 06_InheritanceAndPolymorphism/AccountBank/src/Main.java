import bankClients.IndividualEntrepreneur;
import bankClients.Individuals;
import bankClients.Legals;

public class Main {
    public static void main(String[] args) {

        Individuals individuals = new Individuals(1000);
        System.out.println("Счет физического лица: " + individuals.getAccount());
        individuals.putMoney(500);
        System.out.println("Счет физического лица после пополнения: " + individuals.getAccount());
        individuals.takeMoney(600);
        System.out.println("Счет физического лица после снятия: " + individuals.getAccount());

        Legals legals = new Legals(20000);
        System.out.println("Счет юридического лица: " + legals.getAccount());
        legals.putMoney(1000);
        System.out.println("Счет юридического лица после пополнения: " + legals.getAccount());
        legals.takeMoney(2000);
        System.out.println("Счет юридического лица после снятия: " + legals.getAccount());

        IndividualEntrepreneur indEntrepreneur = new IndividualEntrepreneur(50000);
        System.out.println("Счет индивидуального предпринимателя: " + indEntrepreneur.getAccount());
        indEntrepreneur.putMoney(10000);
        System.out.println("Счет индивидуального предпринимателя после пополнения: " + indEntrepreneur.getAccount());
        indEntrepreneur.takeMoney(5000);
        System.out.println("Счет индивидуального предпринимателя после снятия: " + indEntrepreneur.getAccount());
    }
}
