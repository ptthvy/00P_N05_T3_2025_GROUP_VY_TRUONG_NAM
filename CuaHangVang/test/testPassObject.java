public class testPassObject {
    static void f(Number m) {
        m.i = 15;
    }
    public static void test() {
        Number n = new Number(); 
        n.i = 14;               
        PassObject.f(n);          
        System.out.println(n.i);  
    }
}