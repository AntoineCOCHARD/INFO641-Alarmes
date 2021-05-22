

public class ClassTest{
	public static void main(String[] args) {
		
		EventSource s = new EventSource();
		ListenerIncendie c1 = new ListenerIncendie();
		s.addIncendieListener(c1);
		s.genIncendieEvent("bat1","2");
		
		ListenerGaz c2 = new ListenerGaz();
		s.addGazListener(c2);
		s.genGazEvent("CO2","bat1","1");
		
		ListenerRadiation c3 = new ListenerRadiation();
		s.addRadiationListener(c3);
		s.genRadiationEvent(50,"bat1","3");
		
		
	}

}
