package me.kukkii.addressbook;

import java.io.Serializable;
 

//model class
public class Contact implements Serializable {
 
        private static final long serialVersionUID = 1L;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private String street;
        private String city;
        private String state;
        private String zipCode;
        private String note;
 
        //the following set methods sets the local variables for the current instance in the array.
       
        //This method sets the values for the variables of the Contact Class. (Every member on Team 10)
        public void setFirstName(String firstName) {
       	 this.firstName = firstName;
        }
        
        // This method returns the value for first name
        public String getFirstName(){
       	 return firstName;
        }
        
       //This method sets the values for last name
       public void setLastName(String lastName) {
       	 this.lastName = lastName;
       }

       // This method returns the value for last name
       public String getLastName(){
       	 return lastName;
       }

       //This method sets the values for email
        public void setEmail(String email) {
       	 this.email = email;
        }
        
        // This method returns the value for first name
        public String getEmail(){
       	 return email;
        }
        
       //This method sets the values for phone
        public void setPhone(String phone) {
       	 this.phone = phone;
        } 
        
        // This method returns the value for phone
        public String getPhone(){
       	 return phone;
        }
        
        // This method sets the values for street
        public void setStreet(String street) {
       	 this.street = street;
        }
       	 
        // This method returns the value for street
        public String getStreet(){
       	 return street;
        }
        
       	// This method sets the values for city
        public void setCity(String city) {
       	 this.city = city;
        }
        
        // This method returns the value for city
        public String getCity(){
       	 return city;
        }
        
       //This method sets the values for state
       public void setState(String state) {
       	 this.state = state;
       }
       	
       // This method returns the value for state
       public String state(){
       	 return state;
       }

       //This method sets the values for zip code
       public void setZipCode(String zipCode) {
       	 this.zipCode = zipCode;
       }
       			 
       // This method returns the value for zip code
       public String getZipCode(){
       	 return zipCode;
       }

       public void setNote(String note) {
       	this.note = note;
       }

       // This method returns the value for note
       public String getNote(){
       	 return note;
       }
 
        // This method prints the all the Contact's information
        public void printContact() {
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Email: " + email);
                System.out.println("Phone: " + phone);
                if (street.length() == 0 && city.length() == 0 && state.length() == 0
                                && zipCode.length() == 0) { // If all address information is missing, the punctuation will not be printed.
                        System.out.println("Address:");
                } else {
                        System.out.println("Address: " + street + "\n" + "        " + city
                                        + " " + state + " " + zipCode);
                }
                System.out.println("Notes: " + note);
        }
        
}
 
