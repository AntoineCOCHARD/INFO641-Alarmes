
public class TestFenetre {
	public static void main(String[] args){
		MoniteurA moniA = new MoniteurA();
		MoniteurB moniB = new MoniteurB();
		
		Fenetre fen = new Fenetre(moniA, moniB);
		ListenerIncendie c1 = new ListenerIncendie();
		fen.addIncendieListener(c1);
		
		ListenerGaz c2 = new ListenerGaz();
		fen.addGazListener(c2);
		
		ListenerRadiation c3 = new ListenerRadiation();
		fen.addRadiationListener(c3);
		

		fen.addIncendieListener(moniA);
		fen.addGazListener(moniA);
		

		fen.addGazListener(moniB);
		fen.addRadiationListener(moniB);
		
	}
}
