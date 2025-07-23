public class App {
    public static void main(String[] args) {
        Student s1 = new Student("An", 3.5f);
        Student s2 = new Student("Binh", 3.8f);

        // So sánh
        System.out.println("So sánh GPA: " + s1.compareTo(s2));

        // Kiểm tra equals
        System.out.println("Hai student có cùng GPA? " + s1.equals(s2));
    }
}
