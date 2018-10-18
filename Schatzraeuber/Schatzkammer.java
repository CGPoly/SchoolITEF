import greenfoot.*;

/**
 * Diese Klasse modelliert eine Schatzkammer.
 * 
 * @author Dr. Oliver Heidbüchel
 * @version 2011-09-14
 */
public class Schatzkammer extends MyWorld
{
    int delay;
    /**
     * Es wird eine Schatzkammer erzeugt.
     */
    public Schatzkammer() // wird ausgeführt beim Erzeugen eines Objektes der Klasse Schatzkammer
    {    
        super(19, 19, 30); // Aufruf des Konstruktors der Oberklasse

        setzeSchaetze();
        setzeAbenteurer();
        setzeWaechter();
        setzeWaende();
    }

    private void setzeWaende()
    {
        for(int i=0;i<30;i++)
        {
            int zufallX=Greenfoot.getRandomNumber(19);
            int zufallY=Greenfoot.getRandomNumber(17)+1;
            int anzahl=count(zufallX,zufallY,Schatz.class);
            if (anzahl==0){
                Wand w = new Wand();
                addObject(w,zufallX,zufallY);
            }
        }
    }

    private void setzeSchaetze()
    {
        int anzahlMuenzen = 30;
        while(anzahlMuenzen != 0)
        //for(int i=0;i<30;i++)
        {
            int zufallX=Greenfoot.getRandomNumber(19);
            int zufallY=Greenfoot.getRandomNumber(17)+1;
            int anzahl=count(zufallX,zufallY,Wand.class);

            if (anzahl==0){anzahl=count(zufallX+1,zufallY,Schatz.class);
                if (anzahl==0){anzahl=count(zufallX-1,zufallY,Schatz.class);
                    if (anzahl==0){anzahl=count(zufallX,zufallY+1,Schatz.class);
                        if (anzahl==0){anzahl=count(zufallX,zufallY-1,Schatz.class);
                            if (anzahl==0){anzahl=count(zufallX,zufallY,Schatz.class);}}}}}

            if (anzahl==0){
                Schatz s = new Schatz();
                addObject(s,zufallX,zufallY);
            }
            anzahlMuenzen--;
        }
    }

    private void setzeAbenteurer()
    {
        int zufall = Greenfoot.getRandomNumber(19);
        Abenteurer a = new Abenteurer();
        addObject(a,zufall,18);
    }

    private void setzeWaechter()
    {
        int zufall = Greenfoot.getRandomNumber(19);
        Waechter w = new Waechter();
        addObject(w,zufall,0);
    }

    public void act()
    {
        int anzahlSchaetze = count(Schatz.class);
        int anzahlAbenteurer = count(Abenteurer.class);

        if(anzahlSchaetze <= 2){
            Schlussbild s = new Schlussbild();
            s.setImage("abenteurerGewinnt.png");
            addObject(s,9,9);
            Greenfoot.stop();          
        }

        if(anzahlAbenteurer == 0){
            Schlussbild sw = new Schlussbild();
            sw.setImage("waechterGewinnt.png");
            addObject(sw,9,9);
            Greenfoot.stop();          
        }
        //delay = Greenfoot.getRandomNumber(10000)+1000;
        /*Delay
        try {
        Thread.sleep(delay);
        } catch (InterruptedException ex) {
        // handle error
        }*/
        setzePowerUp();
    }

    private void setzePowerUp()
    {
        int zufallX=Greenfoot.getRandomNumber(19);
        int zufallY=Greenfoot.getRandomNumber(17)+1;
        int anzahl=count(zufallX,zufallY,Wand.class);

        if (anzahl==0){anzahl=count(zufallX+1,zufallY,Schatz.class);
            if (anzahl==0){anzahl=count(zufallX-1,zufallY,Schatz.class);
                if (anzahl==0){anzahl=count(zufallX,zufallY+1,Schatz.class);
                    if (anzahl==0){anzahl=count(zufallX,zufallY-1,Schatz.class);
                        if (anzahl==0){anzahl=count(zufallX,zufallY,Schatz.class);
                            if (anzahl==0){anzahl=count(zufallX,zufallY,PowerUp01.class);}}}}}}

        if (anzahl==0){
            PowerUp01 p01 = new PowerUp01();
            addObject(p01,zufallX,zufallY);
        }
    }
}
