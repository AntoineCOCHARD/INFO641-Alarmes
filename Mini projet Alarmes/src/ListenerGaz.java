
public class ListenerGaz implements EventGazListener {

	@Override
	public void onEvent(EventGaz event) {
		System.out.println("Alerte gaz toxique !");
		event.toString();
		Alerte al = new Alerte(event.getTypeEvent(),event.getDate(),event.getLieuAlarme(),event.getType(),event.getNivAlarme());
	}

}	