
public class TestFenetre {
	public static void main(String[] args){
		Fenetre fen = new Fenetre();
		ListenerIncendie c1 = new ListenerIncendie();
		fen.addIncendieListener(c1);
		
		ListenerGaz c2 = new ListenerGaz();
		fen.addGazListener(c2);
		
		ListenerRadiation c3 = new ListenerRadiation();
		fen.addRadiationListener(c3);
		
		MoniteurA moniA = new MoniteurA();
		fen.addIncendieListener(moniA);
		fen.addGazListener(moniA);
		
		MoniteurB moniB = new MoniteurB();
		fen.addGazListener(moniB);
		fen.addRadiationListener(moniB);
		
	}
}
