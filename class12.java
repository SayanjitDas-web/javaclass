class Vehicle{
   protected String brand = "Tesla";
   void HonK(){
    System.out.println(this.brand +" is giving Honk");
   }
}

class Car1 extends Vehicle{
    void HonK(){
        System.out.println("car1 is honking..");
    }
}

class Car2 extends Vehicle{
    void HonK(){
        System.out.println("car2 is honking..");
    }
}

public class class12 extends Vehicle {
    void class12Method(){
        System.out.println("I ma class12's method");
    }
    public static void main(String[] args) {
        class12 car = new class12();
        Car1 car1 = new Car1();
        Car2 car2 = new Car2();
        // car.HonK();
        car1.HonK();
        // car2.HonK();
    }
}