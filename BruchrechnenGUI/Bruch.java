public class Bruch{

    private int zaehler;
    private int nenner;

    public Bruch(int oben, int unten){
        if (unten != 0)
        {
            setzeZaehler(oben);
            setzeNenner(unten);
            erstelleNormalform();
        }
        else{
            System.out.println("Nenner = 0 ERROR");
        }
    }

    public Bruch potenz(int potenzzahl)
    {
        Bruch multiBruch = new Bruch(zaehler, nenner);
        while(0 != potenzzahl-1)
        {
            potenzzahl -= 1;
            multiBruch = multipliziereMit(multiBruch);
        }
        return multiBruch;
    }

    public Bruch addiere(Bruch summand){ 
        int hauptnenner = gibHauptnennerMit(summand.gibNenner());
        return new Bruch(erweitereAufNenner(hauptnenner) + summand.erweitereAufNenner(hauptnenner), hauptnenner);
    }

    public Bruch subtrahiere(Bruch subtrahend){
        //int hauptnenner = gibHauptnennerMit(subtrahend.gibNenner());
        return addiere(subtrahend.macheNennerPositiv(true));
    }

    public Bruch subtrahiereVon(Bruch minuend){
        //int hauptnenner = gibHauptnennerMit(minuend.gibNenner());
        return addiere(macheNennerPositiv(true));
    }

    public Bruch multipliziereMit(Bruch faktor){
        return new Bruch(zaehler * faktor.gibZaehler(),nenner * faktor.gibNenner());
    }

    public Bruch dividiereDurch(Bruch divisor){
        if (zaehler != 0 && nenner != 0){
            return divisor.multipliziereMit(bildeKehrwert());
        }
        else{
            System.out.println("Dividide by 0 error");
            return new Bruch(0,0);
        }
    }

    public Bruch dividiere(Bruch dividend){
        if (dividend.gibNenner() != 0 && dividend.gibZaehler() != 0){
            return multipliziereMit(dividend.bildeKehrwert());
        }
        else{
            System.out.println("Dividide by 0 error");
            return new Bruch(0,0);
        }
    }

    public int gibHauptnennerMit(int weitererNenner){
        int hNenner = nenner * weitererNenner;
        hNenner /= ggT(weitererNenner);
        return hNenner;
    }

    public int erweitereAufNenner(int nennervorgabe){
        if(nenner != 0)
        {
            if((nennervorgabe % nenner) == 0 ){ 
                return zaehler * (nennervorgabe / nenner);
            }else{
                System.out.println("Impossible error");
                return zaehler;
            }
        }
        else{
            System.out.println("Dividide by 0 error");
            return zaehler;
        }
    }

    public void erstelleNormalform(){
        kuerze();
        macheNennerPositiv();
    }

    public void kuerze(){ 
        int ggt = ggT(zaehler);
        zaehler /= ggt;
        nenner /= ggt;
    }

    public void macheNennerPositiv(){
        if (nenner < 0)
        {
            nenner *= -1;
            zaehler *= -1;
        }
    }

    public Bruch macheNennerPositiv(boolean trueFalse){
        nenner *= -1;
        zaehler *= -1;
        return new Bruch(zaehler, nenner);
    }

    /**
     * Diese Methode ermittelt mit Hilfe des euklidischen Algorithmus den ggT von übergebener Zahl und dem Nenner des aktuellen Bruches.
     * Wer Lust hat, kann (und soll) sich überlegen, warum dieser Algorithmus funktioniert!!!
     */

    public int ggT(int zahl){
        int vorigerRest = zahl;
        int rest = nenner;
        while(rest != 0){
            int naechsterVorigerRest = rest;
            rest = vorigerRest % rest;
            vorigerRest = naechsterVorigerRest;
        }
        return vorigerRest;
    }

    public Bruch bildeKehrwert(){
        if (zaehler != 0){
            return new Bruch(nenner,zaehler);
        }
        else{
            System.out.println("Nenner = 0 ERROR");
            return new Bruch(zaehler,nenner);
        }
    }

    public void setzeZaehler(int vorgabeOben){
        zaehler = vorgabeOben;
    }

    public void setzeNenner(int vorgabeUnten){
        nenner = vorgabeUnten;
    }

    public int gibZaehler(){
        return zaehler;
    }

    public int gibNenner(){
        return nenner;
    }

    public double gibBruchAlsDezimalzahl(){
        if (gibNenner() != 0){
            return (double) gibZaehler() / (double) gibNenner();
        }
        else{
            System.out.println("Dividied by 0 error");
            return 0;
        }
    }
    
    public Bruch copyPaste()
    {
        return new Bruch(zaehler, nenner);
    }
    
    public void crash(boolean doYouRealyWantThis)
    {
        Crasher crasher = new Crasher(doYouRealyWantThis);
        System.out.println("I need a 'true' to work");
    }
}