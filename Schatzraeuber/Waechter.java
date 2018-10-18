import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Abenteurer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Waechter  extends Person
{
    /**
     * Act - do whatever the Abenteurer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        bewegen();
        einsammeln();
    }    
    
    private void bewegen()
    {
        if (Greenfoot.isKeyDown("w")){
            move('o');
        }
        if (Greenfoot.isKeyDown("a")){
            move('l');
        }
        if (Greenfoot.isKeyDown("s")){
            move('u');
        }
        if (Greenfoot.isKeyDown("d")){
            move('r');
        }
    }
    
    private void einsammeln()
    {
        Actor a = getOneIntersectingObject(Abenteurer.class);
        if (a != null){
            World w = getWorld();
            w.removeObject(a);
        }
    }
}
