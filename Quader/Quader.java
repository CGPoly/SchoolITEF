
/**
 * @author J. Erdmann 
 * @version 1.0 (2018-02)
 */

public class Quader{

    private double breite;
    private double hoehe;
    private double tiefe;

    public Quader(double breit, double hoch, double tief){
        
        breite = breit;
        hoehe = hoch;
        tiefe = tief;
    }

    public double berechneVolumen(){        
        return breite*hoehe*tiefe; //durch Passendes zu ersetzen
    }
    
    public double berechneOberflaeche(){
        return 2*breite*hoehe + 2*tiefe*hoehe + 2*tiefe*breite;
    }
    
    public double berechneKantenlaenge(){
        return 4*tiefe + 4*hoehe + 4*breite;
    }

    public void setzeBreite(double vorgabeBreite){
        if(vorgabeBreite <= 0){
            System.out.println("Kantenlängen müssen positiv sein.");
        }else{
            breite = vorgabeBreite;
        }
    }

    public void setzeHoehe(int vorgabeHoehe){
        if(vorgabeHoehe <= 0){
            System.out.println("Kantenlängen müssen positiv sein.");
        }else{
            hoehe = vorgabeHoehe;
        }
    }

    public void setzeTiefe(int vorgabeTiefe){
        if(vorgabeTiefe <= 0){
            System.out.println("Kantenlängen müssen positiv sein.");
        }else{
            tiefe = vorgabeTiefe;
        }
    }

    public double gibBreite(){
        return breite;
    }

    public double gibHoehe(){
        return hoehe;
    }

    public double gibTiefe(){
        return tiefe;
    }

}
