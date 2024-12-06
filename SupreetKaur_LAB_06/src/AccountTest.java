
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        // Create an Account object
        Account account = new Account(1000.00);

        // Create a list of Transaction objects
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, "deposit", 200.00));
        transactions.add(new Transaction(account, "withdraw", 150.00));
        transactions.add(new Transaction(account, "withdraw", 500.00));
        transactions.add(new Transaction(account, "deposit", 300.00));

        // Use ExecutorService to execute threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (Transaction transaction : transactions) {
            executor.execute(transaction);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // Wait for all threads to complete
        }

        System.out.println("Final balance: $" + account.getBalance());
    }
}
