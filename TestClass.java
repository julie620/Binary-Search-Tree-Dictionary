import java.util.Scanner;
import java.security.SecureRandom;

public class TestClass {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Manager myBST = new Manager();
        System.out.println("Welcome to your User Info Dictionary");

        Boolean editing = true;

        do {
            editing = choice(myBST);
        }
        while(editing);
    }

    // displays menu options
    public static void menuOpt() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1) Add Entry");
        System.out.println("2) Delete Entry");
        System.out.println("3) Modify Entry");
        System.out.println("4) Lookup");
        System.out.println("5) List Number of Entries");
        System.out.println("6) Exit"); 
    } // end of intro method

    // keeps program running and options shown until user quits
    public static Boolean choice(Manager myBST) {
        menuOpt();
        int response = input.nextInt();
        input.nextLine();
        switch (response) {
            case 1: // Add Entry
                addOpt(myBST);
                break;
            case 2: // Delete Entry
                removeOpt(myBST);
                break;
            case 3:// Modify Entry
                modifyOpt(myBST);
                break;
            case 4: // Display Entries
                lookupOpt(myBST);
                break;
            case 5: // List Number of Entries

                break;
            case 6: // exit the program
                return false;
            default:
                System.out.println("That is not a valid option. Try again.");
        } // end of swtich statement
        return true;
    } // end of menu method

    // adds entries to the phone book
    public static void addOpt(Manager myBST) {
        SecureRandom random = new SecureRandom();
        int userNum;
        System.out.println("First Name: ");
        String firstName = input.nextLine();
        System.out.println("Last Name: ");
        String lastName = input.nextLine();
        System.out.println("Address: ");
        String address = input.nextLine();
        System.out.println("City: ");
        String city = input.nextLine();
        System.out.println("State: ");
        String state = input.nextLine();
        System.out.println("Zip: ");
        String zip = input.nextLine();
        System.out.println("Email: ");
        String email = input.nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input.nextLine();
        do {
            userNum = random.nextInt(101);
        }
        while (myBST.add(firstName, lastName, address, city, state, zip, email, phoneNumber, 
            userNum) != true);
        System.out.println("User Number: " + userNum);
    } // end of addOpt menu

    public static void removeOpt(Manager myBST) {
        System.out.println("\nWhich entry would you like to remove (Enter User Number)?");
        int entryNum = input.nextInt();
        input.nextLine();
        myBST.remove(entryNum);
        //myBST.removeTest(entryNum);
    } // end of removeOpt method

    // gets the index for modify entry option
    public static int entryIndex(Manager myBST) {
        System.out.println("\nWhich entry would you like to modify (Enter User Number)?");
        int entryNum = input.nextInt();
        input.nextLine();
        return entryNum;
    } // end of entryIndex method

    // gets field for modify entry option
    public static int fieldOpt(Manager myBST) {
        System.out.println("Which field would you like to modify?");
        System.out.println("1) First Name");
        System.out.println("2) Last Name");
        System.out.println("3) Address");
        System.out.println("4) City");
        System.out.println("5) State");
        System.out.println("6) Zip");
        System.out.println("7) Email");
        System.out.println("8) Phone Number");
        int field = input.nextInt();
        input.nextLine();
        return field;
    } // end of fieldOpt mehtod

    // modifies entries in phone book
    public static void modifyOpt(Manager myBST) {
        int userNum = entryIndex(myBST);
        int field = fieldOpt(myBST);
        System.out.print("Enter new information: ");
        switch(field) {
            case 1:
                modFirst(myBST, userNum);
                break;
            case 2:
                modLast(myBST, userNum);
                break;
            case 3:
                modAddress(myBST, userNum);
                break;
            case 4:
                modCity(myBST, userNum);
                break;
            case 5:
                modState(myBST, userNum);
                break;
            case 6:
                modZip(myBST, userNum);
                break;
            case 7:
                modEmail(myBST, userNum);
                break;
            case 8:
                modPhone(myBST, userNum);
                break;
        }   
    } // end of moidfyOpt method

    // modifies first name field of an entry
    public static void modFirst(Manager myBST, int userNum) {
        String newFirst = input.nextLine();
        myBST.modify(newFirst, myBST.lastName(userNum), myBST.address(userNum), 
            myBST.city(userNum), myBST.state(userNum), myBST.zip(userNum), myBST.email(userNum), 
            myBST.phoneNumber(userNum), userNum);
    } // end of modFirst method

    // modifies last name field of an entry
    public static void modLast(Manager myBST, int userNum) {
        String newLast = input.nextLine();
        myBST.modify(myBST.firstName(userNum), newLast, myBST.address(userNum), myBST.city(userNum), 
            myBST.state(userNum), myBST.zip(userNum), myBST.email(userNum), 
            myBST.phoneNumber(userNum), userNum);
    } // end of modLast method

    // modifies address field of an entry
    public static void modAddress (Manager myBST, int userNum) {
        String newAddress = input.nextLine();
        myBST.modify(myBST.firstName(userNum), myBST.lastName(userNum), newAddress, 
            myBST.city(userNum), myBST.state(userNum), myBST.zip(userNum), myBST.email(userNum), 
            myBST.phoneNumber(userNum), userNum);
    } // end of modAddress method

    // modifies city field of an entry
    public static void modCity(Manager myBST, int userNum) {
        String newCity = input.nextLine();
        myBST.modify(myBST.firstName(userNum), myBST.lastName(userNum), myBST.address(userNum), newCity, 
            myBST.state(userNum), myBST.zip(userNum), myBST.email(userNum), 
            myBST.phoneNumber(userNum), userNum);
    } // end of modCity method

    // modifies state field of an entry
    public static void modState(Manager myBST, int userNum) {
        String newState = input.nextLine();
        myBST.modify(myBST.firstName(userNum), myBST.lastName(userNum), myBST.address(userNum), 
            myBST.city(userNum), newState, myBST.zip(userNum), myBST.email(userNum), 
            myBST.phoneNumber(userNum), userNum);
    } // end of modState method

    // modifies zip field of an entry
    public static void modZip(Manager myBST, int userNum) {
        String newZip = input.nextLine();
        myBST.modify(myBST.firstName(userNum), myBST.lastName(userNum), myBST.address(userNum), 
            myBST.city(userNum), myBST.state(userNum), newZip, myBST.email(userNum), 
            myBST.phoneNumber(userNum), userNum);
    } // end of modZip method

    // modifies email field of an entry
    public static void modEmail(Manager myBST, int userNum) {
        String newEmail = input.nextLine();
        myBST.modify(myBST.firstName(userNum), myBST.lastName(userNum), myBST.address(userNum), 
            myBST.city(userNum), myBST.state(userNum), myBST.zip(userNum), newEmail, 
            myBST.phoneNumber(userNum), userNum);
    } // end of modEmail method

    // modifies phone number field of an entry
    public static void modPhone(Manager myBST, int userNum) {
        String newPhoneNum = input.nextLine();
        myBST.modify(myBST.firstName(userNum), myBST.lastName(userNum), myBST.address(userNum), 
            myBST.city(userNum), myBST.state(userNum), myBST.zip(userNum), myBST.email(userNum), 
            newPhoneNum, userNum);
    } // end of modPhone method

    // gets lookup option
    public static int lookupType(Manager myBST) {
        System.out.println("What type of lookup would you like?");
        System.out.println("1) Inorder");
        System.out.println("2) Preorder");
        System.out.println("3) Postorder");
        int type = input.nextInt();
        input.nextLine();
        return type;
    } // end of lookupOpt mehtod

    // modifies entries in phone book
    public static void lookupOpt(Manager myBST) {
        int type = lookupType(myBST);
        switch(type) {
            case 1:
                myBST.inorder(myBST.traversal());
                break;
            case 2:
                myBST.preorder(myBST.traversal());
                break;
            case 3:
                myBST.postorder(myBST.traversal());
                break;
        }   
    } // end of lookupOpt method
}// end of TestClass