import java.util.Scanner;

public class PhoneReader {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите, пожалуйста, номер телефона: ");

        //Убираем из строки все символы, кроме цифр, и возможные лишние пробелы
        String phone = scanner.nextLine ().replaceAll ("[^0-9]", "").trim ();

        //Вывод телефона в унифицированном формате
        if (phone.startsWith ("8")) {
            phone = phone.replaceAll ("^8", "7");
            System.out.println ("Ваш номер телефона: " + phone);
        } else {
            System.out.println ("Ваш номер телефона: " + phone);
        }
    }
}
