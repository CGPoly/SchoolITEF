
import java.util.Random;

public class Zufall{

    private Random zufallsgenerator;

    public Zufall(){
        zufallsgenerator = new Random();
    }

    public int neueZufallszahl(int von, int bis){
        return zufallsgenerator.nextInt(bis - von + 1) + von;
    }
    
}
