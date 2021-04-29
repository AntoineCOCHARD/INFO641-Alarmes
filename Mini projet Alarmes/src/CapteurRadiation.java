
public class CapteurRadiation implements EventRadiationListener {

	@Override
	public void onEvent(EventRadiation event) {
		System.out.println("Alerte, présence de radiations !");
		event.to_string();
	}

}