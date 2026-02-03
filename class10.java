//Class
//Object
//Methods
//Attributes
//Access modifiers

import java.util.Collections;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class class10 {
    // int x = 10;
    // protected void sayHello(){
    //     System.out.println("I am the method for class10");
    // }
    public static void main(String[] args) {
        class11 obj1 = new class11();
        obj1.setAmmount(1000);
        System.out.println(obj1.getAmmount());

        // class10 obj2 = new class10();
        // obj2.x = 20;
        // System.out.println(obj1.x);
        // System.out.println(obj2.x);
        // obj1.sayHello();
        // // sayHello();
        TreeSet<Integer> numbers = new TreeSet<>();
        Random ran = new Random();
        for(int i = 0 ; i < 10 ; i++){
            numbers.add(ran.nextInt(100));
        }
        System.out.println("accending order: "+ numbers);
        System.out.println("smallest number: "+ numbers.first());
        System.out.println("largest number: "+ numbers.last());

        SortedSet<Integer> less50 = numbers.headSet(50);
        System.out.println("less then 50: "+ less50);

    }
}


// Create a TreeSet<Integer>:
//  Add 10 random numbers.
//  Print in ascending order (default).
//  Print the smallest and largest number.
//  Get numbers strictly less than 50.

// Create a TreeSet<String> of words:
//  Print them in alphabetical order.
//  Print the first and last word.
