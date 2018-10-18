public class AstonMartin extends car
{
    public AstonMartin(double SetMaxspeed, String setName, boolean qualityIsGood, double Price, String color){
        super(SetMaxspeed, setName, qualityIsGood, Price, color);
        checkQuality(price, quality);
        /*System.out.print("You've buyed a new car: Aston Martin " + name + "!");
        
        if (price > 10000 & quality == false) {
            System.out.println(" Very bad deal!");
        }
        else  if (price > 100000 | quality == false) {
            System.out.println(" Bad deal!");
        }
        else {
            System.out.println(" Good deal!");
        }
        */
    }
}
