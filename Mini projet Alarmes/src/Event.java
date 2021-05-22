import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

public abstract class Event  extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected String typeEvent;
	protected Date date_creation;
	private DateFormat format;
	protected String lieu;
	protected String nivAlarme;
	
	public Event(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		this.format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return "Alerte : "+this.typeEvent+" date d'apparition : " + format.format(this.date_creation);
	}
	
	public String getTypeEvent() {
		return (this.typeEvent);
	}
	
	public Date getDate() {
		return (this.date_creation);
	}
	
	public String getLieuAlarme() {
		return (this.lieu);
	}
	
	public String getNivAlarme() {
		return (this.nivAlarme);
	}
	
	public abstract String getDetail();
}
