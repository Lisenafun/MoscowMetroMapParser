import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Задаем вместимость контейнеров и грузовиков
        double containerInTruck = 3;
        double boxInContainer = 6;

        //Получение количества ящиков из консоли.
        Scanner scanner = new Scanner (System.in);
        System.out.println ("Введите количество ящиков: ");
        int box = scanner.nextInt ();

        //определяем необходимое количество контейнеров и грузовиков
        int containerCount;
        int truckCount;
        if(box <= boxInContainer){
            containerCount = 1;
        }else {
            containerCount = (box % boxInContainer == 0) ? (int) (box / boxInContainer) : (int) (box / boxInContainer + 1);
        }
        if(containerCount <= containerInTruck){
            truckCount = 1;
        }else {
            truckCount = (containerCount % containerInTruck == 0) ? (int) (containerCount / containerInTruck) : (int) (containerCount / containerInTruck + 1);
        }

        //Вывод общего количества ящиков, контейнеров и грузовиков.
//        System.out.println ("Количество грузовиков: " + truckCount);
//        System.out.println ("Количество контейнеров: " + containerCount);
//        System.out.println ("Количество ящиков: " + box);

        //Вывод результата в соответствии с распределением ящиков по контейнерам и грузовикам.
        int boxDigit = 1;
        int contDigit = 1;
        for (int i = 1; i <= truckCount; i++) {
            System.out.println ("Грузовик " + i + ": ");
            for (int j = 1; j <= containerInTruck; j++) {
                if (contDigit<=containerCount){
                    System.out.println ("\tКонтейнер " + contDigit + ": ");
                    contDigit++;
                    for (int k = 1; k <= boxInContainer; k++) {
                        if (boxDigit > box) {
                            break;
                        } else {
                            System.out.println ("\t\tЯщик " + boxDigit);
                            boxDigit++;
                        }
                    }
                }
            }
        }
    }
}
