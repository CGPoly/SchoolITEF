
public class Wuerfelbecher{
	
	private Wuerfel w1;
	private Wuerfel w2;
	private Wuerfel w3;
	
	private int wurf1;
	private int wurf2;
	private int wurf3;
	
	public Wuerfelbecher(){
		w1 = new Wuerfel();
		w2 = new Wuerfel();
		w3 = new Wuerfel();
		werfen();
	}
	
	public void werfen(){
		wurf1 = w1.neuerWurf();
		wurf2 = w2.neuerWurf();
		wurf3 = w3.neuerWurf();
	}

	public int gibWurf1(){
		return wurf1;
	}

	public int gibWurf2(){
		return wurf2;
	}

	public int gibWurf3(){
		return wurf3;
	}
}
