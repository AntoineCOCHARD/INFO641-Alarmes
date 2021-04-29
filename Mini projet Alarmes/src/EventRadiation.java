import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EventObject;

public class EventRadiation extends EventObject{
	private int niveau_rad;
	private Date date_creation;
	private DateFormat format;

	public EventRadiation(Object source,int niv_radiation) {
		super(source);
		this.niveau_rad = niv_radiation;
		this.format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		this.date_creation = new Date();
	}
	
	public void affiche() {
		System.out.println("Date d'apparition de l'anomalie : " + format.format(this.date_creation)+ "  Radiations de niveau : " + this.niveau_rad);
	}

}
