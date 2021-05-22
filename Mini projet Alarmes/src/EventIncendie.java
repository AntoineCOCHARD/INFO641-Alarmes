import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

public class EventIncendie extends Event{

	public EventIncendie(Object source, String lieu_a, String nivAlarme) {
		super(source);
		this.date_creation = new Date();
		this.typeEvent = "Incendie";
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

	@Override
	public String getDetail() {
		// TODO Auto-generated method stub
		return null;
	}
}

