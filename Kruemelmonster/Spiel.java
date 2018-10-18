public class Spiel
{
    private Kruemel kruemel;
    public Spiel(int runden, int startKekse)
    {
        System.out.print('\u000C');
        kruemel = new Kruemel(startKekse);
        spielen(runden);
    }
    public boolean spielen(int runden)
    {
        System.out.print('\u000C');
        
        for (int x = 1; x == runden + 1; x++)
        {
           if (kruemel.anzahlKekse < 2)
           {
               System.out.println("Du hast leider nicht genug Kekse!");
               return false;
           }
           System.out.print("Runde " + x + ":  ");
           kruemel.einsetzen();
           kruemel.werfen();
           kruemel.zeigeWurf();
           System.out.println("  Kekse: " + kruemel.anzahlKekse);
        }
        System.out.println("Kekse: " + kruemel.anzahlKekse);
        return true;
    }
}
