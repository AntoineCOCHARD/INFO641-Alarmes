
public class CapteurRadiation implements EventRadiationListener {

	@Override
	public void onEvent(EventRadiation event) {
		System.out.println("Alerte, pr�sence de radiations !");
		event.to_string();
	}

}