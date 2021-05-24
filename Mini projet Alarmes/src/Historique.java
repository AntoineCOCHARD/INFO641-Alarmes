import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.awt.Choice;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class Historique extends JFrame implements ActionListener {
	
	ArrayList<Event> alarmes = new ArrayList<Event>();
	DefaultComboBoxModel  event = new DefaultComboBoxModel();
	private JComboBox boxEvent = new JComboBox(event);
	private JLabel probE = new JLabel ("Aucune alarme dans l'historique");
	private MoniteurA moniA;
	private MoniteurB moniB;
	
	public Historique(MoniteurA valMoniA, MoniteurB valMoniB) {
		
		this.moniA = valMoniA;
		this.moniB = valMoniB;
		
		this.setTitle("Historique des alertes traitées");
		this.setSize(800, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setLocation(820,10);
		
		JButton bouton = new JButton("Détails");
		this.getContentPane().add(bouton);
		bouton.setBounds(200, 200, 100, 30);
		bouton.addActionListener(this);
		
		JButton bouton2 = new JButton("Mise à jour");
		this.getContentPane().add(bouton2);
		bouton2.setBounds(520, 200, 100, 30);
		bouton2.addActionListener(this);
		
		JButton bouton3 = new JButton("Remise à zéro");
		this.getContentPane().add(bouton3);
		bouton3.setBounds(335, 200, 150, 30);
		bouton3.addActionListener(this);
		
		boxEvent.setBounds(100, 30, 600, 30);
		this.getContentPane().add(boxEvent);
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
        Event selectionEvent = (Event) this.boxEvent.getSelectedItem();
        String component = e.getActionCommand();
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
            alarmes.add(selectionEvent);
        }

        if (component=="Mise à jour") {
        	/*this.boxEvent.removeAllItems();*/ 
        	
        	for (Event evToAdd: moniA.getListe()) {
        		
        		if (event.getIndexOf(evToAdd) == -1) {
        			boxEvent.addItem(evToAdd);
           		}
        		/*System.out.println(evToAdd);*/
        	}
        	
        	for (Event evToAdd: moniB.getListe()) {
        		if (event.getIndexOf(evToAdd) == -1) {
        			boxEvent.addItem(evToAdd);
           		}
        	}
        }

        if (component=="Remise à zéro") {
           	this.boxEvent.removeAllItems(); 
           	moniA.effListe();
           	moniB.effListe();   
           	System.out.println("Listes effacées");

        }

    }

}

