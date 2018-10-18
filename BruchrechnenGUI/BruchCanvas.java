import java.awt.*;

public class BruchCanvas extends Canvas{

    private Bruch bruch; // Instanzvariable, in der der im Kreisdiagramm anzuzeigende Bruch gespeichert werden soll
    
    public BruchCanvas(){
        bruch = null;
    }
    
    public void zeige(Bruch b){
        bruch = b;
        repaint(); // ruft interne Zeichenmethode der Canvas auf (die niemals direkt aufgerufen werden darf, da das Betriebssystem diese
                   // Zeichenmethode jederzeit aufrufen können muss, wenn etwa das Fenster minimiert oder verschoben wird)
    }
    
    public void paint(Graphics g){ // die eigentliche Zeichenmethode
        g.setColor(Color.red); // legt Grundfarbe rot fest
        // Hier soll nun ein entsprechendes Kreisdiagramm gezeichnet werden.
        g.drawOval(1, 1, getWidth()-5, getHeight()-5);
        
        if (bruch != null){
            g.setColor(Color.blue); // legt die Füllfarbe blau fest
            // Hier soll nun die passende Füllung gezeichnet werden.
            double winkel = 360;
            winkel *= bruch.gibBruchAlsDezimalzahl();
            
            g.fillArc(1, 1, getWidth()-5, getHeight()-5, 90, -(int) winkel);
        }
    }
    
    
}
