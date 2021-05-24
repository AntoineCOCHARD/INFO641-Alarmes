import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Infos_alarme extends JFrame implements ActionListener{
	private DateFormat format;
	public Infos_alarme(Event eventChoisi) {
		this.format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String type_a = eventChoisi.getTypeEvent();
		Date date_a = eventChoisi.getDate();
		String lieu_a = eventChoisi.getLieuAlarme();
		this.setTitle("Informations");
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setLocation(410,10);
		/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		
		if (eventChoisi.getNivAlarme() =="1") {
			this.getContentPane().setBackground(Color.YELLOW);
		}
		if (eventChoisi.getNivAlarme() =="2") {
			this.getContentPane().setBackground(Color.ORANGE);
		}
		if (eventChoisi.getNivAlarme() =="3") {
			this.getContentPane().setBackground(Color.RED);
		}
		JLabel type,date,lieu;
		type = new JLabel("Nature de l'alarme:   "+type_a);
		type = new JLabel("Nature de l'alarme:   "+type_a);
		if (type_a=="Radiation") {
			type = new JLabel("Nature de l'alarme:   "+type_a+" de niveau "+eventChoisi.getDetail());
		}
		if (type_a=="Gaz") {
			type = new JLabel("Nature de l'alarme:   "+type_a+" de type "+eventChoisi.getDetail());
		}
		type.setBounds(50, 30, 300, 30);
		date = new JLabel("Date et heure de l'alarme:   "+format.format(date_a));
		date.setBounds(50, 130, 300, 30);
		lieu = new JLabel("Lieu de l'alarme:   "+lieu_a);
		lieu.setBounds(50, 80, 200, 30);
		this.getContentPane().add(type);
		this.getContentPane().add(date);
		this.getContentPane().add(lieu);
		JButton bouton = new JButton ("Fermer");
		this.getContentPane().add(bouton);
		bouton.setBounds(50, 200, 100, 30);
		bouton.addActionListener(this);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		String component = e.getActionCommand();
		if (component=="Fermer") {
			this.dispose();
		}
	}
}
