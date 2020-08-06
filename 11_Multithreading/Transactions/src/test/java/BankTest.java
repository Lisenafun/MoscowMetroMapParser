import bankSystem.Account;
import bankSystem.Bank;
import bankSystem.Client;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankTest extends TestCase {

    private Bank bank;
    private List<Client> clients;

    @Override
    public void setUp() {
        bank = new Bank();
        clients = new ArrayList<>();
        int countProcessors = Runtime.getRuntime().availableProcessors();
        for(int i = 0; i < countProcessors; i++) {
            Client client = new Client(bank, 10000000);
            clients.add(client);
        }
    }

    public void testTransfer() {
        List<Thread> threads = new ArrayList<>();
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
        HashMap<String, Account> accounts = bank.getAccounts();
        for(Map.Entry<String, Account> entry : accounts.entrySet()) {
            Account account = entry.getValue();
            boolean actual = account.isBlock();
            assertTrue(actual);
        }
    }
}
