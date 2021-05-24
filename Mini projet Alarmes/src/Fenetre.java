import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Fenetre extends JFrame implements ActionListener, ChangeListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] batiments = {"Localisation", "Batiment 1", "Batiment 2"};
	private JComboBox choixBat = new JComboBox(batiments);
	private String[] typeAnomalie = {"Type anomalie", "Gaz", "Radiation", "Incendie"};
	private JComboBox choixAnomalie = new JComboBox(typeAnomalie);
	private String[] nivAlarme = {"Niveau alarme", "1", "2", "3"};
	private JComboBox choixNivAlarme = new JComboBox(nivAlarme);
	private JTextField champDeTexte = new JTextField(".");
	private String res;
	private int entier;
	private JSlider nivRadiations = new JSlider(JSlider.HORIZONTAL,0, 100, 0);
	private EventSource source = new EventSource();
	private JLabel probN = new JLabel("Veuillez choisir un niveau d'alarme correct");
	private JLabel probB = new JLabel("Veuillez choisir une localisation correcte");
	private MoniteurA moniA;
	private MoniteurB moniB;
	
	public Fenetre(MoniteurA valMoniA, MoniteurB valMoniB) {
		this.setTitle("Alarmes");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(10,10);
		this.moniA = valMoniA;
		this.moniB = valMoniB;
		
		this.getContentPane().add(choixBat);
		choixBat.setBounds(150, 20, 100, 30);
		choixBat.addActionListener(this);
		this.getContentPane().add(choixAnomalie);
		choixAnomalie.setBounds(150, 70, 100, 30);
		choixAnomalie.addActionListener(this);
		this.getContentPane().add(choixNivAlarme);
		choixNivAlarme.setBounds(150, 120, 100, 30);
		choixNivAlarme.addActionListener(this);
		
		nivRadiations.addChangeListener(this);
        nivRadiations.setMajorTickSpacing(10);
        nivRadiations.setMinorTickSpacing(5);
        nivRadiations.setPaintTicks(true);
        nivRadiations.setPaintLabels(true);
		
		JButton bouton2 = new JButton("Declencher l'alarme");
		this.getContentPane().add(bouton2);
		bouton2.addActionListener(this);
		bouton2.setBounds(10, 220, 150, 30);
		
		JButton bouton3 = new JButton("Historique");
		this.getContentPane().add(bouton3);
		bouton3.addActionListener(this);
		bouton3.setBounds(225, 220, 150, 30);
		
		this.setVisible(true);
		champDeTexte.addFocusListener(new FocusAdapter() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        champDeTexte.setText("");
		    }
		});
		
		
	}
	
	public void stateChanged(ChangeEvent e) {
        JSlider source = (JSlider)e.getSource();
        entier = source.getValue();
    }

	public void actionPerformed(ActionEvent e) {
		String batChoisi = (String) choixBat.getSelectedItem();
		
		if (batChoisi == "Localisation") {
			
			this.getContentPane().add(probB);
			probB.setBounds(80, 45, 300, 30);
			probB.setVisible(true);
			
		}
		
		else {
			
			probB.setVisible(false);
			
		}
		
		String anomalieChoisie = (String) choixAnomalie.getSelectedItem();
		
		String nivChoisi = (String) choixNivAlarme.getSelectedItem();
		
		if (nivChoisi == "Niveau alarme") {
			
			this.getContentPane().add(probN);
			probN.setBounds(80, 145, 300, 30);
			probN.setVisible(true);
			
		}
		
		else {
			
			probN.setVisible(false);
			
		}
		
		String component = e.getActionCommand();

		if (component=="Declencher l'alarme") {
			
			if (anomalieChoisie == "Gaz") {
				res = champDeTexte.getText();
				source.genGazEvent(res,batChoisi,nivChoisi);
			}
			
			if (anomalieChoisie == "Radiation") {
				source.genRadiationEvent(entier, batChoisi,nivChoisi);
			}
			
			if (anomalieChoisie == "Incendie") {
				source.genIncendieEvent(batChoisi,nivChoisi);
			}
			
			
			nivRadiations.setVisible(false);
			champDeTexte.setVisible(false);
		}
		if (anomalieChoisie == "Radiation"){
            champDeTexte.setVisible(false);
            this.getContentPane().add(nivRadiations);
            nivRadiations.setBounds(50,170,300,50);
            this.setVisible(true);
            nivRadiations.setVisible(true);
        }
		
		if (anomalieChoisie == "Gaz"){
			
			nivRadiations.setVisible(false);
			champDeTexte.setText("Saisir le type de gaz");
			this.getContentPane().add(champDeTexte);
			champDeTexte.setBounds(140,170,120,30);
			this.setVisible(true);
			champDeTexte.setVisible(true);
		}
		
		if (anomalieChoisie == "Incendie"){
			
			nivRadiations.setVisible(false);
			champDeTexte.setVisible(false);

		}
		
		if (component == "Historique") {
			
			Historique histo = new Historique(moniA, moniB);
		}
	}
	
	public void addIncendieListener(EventIncendieListener c) {
		source.addIncendieListener(c);
	}
	
	public void addGazListener(EventGazListener c) {
		source.addGazListener(c);
	}

	public void addRadiationListener(EventRadiationListener c) {
		source.addRadiationListener(c);
	}

}
