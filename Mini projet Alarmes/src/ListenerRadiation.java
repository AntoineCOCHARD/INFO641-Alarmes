
public class ListenerRadiation implements EventRadiationListener {

	@Override
	public void onEvent(EventRadiation event) {
		System.out.println("Alerte, pr�sence de radiations !");
		event.toString();
		Alerte al = new Alerte(event.getTypeEvent(),event.getDate(),event.getLieuAlarme(),event.getNiveau(),event.getNivAlarme());
	}

}