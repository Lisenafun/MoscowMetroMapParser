import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneMap {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        TreeMap<String, String> phoneMap = new TreeMap<> ();//Мар для хранения телефонной книги

        while (true) {

            System.out.println ("Введите, пожалуйста, запрос: ");
            String stringIn = scanner.nextLine ();

            //Проверяем введено имя или телефон
            Pattern pattern = Pattern.compile ("[a-zA-Zа-яА-Я]+([\\s]?[a-zA-Zа-яА-Я]+)*");
            Matcher matcher = pattern.matcher (stringIn);
            boolean isName = matcher.matches ();

            if (stringIn.toLowerCase ().equals ("list")) { //если введена команда list, выводим всю телефонную книгу
                if (phoneMap.isEmpty ()) {
                    System.out.println ("Телефонная книга не содержит данных.");
                } else {
                    for (String key : phoneMap.keySet ()) {
                        System.out.println (key + " - " + phoneMap.get (key));
                    }
                }
            } else {

                //если введено имя:
                if (isName) {
                    String name = stringIn; //необязательная переменная дабы избежать путаницы.
                    if (phoneMap.containsKey (name)) {
                        System.out.println (name + " - " + phoneMap.get (name));
                    } else {
                        System.out.println ("Введите, пожалуйста, номер телефона: ");
                        String phone = scanner.nextLine ();
                        phoneMap.put (name, phone);
                    }

                    //если введен телефон:
                } else {
                    String phone = stringIn;
                    if (phoneMap.containsValue (phone)) {
                        for (Map.Entry<String, String> entry : phoneMap.entrySet ()) {
                            if (entry.getValue ().equals (phone)) {
                                System.out.println (entry.getKey () + " - " + entry.getValue ());
                            }
                        }
                    } else {
                        System.out.println ("Веедите, пожалуйста, имя: ");
                        String name = scanner.nextLine ();
                        phoneMap.put (name, phone);
                    }
                }
            }
        }
    }
}
