//Name: Juliana Serrano
//Date: 11/26/2024
//Lab 6: Binary Search Tree Dictionary
// strutures nodes for BST; 9 data fields for user information entry (Class 1 of 3)

public class Node {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phoneNumber;
    private int userNum;
    Node left;
    Node right;

    public Node(String firstName, String lastName, String address, String city, String state, 
        String zip, String email, String phoneNumber, int userNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userNum = userNum;
        this.left = null;
        this.right = null;
    } // end of Node constructor

    public Node(String firstName, String lastName, String address, String city, String state, 
        String zip, String email, String phoneNumber, int userNum, Node left, Node right) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userNum = userNum;
        this.left = left;
        this.right = right;
    } // end of node constructor

    public String getFirstName() {
        return firstName;
    } // end of getFirstName method

    public String getLastName() {
        return lastName;
    } // end of getLastName method

    public String getAddress() {
        return address;
    } // end of getAddress method

    public String getCity() {
        return city;
    } // end of getCity method

    public String getState() {
        return state;
    } // end of getState method

    public String getZip() {
        return zip;
    } // end of getZip method

    public String getEmail() {
        return email;
    } // end of getEmail method

    public String getPhoneNumber() {
        return phoneNumber;
    } // end of getPhoneNumber method

    public int getUserNum() {
        return userNum;
    } // end of getUserNum method 
   
    //returns node in phone book format
    public String toString() {
        return "First Name: " + firstName + "\nLast Name: " + lastName + "\nAddress: " + address + 
        "\nCity: " + city + "\nState: " + state + "\nZip: " + zip + "\nEmail: " + email + 
        "\nPhone Number: " + phoneNumber + "\nUser Number: " + userNum;
    } // end of toString method
} // end of Node Class