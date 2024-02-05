package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.mainMVC;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PageCompte{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageCompte window = new PageCompte();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PageCompte() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		
		frame = new JFrame();
		frame.setBounds(550, 150, 909, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnDeconnecter = new JButton("deconnecter");
		btnDeconnecter.setBounds(754, 11, 120, 35);
		btnDeconnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mon Compte");
		lblNewLabel.setBounds(280, 11, 312, 100);
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 60));
		frame.getContentPane().add(lblNewLabel);
		
		JButton Button_Restituer = new JButton("Restituer");
		Button_Restituer.setBounds(10, 122, 282, 35);
		Button_Restituer.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		Button_Restituer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_Restituer f2 = new View_Restituer();
				f2.main(null);
			}
		});
		frame.getContentPane().add(Button_Restituer);
		
		JButton btnEmprunterParCode = new JButton("Emprunter par Code Barre");
		btnEmprunterParCode.setBounds(302, 122, 282, 35);
		btnEmprunterParCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_CodeBarre_Emprunte f2 = new View_CodeBarre_Emprunte();
				f2.main(null);
			}
		});
		btnEmprunterParCode.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(btnEmprunterParCode);
		
		JButton Button_ListeLivres = new JButton("Liste Livres");
		Button_ListeLivres.setBounds(592, 122, 282, 35);
		Button_ListeLivres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				View_ListLivres f1 = new View_ListLivres();
				f1.main(null);
			}
		});
		Button_ListeLivres.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(Button_ListeLivres);
		
		
		btnDeconnecter.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(btnDeconnecter);
		
		JLabel lblNewLabel_Nom = new JLabel("Nom :");
		lblNewLabel_Nom.setBounds(10, 215, 42, 25);
		lblNewLabel_Nom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_Nom);
		
		JLabel lblNewLabel_Prenom = new JLabel("Prénom :");
		lblNewLabel_Prenom.setBounds(10, 251, 60, 25);
		lblNewLabel_Prenom.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_Prenom);
		
		JLabel lblNewLabel_LivresEmpruntés = new JLabel("Livres Empruntés :");
		lblNewLabel_LivresEmpruntés.setBounds(10, 351, 113, 25);
		lblNewLabel_LivresEmpruntés.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_LivresEmpruntés);
		
		
		JLabel lblNewLabel_Email = new JLabel("Email :");
		lblNewLabel_Email.setBounds(10, 287, 50, 25);
		lblNewLabel_Email.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_Email);
		

		JLabel lblNewLabel_Nom_out = new JLabel("");
		lblNewLabel_Nom_out.setBounds(62, 221, 120, 14);
		frame.getContentPane().add(lblNewLabel_Nom_out);
		
		JLabel lblNewLabel_Prenom_out = new JLabel("");
		lblNewLabel_Prenom_out.setBounds(80, 257, 120, 14);
		frame.getContentPane().add(lblNewLabel_Prenom_out);
		
		JLabel lblNewLabel_Email_out = new JLabel("");
		lblNewLabel_Email_out.setBounds(70, 293, 120, 14);
		frame.getContentPane().add(lblNewLabel_Email_out);
		
		
		JLabel lblNewLabel_LibresE_out = new JLabel("");
		lblNewLabel_LibresE_out.setBounds(133, 357, 120, 14);
		frame.getContentPane().add(lblNewLabel_LibresE_out);

	}
}
