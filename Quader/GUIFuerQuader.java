
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIFuerQuader extends JFrame{

    private QuaderCanvas Canvas1;
    private QuaderCanvas Canvas2;
    private QuaderCanvas Canvas3;
    private QuaderCanvas Canvas4;
    private QuaderCanvas Canvas5;
    private QuaderCanvas Canvas6;

    public GUIFuerQuader(int hoehe, int breite, int tiefe) {
        super("Quader Canvas"); // Name des erstellten Fensters. Wird in den Parent Constructor eingesetzt
        
        hoehe *= 100;
        breite *= 100;
        tiefe *= 100;
        
        setSize(hoehe*2+breite+36,hoehe*2+tiefe*2+36); // Größe des GUI Fensters. Wahrscheinlich in Pixel.
        setLayout(null); // kein Layoutmanager gewünscht
        setVisible(true); //Macht das GUI Fenster sichtbar.
        
        Canvas1 = new QuaderCanvas();
        Canvas1.setBounds(hoehe, 1, breite, hoehe);
        add(Canvas1);
        
        Canvas2 = new QuaderCanvas();
        Canvas2.setBounds(1, hoehe, hoehe, tiefe);
        add(Canvas2);
        
        Canvas3 = new QuaderCanvas();
        Canvas3.setBounds(hoehe, hoehe, breite, tiefe);
        add(Canvas3);
        
        Canvas4 = new QuaderCanvas();
        Canvas4.setBounds(hoehe+breite, hoehe, hoehe, tiefe);
        add(Canvas4);
        
        Canvas5 = new QuaderCanvas();
        Canvas5.setBounds(hoehe, hoehe+tiefe, breite, hoehe);
        add(Canvas5);
        
        Canvas6 = new QuaderCanvas();
        Canvas6.setBounds(hoehe, hoehe*2+tiefe, breite, tiefe);
        add(Canvas6);
    }

}

 