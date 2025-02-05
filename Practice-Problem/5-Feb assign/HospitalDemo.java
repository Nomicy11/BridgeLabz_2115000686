class Doctor {
    private String name;

    public Doctor(String name) {
        this.name = name;
        System.out.println("Doctor " + this.name + " created.");
    }

    public void consult(Patient patient) {
        System.out.println("Doctor " + this.name + " is consulting with Patient " + patient.getName() + ".");
        patient.receiveConsultation(this);
    }

    public String getName() {
        return this.name;
    }
}

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
        System.out.println("Patient " + this.name + " created.");
    }

    public void receiveConsultation(Doctor doctor) {
        System.out.println("Patient " + this.name + " is being consulted by Doctor " + doctor.getName() + ".");
    }

    public String getName() {
        return this.name;
    }
}

class Hospital {
    private String name;

    public Hospital(String name) {
        this.name = name;
        System.out.println("Hospital " + this.name + " created.");
    }

    public void performConsultation(Doctor doctor, Patient patient) {
        System.out.println("Hospital " + this.name + " is facilitating a consultation.");
        doctor.consult(patient);
    }
}

public class HospitalDemo {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("Dr. Smith");
        Doctor doctor2 = new Doctor("Dr. Johnson");

        Patient patient1 = new Patient("Alice");
        Patient patient2 = new Patient("Bob");

        Hospital hospital = new Hospital("City Hospital");

        hospital.performConsultation(doctor1, patient1);
        hospital.performConsultation(doctor2, patient2);
        hospital.performConsultation(doctor1, patient2);
    }
}
