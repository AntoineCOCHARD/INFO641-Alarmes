
public class ClassTest {
	public static void main(String[] args) {
		EventSource s = new EventSource();
		CapteurIncendie c1 = new CapteurIncendie();
		s.addIncendieListener(c1);
		s.genIncendieEvent();
		
		CapteurGaz c2 = new CapteurGaz();
		s.addGazListener(c2);
		s.genGazEvent("CO2");
		
		CapteurRadiation c3 = new CapteurRadiation();
		s.addRadiationListener(c3);
		s.genRadiationEvent(30);
	}

}
