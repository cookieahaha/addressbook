package me.kukkii.addressbook;

import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
 
//add window
public class ContactEntryView extends JFrame implements ActionListener{
 
		private ContactMainView contactMainView;
	
        private JPanel contentPane;
        private JTextField txtFirstName;
        private JTextField txtLastName;
        private JTextField txtEmail;
        private JTextField txtPhone;
        private JTextField txtStreet;
        private JTextField txtCity;
        private JTextField txtState;
        private JTextField txtZipCode;
        private JTextField txtNote;
       
        private ContactList contactList;
        private JButton btnCancel;

        /**
         * Launch the application.
         */
  
 // set contactList from ContactMainView
        public void setModel(ContactList contactList){
                this.contactList = contactList;
        }
       
//Create the frame
        public ContactEntryView() {
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setBounds(100, 100, 450, 571);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
                contentPane.setLayout(null);
               
                txtFirstName = new JTextField();
                txtFirstName.setText("first name");
                txtFirstName.setBounds(42, 17, 134, 28);
                contentPane.add(txtFirstName);
                txtFirstName.setColumns(10);
               
                txtLastName = new JTextField();
                txtLastName.setText("last name");
                txtLastName.setBounds(207, 17, 134, 28);
                contentPane.add(txtLastName);
                txtLastName.setColumns(10);
               
                txtEmail = new JTextField();
                txtEmail.setText("email");
                txtEmail.setBounds(42, 71, 134, 28);
                contentPane.add(txtEmail);
                txtEmail.setColumns(10);
               
                txtPhone = new JTextField();
                txtPhone.setText("phone");
                txtPhone.setBounds(42, 125, 134, 28);
                contentPane.add(txtPhone);
                txtPhone.setColumns(10);
               
                JButton btnAdd = new JButton("Add");
                btnAdd.setBounds(312, 499, 117, 29);
                contentPane.add(btnAdd);
                
                txtStreet = new JTextField();
                txtStreet.setText("street");
                txtStreet.setBounds(42, 177, 134, 28);
                contentPane.add(txtStreet);
                txtStreet.setColumns(10);
                
                txtCity = new JTextField();
                txtCity.setText("city");
                txtCity.setBounds(207, 177, 134, 28);
                contentPane.add(txtCity);
                txtCity.setColumns(10);
                
                txtState = new JTextField();
                txtState.setText("state");
                txtState.setBounds(368, 177, 50, 28);
                contentPane.add(txtState);
                txtState.setColumns(10);
                
                txtZipCode = new JTextField();
                txtZipCode.setText("zip code");
                txtZipCode.setBounds(42, 217, 134, 28);
                contentPane.add(txtZipCode);
                txtZipCode.setColumns(10);
                
                txtNote = new JTextField();
                txtNote.setText("note");
                txtNote.setBounds(42, 278, 376, 209);
                contentPane.add(txtNote);
                txtNote.setColumns(10);
                
                btnCancel = new JButton("Cancel");
                btnCancel.setBounds(183, 499, 117, 29);
                contentPane.add(btnCancel);
                
                btnAdd.addActionListener(this);
                btnCancel.addActionListener(this);
        }
 
        // set contactMainView from ContactMainView
    	public void setContactMainView(ContactMainView contactMainView){
    		this.contactMainView = contactMainView;
    	}
        
    	// actions when the button was clicked
        public void actionPerformed(ActionEvent event){
        	// actions when add button was clicked
        	String cmdName=event.getActionCommand();
                if("Add".equals(cmdName)){
                	String firstname = txtFirstName.getText();
                	String lastname = txtLastName.getText();
                	if (lastname == null || lastname.length() == 0){
                		JOptionPane.showMessageDialog(null, "Put First name");
                		return;
                	}
                	String email = txtEmail.getText();
                	if (this.testEmail(email) == false){
                		JOptionPane.showMessageDialog(null,"Email has to be ****@****.com");
                		return;
                	}
                	String phone = txtPhone.getText();
                	if (this.testPhone(phone) == false){
                		JOptionPane.showMessageDialog(null, "Phone has to be ***-***-****");
                		return;
                	}
                	String street = txtStreet.getText();
                	String city = txtCity.getText();
                	String state = txtState.getText();
                	String zipcode = txtZipCode.getText();
                	String note = txtNote.getText();
                	
                	Contact contact;
                	contact = new Contact();
                	
                	contact.setFirstName(firstname);
                	contact.setLastName(lastname);
                	contact.setEmail(email);
                	contact.setPhone(phone);
                	contact.setStreet(street);
                	contact.setCity(city);
                	contact.setState(state);
                	contact.setZipCode(zipcode);
                	contact.setNote(note);      
                	
                	contactList.addContact(contact);
                	contactList.sortLastName();
                	contactList.writeLinesToFile("addressbook.ser", false);
                	//contactList.printContactList();
                	
                	this.setVisible(false);
                	contactMainView.setVisible(false);     // close the window
                	contactMainView.getContentPane().removeAll();   // removes all information in contactMainView
            		contactMainView.setModel(contactList);       // set a new contactList with new contact
            		//contactMainView.pack();
            		contactMainView.setVisible(true);   // open the contactMainView window with new contact
           
          
        }
                // actions when Cancel button was clicked
                else if("Cancel".equals(cmdName)){
                	System.out.println("cancel method was called.");
                	this.setVisible(false);                	
                }

        }


// tests the syntax of the tempEmail. If it is correct it returns true, if it is incorrect it returns false.
        private boolean testEmail(String tempEmail) {
        	// Test if email is in the form name@domain. Also check there is only one @ in the String.

		int firstAt = tempEmail.indexOf("@");
		int lastAt = tempEmail.lastIndexOf("@");
		int com = tempEmail.indexOf(".com");

		if (null == tempEmail || tempEmail.isEmpty()) {
		return true;
		} else if (firstAt > 0 && lastAt < tempEmail.length() - 1
			&& firstAt == lastAt && com > 0) {
		return true;
		}
		return false;
	}


// tests the syntax of the tempPhone number. If it is correct it returns true, if it is incorrect it returns false.
	private boolean testPhone(String tempPhone) {
		int firstDash = tempPhone.indexOf("-");
		int secondDash = tempPhone.lastIndexOf("-");
		int phoneLength = tempPhone.length();

		if (null == tempPhone || tempPhone.isEmpty()) {
			return true;
		} else if (firstDash == 3 && secondDash == 7 && phoneLength == 12) {
			return true;
		}
		return false;
	}

}
