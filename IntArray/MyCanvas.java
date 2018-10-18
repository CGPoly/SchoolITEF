import java.awt.*;
import javax.swing.*;

/**
 * Ansicht einer Zahlenliste in Form eines Balkendiagramms.
 * 
 * @author Dr. Oliver Heidbuechel
 * @version 2.0
 */
public class MyCanvas extends Canvas
{
    private double saeulenBreite = 0.0;
    private int[] zahlenliste;
    private int anzahl = 0;

    /**
     * Konstruktor fuer Objekte der Klasse MyCanvas.
     * 
     * Die Zeichnung erscheint in einer Flaeche von 450 x 220!
     * 
     * @param zahlenliste Die Zahlenliste, die angezeigt werden soll!
     */
    public MyCanvas(int[] zahlenliste){
       this.zahlenliste = zahlenliste;
    }
         
   // einzelne Saeule zeichnen
   private void zeichneSaeule(int index, int zahl, Graphics g){
      int hoehe = zahl / 5;
      g.setColor(Color.red);
      g.fillRect((int)(index * saeulenBreite), 200 - hoehe, (int)(saeulenBreite/2), hoehe);
   } 
   
  // Diagramm beschriften
  private void beschrifteDiagramm(Graphics g){
    g.setColor(Color.blue);
    for (int i = 900; i >= 0; i-= 100){
        g.drawString("" + i, 410, (1000 - i) / 5 + 5);
        g.drawLine(0, (1000 - i) / 5, 400, (1000 - i) / 5);
    }
    for (int i = 0; i < anzahl; i++){
        g.drawString("" + i, (int)(i * saeulenBreite), 220);
    }
  }
  
    /**
     * Das Balkendiagramm wird neu gezeichnet!
     */
    public void paint(Graphics g){
       if (anzahl > 0){
           saeulenBreite = 400 / anzahl;
       }
     
       g.setColor(Color.blue);
       for (int i = 0; i < anzahl; i++){
           zeichneSaeule(i, zahlenliste[i], g);
       }
       beschrifteDiagramm(g);
    }
  
    /**
     * Setzt die Anzahl der zu zeichnenden Saeulen fest!
     * 
     * @param anzahl Anzahl der Säulen
     */
    public void setAnzahl(int anzahl){
        this.anzahl = anzahl;   
    }
}


