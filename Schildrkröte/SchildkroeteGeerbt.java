public class SchildkroeteGeerbt extends Turtle  
{
    public SchildkroeteGeerbt()
    {

    }

    public void vor(double laenge, int pause)
    {
        vor(laenge);
        ruhe(pause);
    }

    public void drehe(double laenge, int pause)
    {
        drehe(laenge);
        ruhe(pause);
    }

    public void quadrat(double laenge)
    {
        for (int i= 0; i < 4; i++)
        {
            vor(laenge);
            drehe(90);
        }
    }

    public void nEck(int eckenzahl, double seitenlaenge)
    {
        if (eckenzahl > 1)
        {
            for (int i = 0; i < eckenzahl; i++)
            {
                vor(seitenlaenge, 100);
                drehe(360/eckenzahl);
            }
        }
        else if (eckenzahl < 1)
        {
            for (int i = 0; i > eckenzahl; i--)
            {
                vor(seitenlaenge);
                drehe(360/eckenzahl);
            }
        }
    }

    public void kreis(double radius)
    {
        geheImBogen(360, radius);
    }

    public void hausVomNikolaus(double grundlaenge)
    {
        vor(grundlaenge);
        drehe(-90);
        vor(grundlaenge);
        drehe(-30);
        vor(grundlaenge);
        drehe(-120);
        vor(grundlaenge);
        drehe(-30);
        vor(grundlaenge);
        drehe(-135);
        vor (1.425/*Die Zahl ist durch probieren Entstanden*/*grundlaenge); 
        drehe(-135);
        vor(grundlaenge);
        drehe(-135);
        vor (1.425*grundlaenge);
    }

    public void strichKreis(double strichlaenge, double kreisradius)
    {
        vor(strichlaenge);
        kreis(kreisradius);
    }

    public void pentagram(double grundlaenge)
    {
        for (int i=0; i <= 4; i++)
        {
            vor(grundlaenge);
            drehe(144);
        }
    }

    public void DreieckReihe2(double grundlaenge, int anzahl)
    {
        for (int i = 0; i <= anzahl; i++)
        {
            nEck(3, grundlaenge);
            drehe(60);
            vor(0.6*grundlaenge);
            drehe(-60);
            drehe(180);
            vor(0.3*grundlaenge);
            drehe(180);
        }
    }

    public void atomkraft(double grundlaenge)
    {
        for(int i = 0; i < 3; i++)
        {
            nEck(3, grundlaenge);
            drehe(120);
        }
    }

    public void zweiDreiecke(double grundlaenge) //habe den richtigen Winkel nicht gefunden
    {
        for(int i = 0; i < 5; i++)
        {
            nEck(3, grundlaenge);
            drehe(200);
        }
    }

    public void dreieckKreis(double grundlaenge) //habe den richtigen Winkel nicht gefunden
    {
        for(int i = 0; i <12; i++)
        {
            nEck(3, grundlaenge);
            drehe(30);
        }
    }

    public void sanduhr(double grundlaenge)
    {
        for(int i = 0; i < 2; i++)
        {
            nEck(3, grundlaenge);
            drehe(180);
        }
    }

    public void quadrate(double grundlaenge)
    {
        drehe(-90);
        for (int i = 0; i < 20; i++)
        {
            quadrat(grundlaenge);
            drehe(-90);
            vor(grundlaenge);
        }
    }   

    public void klausur(double seitenlaenge, int anzahl)
    {
        for(int i = 0; i<=anzahl-2; i++)
        {
            vor(seitenlaenge);
            drehe(-90);
            vor(seitenlaenge);
            drehe(-90);

            vor(seitenlaenge/2);
            drehe(-90);
            vor(seitenlaenge/2);
            drehe(-90);
        }
        for(int i = 0; i<=2;i++)
        {
            vor(seitenlaenge);
            drehe(-90);
        }
        for(int i = 0; i<=anzahl-2;i++)
        {
            vor(seitenlaenge/2);
            drehe(90);
            vor(seitenlaenge/2);
            drehe(-90);
        }
        vor(seitenlaenge); 
    }

    public void gabelStecher(int grundlaenge, double kreisRadius)
    {
        for(int i = 0; i < 4; i++)
        {
            vor(grundlaenge);
            geheImBogen((360*3)/4, kreisRadius);
        }
    }

    public void gabelStecherFail01(int grundlaenge, double kreisRadius)
    {
        for(int i = 0; i < 2; i++)
        {
            vor(grundlaenge);
            geheImBogen((360*3)/4, kreisRadius);
            drehe(-90);
        }
    }
    public void nEckBeveled(int grundlaenge, double bevelSize, int eckenzahl)
    {
        for (int i = 0; i < eckenzahl; i++)
        {
            vor(grundlaenge);
            geheImBogen(360/eckenzahl, bevelSize);
        }
    }
}
