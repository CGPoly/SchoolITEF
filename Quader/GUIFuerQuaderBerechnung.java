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
        setSize(425,200); // Größe des GUI Fensters. Wahrscheinlich in Pixel.
        setLayout(null); // kein Layoutmanager gewünscht
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Löscht Objekt beim Schließen des Fensters.
        setVisible(true); //Macht das GUI Fenster sichtbar.

        lBreite = new JLabel("Breite:"); // Text für das Label festgelegt
        lBreite.setBounds(10,10,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lBreite); // fügt das Label im Fenster ein        
        lBreite.validate();
        lBreite.repaint();

        lHoehe = new JLabel("Hoehe:"); // Text für das Label festgelegt
        lHoehe.setBounds(135,10,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lHoehe); // fügt das Label im Fenster ein
        lHoehe.validate();
        lHoehe.repaint();

        lTiefe = new JLabel("Tiefe:"); // Text für das Label festgelegt
        lTiefe.setBounds(260,10,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lTiefe); // fügt das Label im Fenster ein
        lTiefe.validate();
        lTiefe.repaint();
        
        lErgebniss = new JLabel("Ergebniss = "); // Text für das Label festgelegt
        lErgebniss.setBounds(10,70,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lErgebniss); // fügt das Label im Fenster ein
        lErgebniss.validate();
        lErgebniss.repaint();
        

        tEingabeHoehe = new JTextField();
        tEingabeHoehe.setBounds(10,40,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tEingabeHoehe); // fügt das Textfeld im Fenster ein
        tEingabeHoehe.repaint();
        tEingabeHoehe.validate();

        tEingabeBreite = new JTextField();
        tEingabeBreite.setBounds(135,40,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tEingabeBreite); // fügt das Textfeld im Fenster ein
        tEingabeBreite.validate();
        tEingabeBreite.repaint();

        tEingabeLaenge = new JTextField();
        tEingabeLaenge.setBounds(260,40,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tEingabeLaenge); // fügt das Textfeld im Fenster ein
        tEingabeLaenge.validate();
        tEingabeLaenge.repaint();

        tAusgabeErgebniss = new JTextField();
        tAusgabeErgebniss.setBounds(135,70,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tAusgabeErgebniss); // fügt das Textfeld im Fenster ein
        tAusgabeErgebniss.validate();
        tAusgabeErgebniss.repaint();

        
        bVolumen = new JButton("Volumen"); // Text auf dem Button festgelegt
        bVolumen.setBounds(10,125,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bVolumen.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bVolumen); // fügt den Button im Fenster ein
        bVolumen.validate();
        bVolumen.repaint();

        bOberflaeche = new JButton("Oberflaeche"); // Text auf dem Button festgelegt
        bOberflaeche.setBounds(135,125,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bOberflaeche.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bOberflaeche); // fügt den Button im Fenster ein
        bOberflaeche.validate();
        bOberflaeche.repaint();

        bKantenlaenge = new JButton("Kantenlaenge"); // Text auf dem Button festgelegt
        bKantenlaenge.setBounds(260,125,125,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bKantenlaenge.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bKantenlaenge); // fügt den Button im Fenster ein
        bKantenlaenge.validate();
        bKantenlaenge.repaint();
    }

    public void actionPerformed(ActionEvent e){ // Diese Methode MUSS geschrieben werden, da das Interface ActionListener implementiert wurde.
        // Dieses Fenster GUIFuerBrueche (= Objekt dieser Klasse GUIFuerBrueche) ist Ereignisempfänger.
        // Diese Methode muss verraten, was mit dem Ereignisempfänger passieren soll,
        // wenn ein automatisch erzeugtes Ereignisobjekt e ausgelöst (also ein Button gedrückt) wird.
        if ("".equals(tEingabeHoehe.getText()) || "".equals(tEingabeBreite.getText()) || "".equals(tEingabeLaenge.getText()))
        {
            //System.out.println("ERROR: Bruch1 und Bruch2 müssen komplett gefüllt sein!");
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

            if (e.getSource() == bVolumen){ // fragt, ob der Button "Addiere" gedrückt worden ist
                ergebniss = quader.berechneVolumen();
            } else if (e.getSource() == bOberflaeche){ // fragt, ob der Button "Subtrahiere" gedrückt worden ist
                ergebniss = quader.berechneOberflaeche();
            } else { // ist bis hier kein Button erkannt worden, so muss der Button "Dividiere" gedrückt worden sein
                ergebniss = quader.berechneKantenlaenge();
            }
            String text = "" + ergebniss;
            tAusgabeErgebniss.setText("" + text); // durch Kombination des Integer-Objekts mit einem leeren String wird das Integer-Objekt
        }
    }

}

