public class Main
{
    public static void main(String[] args)
    {
        Container container = new Container();
        container.count += 7843;

        System.out.println (sumDigits (5678420));

    }

    public static Integer sumDigits(Integer number)
    {
        String string = number.toString ();
        int x = 0;
        for (int i = 0; i < string.length (); i++) {
            //x = x + Integer.parseInt (String.valueOf (string.charAt (i)));
            x = x + Character.getNumericValue (string.charAt (i));
        }
        return x;
    }
}
