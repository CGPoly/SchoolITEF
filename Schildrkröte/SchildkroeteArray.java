public class SchildkroeteArray extends SchildkroeteGeerbt
{

    public SchildkroeteArray()
    {

    }

    public void quadratArray(double grundlaenge, int anzahl)
    {
        drehe(90);
        for (int i = 0; i < anzahl; i++)
        {
            quadrat(grundlaenge);
            drehe(-90);
            vor(grundlaenge*3);
            drehe(90);
            grundlaenge *= 2;
        }
    }   

    public void kreisStrichArray(double radius, double strichlaenge, int anzahl)
    {
        for (int i = 0; i < anzahl; i++)
        {
            strichKreis(strichlaenge, radius); 
            radius *= 2;
            strichlaenge *= 2;
        }
    }  

    public void hausVomNikolausArray(double groeße, int anzahl)
    {
        for (int i = 0; i < anzahl; i++)
        {
            hausVomNikolaus(groeße);
            groeße *= 2;
            drehe(-45);
        }
    }  

    public void klausur2(double seitenlaenge, int quadratAnzahl, int treppenanzahl)
    {
        for(int i = 0; i < treppenanzahl; i++)
        {
            klausur(seitenlaenge, quadratAnzahl);
            drehe(360/treppenanzahl-90);
        }
    }

    public void klausur2HighValue(double seitenlaenge, int quadratAnzahl, int treppenanzahl)
    {
        for(int i = 0; i < treppenanzahl; i++)
        {
            klausur(seitenlaenge, quadratAnzahl);
            drehe(360/treppenanzahl);
        }
    }

    public void gabelStecherArray(int grundlaenge, double kreisRadius, int arrayX, int arrayY)
    {
        for(int c = 0; c < 2; c++)
        {
            for (int i = 0; i < arrayX; i++)
            {
                vor(grundlaenge);
                geheImBogen(360, kreisRadius);
            }

            vor(grundlaenge);
            geheImBogen((360*3)/4, kreisRadius);

            for (int i = 0; i < arrayY; i++)
            {
                vor(grundlaenge);
                geheImBogen(360, kreisRadius);
            }

            vor(grundlaenge);
            geheImBogen((360*3)/4, kreisRadius);
        }
    }

    public void gabelStecherArray02(int grundlaenge, double kreisRadius, int eckenzahl)//WIP
    {
        for (int i = 0; i < eckenzahl; i++)
        {
            vor(grundlaenge);
            geheImBogen(270+(360/eckenzahl), kreisRadius);
        }

    }

    public void gabelStecherArraySimple(int grundlaenge, double kreisRadius, int anzahl)
    {
        for(int i = 0; i < anzahl; i++)
        {
            gabelStecher(grundlaenge, kreisRadius);
            drehe(360/anzahl);
        }
    }
    
    public void gabelStecherArray03(int grundlaenge, double kreisRadius, int anzahl)
    {
        for(int i = 0; i < anzahl; i++)
        {
            gabelStecher(grundlaenge, kreisRadius);
            drehe(360/anzahl);
            vor(grundlaenge);
        }
    }
}
