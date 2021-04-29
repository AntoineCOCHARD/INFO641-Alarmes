import java.text.SimpleDateFormat;
import java.util.*;
import java.text.DateFormat;


public class EventGaz extends EventObject {
	private String type_gaz;
	private Date date_creation;
	private DateFormat format;

	public EventGaz(Object source, String type_du_gaz) {
		super(source);
		this.type_gaz = type_du_gaz;
		this.format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.date_creation = new Date();
	}
	
	public void to_string() {
		System.out.println("Date d'apparition de l'anomalie : " + format.format(this.date_creation) + "  Présence de : " + this.type_gaz);
	}
	
	public String get_type() {
		return this.type_gaz;
	}
	
}
