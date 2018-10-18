
public class KruemelStatistik{
    protected int anzahlKekse;
    private Wuerfelbecher meinBecher;
    
    public KruemelStatistik(int anzahlKekse){
        this.anzahlKekse = anzahlKekse;
        meinBecher = new Wuerfelbecher();
    }

    public void werfen(){
        meinBecher.werfen();
    }
    
    public void einsetzen(){
        anzahlKekse -= 2;
    }
    
    public void zeigeWurf(){
        int wurf1 = meinBecher.gibWurf1();
        int wurf2 = meinBecher.gibWurf2();
        int wurf3 = meinBecher.gibWurf3();
        int ergebniss = wurf1 + wurf2 + wurf3;
        if (wurf1 == wurf2 && wurf1 == wurf3 && wurf2 == wurf3)
        {
            anzahlKekse += 6;
        }
        else if (wurf1 == wurf2 ^ wurf1 == wurf3 ^ wurf2 == wurf3)
        {
            anzahlKekse += 4;
        }
        else if (ergebniss < 12 && ergebniss > 8)
        {
            anzahlKekse += 3;
        }
    }
}
