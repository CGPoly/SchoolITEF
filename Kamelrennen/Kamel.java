import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kamel here.
 * 
 * @author (KBovi) 
 * @version (1.0)
 */
public class Kamel extends Actor
{
    int eStart = 3;
    int delay = 5;
    boolean atStart = true;
    int e= eStart;
    Zeit z = new Zeit(delay);
    
    /**
     * Der Sensor ueberprueft, ob sich das Kamel bewegen kann.
     */     
    private boolean kannBewegen()
    {     
        return true;
    }

    /**
     * Das Kamel bewegt sich um ein Feld vorwärts, falls möglich. 
     */
    public void bewegen()
    {

        int rand = Greenfoot.getRandomNumber(2);
        Actor g = getOneObjectAtOffset(1, 0, Gras.class);
        Actor pu = getOneObjectAtOffset(1, 0, PowerUp.class);
        if (pu != null)
        {
            int x = getX();
            int y = getY();
            setLocation(x + 3, y);
            World w = getWorld();
            w.removeObject(pu);
        }

        else if (rand == 1)
        {
            if (g != null)
            {
                if (e != 0)
                {
                    e--;
                }
                else 
                {
                    World w = getWorld();
                    w.removeObject(g);
                    e = eStart;
                }
            }
            else
            {
                int x = getX();
                int y = getY();
                setLocation(x + 1, y);
            }
        }
        Greenfoot.delay(delay);
    }

    /**
     * Das Kamel bewegt sich, falls eine 2-seitige "Münze" Wappen oben hat. 
     */
    public void ziel(){
        Actor a = getOneIntersectingObject(Ziellienie.class);
        if (a != null){
            z.ziel();
        }
    }

    public void act() 
    {
        if (atStart)
        {
            World w = getWorld();
            w.addObject(z,16,getY()-1);
            atStart = false;
        }
        bewegen ();
        ziel();
    }    
}
