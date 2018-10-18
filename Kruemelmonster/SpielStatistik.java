public class SpielStatistik
{
    private KruemelStatistik kruemel;
    public SpielStatistik(int startKekse)
    {
        kruemel = new KruemelStatistik(startKekse);
    }
    public boolean spielen(int runden)
    {
        System.out.print("Start Kekse: " + kruemel.anzahlKekse);
        int x = 0;
        while (!(x == runden))
        {
           x++;
           if (kruemel.anzahlKekse < 2)
           {
               System.out.println("    Du hast leider nicht genug Kekse!");
               return false;
           }
           kruemel.einsetzen();
           kruemel.werfen();
           kruemel.zeigeWurf();
        }
        System.out.print("    Kekse: " + kruemel.anzahlKekse);
        System.out.println("    Runden: " + runden);
        return true;
    }
    public void statistikSpiel(int runden, int rundenProRunde)
    {
        boolean t = true;
        int x = 0;
        while (!(x >= runden))
        {
            x++;
            System.out.print("Runde: " + x + "    ");
            t = spielen(rundenProRunde);
            if (t == false)
            {
                break;
            }
        }
       System.out.println("Kekse / Runde: " + (kruemel.anzahlKekse / runden));
    }
}