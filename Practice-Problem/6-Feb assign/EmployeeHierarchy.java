
class Employee {
    public String name;
	public int id;
	public int salary;

    public Employee(String name, int id,int salary) {
        this.name = name;
		this.id = id;
		this.salary = salary;
		
        
    }

    public void displayDetails() {
        System.out.println("Employee Details");
    }
}


class Manager extends Employee {
	private int teamSize;
    public Manager(String name, int id,int salary, int teamSize) {
		super(name,id,salary);
		this.teamSize = teamSize;
        
    }
    
    public void displayDetails() {
        System.out.println("Manager Name: "+name+"\nID: "+id+ "\nSalary: "+salary+ "\nSize of Team: "+teamSize);
		System.out.println("-----------------------------------------------");
    }
}


class Developer extends Employee {
	private String programmingLanguage;
    public Developer(String name, int id,int salary, String programmingLanguage) {
		super(name,id,salary);
		this.programmingLanguage = programmingLanguage;
        
    }


    public void displayDetails() {
        System.out.println("Developer Name: "+name+"\nID: "+id+ "\nSalary: "+salary+ "\nProgramming Language: "+programmingLanguage);
		System.out.println("-----------------------------------------------");
    }
}

class Intern extends Employee {
	private String university;
    public Intern(String name, int id,int salary, String university) {
		super(name,id,salary);
		this.university = university;
		
        
    }

   
    public void displayDetails() {
        System.out.println("Intern Name: "+name+"\nID: "+id+ "\nSalary: "+salary+ "\nUniversity: "+university);
		System.out.println("-----------------------------------------------");
    }
}


public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee manager = new Manager("Prem",101,4000000,8);
        Employee developer = new Developer("Rudra",102, 3000000, "C#");
        Employee intern = new Intern("Anjali",103,1000000, "GLA University");

        manager.displayDetails(); 
	
        developer.displayDetails();  
        intern.displayDetails(); 
    }
}
