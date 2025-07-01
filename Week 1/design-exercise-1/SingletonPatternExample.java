//design patterns and principles 
//exercise 1 - implement singleton pattern
class Logger {
    private static Logger instance; // declaring a static member and not a dtype because dtype can be instantiated inside the main class basically so that only one instance exists
    
    private Logger() {} // this is done to prevent instantiation in the main class 
    
    public static Logger getInstance() // the method and its getter class
    {
        if(instance == null) // checking if singleton has been created
        {
            instance = new Logger(); // creates a new instance of class and stores it at the pointer instance
        }
        return instance; // returns the pointer to the singleton instance
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger obj1 = Logger.getInstance(); // creating 2 objects in main and calling them to confirm
        Logger obj2 = Logger.getInstance();
        
        if(obj1 == obj2) {
            System.out.println("True");
            System.out.println("address of obj1 : " + obj1);
            System.out.println("address of obj2 : " + obj2);
        }
        else {
            System.out.println("False");
            System.out.println("address of obj1 : " + obj1);
            System.out.println("address of obj2 : " + obj2);
        }
    }
}