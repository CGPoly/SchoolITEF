public class Schildkroete
{
    protected Turtle t;

    public Schildkroete(){
        t = new Turtle();
    }

    public void quadrat(double laenge){
        for (int i = 0; i < 4; i++) {
            t.vor(laenge);
            t.drehe(90);
        }
    }

    public void vor (double d){ // alternativ kann natürlich jede Turtle-Methode durch eine eigene Methode hier übertragen werden..., z. B.:
        t.vor(d);
    }

    public void nEck(int eckenzahl, double seitenlaenge)
    {
        for (int i = 0; i < eckenzahl; i++)
        {
            t.vor(seitenlaenge);
            t.drehe(360/eckenzahl);
        }
    }
    
    private void nEckGespiegelt(int eckenzahl, double seitenlaenge)
    {
        for (int i = 0; i < eckenzahl; i++)
        {
            t.vor(seitenlaenge);
            t.drehe(-(360/eckenzahl));
        }
    }

    public void kreis(double radius)
    {
        for (int i = 0; i < 360; i++)
        {
            t.vor(radius/90);
            t.drehe(-1);
        }
    }

    public void hausVomNikolaus(double grundlaenge)
    {
        t.vor(grundlaenge);
        t.drehe(-90);
        t.vor(grundlaenge);
        t.drehe(-30);
        t.vor(grundlaenge);
        t.drehe(-120);
        t.vor(grundlaenge);
        t.drehe(-30);
        t.vor(grundlaenge);
        t.drehe(-135);
        t.vor (1.425/*Die Zahl ist durch probieren Entstanden*/*grundlaenge); 
        t.drehe(-135);
        t.vor(grundlaenge);
        t.drehe(-135);
        t.vor (1.425*grundlaenge);
    }

    public void rundSiedlung(double grundlaenge)
    {
        for (int o = 0; o <=1; o++)
        {
            double zwischenSpeicher1 = grundlaenge;
            for (int i = 0; i <=2; i++)
            {
                hausVomNikolaus(zwischenSpeicher1);
                zwischenSpeicher1 = zwischenSpeicher1/2;
            }

            hausVomNikolaus(grundlaenge/2);
        }
    }

    public void sechsDreiecke(double grundlaenge)
    {
        nEck(3, grundlaenge);
        t.drehe(60);
        t.vor(grundlaenge/2);
        t.drehe(60);
        t.vor(grundlaenge/2);
        t.drehe(180);
        nEck(3, grundlaenge);
        t.vor(grundlaenge/2);
        t.drehe(60);
        t.vor(grundlaenge/2);
    }

    public void strichKreis(double strichlaenge, double kreisradius)
    {
        t.vor(strichlaenge);
        kreis(kreisradius);
    }

    public void pentagram(double grundlaenge)
    {
        for (int i=0; i <= 4; i++)
        {
            t.vor(grundlaenge);
            t.drehe(144);
        }
    }

    public void zweiDreiecke(double grundlaenge)
    {
        nEck(3, grundlaenge);
        t.drehe(60);
        t.vor(0.6*grundlaenge);
        t.drehe(-60);
        t.drehe(180);
        t.vor(0.3*grundlaenge);
        t.drehe(180);
        nEckGespiegelt(3, grundlaenge);
    }

    public void dreieckReihe(double grundlaenge, int anzahl)
    {   
        for(int i=0; i <= anzahl; i++)
        {
            nEck(3, grundlaenge);
            t.drehe(60);
            t.vor(grundlaenge/2);
            t.drehe(-60);
            t.drehe(180);
            t.vor(grundlaenge/2);
            t.drehe(180);
        }
    }
}

