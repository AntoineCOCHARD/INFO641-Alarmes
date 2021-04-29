import java.util.*;

public class EventSource {
	private List<EventGazListener> liste_gaz_listener = new ArrayList<EventGazListener>();
	private List<EventIncendieListener> liste_incendie_listener = new ArrayList<EventIncendieListener>();
	private List<EventRadiationListener> liste_radiation_listener = new ArrayList<EventRadiationListener>();
	
	public void addGazListener(EventGazListener listener) {
		this.liste_gaz_listener.add(listener);
	}
	
	public void addIncendieListener(EventIncendieListener listener) {
		this.liste_incendie_listener.add(listener);
	}
	
	public void addRadiationListener(EventRadiationListener listener) {
		this.liste_radiation_listener.add(listener);
	}
	
	public void genGazEvent(String type_du_gaz) {
		EventGaz evenement = new EventGaz(this, type_du_gaz);
		for (EventGazListener l : liste_gaz_listener) {
			l.onEvent(evenement);
		}
	}
	
	public void genIncendieEvent() {
		EventIncendie evenement = new EventIncendie(this);
		for (EventIncendieListener l : liste_incendie_listener) {
			l.onEvent(evenement);
		}
	}
	
	public void genRadiationEvent(int niv_radiation) {
		EventRadiation evenement = new EventRadiation(this,niv_radiation);
		for (EventRadiationListener l : liste_radiation_listener) {
			l.onEvent(evenement);
		}
	}
}
