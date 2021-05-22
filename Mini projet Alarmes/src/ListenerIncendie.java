
public class ListenerIncendie implements EventIncendieListener {

	@Override
	public void onEvent(EventIncendie event) {
		System.out.println("Au feu! Appelez les pompiers !");
		event.toString();
		Alerte al = new Alerte(event.getTypeEvent(),event.getDate(),event.getLieuAlarme(),"nothing",event.getNivAlarme());
	}

}	
