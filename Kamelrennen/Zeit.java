import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zeit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zeit extends Actor
{
    int delay;
    int zeit;
    boolean ziel = false;
    Color t = new Color(0,0,0,0);
    public Zeit(int kdelay)
    {
        delay = kdelay;
        zeit = 0;
    }

    /**
     * Act - do whatever the Zeit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (!ziel)
        {
            Greenfoot.delay(delay);
            zeit++;
            setImage(new GreenfootImage(""+zeit, 30, Color.BLACK, t));
        }
    }

    public void ziel()
    {
        ziel = true;
    }
}
