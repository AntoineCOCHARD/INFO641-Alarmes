import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Choice;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MoniteurB extends JFrame implements EventGazListener, EventRadiationListener, ActionListener {
	
	ArrayList<Event> alarmesRecuesB = new ArrayList<Event>();
	ArrayList<Event> sauvegardeAlarmesRecuesB = new ArrayList<Event>();
	DefaultComboBoxModel<Event>  event = new DefaultComboBoxModel<Event> ( );
	private JComboBox listeEvent = new JComboBox(event);
	private JLabel probE = new JLabel ("Veuillez choisir une alerte");
	
	@Override
	public void onEvent(EventRadiation event) {
		listeEvent.addItem(event);
	}

	@Override
	public void onEvent(EventGaz event) {
		listeEvent.addItem(event);
	}
	
	public MoniteurB() {
		this.setTitle("Moniteur B");
		this.setSize(800, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setLocation(10,610);
		
		JButton bouton = new JButton("Détails");
		this.getContentPane().add(bouton);
		bouton.setBounds(200, 200, 100, 30);
		bouton.addActionListener(this);
		JButton bouton2 = new JButton("Traitée");
		this.getContentPane().add(bouton2);
		bouton2.setBounds(520, 200, 100, 30);
		bouton2.addActionListener(this);
		listeEvent.setBounds(100, 30, 600, 30);
		this.getContentPane().add(listeEvent);
		this.setVisible(true);
	}
	
	public ArrayList<Event> getListe() {
		return this.sauvegardeAlarmesRecuesB;
	}

	public void effListe() {
		this.sauvegardeAlarmesRecuesB.clear();
	}
	
	public void actionPerformed(ActionEvent e) {
        Event selectionEvent = (Event) listeEvent.getSelectedItem();
        String component = e.getActionCommand();
        sauvegardeAlarmesRecuesB.add(selectionEvent);
        
        if (component=="Détails") {
        	probE.setVisible(false);
        	try{
        		Infos_alarme inf = new Infos_alarme(selectionEvent);
        	}
        	catch(NullPointerException ex){
        		this.getContentPane().add(probE);
    			probE.setBounds(340, 150, 300, 30);
    			probE.setVisible(true);
        	}
            alarmesRecuesB.add(selectionEvent);
        }


        if (component=="Traitée") {

            if (alarmesRecuesB.contains(selectionEvent)) {

            listeEvent.removeItem(selectionEvent);
            alarmesRecuesB.remove(selectionEvent);

            }

            else;

        }

    }
}
