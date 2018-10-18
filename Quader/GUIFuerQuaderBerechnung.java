import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIFuerQuaderBerechnung extends JFrame implements ActionListener{

    private JButton bVolumen;
    private JButton bOberflaeche;
    private JButton bKantenlaenge;

    private JTextField tEingabeHoehe;
    private JTextField tEingabeBreite;
    private JTextField tEingabeLaenge;
    private JTextField tAusgabeErgebniss;

    private JLabel lBreite;
    private JLabel lHoehe;
    private JLabel lTiefe;
    private JLabel lErgebniss;

    private GUIFuerQuader GUIquader;

    private Quader quader;

    public GUIFuerQuaderBerechnung(){
        super("GUI Quader"); // Name des erstellten Fensters. Wird in den Parent Constructor eingesetzt
        setSize(425,200); // Gr��e des GUI Fensters. Wahrscheinlich in Pixel.
        setLayout(null); // kein Layoutmanager gew�nscht
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // L�scht Objekt beim Schlie�en des Fensters.
        setVisible(true); //Macht das GUI Fenster sichtbar.

        lBreite = new JLabel("Breite:"); // Text f�r das Label festgelegt
        lBreite.setBounds(10,10,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Labels
        add(lBreite); // f�gt das Label im Fenster ein        
        lBreite.validate();
        lBreite.repaint();

        lHoehe = new JLabel("Hoehe:"); // Text f�r das Label festgelegt
        lHoehe.setBounds(135,10,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Labels
        add(lHoehe); // f�gt das Label im Fenster ein
        lHoehe.validate();
        lHoehe.repaint();

        lTiefe = new JLabel("Tiefe:"); // Text f�r das Label festgelegt
        lTiefe.setBounds(260,10,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Labels
        add(lTiefe); // f�gt das Label im Fenster ein
        lTiefe.validate();
        lTiefe.repaint();
        
        lErgebniss = new JLabel("Ergebniss = "); // Text f�r das Label festgelegt
        lErgebniss.setBounds(10,70,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Labels
        add(lErgebniss); // f�gt das Label im Fenster ein
        lErgebniss.validate();
        lErgebniss.repaint();
        

        tEingabeHoehe = new JTextField();
        tEingabeHoehe.setBounds(10,40,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Textfeldes
        add(tEingabeHoehe); // f�gt das Textfeld im Fenster ein
        tEingabeHoehe.repaint();
        tEingabeHoehe.validate();

        tEingabeBreite = new JTextField();
        tEingabeBreite.setBounds(135,40,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Textfeldes
        add(tEingabeBreite); // f�gt das Textfeld im Fenster ein
        tEingabeBreite.validate();
        tEingabeBreite.repaint();

        tEingabeLaenge = new JTextField();
        tEingabeLaenge.setBounds(260,40,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Textfeldes
        add(tEingabeLaenge); // f�gt das Textfeld im Fenster ein
        tEingabeLaenge.validate();
        tEingabeLaenge.repaint();

        tAusgabeErgebniss = new JTextField();
        tAusgabeErgebniss.setBounds(135,70,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Textfeldes
        add(tAusgabeErgebniss); // f�gt das Textfeld im Fenster ein
        tAusgabeErgebniss.validate();
        tAusgabeErgebniss.repaint();

        
        bVolumen = new JButton("Volumen"); // Text auf dem Button festgelegt
        bVolumen.setBounds(10,125,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Buttons
        bVolumen.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bVolumen); // f�gt den Button im Fenster ein
        bVolumen.validate();
        bVolumen.repaint();

        bOberflaeche = new JButton("Oberflaeche"); // Text auf dem Button festgelegt
        bOberflaeche.setBounds(135,125,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Buttons
        bOberflaeche.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bOberflaeche); // f�gt den Button im Fenster ein
        bOberflaeche.validate();
        bOberflaeche.repaint();

        bKantenlaenge = new JButton("Kantenlaenge"); // Text auf dem Button festgelegt
        bKantenlaenge.setBounds(260,125,125,20); // x-Koordinate, y-Koordinate, Breite und H�he des Buttons
        bKantenlaenge.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bKantenlaenge); // f�gt den Button im Fenster ein
        bKantenlaenge.validate();
        bKantenlaenge.repaint();
    }

    public void actionPerformed(ActionEvent e){ // Diese Methode MUSS geschrieben werden, da das Interface ActionListener implementiert wurde.
        // Dieses Fenster GUIFuerBrueche (= Objekt dieser Klasse GUIFuerBrueche) ist Ereignisempf�nger.
        // Diese Methode muss verraten, was mit dem Ereignisempf�nger passieren soll,
        // wenn ein automatisch erzeugtes Ereignisobjekt e ausgel�st (also ein Button gedr�ckt) wird.
        if ("".equals(tEingabeHoehe.getText()) || "".equals(tEingabeBreite.getText()) || "".equals(tEingabeLaenge.getText()))
        {
            //System.out.println("ERROR: Bruch1 und Bruch2 m�ssen komplett gef�llt sein!");
            tEingabeHoehe.setText("ERROR:");
            tEingabeBreite.setText("Fill all");
            tEingabeLaenge.setText("gabs");
        }
        else 
        {
            int laenge = Integer.parseInt(tEingabeLaenge.getText()); // wandelt den eingegebenen Zahl-String in eine Integer-Zahl um
            int breite = Integer.parseInt(tEingabeBreite.getText()); // wandelt den eingegebenen Zahl-String in eine Integer-Zahl um
            int hoehe = Integer.parseInt(tEingabeHoehe.getText());

            quader = new Quader(breite, hoehe, laenge);

            GUIquader = new GUIFuerQuader(hoehe, breite, laenge);

            double ergebniss;

            if (e.getSource() == bVolumen){ // fragt, ob der Button "Addiere" gedr�ckt worden ist
                ergebniss = quader.berechneVolumen();
            } else if (e.getSource() == bOberflaeche){ // fragt, ob der Button "Subtrahiere" gedr�ckt worden ist
                ergebniss = quader.berechneOberflaeche();
            } else { // ist bis hier kein Button erkannt worden, so muss der Button "Dividiere" gedr�ckt worden sein
                ergebniss = quader.berechneKantenlaenge();
            }
            String text = "" + ergebniss;
            tAusgabeErgebniss.setText("" + text); // durch Kombination des Integer-Objekts mit einem leeren String wird das Integer-Objekt
        }
    }

}

