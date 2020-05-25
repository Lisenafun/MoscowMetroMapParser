public class RainbowArray {
    public static void main(String[] args) {

        String rainbowString = "Каждый охотник желает знать, где сидит фазан";

        //Заполняем массив словами из строки
        String[] rainbowWords = rainbowString.split (",?\\s+");

        //Распечатываем массив в правильном порядке
        for (int i = 0; i < rainbowWords.length; i++) {
            System.out.println (rainbowWords[i]);
        }
        System.out.println ();

        //2 варианта распечатать массив в обратном порядке:
        for (int i = 1; i <= rainbowWords.length; i++) {
            System.out.println (rainbowWords[rainbowWords.length-i]);
        }
        System.out.println ();

        for (int i = rainbowWords.length-1; i >= 0 ; i--) {
            System.out.println (rainbowWords[i]);
        }
    }
}
