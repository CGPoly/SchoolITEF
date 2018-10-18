import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 * GUI fuer das Projekt Zahlenliste
 * 
 * @author Dr. Oliver Heidbuechel
 * @version 2.0
 */
public class IntArrayGUI extends JFrame implements ActionListener
{
    private JButton bErzeuge, bMinimum, bMaximum, bMittelwert, bSortierung;
    private JButton bTausche;
    private JTextField tIndexI, tIndexJ;
    private MyCanvas leinwand;
    private MyList liste;
    private JLabel lAusgabe;

    private Random z = new Random();
    private int[] zahlenliste;

    /**
     * Konstruktor fuer Objekte der Klasse IntArrayGUI
     */
    public IntArrayGUI(){
        super("Zahlenliste");

        // Zahlenliste
        zahlenliste = new int[20];

        // Fenster
        setSize(880, 420);
        setLocation(100, 100);
        JPanel folie = new JPanel();
        getContentPane().add(folie);
        folie.setBackground(Color.lightGray);
        folie.setLayout(null);

        // Neue Zufallszahlen
        bErzeuge = new JButton("Erzeuge Zufallszahlen");
        bErzeuge.setBounds(20, 70, 180, 30);
        bErzeuge.addActionListener(this);
        folie.add(bErzeuge);

        // Tausche
        JLabel lIndexI = new JLabel("i: ");
        lIndexI.setBounds(20, 150, 20, 20);
        folie.add(lIndexI);
        JLabel lIndexJ = new JLabel("j: ");
        lIndexJ.setBounds(20, 180, 20, 20);
        folie.add(lIndexJ);
        tIndexI = new JTextField("0");
        tIndexI.setBounds(60, 150, 30, 20);
        folie.add(tIndexI);
        tIndexJ = new JTextField("0");
        tIndexJ.setBounds(60, 180, 30, 20);
        folie.add(tIndexJ);
        bTausche = new JButton("Tausche");
        bTausche.addActionListener(this);
        bTausche.setBounds(110, 150, 90, 50);
        folie.add(bTausche);

        // Listenfeld
        liste = new MyList(zahlenliste);
        liste.setBounds(210, 30, 50, 220);
        folie.add(liste);

        // Leinwand
        leinwand = new MyCanvas(zahlenliste);
        leinwand.setAnzahl(zahlenliste.length);
        leinwand.setBounds(290, 30, 450, 220);
        leinwand.setBackground(Color.lightGray);
        folie.add(leinwand);

        // Ausgabezeile
        lAusgabe = new JLabel("");
        lAusgabe.setBounds(210, 270, 500, 20);
        folie.add(lAusgabe);

        // Buttons
        bMinimum = new JButton("Minimum");
        bMinimum.setBounds(760, 30, 100, 20);
        bMinimum.addActionListener(this);
        folie.add(bMinimum);
        bMaximum = new JButton("Maximum");
        bMaximum.setBounds(760, 60, 100, 20);
        bMaximum.addActionListener(this);
        folie.add(bMaximum);
        bMittelwert = new JButton("Mittelwert");
        bMittelwert.setBounds(760, 90, 100, 20);
        bMittelwert.addActionListener(this);
        folie.add(bMittelwert);
        bSortierung = new JButton("Sortieren");
        bSortierung.setBounds(760, 120, 100, 20);
        bSortierung.addActionListener(this);
        folie.add(bSortierung);

        // Anzeigen
        setVisible(true);
        erzeugeZufallszahlen();
    }

    /**
     * Erzeuge neue Zufallszahlen!
     * 
     * Die Leinwand und das Listenfeld werden angepasst.
     * Das Label lAusgabe wird "" gesetzt.
     */
    private void erzeugeZufallszahlen(){

        for (int i = 0; i < zahlenliste.length ; i++){
            zahlenliste[i] = z.nextInt(1000);
        }

        refresh();
        lAusgabe.setText("");
    }

    /**
     * Zeichne neu und stelle die Liste neu dar!
     * Das Label lAusgabe wird "" gesetzt.
     */
    private void refresh(){
        liste.refresh(zahlenliste.length);
        leinwand.update(leinwand.getGraphics());
    }

    /**
     * Reagiere auf Events!
     */
    public void actionPerformed (ActionEvent ev) {
        Object quelle = ev.getSource();
        if (quelle == bErzeuge){
            erzeugeZufallszahlen();
        }
        else if (quelle == bMinimum){
            int min = minimum(0, zahlenliste.length);
            lAusgabe.setText("Minimum: " + zahlenliste[min]);
        }
        else if (quelle == bMaximum){
            int max = maximum(0, zahlenliste.length);
            lAusgabe.setText("Maximum: " + zahlenliste[max]);
        }
        else if (quelle == bMittelwert){
            double m = mittelwert();
            lAusgabe.setText("Mittelwert: " + m);
        }
        else if (quelle == bTausche){
            int i, j;
            i = Integer.parseInt(tIndexI.getText());
            j = Integer.parseInt(tIndexJ.getText());
            tausche(i, j);
            refresh();
        }
        else if (quelle == bSortierung){
            sortiere (0, zahlenliste.length);
            refresh();
        }
    }

    /**
     * Sucht den Index eines minimalen Elementes
     * 
     * @param start Bei diesem Index wird die Suche begonnen
     * @param ende Vor diesem Index endet die Suche
     * @return Index
     */
    private int minimum(int start, int ende){
        int kleinsteZahl = 1001;
        int stelle=0;
        for (int i = start; i < ende; i++)
        {
            if (zahlenliste[i]<kleinsteZahl)
            {
                kleinsteZahl = zahlenliste[i];
                stelle=i;
            }
        }
        return(stelle);
    }

    /**
     * Sucht den Index eines maximalen Elementes
     * 
     * @param start Bei diesem Index wird die Suche begonnen
     * @param ende Vor diesem Index endet die Suche
     * @return Index
     */
    private int maximum(int start, int ende){
        int grössteZahl = 0;
        int stelle=0;
        for (int i = start; i < ende; i++)
        {
            if (zahlenliste[i]>grössteZahl)
            {
                grössteZahl = zahlenliste[i];
                stelle=i;
            }
        }
        return(stelle);
    }

    /**
     * Berechnet den Mittelwert der Zahlenliste
     * 
     * @return Mittelwert
     */
    private double mittelwert(){
        int alleZusammen = 0;
        for (int i = 0; i < zahlenliste.length; i++)
        {
            alleZusammen += zahlenliste[i];
        }
        return(alleZusammen / zahlenliste.length);
    }

    /**
     * Tausche zwei Elemente in der Zahlenliste!
     * 
     * @param i Index des ersten Elementes
     *        j Index des zweiten Elementes
     */
    private void tausche(int i, int j){
        int ii = zahlenliste[i];
        int jj = zahlenliste[j];
        zahlenliste[i] = jj;
        zahlenliste[j] = ii;
    }

    private void sortiere(int start ,int ende){
        int zahlenlisteS[] = new int [20];
        for(int i=0 ;i < zahlenliste.length;i++){
        zahlenlisteS[i]=zahlenliste[i];
        }
        for(int j=0;j < zahlenliste.length; j++){
         int grössteZahl = 0;
         int stelle=0;
        for (int i = start; i < ende; i++)
        {
            if (zahlenliste[i]>grössteZahl)
            {
                grössteZahl = zahlenliste[i];
                stelle=i;
            }
        }
        zahlenliste[j]=zahlenlisteS[stelle];//tausche mit minimum fkt
        zahlenlisteS[stelle]=0;
    }
}
}

