package me.kukkii.addressbook;

// view of the main window contains MenuPanel and ContactInformationPanelView
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollPane;

// ContactMainView
public class ContactMainView extends JFrame {

	private JPanel contentPane;
	private ContactList contactList;
	private JPanel panel;

// Launch the application
	public static void main(String[] args) {

		final ContactList contactList;
		contactList = new ContactList();

		contactList.init();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					ContactMainView frame = new ContactMainView();
					frame.setSize(500,1000);
					frame.setModel(contactList);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

//creates a new MenuPanelView and ContactInformationPanelView and get all indexes of the array 
	public void setModel(ContactList contactList) {

		this.contactList = contactList;
		
		MenuPanelView menuPanel = new MenuPanelView();
		menuPanel.setContactMainView(this);
		menuPanel.setModel(contactList);
		contentPane.add(menuPanel);
		
		Contact[] all = contactList.getAllContacts();
		for (int i = 0; i < contactList.getListSpot(); i++) {
				Contact contact = all[i];
				ContactInformationPanelView contactPanel = new ContactInformationPanelView(contact,true);
				contentPane.add(contactPanel);
				contactPanel.setModel(contactList);
				contactPanel.setContactMainView(this);

			}
	}
	
//Create the frame
	public ContactMainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
	}

}
