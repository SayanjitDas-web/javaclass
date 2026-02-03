public class class11 {
    private int ammount = 0;
    // private int x , y, z;
    // private int a,b;
    // public class11(int num1, int num2, int num3){
    //     this(11, 22);
    //     this.x = num1;
    //     this.y = num2;
    //     this.z = num3;
    //     System.out.println("I am in first constructor..");
    //     System.out.println(x+y+z);
    // }
    // public class11(int a, int b){
    //     this.a = a;
    //     this.b = b;
    //     System.out.println("in the second constructor"+a+","+b);
    // }
       void setAmmount(int ammount){
        this.ammount = ammount;
       }
       int getAmmount(){
        return this.ammount;
       }
    public static void main(String[] args) {
        // class11 myobj1 = new class11(1,2,3);
        // class11 myobj2 = new class11(12,13);
        Vehicle car1 = new Vehicle();
        System.out.println(car1.brand);
        // myobj1.x = 10;
    }
}
