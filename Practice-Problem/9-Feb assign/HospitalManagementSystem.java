import java.util.Scanner;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Diagnosis: " + diagnosis);
        System.out.println("Total Bill: $" + calculateBill());
    }
}

interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String[] records = new String[5]; // Fixed-size array
    private int recordCount = 0;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyCharge) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount] = record;
            recordCount++;
            System.out.println("Record added for In-Patient " + getName());
        } else {
            System.out.println("Medical record storage full for " + getName());
        }
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (int i = 0; i < recordCount; i++) {
            System.out.println("- " + records[i]);
        }
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String[] records = new String[5]; // Fixed-size array
    private int recordCount = 0;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        if (recordCount < records.length) {
            records[recordCount] = record;
            recordCount++;
            System.out.println("Record added for Out-Patient " + getName());
        } else {
            System.out.println("Medical record storage full for " + getName());
        }
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (int i = 0; i < recordCount; i++) {
            System.out.println("- " + records[i]);
        }
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating an InPatient
        System.out.println("Enter In-Patient details:");
        System.out.print("Patient ID: ");
        String inPatientId = scanner.next();
        System.out.print("Name: ");
        String inPatientName = scanner.next();
        System.out.print("Age: ");
        int inPatientAge = scanner.nextInt();
        System.out.print("Diagnosis: ");
        String inPatientDiagnosis = scanner.next();
        System.out.print("Days Admitted: ");
        int daysAdmitted = scanner.nextInt();
        System.out.print("Daily Charge: ");
        double dailyCharge = scanner.nextDouble();
        InPatient inPatient = new InPatient(inPatientId, inPatientName, inPatientAge, inPatientDiagnosis, daysAdmitted, dailyCharge);

        // Creating an OutPatient
        System.out.println("\nEnter Out-Patient details:");
        System.out.print("Patient ID: ");
        String outPatientId = scanner.next();
        System.out.print("Name: ");
        String outPatientName = scanner.next();
        System.out.print("Age: ");
        int outPatientAge = scanner.nextInt();
        System.out.print("Diagnosis: ");
        String outPatientDiagnosis = scanner.next();
        System.out.print("Consultation Fee: ");
        double consultationFee = scanner.nextDouble();
        OutPatient outPatient = new OutPatient(outPatientId, outPatientName, outPatientAge, outPatientDiagnosis, consultationFee);

        System.out.println("\nProcessing Patient Details...");
        processPatient(inPatient);
        processPatient(outPatient);

        System.out.println("\nAdding Medical Records...");
        inPatient.addRecord("Prescribed antibiotics for infection.");
        outPatient.addRecord("Routine check-up, no complications.");

        System.out.println("\nViewing Medical Records...");
        inPatient.viewRecords();
        outPatient.viewRecords();


    }

    public static void processPatient(Patient patient) {
        patient.getPatientDetails();
        System.out.println("----------------------------");
    }
}
