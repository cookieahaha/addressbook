package me.kukkii.addressbook;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;


//Controller class. Has all the verbs of the program, and defines the array of contacts. (everyone)
public class ContactList {

	private static final long serialVersionUID = 1L;
	static final String STORE_FILE = "contacts.txt";
	private static final int LIMIT = 100; // static because each instance doesn't have to have a different value.
	Contact[] list; // array that gets and stores all the contact objects
	private int listSpot = 0; // holds the next empty spot in the array


	// This method sets the limit of the list with LIMIT values of type integer.
	public ContactList() {
		list = new Contact[LIMIT];
	}


	  // This method adds a new contact to the array list. (Every member on Team 10)
    public void addContact(Contact contact) {
    	   if (listSpot <= LIMIT) {
    		   list[listSpot] = contact;
            		//System.out.println("Method addContact was called.");
    		   listSpot = listSpot+1;
    				return;
    			}
    		}

    // This method deletes a contact from the array list. (Every member on Team 10)
    public void deleteContact(Contact contact) {
            for (int i=0; i<listSpot; i++){
            		if(list[i].getEmail().equals(contact.getEmail()) ){
            			//list[i] = null;
            			for (int j=i; j<listSpot-1; j++){
            				list[j] = list[j+1];
            			}
            			listSpot = listSpot-1;
           				break;
            		}
            }
    		//System.out.println("Method deleteContact was called.");
    }

	// This method sorts the array by Last names (WNG)
	public void sortLastName() {
		int in;
		int out;
		for (out = 1; out < listSpot; out++) {
			Contact temp = list[out];
			in = out;

			while (in > 0 && list[in - 1].getLastName().toLowerCase().compareTo(temp.getLastName().toLowerCase()) > 0) {
				list[in] = list[in - 1]; // shift item to the right
				--in; // go left one position
			}
			list[in] = temp;
		} 
	}


	// This method writes and saves the information into a text file to disk.
	public void writeLinesToFile(String filePath, boolean appendToFile) {
		FileOutputStream outFileStream;
		ObjectOutputStream outObjectStream;
		try {
			outFileStream = new FileOutputStream(filePath);
			outObjectStream = new ObjectOutputStream(outFileStream);
			for (int i = 0; i < listSpot; i++) {
				outObjectStream.writeObject(list[i]);
			}
			outObjectStream.flush();
			outObjectStream.close();
			outFileStream.close();
		} catch (IOException ioe) {
			System.out.println("Error writing objects to the file: "
					+ ioe.getMessage());
			ioe.printStackTrace();
		}
		System.err.println("writing to file succesfully!");
	}


	// This method reads the saved file into the array Contact[] list
    public void readContactsFromFile() throws Exception {
        FileInputStream inFileStream = null;
        ObjectInputStream inObjectStream = null;

        System.err.println("Reading in Contacts from File...");

        try {
                inFileStream = new FileInputStream("contacts.txt");
                inObjectStream = new ObjectInputStream(inFileStream);

                // Reset listSpot to read in Contacts
                listSpot = 0;

                // Read in each Contact from the store file and assign to list
                // Contact[].
                // Assign current read Contact position to listSpot.
                boolean keepGoing = true;

                while (keepGoing) {

                        Contact readContact = (Contact) inObjectStream.readObject();
                        if (null == readContact) {
                               
                        } else {

                                list[listSpot] = readContact;
                                listSpot++;
                        }
                }

        } catch (EOFException eof) {
                System.err.println("EOF: Finished reading in Contacts");

        } catch (IOException ioe) {
                System.err.println("Error reading from the file: "
                                + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
                System.err.println("Error in casting to Object: " + cnfe);

        } finally {
                if (inFileStream != null)
                        inFileStream.close();
                if (inObjectStream != null)
                        inObjectStream.close();
        }

}


	//initiates the program.
	public void init() {
		try {
			readContactsFromFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//get all contact's information
    public Contact[] getAllContacts(){
    	return list;
    }

    public int getListSpot(){
    	return listSpot;
    }
    
    /*
	public void printContactList() {

		System.out.println("Printing Contact List");
		for (int i = 0; i < listSpot; i++) {
			if (list[i] != null) { // print list[i] only if list[i] IS NOT(!=)
				// null
				System.out.println("===========================");
				list[i].printContact();
			}
		}
	}
*/
  
   
}

