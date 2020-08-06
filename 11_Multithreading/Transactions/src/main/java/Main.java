import bankSystem.Account;
import bankSystem.Bank;
import bankSystem.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        List<Client> clients = new ArrayList<>();
        int countProcessors = Runtime.getRuntime().availableProcessors();
        for(int i = 0; i < countProcessors; i++) {
            Client client = new Client(bank, 10000000);
            clients.add(client);
        }

        List<Thread> threads = new ArrayList<>(countProcessors);
        for(Client client : clients) {
            Thread thread = new Thread(client);
            threads.add(thread);
            thread.start();
        }

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
            System.out.println("Статус счета " + accNumber + " - " + entry.getValue().isBlock());

        }
    }
}
