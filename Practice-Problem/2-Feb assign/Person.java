public class Person {
    private String name;
    private int age;

    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

   
    public Person(Person other) {
        this.name = other.name;
        this.age = other.age;
    }

    
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

   
    public void displayPersonInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Person person1 = new Person("Alice", 30);
        person1.displayPersonInfo();

        Person person2 = new Person(person1); 
        person2.displayPersonInfo();
    }
}
