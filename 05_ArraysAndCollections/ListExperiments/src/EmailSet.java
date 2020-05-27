import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSet {
    public static void main(String[] args) {

        HashSet<String> emailSet = new HashSet<> (); //Список для хранения почтовых адресов
        Scanner scanner = new Scanner (System.in);

        boolean stop = true; //Переменная для остановки цикла
        while (stop) {
            System.out.println ("Введите, пожалуйста, команду: ");
            String stringIn = scanner.nextLine ().trim (); //Считываем введенную строку из консоли

            //проверяем начинается ли строка на определенную команду
            if (stringIn.toLowerCase ().startsWith ("add")) { //добавление е-mail в список

                int firstSpace = stringIn.indexOf (" "); //ищем первый пробел
                String email = stringIn.substring (firstSpace).trim (); //выделяем в строке е-mail

                //Проверка строки е-mail на корректный ввод
                Pattern pattern = Pattern.compile ("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
                Matcher matcher = pattern.matcher (email);
                boolean matches = matcher.matches ();
                if (matches) {
                    emailSet.add (email);
                    System.out.println ("Новый почтовый адрес добавлен в список.");
                } else {
                    System.out.println ("Почтовый адрес введен некорректно. Повторите, пожалуйста, попытку.");
                }
            }
            if (stringIn.toLowerCase ().startsWith ("list")) { //вывод списка в консоль
                if (!emailSet.isEmpty ()) {
                    for (String mail : emailSet) {
                        System.out.println (mail);
                    }
                } else {
                    System.out.println ("Список не содержит данных.");
                }
            }
            if (stringIn.toLowerCase ().startsWith ("stop")) { //остановка программы
                stop = false;
            }
        }
    }
}
