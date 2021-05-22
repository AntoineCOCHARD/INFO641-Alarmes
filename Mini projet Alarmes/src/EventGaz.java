import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;


public class EventGaz extends Event {
	private String typeGaz;

	public EventGaz(Object source, String type_du_gaz, String lieu_a, String nivAlarme) {
		super(source);
		this.typeGaz = type_du_gaz;
		this.date_creation = new Date();
		this.typeEvent = "Gaz";
		this.lieu = lieu_a;
		this.nivAlarme = nivAlarme;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	@Override
	public String getTypeEvent() {
		// TODO Auto-generated method stub
		return super.getTypeEvent();
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return super.getDate();
	}

	@Override
	public String getLieuAlarme() {
		// TODO Auto-generated method stub
		return super.getLieuAlarme();
	}

	public String getType() {
		return this.typeGaz;
	}

	@Override
	public String getDetail() {
		// TODO Auto-generated method stub
		return this.typeGaz;
	}
	
}
