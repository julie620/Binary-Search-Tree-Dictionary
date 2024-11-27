//Name: Juliana Serrano
//Date: 11/26/2024
//Lab 6: Binary Search Tree Dictionary
// methods to edit BST and return node information (Class 2 of 3)

public class Manager {
    private Node root;

    public Manager () {
        root = null;
    }

    // Adds node at apporpriate place
    public Boolean add(String firstName, String lastName, String address, String city, String state, 
        String zip, String email, String phoneNumber, int userNum) {
        if (root == null) {
            //adding to an empty list
            root = new Node(firstName, lastName, address, city, state, zip, email, phoneNumber,
                userNum);
            return true; // new node added
        } else {
            //finds parent for new node
            Node current = root;
            Node parent = root;
            while (current != null) {
                if (userNum < current.getUserNum()) {
                    parent = current;
                    current = current.left;
                } else if (userNum > current.getUserNum()) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // does not add if duplicate value
                }
            }
            // adds new node attcahed to parent
            if (userNum < parent.getUserNum()) {
                parent.left = new Node(firstName, lastName, address, city, state, zip, email, phoneNumber,
                userNum);
            } else {
                parent.right = new Node(firstName, lastName, address, city, state, zip, email, phoneNumber,
                userNum);
            }
            return true; // new node added
        }
    } // end of add method

    //removes node from tree
    public Boolean remove(int userNum) {
        Node current = root;
        Node parent = root;
        while (userNum != current.getUserNum()) {
            if (userNum < current.getUserNum()) {
                parent = current;
                current = current.left;
            } else if (userNum > current.getUserNum()) {
                parent = current;
                current = current.right;
            } else{
                return false;
            }
        }
        if (current == root) {
            if (current.left == null) {
                root = current.right;
            } else if (current.right == null) {
                root = current.left;
            } else {
                removeRootTwo(userNum);
            }
        } else if (current.left == null && current.right == null) {
           removeLeaf(current, parent, userNum);
        } else if (current.left == null) {
            removeChildR(current, parent, userNum);
        } else if (current.right == null) {
            removeChildL(current, parent, userNum);
        } else {
            removeTwoChild(current, parent, userNum);
        }
        return true;
    } // end of remove method

    // removes root with two children
    public void removeRootTwo(int userNum) {
        Node replacment = root.right;
        while (replacment.left != null) {
            replacment = replacment.left;
        }
        root = new Node(replacment.getFirstName(), replacment.getLastName(), replacment.getAddress(), 
            replacment.getCity(), replacment.getState(), replacment.getZip(), replacment.getEmail(),
            replacment.getPhoneNumber(), replacment.getUserNum(), root.left, replacment.right);
    } // end of removeRootTwo method

    // removes leaf(node with no children) from tree
    public void removeLeaf (Node current, Node parent, int userNum) {
        if (parent.left.getUserNum() == userNum) {
            parent.left = null;
        } else {
            parent.right = null;
        }
    } // end of removeLead method

    // removes node with a right child
    public void removeChildR(Node current, Node parent, int userNum) {
        if (userNum < parent.getUserNum()) {
            parent.left = current.right;
        } else {
            parent.right = current.right;
        }
    } // en of removeOneChildR method

    // removes node with a left child
    public void removeChildL(Node current, Node parent, int userNum) {
        if (userNum < parent.getUserNum()) {
            parent.left = current.left;
        } else {
            parent.right = current.left;
        }
    } // end of removeChildL methd=od

    // removes a node with two children
    public void removeTwoChild(Node current, Node parent, int userNum) {
        Node replacment = current.right;
        while (replacment.left != null) {
            replacment = replacment.left;
        }
        if (userNum < parent.getUserNum()) {
            parent.left = replacment;
        } else {
            parent.right = replacment;
        }
    } // end of removeTwoChild method

    // checks if user number exists
    public Boolean validMod(int userNum) {
        Node current = root;
        while (userNum != current.getUserNum()) {
            if (userNum < current.getUserNum()) {
                current = current.left;
            } else if (userNum > current.getUserNum()) {
                current = current.right;
            } else {
                return false;
            }
        }
        return true;
    } // end of validMod method

    // navigates to node to be modified
    public Node modNode(int userNum) {
        Node current = root;
        while (userNum != current.getUserNum()) {
            if (userNum < current.getUserNum()) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return current;
    } // end of modNode method

    // modifies a node
    public Boolean modify(String firstName, String lastName, String address, String city, 
        String state, String zip, String email, String phoneNumber, int userNum) {
        if (validMod(userNum) != true) {
            System.out.println("false");
            return false;
        }
        Node current = root;
        while (userNum != current.getUserNum()) {
            if (userNum < current.getUserNum()) {
                current = current.left;
            } else if (userNum > current.getUserNum()) {
                current = current.right;
            }
        }
        remove(userNum);
        add(firstName, lastName, address, city, state, zip, email, phoneNumber, userNum);
        return true;
    } // end of modify method

    // starts at root for traversal
    public Node traversal() {
        Node current = root;
        return current;
    } // end of traversal method

    // walks through list from leftmost tree node (inorder)
    public void inorder(Node current) {
        if (current != null) {
            inorder(current.left);
            System.out.println(current.toString() + "\n");
            inorder(current.right);
        }
    } // end of inorder method

    // walks through list from top to left subtrees to right subtrees(preorder)
    public void preorder(Node current) {
        if (current != null) {
            System.out.println(current.toString() + "\n");
            preorder(current.left);
            preorder(current.right);
        }
    }// end of preorder method

    // walks through list from left subtrees to right subtrees to root
    public void postorder(Node current) {
        if (current != null) {
            postorder(current.left);
            postorder(current.right);
            System.out.println(current.toString() + "\n");
        }
    } // end of postorder

    // Following methods return data of specified node
    public String firstName(int userNum) {
        return modNode(userNum).getFirstName();
    } // end of getFirstName method

    public String lastName(int userNum) {
        return modNode(userNum).getLastName();
    } // end of getLastName method

    public String address(int userNum) {
        return modNode(userNum).getAddress();
    } // end of getAddress method

    public String city(int userNum) {
        return modNode(userNum).getCity();
    } // end of getCity method

    public String state(int userNum) {
        return modNode(userNum).getState();
    } // end of getState method

    public String zip(int userNum) {
        return modNode(userNum).getZip();
    } // end of getZip method

    public String email(int userNum) {
        return modNode(userNum).getCity();
    } // end of getEmail method

    public String phoneNumber(int userNum) {
        return modNode(userNum).getPhoneNumber();
    } // end of getPhoneNumber method
} // end of Manager Class
