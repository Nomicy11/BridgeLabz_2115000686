//Hybrid Inheritance
class Person {
    public String name;
    public int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }


    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

interface Worker {
    void performDuties(); 
}


class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

  
    public void performDuties() {
        System.out.println("Role: Chef");
        System.out.println("Specialty: " + specialty);
        System.out.println(name + " is cooking delicious meals.");
    }
}


class Waiter extends Person implements Worker {
    private int tableCount;

    public Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

   
    public void performDuties() {
        System.out.println("Role: Waiter");
        System.out.println("Tables Assigned: " + tableCount);
        System.out.println(name + " is serving customers efficiently.");
    }
}


public class RestaurantManagement {
    public static void main(String[] args) {
      
        Chef chef = new Chef("Vikas Khanna", 101, "French Cuisine");
        chef.displayDetails();
        chef.performDuties();
        System.out.println("----------------------");

        
        Waiter waiter = new Waiter("Raju", 202, 5);
        waiter.displayDetails();
        waiter.performDuties();
    }
}
