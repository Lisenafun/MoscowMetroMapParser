public class Alphabet {
    public static void main(String[] args) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String alphUp = alphabet.toUpperCase ();
        String allAlphabet = alphabet.concat (alphUp);

        for (int i = 0; i < allAlphabet.length (); i++) {
            char c = allAlphabet.charAt (i);
            int code = (int) c;
            System.out.println (c + ": " + code);
        }

    }
}
