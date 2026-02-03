class Vehicle{ // parent class
    protected int modelNumber; 
    protected String modelName; 
    
    public Vehicle(int m_Number, String m_Name){
       this.modelNumber = m_Number;
       this.modelName = m_Name;
    }

    void Honk(){
        System.out.println("Vehicle is honking..");
    }

    void getInfo(){
        System.out.println("Model-number: "+ this.modelNumber);
        System.out.println("Model-name: "+ this.modelName);
    }
}

class Car1 extends Vehicle{//child class
     public Car1(int m_Number, String m_Name){
       super(m_Number, m_Name);
       super.Honk();
     }
}

abstract class Animal{
    public abstract void sound();
    public void walk(){
        System.out.println("Animal is walking");
    }
}

class Dog extends Animal{
    public void sound(){
        System.err.println("Dog is making sounds..");
    }
}

public class class13 {
    public static void main(String[] args) {
        Car1 car1 = new Car1(111, "tata nano");
        car1.getInfo();
        Dog d1 = new Dog();
        d1.sound();
        d1.walk();
    }
}
