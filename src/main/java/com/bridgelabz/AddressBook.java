package com.bridgelabz;

import java.util.*;

public class AddressBook {
    static String name;
    int xz;
    static boolean is_Running = false;
    public HashMap<String, ContactInfo> addressBook;
    public ArrayList<ContactInfo> listOfContacts = new ArrayList<>();



    public AddressBook() {
        addressBook = new HashMap<>();
    }

    //Driver code
    public static void main(String[] args) {


        HashMap<String, AddressBook> multiAdressBook = new HashMap<>();
        System.out.println("Welcome to the ADDRESS BOOK");

        AddressBook obj=new AddressBook();

        AddressBook addressBookObj1 = new AddressBook();
        AddressBook addressBookObj2 = new AddressBook();
        AddressBook addressBookObj3 = new AddressBook();
        multiAdressBook.put("AB1", addressBookObj1);
        multiAdressBook.put("AB2", addressBookObj2);
        multiAdressBook.put("AB3", addressBookObj3);

        for (Map.Entry<String,AddressBook> addressbookEntry : multiAdressBook.entrySet()) {
            addressbookEntry.getKey();
        }

        while (!is_Running) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 ,2 ,3 for diff addressBook and 4 to exit");
            int option = scanner.nextInt();
            String key = switch (option) {
                case 1 -> "AB1";
                case 2 -> "AB2";
                case 3 -> "AB3";
                default -> null;
            };
            if (option == 4) break;
            System.out.println(" Enter \n 1 to create a new contact \n 2 to exit \n 3 to edit existing contact \n 4 to delete an existing contact");
            int choice = scanner.nextInt();
            if (choice == 1) {
                ContactInfo contact = new ContactInfo();
                contact.setContactInfo();
                name = contact.firstName.toUpperCase(Locale.ROOT) + " " + contact.lastName.toUpperCase(Locale.ROOT);
                if (multiAdressBook.get(key).addressBook.keySet().stream().noneMatch(k -> k.equals(name))){                 //JAVA STREAMS is used to check if any duplicate
                    multiAdressBook.get(key).addressBook.put(name, contact);
                    multiAdressBook.get(key).listOfContacts.add(contact);                                                                                                     //contact already exist in the addressBook
                    multiAdressBook.get(key).addressBook.get(name).displayContactInfo();
                }
                else System.out.println("Contact already exist duplicate not allowed");
            } else if (choice == 2) {
                is_Running = true;
            } else if (choice == 3) {
                multiAdressBook.get(key).editContact();
            } else if (choice == 4) {
                multiAdressBook.get(key).deleteContact();
            }
        }
        obj.searchContactBasedOnCity(multiAdressBook);
    }

    /**
     * Method to delete an existing contact
     */
    public void deleteContact() {
        int xc;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first and last name of the contact you want to delete from AddressBook: ");
        String name = scanner.nextLine().toUpperCase(Locale.ROOT);
        if (addressBook.containsKey(name)) {
            addressBook.remove(name);
            System.out.println("Contact removed");
        } else
            System.out.println("Contact not found");
    }

    /**
     * Method to edit an existing contact
     */
    public void editContact() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your first name and Last name  : ");
        String name = sc.nextLine().toUpperCase(Locale.ROOT);
        if (addressBook.containsKey(name)) {
            System.out.println("Enter the number you want to edit\n1.Address\n2.City\n3.State\n4.Zipcode\n5.Phone Number\n6.Email");
            int number = sc.nextInt();
            sc.nextLine();
            switch (number) {
                case 1 -> {
                    System.out.println("Enter new Address");
                    addressBook.get(name).setAddress(sc.nextLine());
                }
                case 2 -> {
                    System.out.println("Enter new City");
                    addressBook.get(name).setCity(sc.nextLine());
                }
                case 3 -> {
                    System.out.println("Enter new State");
                    addressBook.get(name).setState(sc.nextLine());
                }
                case 4 -> {
                    System.out.println("Enter new ZipCode");
                    addressBook.get(name).setZipcode(sc.nextLine());
                }
                case 5 -> {
                    System.out.println("Enter new Phone number");
                    addressBook.get(name).setPhoneNo(sc.nextLine());
                }
                case 6 -> {
                    System.out.println("Enter new Email");
                    addressBook.get(name).setEmail(sc.nextLine());
                }
                default -> System.out.println("Please input a valid number (1-6)");
            }
            addressBook.get(name).displayContactInfo();
        } else System.out.println("Contact not found");
    }

    /**
     * UC8 Method
     */
    public void searchContactBasedOnCity(HashMap<String,AddressBook> multiAddressBook){

        HashMap<String,String> personCityDictionary = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the city to search the contacts based on city");
        String searchCity = scanner.nextLine();
        int counter=0;

        for (Map.Entry<String,AddressBook> addressBookEntry: multiAddressBook.entrySet()) {
            addressBookEntry.getKey();
            AddressBook currentAddressBook = addressBookEntry.getValue();
            for (ContactInfo item: currentAddressBook.listOfContacts) {
                System.out.println();
                System.out.println(item.showContact());
            }

        }

        for (Map.Entry<String,AddressBook> addressBookEntry: multiAddressBook.entrySet()) {
            System.out.println(addressBookEntry.getKey());
            for (Map.Entry<String,ContactInfo> contactEntry: addressBookEntry.getValue().addressBook.entrySet()) {
                String result = addressBookEntry.getValue().addressBook.get(contactEntry.getKey()).showContact();
                System.out.println(contactEntry.getKey());
                if (result.contains(searchCity)){
                    personCityDictionary.put(contactEntry.getKey(),searchCity);
                    counter++;
                }
            }
        }
        for (Map.Entry<String,String> pEntry : personCityDictionary.entrySet() ) {
            System.out.println("Key= "+pEntry.getKey()+", Value= "+ pEntry.getValue());
        }
        System.out.println("No of contacts from the searched city were: "+counter);
    }
}

/**
 * Template class for creating a contact
 */
class ContactInfo {
    String firstName, lastName, address, city, state, zipcode, phoneNo, email;

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

    /**
     * Method to display the contact details
     */
    public void displayContactInfo() {
        System.out.print(" First Name: " + firstName + "\n Last Name: " + lastName + "\n Address: " + address +
                "\n City: " + city + "\n State: " + state + "\n Zipcode: " + zipcode + "\n PhoneNO: " + phoneNo + "\n Email: " + email + "\n");
    }

    public String showContact(){
        return  " First Name: " + firstName + "\n Last Name: " + lastName + "\n Address: " + address +
                "\n City: " + city + "\n State: " + state + "\n Zipcode: " + zipcode + "\n PhoneNO: " + phoneNo + "\n Email: " + email + "\n";
    }
}