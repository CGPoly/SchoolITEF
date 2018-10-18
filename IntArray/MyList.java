import java.awt.*;
import javax.swing.*;

/**
 * Darstellung der Zahlenliste in einem Listenfeld!
 * 
 * @author Dr. Oliver Heidbuechel
 * @version 2.0
 */
public class MyList extends List
{
    private int[] zahlenliste;
    
	/**
	 * Konstruktor fuer Objekte der Klasse MyList
	 * 
	 * @param zahlenliste Die Zahlenliste, die angezeigt werden soll!
	 */
	public MyList(int[] zahlenliste){
       this.zahlenliste = zahlenliste;
   	}
	   
    /**
     * Die ersten <i>anzahl</i> Zahlen aus der Zahlenliste werden neu in das Listenfeld eingetragen!
     * 
     * @param anzahl So viele Zahlen aus der Zahlenliste werden in
     * das Listenfeld der Reihe nach beginnend mit dem 0ten Element 
     * eingetragen. 
     */
    public void refresh(int anzahl){
        removeAll();
       
        for (int i = 0; i < anzahl; i++){
           add("" + zahlenliste[i]);
        }
    }
}


