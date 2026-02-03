// class Example {
//     public void sayName(){
//         System.out.println("this is a demo say name method!");
//     }

//     /**
//      * 
//      * @deprecated
//      * this method is inefficient. Use {@link #newAdd(int, int)} instead
//      */
//     @Deprecated(since="2.0", forRemoval = true)
//     public int add(int num1, int num2){
//         int sum = num1 + num2;
//         return sum;
//     }

//     public int newAdd(int num1, int num2){
//         return num1 + num2;
//     }
// }

// class Example2 extends Example{

//     @Override
//     public void sayName(){
//         System.out.println("this method is in the example2");
//     }
// }

import java.io.File;
import java.io.IOException;

public class class16 {
    public static void main(String[] args) {
        // Example ex = new Example2();
        // ex.sayName();
        // System.out.println(ex.add(10, 20));
        File file = new File("texts/test.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("file created: " + file.getName());
            } else {
                System.out.println("file already existed!");
            }
        } catch (IOException e) {
            System.out.println("Error occured!");
            // e.printStackTrace();
        }
    }
}
