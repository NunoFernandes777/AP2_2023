package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.SwingConstants;

import controller.mainMVC;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import controller.mainMVC;
import javax.swing.JList;

public class View_CreationGenre {
	private JFrame frame;
	private JTextField textField_Genre;
	private DefaultListModel<String> listModel;
    private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_CreationGenre window = new View_CreationGenre();
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
	public View_CreationGenre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        frame = new JFrame();
        frame.setBounds(550, 150, 909, 481);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setBounds(461, 11, 422, 420);

        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { 
                    int index = list.locationToIndex(e.getPoint()); 
                    String item = listModel.getElementAt(index); 

                }
            }
        });
        
        for (int i = 0; i != mainMVC.getM().getListGenre().size(); i++) {
            listModel.addElement(mainMVC.getM().getListGenre().get(i).LigneGenre());
        }
        
        frame.getContentPane().add(list);
		
		JButton btnNewButton_Back = new JButton("<=");
		btnNewButton_Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PageCompte f1 = new PageCompte();
                PageCompte.main(null);
			}
		});
		btnNewButton_Back.setBounds(20, 11, 50, 25);
		frame.getContentPane().add(btnNewButton_Back);
		
		JLabel lblNewLabel_Titre_Creation = new JLabel("Creation Genres");
		lblNewLabel_Titre_Creation.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_Titre_Creation.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_Titre_Creation.setBounds(92, 90, 279, 62);
		frame.getContentPane().add(lblNewLabel_Titre_Creation);
		
		JLabel lblNewLabel_Creation_genre = new JLabel("genre :");
		lblNewLabel_Creation_genre.setBounds(96, 205, 46, 14);
		frame.getContentPane().add(lblNewLabel_Creation_genre);
		
		textField_Genre = new JTextField();
		textField_Genre.setBounds(152, 202, 194, 20);
		frame.getContentPane().add(textField_Genre);
		textField_Genre.setColumns(10);
		
		JButton btnNewButton_Creation = new JButton("Creer");
		btnNewButton_Creation.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String genre = textField_Genre.getText(); // Supondo que textFieldGenre seja o campo onde o usuário insere o gênero
		        try {
		            mainMVC.getM().creer_genre(genre);
		        } catch (SQLException ex) {
		            // Lide com a exceção apropriadamente, por exemplo, mostrando uma mensagem de erro
		            ex.printStackTrace();
		        }
		    }
		});
		btnNewButton_Creation.setBounds(37, 371, 105, 35);
		frame.getContentPane().add(btnNewButton_Creation);
		
		JButton btnNewButton_Creation_1 = new JButton("Editer");
		btnNewButton_Creation_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_Creation_1.setBounds(180, 371, 105, 35);
		frame.getContentPane().add(btnNewButton_Creation_1);
		
		JButton btnNewButton_Creation_2 = new JButton("Supprimer");
        btnNewButton_Creation_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String selectedGenre = list.getSelectedValue();
                if (selectedGenre != null) {
                    try {

                        mainMVC.getM().supprimer_genre(selectedGenre);

                        listModel.removeElement(selectedGenre);
                    } catch (SQLException ex) {

                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton_Creation_2.setBounds(318, 371, 105, 35);
        frame.getContentPane().add(btnNewButton_Creation_2);
		
		
		
	}
}
