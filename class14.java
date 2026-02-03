interface Employee {
    public void showId();    
    public void salary();    
}

class Developer implements Employee{
    private String name, address, id, project;
    private int age, sal;
    Developer(String id,String project, String name,String address,int age, int sal){
       this.id = id;
       this.project = project;
       this.name = name;
       this.address = address;
       this.age = age;
       this.sal = sal;
    }
    public void showId(){
       System.out.println("id: " + this.id);
       System.out.println("project: " + this.project);
       System.out.println("name: " + this.name);
       System.out.println("address: " + this.address);
       System.out.println("age: " + this.age);
    }
    public void salary(){
        System.out.println(this.name + "'s salary is: " + this.sal);
    }
}

class Teacher implements Employee {
    private String name, address, id, subject;
    private int age, sal;
    Teacher(String id,String subject, String name,String address,int age, int sal){
       this.id = id;
       this.subject = subject;
       this.name = name;
       this.address = address;
       this.age = age;
       this.sal = sal;
    }
    public void showId(){
       System.out.println("id: " + this.id);
       System.out.println("subject: " + this.subject);
       System.out.println("name: " + this.name);
       System.out.println("address: " + this.address);
       System.out.println("age: " + this.age);
    }
    public void salary(){
        System.out.println(this.name + "'s salary is: " + this.sal);
    }
}
enum Level{
    LOW,
    MEDIUM,
    HIGH;
}

public class class14 {
    public static void main(String[] args) {
        Employee e1 = new Employee(){
            public void showId() {
                System.out.println("In the anonymous class showId");
            };
            public void salary(){
                System.out.println("In the anonymous class salary");
            };
        } ;

        Level currLevel = Level.MEDIUM;

        e1.showId();
        e1.salary();
        Developer dev1 = new Developer("abcd", "App development", "Niladri", "Kakinara", 20, 100000);
        Teacher teacher1 = new Teacher("ab12", "Java", "sayanjit", "Dumdum", 25, 100);
        dev1.showId();
        dev1.salary();
        teacher1.showId();
        teacher1.salary();
    }
}
