import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Abenteurer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Abenteurer  extends Person
{
    public boolean invincible;
    /**
     * Act - do whatever the Abenteurer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        bewegen();
        einsammeln();
        powerSammeln();
    }    

    private void bewegen()
    {
        if (Greenfoot.isKeyDown("right")){
            move('r');
        }
        if (Greenfoot.isKeyDown("left")){
            move('l');
        }
        if (Greenfoot.isKeyDown("up")){
            move('o');
        }
        if (Greenfoot.isKeyDown("down")){
            move('u');
        }
    }

    private void einsammeln()
    {
        Actor s = getOneIntersectingObject(Schatz.class);
        if (s != null){
            World w = getWorld();
            w.removeObject(s);
        }
    }

    private void powerSammeln()
    {
        Actor s = getOneIntersectingObject(PowerUp01.class);
        if (s != null){
            World w = getWorld();
            w.removeObject(s);
            invincible = true;
        }
    }
}
