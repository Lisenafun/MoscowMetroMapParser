
public class Cat
{
    private final static int EYES_COUNT = 2;
    private final static double MIN_WEIGHT = 1000.0;
    private final static double MAX_WEIGHT = 9000.0;
    private static int count;
    private CatColor color;

    private double originWeight;
    private double weight;
    private double feedAmount;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        count++;
    }

    public Cat(Cat otherCat){
        this.weight = otherCat.weight;
        originWeight = this.weight;
        count++;
    }

    public Cat(double originWeight) {
        if(originWeight < MIN_WEIGHT || originWeight > MAX_WEIGHT){
            System.out.println ("Cat can not create, cat weight must be more than 1000 and less than 9000.\nThis cat dead.");
        }else {
            weight = originWeight;
            this.originWeight = weight;
            count++;
        }
    }

    public void meow()
    {
        if (isAlive ()) {
            weight = weight - 1;
            checkCount ();
            System.out.println ("Meow");
        }else{
            System.out.println ("Cat exploded or dead");
        }
    }

    public void feed(Double amount)
    {
        if(isAlive ()) {
            weight = weight + amount;
            feedAmount = feedAmount + amount;
            checkCount ();
        }else{
            System.out.println ("Cat exploded or dead");
        }
    }

    public void drink(Double amount)
    {
        if(isAlive ()) {
            weight = weight + amount;
            checkCount ();
        }else{
            System.out.println ("Cat exploded or dead");
        }
    }

    public void pee(){
        if(isAlive ()){
            weight = weight - 150;
            checkCount ();
            System.out.println("pee");
        }else{
            System.out.println ("Cat exploded or dead");
        }
    }

    public CatColor getColor() {
        return color;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public boolean isAlive(){
        if(weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            return false;
        }else{
            return true;
        }
    }

    public void checkCount(){
        if(weight < MIN_WEIGHT || weight > MAX_WEIGHT) {
            count--;
        }
    }

//    public static Cat doCopy(Cat copyCat){
//        Cat cat = copyCat;
//        count++;
//        return cat;
//    }

    public Double getWeight()
    {
        return weight;
    }

    public Double getFeedAmount(){
        return feedAmount;
    }

    public static int getCount() {
        return count;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}