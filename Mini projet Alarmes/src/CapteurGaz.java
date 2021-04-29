
public class CapteurGaz implements EventGazListener {

	@Override
	public void onEvent(EventGaz event) {
		System.out.println("Alerte gaz toxique !");
		event.to_string();
	}

}	