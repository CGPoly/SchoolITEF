
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIFuerBrueche extends JFrame implements ActionListener{

    private JButton bAddiere;
    private JButton bSubtrahiere;
    private JButton bMultipliziere;
    private JButton bDividiere;
    private JButton bCrash;

    private JTextField tEingabeZaehler1;
    private JTextField tEingabeNenner1;
    private JTextField tEingabeZaehler2;
    private JTextField tEingabeNenner2;
    private JTextField tAusgabeZaehler;
    private JTextField tAusgabeNenner;

    private JLabel lbruch1;
    private JLabel lbruch2;
    private JLabel lbruch3;
    private JLabel lbruchStrich1;
    private JLabel lbruchStrich2;
    private JLabel lbruchStrich3;

    private BruchCanvas bruchCanvas1;
    private BruchCanvas bruchCanvas2;
    private BruchCanvas bruchCanvas3;

    public GUIFuerBrueche(){
        super("GUI für Brüche"); // Name des erstellten Fensters. Wird in den Parent Constructor eingesetzt
        setSize(300,300); // Größe des GUI Fensters. Wahrscheinlich in Pixel.
        setLayout(null); // kein Layoutmanager gewünscht
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Löscht Objekt beim Schließen des Fensters.
        setVisible(true); //Macht das GUI Fenster sichtbar.

        lbruch1 = new JLabel("1.Bruch"); // Text für das Label festgelegt
        lbruch1.setBounds(10,10,100,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lbruch1); // fügt das Label im Fenster ein
        lbruch1.validate();
        lbruch1.repaint();

        lbruch2 = new JLabel("2.Bruch"); // Text für das Label festgelegt
        lbruch2.setBounds(110,10,100,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lbruch2); // fügt das Label im Fenster ein

        lbruch3 = new JLabel("3.Bruch"); // Text für das Label festgelegt
        lbruch3.setBounds(210,10,100,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lbruch3); // fügt das Label im Fenster ein

        lbruchStrich1 = new JLabel("------------"); // Text für das Label festgelegt
        lbruchStrich1.setBounds(10,50,100,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lbruchStrich1); // fügt das Label im Fenster ein

        lbruchStrich2 = new JLabel("------------"); // Text für das Label festgelegt
        lbruchStrich2.setBounds(110,50,100,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lbruchStrich2); // fügt das Label im Fenster ein

        lbruchStrich3 = new JLabel("------------"); // Text für das Label festgelegt
        lbruchStrich3.setBounds(210,50,100,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Labels
        add(lbruchStrich3); // fügt das Label im Fenster ein

        
        tEingabeZaehler1 = new JTextField();
        tEingabeZaehler1.setBounds(10,40,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tEingabeZaehler1); // fügt das Textfeld im Fenster ein
        tEingabeZaehler1.validate();
        tEingabeZaehler1.repaint();

        tEingabeZaehler2 = new JTextField();
        tEingabeZaehler2.setBounds(110,40,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tEingabeZaehler2); // fügt das Textfeld im Fenster ein

        tAusgabeZaehler = new JTextField();
        tAusgabeZaehler.setBounds(210,40,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tAusgabeZaehler); // fügt das Textfeld im Fenster ein

        tEingabeNenner1 = new JTextField();
        tEingabeNenner1.setBounds(10,70,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tEingabeNenner1); // fügt das Textfeld im Fenster ein

        tEingabeNenner2 = new JTextField();
        tEingabeNenner2.setBounds(110,70,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tEingabeNenner2); // fügt das Textfeld im Fenster ein

        tAusgabeNenner = new JTextField();
        tAusgabeNenner.setBounds(210,70,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Textfeldes
        add(tAusgabeNenner); // fügt das Textfeld im Fenster ein

        bAddiere = new JButton("+"); // Text auf dem Button festgelegt
        bAddiere.setBounds(10,125,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bAddiere.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bAddiere); // fügt den Button im Fenster ein
        bAddiere.validate();
        bAddiere.repaint();

        bSubtrahiere = new JButton("-"); // Text auf dem Button festgelegt
        bSubtrahiere.setBounds(75,125,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bSubtrahiere.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bSubtrahiere); // fügt den Button im Fenster ein

        bMultipliziere = new JButton("x"); // Text auf dem Button festgelegt
        bMultipliziere.setBounds(135,125,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bMultipliziere.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bMultipliziere); // fügt den Button im Fenster ein

        bDividiere = new JButton("÷"); // Text auf dem Button festgelegt
        bDividiere.setBounds(210,125,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bDividiere.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bDividiere); // fügt den Button im Fenster ein

        bCrash = new JButton("?"); // Text auf dem Button festgelegt
        bCrash.setBounds(210,100,50,20); // x-Koordinate, y-Koordinate, Breite und Höhe des Buttons
        bCrash.addActionListener(this); // meldet dieses Fenster GUI1 (= Objekt dieser Klasse GUI1) bei der Ereignisquelle (also dem Button) an
        add(bCrash); // fügt den Button im Fenster ein

        bruchCanvas1 = new BruchCanvas();
        bruchCanvas1.setBounds(10,175,75,75);
        add(bruchCanvas1);

        bruchCanvas2 = new BruchCanvas();
        bruchCanvas2.setBounds(95,175,75,75);
        add(bruchCanvas2);

        bruchCanvas3 = new BruchCanvas();
        bruchCanvas3.setBounds(180,175,75,75);
        add(bruchCanvas3);
    }

    public void actionPerformed(ActionEvent e){ // Diese Methode MUSS geschrieben werden, da das Interface ActionListener implementiert wurde.
        // Dieses Fenster GUIFuerBrueche (= Objekt dieser Klasse GUIFuerBrueche) ist Ereignisempfänger.
        // Diese Methode muss verraten, was mit dem Ereignisempfänger passieren soll,
        // wenn ein automatisch erzeugtes Ereignisobjekt e ausgelöst (also ein Button gedrückt) wird.
        if ("".equals(tEingabeZaehler1.getText()) || "".equals(tEingabeNenner1.getText()) || "".equals(tEingabeZaehler2.getText()) || "".equals(tEingabeNenner2.getText()))
        {
            //System.out.println("ERROR: Bruch1 und Bruch2 müssen komplett gefüllt sein!");
            tEingabeZaehler1.setText("ERROR:");
            tEingabeZaehler2.setText("All gabs");
            tEingabeNenner1.setText("have to");
            tEingabeNenner2.setText("be filled");
        }
        else 
        {
            int z1 = Integer.parseInt(tEingabeZaehler1.getText()); // wandelt den eingegebenen Zahl-String in eine Integer-Zahl um
            int n1 = Integer.parseInt(tEingabeNenner1.getText()); // wandelt den eingegebenen Zahl-String in eine Integer-Zahl um
            Bruch b1 = new Bruch(z1,n1); // erzeugt aus den beiden zuvor erfolgten Eingaben ein Bruch-Objekt
            bruchCanvas1.zeige(b1); // zeichnet die Canvas

            int z2 = Integer.parseInt(tEingabeZaehler2.getText()); // wandelt den eingegebenen Zahl-String in eine Integer-Zahl um
            int n2 = Integer.parseInt(tEingabeNenner2.getText()); // wandelt den eingegebenen Zahl-String in eine Integer-Zahl um
            Bruch b2 = new Bruch(z2,n2); // erzeugt aus den beiden zuvor erfolgten Eingaben ein Bruch-Objekt
            bruchCanvas2.zeige(b2); // zeichnet die Canvas

            Bruch b3; // b3 muss vorab als lokale Variable eingeführt werden, da es sonst außerhalb der if-Anweisung nicht bekannt ist
            b3 = null;          // hier wird ein leerer Konstruktor für b3 benötigt, der intern aufgerufen wird, obwohl er nicht geschrieben wurde
            if (e.getSource() == bAddiere){ // fragt, ob der Button "Addiere" gedrückt worden ist
                b3 = b1.addiere(b2);
            } else if (e.getSource() == bSubtrahiere){ // fragt, ob der Button "Subtrahiere" gedrückt worden ist
                b3 = b1.subtrahiere(b2);
            } else if (e.getSource() == bMultipliziere){ // fragt, ob der Button "Multipliziere" gedrückt worden ist
                b3 = b1.multipliziereMit(b2);
            } else if (e.getSource() == bCrash){
                b1.crash(true);
                b3 = b1;
            } else { // ist bis hier kein Button erkannt worden, so muss der Button "Dividiere" gedrückt worden sein
                b3 = b1.dividiere(b2);
            }
            bruchCanvas3.zeige(b3); // zeichnet die Canvas
            int z3 = b3.gibZaehler();
            int n3 = b3.gibNenner();
            String tZ3 = "" + z3;
            String tN3 = "" + n3;
            tAusgabeZaehler.setText("" + tZ3); // durch Kombination des Integer-Objekts mit einem leeren String wird das Integer-Objekt
            tAusgabeNenner.setText("" + tN3); // in ein String-Objekt konvertiert 
        }
    }

}
