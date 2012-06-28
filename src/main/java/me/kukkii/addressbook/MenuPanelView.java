package me.kukkii.addressbook;

// menu panel for ContactMainView

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.Scanner;

// menu panel
public class MenuPanelView extends JPanel implements ActionListener{

	private ContactMainView contactMainView;
	private ContactList contactList;
	
	private JTextField searchField;

 //Create the panel 
	public MenuPanelView() {
		setLayout(new FlowLayout());
		
		JButton btnNewContact = new JButton("New contact");
		add(btnNewContact);
		btnNewContact.addActionListener(this);

		searchField = new JTextField("search",15);
		add(searchField);
		
		JButton btnGo = new JButton("GO!");
		add(btnGo);
		btnGo.addActionListener(this);
	}
	
// get Contactlist contactlist from ContactMainView 	
	public void setModel(ContactList contactlist){
		this.contactList = contactlist;
	}
	
// get ContactMainView contactMainView from ContactMainView 	
	public void setContactMainView(ContactMainView contactMainView){
		this.contactMainView = contactMainView;
	}
	
// actions when the button btnNewContact was clicked	
	public void actionPerformed(ActionEvent event){
		String cmdName=event.getActionCommand();
        if("New contact".equals(cmdName)){
        	ContactEntryView frame = new ContactEntryView();
        	frame.setModel(contactList);	
        	frame.setContactMainView(contactMainView);	
        	frame.setVisible(true);
        }
        else if("GO!".equals(cmdName)){
        	this.search();
        }
	}
	
    	// This method searches by Last Name, Email, or Zip Code. if found it prints the contact's information searched or prints "not found". (WNG)
    	public void search() {
    		String search;
    		search = searchField.getText();

    		int count = 0;

    		JFrame searchWindow = new JFrame();
    		searchWindow.setSize(500,500);
    		
    		Contact[] list = contactList.getAllContacts();
    		for (int e = 0; e < contactList.getListSpot(); e++) {
    				Contact contact = list[e];
    				if (search.equalsIgnoreCase(list[e].getLastName())
        					|| search.equalsIgnoreCase(list[e].getEmail())
        					|| search.equalsIgnoreCase(list[e].getZipCode())) {
    						ContactInformationPanelView contactPanel = new ContactInformationPanelView(contact,false);
    						searchWindow.getContentPane().add(contactPanel);
    						count = count + 1;
    				}
    		}
    		if (count < 1) {
    				JOptionPane.showMessageDialog(null,"No matches found for: " + search);
    				return;
    		}
    		searchWindow.setVisible(true);
    	}
    	
        
}
