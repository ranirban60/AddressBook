package com.bridgelabz;

import java.util.HashMap;
import java.util.Scanner;

public class AddressBook {
    static String name;

    public static void main(String[] args){

        System.out.println("Welcome to the ADDRESS BOOK");
        HashMap<String,ContactInfo> addressBook = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 to create a new contact");
        int choice = scanner.nextInt();
        if (choice==1){
            ContactInfo contact = new ContactInfo();
            contact.setContactInfo();
            name = contact.firstName + " " + contact.lastName;
            addressBook.put(name,contact);
            addressBook.get(name).displayContactInfo();
        }

    }
}

class ContactInfo{
    String firstName,lastName,address,city,state,zipcode,phoneNo,email;

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }
    public void setLastName(String lastName){
        this.lastName=lastName;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setState(String state){
        this.state=state;
    }
    public void setZipcode(String zipcode){
        this.zipcode=zipcode;
    }
    public void setPhoneNo(String phoneNo){
        this.phoneNo=phoneNo;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public void setContactInfo() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter First Name: \n Last Name: \n Address: \n City: \n State: \n Zipcode: \n PhoneNO: \n Email: \n");
        setFirstName(sc.nextLine());
        setLastName(sc.nextLine());
        setAddress(sc.nextLine());
        setCity(sc.nextLine());
        setState(sc.nextLine());
        setZipcode(sc.nextLine());
        setPhoneNo(sc.nextLine());
        setEmail(sc.nextLine());
    }
    public void displayContactInfo(){
        System.out.print("First Name: "+firstName+"\n Last Name: "+lastName+"\n Address: "+address+
                "\n City: "+city+"\n State: "+state+ "\n Zipcode: "+zipcode+"\n PhoneNO: "+phoneNo+"\n Email: "+email);
    }

}
