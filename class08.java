import java.util.*;

public class class08 {
    public static void main(String[] args) {
        //set - Hash set, Tree set, Linkedhash set
        //Hash set
        HashSet<Number> myHashSet = new HashSet<>();
        Collections.addAll(myHashSet, 1.2,2.5,1.2,3.4,7);
    //     myHashSet.add(10);
    //     // System.out.println(myHashSet.contains(2.3));
       for(int i = 0; i < myHashSet.size(); i++){
        System.out.println(i);
       }
        System.out.println(myHashSet);
    }
}

// 1. ArrayList Exercises
// Create an ArrayList of integers and:
// Add 10 numbers.
// Print them using a for-each loop.
// Remove the 5th element.
// Sort the list in ascending order.
// Search for a number entered by the user.

// 2. Write a program to store names in an ArrayList and:
// Print them in reverse order.
// Replace the second element with another name.
// Check if a name exists.