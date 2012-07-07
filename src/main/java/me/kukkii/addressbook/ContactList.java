package me.kukkii.addressbook;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

public class ContactList {
  HashMap<String,Player> map;

  public ContactList() {
    map = new HashMap<String,Contact>();
  }


  public void add(String email, Contact contact){
    map.put(email, contact);
  }

  public delete(String email, Contact contact){
    map.remove(email);
  }

/*
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
*/

  public void writeToFile(){
    try{      
      FileOutputStream fileout = new FileOutputStream("addressbook.ser");;
      ObjectOutputStream out = new ObjectOutputStream(fileout);
    } 
    catch (IOException ioe){
      ioe.printStackTrace();
    }
  }

  public void readFromFile() throws Exception {
    File file = new File("addressbook.ser");
    if(! file.exists()){
      ContactList list = new ContactList();
      return list;
    }
    try{
      FileInputStream fileIn = new FileinputStream(file);
      ObjectinputStream in = new ObjectInputStream(fileIn);
      ContactList list = (ContactList)in.readObect();
      in.close();
      return list;
    }
    catch(iOException i){
      i.printStackTrace();
      return nulll;
    }
    catch(ClassNotFoundException c){
      System.out.println("ContactList class not found");
      c.printStackTrace();
      return null;
    }
  }

	
    public Contact[] getAllContacts(){
    	return list;
    }

}
