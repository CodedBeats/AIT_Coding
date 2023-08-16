package constants_statics_enumerators;


// Static members (variables and methods) belong to the class itself rather than instances of the class. 
// They are shared among all instances of the class.
public class StaticExample {
    private static int counter = 0;
    
    public StaticExample() {
        counter++;
    }
    
    public static int getCounter() {
        return counter;
    }
    
    public static void main(String[] args) {
        StaticExample obj1 = new StaticExample(); // counter = 1;
        StaticExample obj2 = new StaticExample(); // counter = 2;
        
        System.out.println("Counter: " + StaticExample.getCounter());
    }
}
