package me.kukkii.addressbook;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;


public class MainPanelView extends JPanel implements ActionListener{

	private ContactMainView contactMainView;
	private ContactList contactList;
	
    private JButton btnNewContact;
	
	/**
	 * Create the panel.
	 */
	public MainPanelView() {
		setLayout(null);
		
		JButton btnNewContact = new JButton("New contact");
		btnNewContact.setBounds(6, 6, 117, 29);
		add(btnNewContact);
		btnNewContact.addActionListener(this);

	}
	
	public void setModel(ContactList contactlist){
		this.contactList = contactlist;
	}
	
	public void setContactMainView(ContactMainView contactMainView){
		this.contactMainView = contactMainView;
	}
	
	public void actionPerformed(ActionEvent event){
		ContactEntryView frame = new ContactEntryView();
		frame.setModel(contactList);
		frame.setContactMainView(contactMainView);
        frame.setVisible(true);
    }
	
}
