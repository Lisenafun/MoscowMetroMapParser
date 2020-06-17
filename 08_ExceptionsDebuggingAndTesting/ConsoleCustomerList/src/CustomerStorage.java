import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerStorage {
    private HashMap<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws CustomerStorageException{
        String[] components = data.split("\\s+");
        if(components.length == 4) {
            String name = components[0] + " " + components[1];
            Pattern emailPattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
            Pattern phonePattern = Pattern.compile("(\\+7)[0-9]{10}");
            Matcher emailMatcher = emailPattern.matcher(components[2]);
            Matcher phoneMather = phonePattern.matcher(components[3]);
            boolean emailMatches = emailMatcher.matches();
            boolean phoneMatches = phoneMather.matches();
            if(emailMatches & phoneMatches) {
                storage.put(name, new Customer(name, components[3], components[2]));
            } else {
                throw new CustomerStorageException("Wrong format email or phone. \nCorrect email format: vasily.petrov@gmail.com\nCorrect phone format: +79215637722.");
            }
        } else {
            throw new CustomerStorageException("Wrong format. Correct format: \nadd Василий Петров vasily.petrov@gmail.com +79215637722");
        }
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) throws CustomerStorageException{
        String[] components = name.split("\\s+");
        if(components.length == 2) {
            storage.remove(name);
        } else {
            throw new CustomerStorageException("Wrong format. Correct format: \n remove Василий Петров");
        }
    }

    public int getCount() {
        return storage.size();
    }
}