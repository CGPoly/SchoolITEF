
import java.awt.*;

public class QuaderCanvas extends Canvas{
    

    public QuaderCanvas(){
        repaint(); // ruft interne Zeichenmethode der Canvas auf (die niemals direkt aufgerufen werden darf, da das Betriebssystem diese
        // Zeichenmethode jederzeit aufrufen können muss, wenn etwa das Fenster minimiert oder verschoben wird)
    }
    
    public void paint(Graphics g){ // die eigentliche Zeichenmethode
          // hier durch passendes ergänzen 
          g.setColor(Color.red); 
          g.fillRect(3, 3, getWidth()-6, getHeight()-6);
          g.setColor(Color.blue);
          g.drawRect(3, 3, getWidth()-6, getHeight()-6);
    }

}
