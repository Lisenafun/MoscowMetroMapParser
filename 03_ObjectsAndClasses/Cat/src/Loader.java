
public class Loader
{
    public static void main(String[] args)
    {
        //создание кошек
        Cat cat = new Cat ();
        Cat murka = new Cat ();
        Cat rosa = new Cat ();
        Cat che = new Cat ();
        Cat don = new Cat ();

        //контроль веса созданных кошек
        System.out.println ("Cat count: " + Cat.getCount ());//метод подсчета кошек
        System.out.println ("cat weight: " + cat.getWeight ());
        System.out.println ("murka weight: " + murka.getWeight ());
        System.out.println ("rosa weight: " + rosa.getWeight ());
        System.out.println ("che weight: " + che.getWeight ());
        System.out.println ("don weight: " + don.getWeight ());

        //кормление кошек и проверка веса
        cat.feed (500.);
        murka.feed (1000.);
        System.out.println ("cat weight after feed: " + cat.getWeight ());
        System.out.println ("murka weight after feed: " + murka.getWeight ());

        //закормили кошку, чтобы она взорвалась
        for (double i = 500; ; i =+ 500) {
            if (rosa.getStatus ().equals ("Exploded")){
                System.out.println ("rosa " + rosa.getStatus ());
                break;
            }else {
                System.out.println ("rosa weight: " + rosa.getWeight ());
                rosa.feed (i);
            }
        }

        //"замяукали" кошку, чтобы она умерла
        while (!(don.getStatus ().equals ("Dead"))) {
            System.out.print ("don ");
            don.meow ();
        }
        System.out.println ("don " + don.getStatus ());

        //проверка метода pee() и метода получения съеденной пищи getFeedAmount
        System.out.println ("che weight: " + che.getWeight ());
        che.feed (150.);
        System.out.print ("che "); che.pee (); che.pee (); che.pee ();
        System.out.println ("che weight: " + che.getWeight ());
        System.out.println ("che feed amount: " + che.getFeedAmount ());
        che.feed (150.);
        System.out.println ("che feed amount: " + che.getFeedAmount ());

        System.out.println ("Cat count: " + Cat.getCount ());//проверка изменения количества кошек

        //создание кошки с новым конструктором
        Cat fred = new Cat (2500);
        System.out.println ("fred " + fred.getStatus ());
        System.out.println ("Cat count: " + Cat.getCount ());

        //создание котенка методом getKitten()
        Cat kitty = getKitten ();

        //проверка на то, что умершая(взорвавшаяся) кошка не совершает действий
        System.out.println ("kitty weight: " + kitty.getWeight ());
        kitty.pee ();
        kitty.pee ();
        System.out.println ("Cat count: " + Cat.getCount ());

        //создание копии кошки
        Cat frank = Cat.doCopy (fred);
        System.out.println ("frank " + frank.getStatus () + " " + frank.getWeight ());
        System.out.println ("fred " + fred.getStatus () + " " + fred.getWeight ());
        System.out.println ("Cat count: " + Cat.getCount ());
    }

    public static Cat getKitten(){
        return new Cat (1100);
    }
}