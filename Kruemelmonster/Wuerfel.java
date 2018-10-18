
public class Wuerfel{
	
	private Zufall meinZufall;
	
	public Wuerfel(){
		meinZufall = new Zufall();
	}
	
	public int neuerWurf(){
		return meinZufall.neueZufallszahl(1, 6);
	}
}
