import bankSystem.Account;
import bankSystem.Bank;
import bankSystem.Client;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        List<Client> clients = new ArrayList<>();
        int countProcessors = Runtime.getRuntime().availableProcessors();
        for(int i = 0; i < countProcessors; i++) {
            Client client = new Client(bank, 10000000);
            clients.add(client);
        }
        System.out.println("Количество средств в Банке: " + bank.getFund());

        List<Thread> threads = new ArrayList<>(countProcessors);
        for(Client client : clients) {
            Thread thread = new Thread(client);
            threads.add(thread);
            thread.start();
        }

        //Метод join нам здесь нужен, чтобы дождаться завершения работы потоков и остальной код начал выполняться только после этого.
        for(Thread thread : threads) {
            try {
                thread.join();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все потоки завершены.");
        HashMap<String, Account> accounts = bank.getAccounts();
        for(Map.Entry<String, Account> entry : accounts.entrySet()) {
            String accNumber = entry.getValue().getAccNumber();
            System.out.println("Остаток на счете: " + accNumber + " - " + bank.getBalance(accNumber));
        }
        System.out.println("Количество средств в Банке после всех переводов: " + bank.getFund());
    }
}
