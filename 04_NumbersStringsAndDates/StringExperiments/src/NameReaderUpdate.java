import java.util.Arrays;
import java.util.Scanner;

public class NameReaderUpdate {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите, пожалуйста, ваши ФИО: ");

        //Убираем из строки все, что не буквы, делим словами пробелом.
        String allName = scanner.nextLine ().replaceAll ("[^а-яА-Я]", " ").replaceAll ("( )+", " ").trim ();

        String[] columnNames = {"Фамилия: ", "Имя: ", "Отчество: "};
        String[] names = allName.split (" "); //Загружаем полученные данные в массив.

        //Вывод данных в консоль с проверкой, введенных данных на количество слов.
        String[] namesRight = {};
        if (names.length < columnNames.length) {
            namesRight = Arrays.copyOf (names, columnNames.length);
            for (int i = 0; i < columnNames.length; i++) {
                if (namesRight[i] == null || namesRight[i].equals ("")) {
                    namesRight[i] = "Не указано";
                    System.out.println (columnNames[i] + namesRight[i]);
                } else {
                    System.out.println (columnNames[i] + namesRight[i]);
                }
            }
        } else {
            for (int i = 0; i < columnNames.length; i++) {
                System.out.println (columnNames[i] + names[i]);
            }
        }
    }
}
