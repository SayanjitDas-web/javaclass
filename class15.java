enum Level {
    LOW("low level"),
    MEDIUM("medium level"),
    HIGH("high level");
    private String description;
    private Level(String description){
        this.description = description;
    }

    public String getDesc(){ //Getter function
        return this.description;
    }
}

class MyDataType<A>{
    private A val;
    public void set(A value){
        this.val = value;
    }
    public A get(){
        return this.val;
    }
}

public class class15 {

    static <T> void printArray(T[] arr){
        for(T item: arr){
            System.out.println(item);
        }
    }
    public static void main(String[] args) {
        Level lvl = Level.HIGH;
        System.out.println(lvl.getDesc());
        Integer[] numbers = {1,2,3,4,5};
        // int sum = 0;
        // System.out.println("sum: " + sum);
        try {
            for(int i = 0 ; i < 10 ; i++){
            System.out.println(numbers[i]);
            // sum = sum - numbers[i];
        }
        } catch (Exception e) {
           System.out.println("Somthing went wrong..");
        }

        MyDataType<Integer> val1 = new MyDataType<Integer>();
        val1.set(10);
        System.out.println(val1.get());
        printArray(numbers);
    }
}
