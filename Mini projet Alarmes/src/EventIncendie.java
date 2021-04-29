import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

public class EventIncendie extends EventObject{
	private Date date_creation;
	private DateFormat format;

	public EventIncendie(Object source) {
		super(source);
		this.format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.date_creation = new Date();
	}
	
	public void affiche() {
		System.out.println("Date d'apparition de l'anomalie : " + format.format(this.date_creation));
	}
}

