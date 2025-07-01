public class Person {
    private String name; 

    public String getName() {
        return name; }
    public void setName(String newName) {
        this.name = newName; 
}
    public static void In() {
        Person p = new Person();
        p.setName("vy");
        System.out.println(p.name);

        
    }
}

