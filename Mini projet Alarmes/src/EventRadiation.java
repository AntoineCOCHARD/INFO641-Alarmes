import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

public class EventRadiation extends Event{
	private int niveauRad;

	public EventRadiation(Object source,int niv_radiation, String lieu_a, String nivAlarme) {
		super(source);
		this.niveauRad = niv_radiation;
		this.date_creation = new Date();
		this.typeEvent = "Radiation";
		this.lieu = lieu_a;
		this.nivAlarme = nivAlarme;

	}
	
	public String getNiveau() {
		return (""+this.niveauRad);
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
		return (""+this.niveauRad);
	}
}
