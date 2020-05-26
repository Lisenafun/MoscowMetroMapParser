import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    public static Scanner scanner = new Scanner (System.in);//Ввод в консоль
    public static ArrayList<String> todoList = new ArrayList<> ();//Список дел
    public static String command = "";//Записываемая строка
    public static String[] stringsNumber = {};//Массив для извлечения номера дела при его указании в строке
    public static String[] stringsCommand = {};//Массив для деления строки на команду и имя дела
    public static String commandToLowerCase = "";//Переменная для перевода команды в нижний регистр

    public static void main(String[] args) {

        boolean stop = true;//Переменная для остановки цикла while
        while (stop) {

            System.out.println ("Введите, пожалуйста, команду: ");

            //Записываем строку из консоли
            command = scanner.nextLine ().trim ();

            stringsNumber = command.replaceAll ("[^0-9]", " ").replaceAll ("( )+", " ").trim ().split (" ");
            stringsCommand = command.split ("\\s\\d+\\s");
            commandToLowerCase = command.toLowerCase ();

            //Проверяем есть ли числа в строке и выполняем команды согласно условию
            if (stringsNumber[0].isEmpty ()) {
                if (commandToLowerCase.startsWith ("add")) {
                    add (command);
                }
                if (command.equals ("list")) {
                    list ();
                }
                if (command.equals ("stop")) {
                    stop = false;
                }
            } else {

                //Переменная для номера(индекса) дела.
                int numberOfIndex = Integer.parseInt (stringsNumber[0]);

                if (commandToLowerCase.startsWith ("add")) {
                    add (numberOfIndex, stringsCommand);
                }
                if (commandToLowerCase.startsWith ("edit")) {
                    edit (numberOfIndex, stringsCommand);
                }
                if (commandToLowerCase.startsWith ("delete")) {
                    delete (numberOfIndex);
                }
            }
        }
    }

    //Метод для добавления дела без указания индекса
    public static void add(String command) {
        int firstSpace = command.indexOf (" ");
        String todoStrings = command.substring (firstSpace).trim ();
        todoList.add (todoStrings);
    }

    //Метод для добавления дела с указанием индекса
    public static void add(int index, String[] strings) {
        if (strings.length < 2) {
            System.out.println ("Задано некорректное имя дела.");
        } else {
            String todoStrings = strings[1].trim ();
            if (index < todoList.size ()) {
                todoList.add (index, todoStrings);
            } else {
                todoList.add (todoStrings);
            }
        }
    }

    //Метод для замены дела с указанием индекса
    public static void edit(int index, String[] strings) {
        String todoStrings = strings[1].trim ();
        if (index < todoList.size ()) {
            todoList.set (index, todoStrings);
        } else {
            System.out.println ("Дело под указанным номером ранее не было создано. Заменить невозможно.");
        }
    }

    //Метод для удаления дела с указанием индекса
    public static void delete(int index) {
        if (index < todoList.size ()) {
            todoList.remove (index);
        } else {
            System.out.println ("Дело под указанным номером ранее не было создано. Удалить невозможно.");
        }
    }

    //Метод для вывода списка дел
    public static void list() {
        for (int i = 0; i < todoList.size (); i++) {
            System.out.println (i + " - " + todoList.get (i));
        }
    }
}