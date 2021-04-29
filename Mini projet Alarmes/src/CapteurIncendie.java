
public class CapteurIncendie implements EventIncendieListener {

	@Override
	public void onEvent(EventIncendie event) {
		System.out.println("Au feu! Appelez les pompiers !");
		event.affiche();
	}

}	
