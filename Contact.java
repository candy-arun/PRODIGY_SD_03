import java.util.Scanner;
import java.util.ArrayList;
class Contact
{
    private String name;
    private String phoneNumber;
    private String emailAddress;
    public String getName() {
        return name;
    }
    public void setName(String contactName){
        name = contactName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String number) {
        phoneNumber = number;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailid) {
        emailAddress = emailid;
    }
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail Address: " + emailAddress;
    }
}
class ContactManager
{
    ArrayList<Contact> contacts = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter email address: ");
        String emailAddress = sc.nextLine();
        Contact n = new Contact();
        n.setName(name);
        n.setPhoneNumber(phoneNumber);
        n.setEmailAddress(emailAddress);
        contacts.add(n);
        System.out.println("Contact added successfully");
    }
    public void viewContacts() {
        if (contacts.size()==0) {
            System.out.println("No contacts available.\n");
        } else {
            for (Contact n : contacts) {
                System.out.println(n);
            }
        }
    }
    public void editContact() {
        System.out.print("Enter the name of the contact you want to edit: ");
        String nameToEdit = sc.nextLine();

        for (Contact n : contacts) {
            if (n.getName().equalsIgnoreCase(nameToEdit)) {
                System.out.print("Enter new phone number: ");
                String newPhoneNumber = sc.nextLine();
                System.out.print("Enter new email address: ");
                String newEmailAddress = sc.nextLine();

                n.setPhoneNumber(newPhoneNumber);
                n.setEmailAddress(newEmailAddress);

                System.out.println("Contact updated successfully");
                return;
            }
        }
        System.out.println("Contact is not found");
    }
    public void deleteContact() {
        System.out.print("Enter the name of the contact you want to delete: ");
        String nameToDelete = sc.nextLine();

        for (Contact n : contacts) {
            if (n.getName().equalsIgnoreCase(nameToDelete)) {
                contacts.remove(n);
                System.out.println("Contact is deleted successfully");
                return;
            }
        }

        System.out.println("Contact is not found");
    }
}
class Contactapp {
    public static void main(String[] args) {
        ContactManager obj = new ContactManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Contact Management System" + "\n 1. Add Contact" + "\n 2. View Contacts" + "\n 3. Edit Contact" + "\n 4. Delete Contact" + "\n 5. Exit" );
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    obj.addContact();
                    break;
                case 2:
                    obj.viewContacts();
                    break;
                case 3:
                    obj.editContact();
                    break;
                case 4:
                    obj.deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting the program");
                    sc.close();
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}