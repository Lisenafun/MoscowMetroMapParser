public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println (text);

        //Убираем все символы, кроме цифр, разделяем пробелом.
        text = text.replaceAll ("[^0-9]", " ").replaceAll ("( )+", " ").trim ();

        //Загружаем числа в массив
        String[] salary = text.split (" ");
        int allSalary = 0;

        //Суммируем числа
        for (int i = 0; i < salary.length; i++) {
            allSalary = allSalary + Integer.parseInt (salary[i]);
        }

        //Вывод общего заработка
        System.out.println ("Заработок всех людей, указанных в предложении: " + allSalary + " руб.");
    }
}