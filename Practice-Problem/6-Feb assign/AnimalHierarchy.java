
class Animal {
    public String name;
	public int age;
  

    public Animal(String name, int age) {
        this.name = name;
		this.age = age;
        
    }

    public void makeSound() {
        System.out.println("Some animal sound");
    }
}


class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    
    public void makeSound() {
        System.out.println(name + " Woof! Woof!\n Age: " +age);
    }
}


class Cat extends Animal {
    public Cat(String name, int age) {
       super(name,age);
    }


    public void makeSound() {
        System.out.println(name + " Meow! Meow!\n Age: " +age);
    }
}

class Bird extends Animal {
    public Bird(String name,int age) {
        super(name,age);
    }

   
    public void makeSound() {
        System.out.println(name + " Tweet! Tweet!\n Age: " +age);
    }
}


public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal dog = new Dog("Buddy",7);
        Animal cat = new Cat("Whiskers",4);
        Animal bird = new Bird("Tweety",5);

        dog.makeSound(); 
        cat.makeSound();  
        bird.makeSound(); 
    }
}
