public class Crasher
{
    public Crasher(boolean doYouRealyWantThis)
    {
        if(doYouRealyWantThis)
        {
            Crasher goGoGo = new Crasher(true);
        }
    }
}
