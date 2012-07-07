package me.kukkii.addressbook;

import java.io.Serializable;
 

//model class
public class Contact implements Serializable {
 
  private String firstName;
  private String lastName;
  private String email;
  private String phone;
  private String street;
  private String city;
  private String state;
  private String zipCode;
  private String note;
 
       
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
        
  public String getFirstName(){
    return firstName;
  }
        
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName(){
    return lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }
        
  public String getEmail(){
    return email;
  }
        
  public void setPhone(String phone) {
    this.phone = phone;
  } 
        
  public String getPhone(){
    return phone;
  }
        
  public void setStreet(String street) {
    this.street = street;
  }
       	 
  public String getStreet(){
    return street;
  }
        
  public void setCity(String city) {
    this.city = city;
  }
        
  public String getCity(){
    return city;
  }
        
  public void setState(String state) {
    this.state = state;
  }
       	
  public String state(){
    return state;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }
       			 
  public String getZipCode(){
    return zipCode;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getNote(){
    return note;
  }
 
  public void printContact() {
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Email: " + email);
    System.out.println("Phone: " + phone);
    if (street.length() == 0 && city.length() == 0 && state.length() == 0 && zipCode.length() == 0) { // If all address information is missing, the punctuation will not be printed.
      System.out.println("Address:");
    }
    else {
       System.out.println("Address: " + street + "\n" + "        " + city + " " + state + " " + zipCode);
    }
     System.out.println("Notes: " + note);
  }
        
}
 
