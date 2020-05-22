public class TextDiv {
    public static void main(String[] args) {

        String text = "To this day, New Zealanders like to see themselves as practical, coping with anything thrown at them, with good life skills and a cooperative “can-do” spirit. New Zealand, Levine writes, is not a large or powerful country but has an “attractive self-image” of inspiring others, leading by example, idealism and pragmatic innovation.\n" + "\n" + "That positive outlook sees New Zealand ranked as the eighth-most-happy country in the 2019 UN World Happiness Report for the seventh year in a row, the only nation outside Europe in the top 10.\n" + "\n" + "In the same survey, Wellington was ranked as the third-happiest city. Auckland and Christchurch are in the top 20, despite Christchurch’s decade of devastating earthquakes and the attack that took 51 lives last year.";

        //Убираем знаки отличные от букв, оставляем между словами 1 пробел.
        text = text.replaceAll ("[^a-zA-Z]", " ").replaceAll ("( )+", " ").trim ();

        //создаем массив из слов, выбранной строки, деля их по пробелам.
        String[] words = text.split (" ");

        //Вывод слов в консоль
        for (String string: words) {
            System.out.println (string);
        }
    }
}
