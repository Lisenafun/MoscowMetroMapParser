import java.util.Scanner;

public class NameReader {
    public static void main(String[] args) {

        //Ввод данных в консоль
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите, пожалуйста, ваши ФИО: ");
        String allName = scanner.nextLine ().trim ();

        //Переменные для пробела
        int spaceCount = 0;
        int spaceFirst = allName.indexOf (' ');
        int spaceLast = allName.lastIndexOf (' ');

        //Определяем количество пробелов и отсекаем лишнее
        for (int i = 0; i < allName.length (); i++) {
            if (Character.isSpaceChar (allName.charAt (i))) {
                spaceCount++;
                if (spaceCount == 1) {
                    spaceFirst = i;
                } else if (spaceCount == 2) {
                    spaceLast = i;
                } else if (spaceCount == 3) {
                    spaceLast = i;
                    allName = allName.substring (0, spaceLast).trim ();
                    spaceLast = allName.lastIndexOf (' ');
                    break;
                }
            }
        }

        //Переменные фамилии, имени и отчества
        String familyName;
        String name;
        String fatherName;

        //Разбиваем полученную строку на три строки с ФИО
        if (spaceFirst == spaceLast & spaceFirst != -1) {
            familyName = allName.substring (0, spaceFirst).trim ();
            name = allName.substring (spaceFirst).trim ();
            fatherName = "Не указано";
        } else if (spaceFirst == -1 & spaceLast == -1) {
            familyName = allName;
            name = "Не указано";
            fatherName = "Не указано";
        } else {
            familyName = allName.substring (0, spaceFirst).trim ();
            name = allName.substring (spaceFirst, spaceLast).trim ();
            fatherName = allName.substring (spaceLast).trim ();
        }

        //Вывод в консоль
        System.out.println ("Фамилия: " + familyName);
        System.out.println ("Имя: " + name);
        System.out.println ("Отчество: " + fatherName);
    }
}


