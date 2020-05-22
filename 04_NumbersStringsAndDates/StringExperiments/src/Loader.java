public class Loader {
    public static void main(String[] args) {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println (text);

        //Вычисление суммы заработков всех людей в предложении.
        String salary = "";
        int allSalary = 0;
        for (int i = 0; i < text.length (); i++) {
            char c = text.charAt (i);
            if (Character.isDigit (c)) {
                if (Character.isSpaceChar (text.charAt (i + 1))) {
                    salary = salary.concat (Character.toString (c));
                    allSalary = allSalary + Integer.parseInt (salary);
                    salary = "";
                } else {
                    salary = salary.concat (Character.toString (c));
                }
            }
        }
        System.out.println ("Зарплата Васи, Пети и Маши: " + allSalary);

        //Определяем строки, где указаны зарплаты Васи и Маши.
        int vasyaIndex = text.indexOf ("Вася");
        int mashaIndex = text.indexOf ("Маша");
        int rubleIndex = text.indexOf ("рубл");
        int rubleLastIndex = text.lastIndexOf ("рубл");

        //Отделяем найденные строки
        String salaryVasya = text.substring (vasyaIndex, rubleIndex).trim ();
        String salaryMasha = text.substring (mashaIndex, rubleLastIndex).trim ();

        //оставляем в строках только цифры
        int spaceVasya = salaryVasya.lastIndexOf (" ");
        int spaceMasha = salaryMasha.lastIndexOf (" ");
        salaryVasya = salaryVasya.substring (spaceVasya).trim ();
        salaryMasha = salaryMasha.substring (spaceMasha).trim ();

        //Вычисляем сумму заработков
        int salaryVasyaMasha = Integer.parseInt (salaryVasya) + Integer.parseInt (salaryMasha);

        System.out.println ("Зарплата Васи: " + salaryVasya);
        System.out.println ("Зарплата Маши: " + salaryMasha);
        System.out.println ("Общий заработок Васи и Маши: " + salaryVasyaMasha);
    }
}