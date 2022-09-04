package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Template class for creating a contact
 */
class ContactInfo {
    String firstName, lastName, address, city, state, zipcode, phoneNo, email;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to save contact details
     */
    public void setContactInfo() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter \n First Name: \n Last Name: \n Address: \n City: \n State: \n Zipcode: \n PhoneNO: \n Email: \n");
        setFirstName(sc.nextLine());
        setLastName(sc.nextLine());
        setAddress(sc.nextLine());
        setCity(sc.nextLine());
        setState(sc.nextLine());
        setZipcode(sc.nextLine());
        setPhoneNo(sc.nextLine());
        setEmail(sc.nextLine());
    }

    /**
     * Method to display the contact details
     */
    public void displayContactInfo() {
        System.out.print(" First Name: " + firstName + "\n Last Name: " + lastName + "\n Address: " + address +
                "\n City: " + city + "\n State: " + state + "\n Zipcode: " + zipcode + "\n PhoneNO: " + phoneNo + "\n Email: " + email + "\n");
    }

    public String showContact() {
        return  firstName + "," + lastName + "," + address +
                "," + city + "," + state + "," + zipcode + "," + phoneNo + "," + email + "\n";
    }
}