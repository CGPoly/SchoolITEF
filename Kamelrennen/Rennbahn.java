import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.lang.Class;

/**
 * Write a description of class Rennbahn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rennbahn  extends World
{
    public int p1 = 0;
    public int p2 = 0;
    public int p3 = 0;
    public Kamel k1 = new Kamel();
    public Kamel k2 = new Kamel();
    public Kamel k3 = new Kamel();
    public Color t = new Color(0,0,0,0);
    /**
     * Constructor for objects of class Rennbahn.
     * 
     */
    public Rennbahn()
    {    
        super(15, 6, 65); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        /*for(int i=0;i<3;i++)
        {
        int Y=1+i*2;
        Kamel k = new Kamel();
        addObject(k,0,Y);
        }*/
        addObject(k1,0,1);
        addObject(k2,0,3);
        addObject(k3,0,5);

        for(int i=0;i<3;i++)
        {
            int Y=1+i*2; 
            Ziellienie z = new Ziellienie();
            addObject(z,15,Y);
        }

        for(int i=0;i<3;i++)
        {
            int Y=1+i*2; 
            Startlienie s = new Startlienie();
            addObject(s,0,Y);
        }

        for(int i=0;i<3;i++)
        {
            int Y=1+i*2;
            int a=0;
            while (a<3)
            {
                int zufallX=Greenfoot.getRandomNumber(13)+1;
                int anzahl=count(zufallX,Y,Gras.class);
                if (anzahl==0){
                    Gras g = new Gras();
                    addObject(g,zufallX,Y);
                    a++;
                }
            }
        }

        for(int i=0;i<3;i++)
        {
            int Y=1+i*2;
            if(Greenfoot.getRandomNumber(10) == 1)
            {
                int stop = 0;
                boolean f = false;
                while (!f)
                {
                    int zufallX=Greenfoot.getRandomNumber(13)+1;
                    int anzahl=count(zufallX,Y,Gras.class);
                    if (anzahl==0){
                        anzahl = count(zufallX+1,Y,Gras.class);
                        if (anzahl!=0){
                            anzahl = count(zufallX+2,Y,Gras.class);
                            if (anzahl==0){
                                PowerUp pu = new PowerUp();
                                addObject(pu,zufallX,Y);
                                f = true;
                            }
                        }
                    }
                    if (stop == 25)
                    {
                        f = true;
                    }
                    stop++;
                }
            }
        }
    }

    public int count(Class cls){
        List list = getObjects(cls);
        int size = list.size();
        return size;
    }

    public int count(int x, int y, Class cls){
        List list = getObjectsAt(x, y, cls);
        int size = list.size();
        return size;        
    }

    public void act()
    {
        testeAufSieg();
    }

    public void testeAufSieg()
    {
        if (p1 == 0)
        {
            if (k1.z.ziel)
            {
                p1 = 1;
            }
            if (k2.z.ziel)
            {
                p1 = 2;
            }
            if (k3.z.ziel)
            {
                p1 = 3;
            }
        }
        else if (p2 == 0)
        {
            if (p1 == 1)
            {
                if (k2.z.ziel)
                {
                    p2 = 2;
                }
                if (k3.z.ziel)
                {
                    p2 = 3;
                }
            }
            else if (p1 == 2)
            {
                if (k1.z.ziel)
                {
                    p2 = 1;
                }
                if (k3.z.ziel)
                {
                    p2 = 3;
                }
            }
            else if (p1 == 3)
            {
                if (k1.z.ziel)
                {
                    p2 = 1;
                }
                if (k2.z.ziel)
                {
                    p2 = 2;
                }
            }
        }
        else if (p3 == 0)
        {
            if ((p1 == 1 && p2 == 2) || (p2 == 1 && p1 == 2))
            {
                if (k3.z.ziel)
                {
                    p3 = 3;
                }
            }
            else if ((p1 == 2 && p2 == 3) || (p2 == 2 && p1 == 3))
            {
                if (k1.z.ziel)
                {
                    p3 = 1;
                }
            }
            else if ((p1 == 1 && p2 == 3) || (p2 == 1 && p1 == 3))
            {
                if (k2.z.ziel)
                {
                    p3 = 2;
                }
            }
        }
        else
        {
            Schlussbild s1 = new Schlussbild();
            s1.setImage(new GreenfootImage("1.Platz", 30, Color.ORANGE, t));
            addObject(s1,8,1+(p1-1)*2);

            Schlussbild s2 = new Schlussbild();
            s2.setImage(new GreenfootImage("2.Platz", 30, Color.ORANGE, t));
            addObject(s2,8,1+(p2-1)*2);

            Schlussbild s3 = new Schlussbild();
            s3.setImage(new GreenfootImage("3.Platz", 30, Color.ORANGE, t));
            addObject(s3,8,1+(p3-1)*2);

            Greenfoot.stop();
        }
    }
}
