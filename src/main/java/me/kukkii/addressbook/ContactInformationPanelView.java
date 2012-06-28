package me.kukkii.addressbook;

//a contact information panel for ContactMainView
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.*;

//ContactInformationPanel
public class ContactInformationPanelView extends JPanel implements ActionListener{
	
    private ContactList contactList;
    private Contact contact;
	private ContactMainView contactMainView;

	
//Create the panel
	public ContactInformationPanelView(Contact contact,boolean hasDeleteButton) {
		this.contact = contact;
		setLayout(null);
		
		JLabel lblFirstName = new JLabel(contact.getFirstName());
		lblFirstName.setBounds(24, 31, 103, 16);
		add(lblFirstName);
		
		JLabel lblLastName = new JLabel(contact.getLastName());
		lblLastName.setBounds(139, 31, 111, 16);
		add(lblLastName);
		
		JLabel lblPhone = new JLabel(contact.getPhone());
		lblPhone.setBounds(23, 53, 227, 16);
		add(lblPhone);
		
		JLabel lblEmail = new JLabel(contact.getEmail());
		lblEmail.setBounds(24, 73, 242, 16);
		add(lblEmail);
		
		JLabel lblStreet = new JLabel(contact.getStreet());
		lblStreet.setBounds(24, 94, 185, 16);
		add(lblStreet);
		
		JLabel lblCity = new JLabel(contact.getCity());
		lblCity.setBounds(24, 111, 226, 16);
		add(lblCity);
		
		JLabel lblState = new JLabel(contact.getStreet());
		lblState.setBounds(139, 111, 61, 16);
		add(lblState);
		
		JLabel lblZipCode = new JLabel(contact.getZipCode());
		lblZipCode.setBounds(24, 129, 61, 16);
		add(lblZipCode);
		
		if ( hasDeleteButton == true){   // when boolean HasDeleteButton is false, window without delete button will be pop up 
			JButton btnDelete = new JButton("delete");
			btnDelete.setBounds(361, 26, 72, 29);
			add(btnDelete);

			btnDelete.addActionListener(this);
		}
	}
	
// get ContactList contactList from ContactMainView
	public void setModel(ContactList contactList) {
		this.contactList = contactList;
	}
	
// get ContactMainView contactMainView from ContactMainView
	public void setContactMainView(ContactMainView contactMainView){
		this.contactMainView = contactMainView;
	}
	
// actions when the delete button was clicked
		public void actionPerformed(ActionEvent event){
			contactList.deleteContact(contact);
			contactList.writeLinesToFile("contacts.txt", false);
			
			contactMainView.setVisible(false);
        	contactMainView.getContentPane().removeAll();
    		contactMainView.setModel(contactList);
    		//contactMainView.pack();
    		contactMainView.setVisible(true);
	}
}
