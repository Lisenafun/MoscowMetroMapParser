import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class BirthdaySubmit {
    public static void main(String[] args) {

        //Формат вывода даты
        DateFormat dateFormat = new SimpleDateFormat ("dd.MM.yyyy");

        //Формат вывода дня недели по-английски(US)
        DateFormat dayOfWeekFormatUS = new SimpleDateFormat ("E", Locale.US);

        Calendar birthday = new GregorianCalendar (1988, Calendar.APRIL, 4);//Задаем дату рождения
        Calendar today = Calendar.getInstance ();//Определяем дату сегодняшнюю
        int countYear = today.get (Calendar.YEAR) - birthday.get (Calendar.YEAR);//Вычисляем количество лет

        //Переводим в формат даты
        Date dateBirthday = birthday.getTime ();

        //Вывод дней рождений за определенное количество лет
        for (int i = 0; i <= countYear; i++) {
            System.out.println (i + " - " + dateFormat.format (dateBirthday) + " - " + dayOfWeekFormatUS.format (dateBirthday));
            birthday.add (Calendar.YEAR, +1);
            dateBirthday = birthday.getTime ();
        }
    }
}
