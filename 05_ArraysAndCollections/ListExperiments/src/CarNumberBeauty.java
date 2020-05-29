import java.util.*;

public class CarNumberBeauty {
    public static void main(String[] args) {

        ArrayList<String> carNumbers = new ArrayList<> ();

        //массив с буквами для номера
        String[] alphabetics = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};

        //массив с счастливыми цифрами
        int[] digits = new int[9];
        int digitLike = 111;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = digitLike;
            digitLike += 111;
        }

        //массив с номерами регионов
        String[] digitsRegion = new String[199];
        for (int i = 1; i <= digitsRegion.length; i++) {
            if (i <= 9) {
                digitsRegion[i - 1] = "0" + i;
            } else {
                digitsRegion[i - 1] = Integer.toString (i);
            }
        }

        //Заполняем список номерами машин
        for (String alpha : alphabetics) {
            for (int digit : digits) {
                for (String beta : alphabetics) {
                    for (String gamma : alphabetics) {
                        for (String digitReg : digitsRegion) {
                            String carNumber = alpha + digit + beta + gamma + digitReg;
                            carNumbers.add (carNumber);
                        }
                    }
                }
            }
        }

        //Вводим в консоль желаемый номер машины
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите, пожалуйста, номер машины: ");
        String carNumberIn = scanner.nextLine ().toUpperCase ().trim ();

        //Выводы результатов поиска номера разными способами
        System.out.print ("Поиск перебором: ");
        long startTimeSearch = System.nanoTime ();
        if (carNumbers.contains (carNumberIn)) {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер найден, поиск занял " + duration + "нс");
        } else {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер не найден, поиск занял " + duration + "нс");
        }

        System.out.print ("Бинарный поиск: ");
        startTimeSearch = System.nanoTime ();
        if (Collections.binarySearch (carNumbers, carNumberIn) >= 0) {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер найден, поиск занял " + duration + "нс");
        } else {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер не найден, поиск занял " + duration + "нс");
        }

        HashSet<String> carNumbersSet = new HashSet<> (carNumbers);

        System.out.print ("Поиск в HashSet: ");
        startTimeSearch = System.nanoTime ();
        if (carNumbersSet.contains (carNumberIn)) {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер найден, поиск занял " + duration + "нс");
        } else {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер не найден, поиск занял " + duration + "нс");
        }

        TreeSet<String> carNumbersTree = new TreeSet<> (carNumbers);

        System.out.print ("Поиск в TreeSet: ");
        startTimeSearch = System.nanoTime ();
        if (carNumbersTree.contains (carNumberIn)) {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер найден, поиск занял " + duration + "нс");
        } else {
            long finishTimeSearch = System.nanoTime ();
            long duration = finishTimeSearch - startTimeSearch;
            System.out.println ("номер не найден, поиск занял " + duration + "нс");
        }
    }
}
