import bankSystem.Account;
import bankSystem.Bank;
import junit.framework.TestCase;

import java.util.Map;

public class BankTest extends TestCase {

    private Bank bank;

    @Override
    public void setUp() {
        bank = new Bank();

        for(int i = 0; i < 1000; i++) {
            Account account = new Account(String.valueOf(i), bank);
            account.putMoney(10000000);
        }
    }

    public void testTransferLessThanFiftyThousand() {
        for(int i = 0; i < 1000; i++) {
            for(int j = 999; j >= 0; j--) {
                int finalI = i;
                int finalJ = j;
                new Thread(() -> bank.transfer(String.valueOf(finalI), String.valueOf(finalJ), 5000));
            }
        }
        for(Map.Entry<String, Account> entry : bank.getAccounts().entrySet()) {
            long actualMoney = bank.getBalance(entry.getValue().getAccNumber());
            long expectedMoney = 10000000;
            assertEquals(expectedMoney, actualMoney);
        }
    }
}
