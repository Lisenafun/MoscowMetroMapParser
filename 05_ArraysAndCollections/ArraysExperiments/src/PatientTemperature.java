import java.text.DecimalFormat;

public class PatientTemperature {
    public static void main(String[] args) {

        //Задаем массив с 30 пациентами, у каждого из которых есть одно значение температуры
        double[][] patientTemps = new double[30][1];

        //Формат для вывода температуры
        DecimalFormat formattedDouble = new DecimalFormat ("#0.0");

        double allTemp = 0; //переменная для суммы всех температур в больнице
        int patientHealthyCount = 0; //переменная количества здоровых пациентов

        //Вывод всех пациентов с их температурой
        for (int i = 0; i < patientTemps.length; i++) {
            System.out.print ("Пациент " + (i + 1) + ": ");
            for (int j = 0; j < patientTemps[i].length; j++) {
                patientTemps[i][j] = 32 + (Math.random () * 8);
                allTemp = allTemp + patientTemps[i][j];
                if (patientTemps[i][j] <= 36.9 & patientTemps[i][j] >= 36.2) {
                    patientHealthyCount++;
                }
                System.out.println (formattedDouble.format (patientTemps[i][j]) + " ");
            }
        }

        //средняя температура по больнице
        double mediumTemp = allTemp / patientTemps.length;

        //Вывод средней температуры по больнице и количества здоровых пациентов
        System.out.println ("Средняя температура по больнице: " + formattedDouble.format (mediumTemp));
        System.out.println ("Количество здоровых пациентов: " + patientHealthyCount);
    }
}
