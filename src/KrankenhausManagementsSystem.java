import java.util.ArrayList;
import java.util.Scanner;

public class KrankenhausManagementsSystem {

    ArrayList<Patient> patienten = new ArrayList<>();
    ArrayList<Arzt> doctors = new ArrayList<>();
    ArrayList<Termin> termine = new ArrayList<>();



    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nKrankenhausmanagementssystem");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Arzt");
            System.out.println("3. Termine ausmachen");
            System.out.println("4. Terminübersicht");
            System.out.println("5. Exit");
            System.out.print("Geben Sie Ihre Auswahl ein: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    bookAppointment(scanner);
                    break;
                case 4:
                    viewAppointments();
                    break;
                case 5:
                    System.out.println("Beenden...");
                    return;
                default:
                    System.out.println("Die angegebene Zahl ist ungültig. Biette versuchen Sie nochmal.");
            }
        }
    }

    private void addPatient(Scanner scanner) {
        System.out.print("Geben Sie patient name ein: ");
        String name = scanner.nextLine();
        System.out.print("Geben Sie patient age ein: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Geben Sie patient Geschlecht ein: ");
        String gender = scanner.nextLine();

        Patient patient = new Patient(name, age, gender);
        patienten.add(patient);
        System.out.println("Patient wurde erfolgreich hinzugefügt .");
    }

    private void addDoctor(Scanner scanner) {
        System.out.print("Geben Sie doctor name ein: ");
        String name = scanner.nextLine();
        System.out.print("Geben Sie doctor Fachgebiet ein: ");
        String specialization = scanner.nextLine();

        Arzt doctor = new Arzt(name, specialization);
        doctors.add(doctor);
        System.out.println("Doctor wurde erfolgreich hinzugefügt.");
    }

    private void bookAppointment(Scanner scanner) {
        System.out.print("Geben Sie patient name ein: ");
        String patientName = scanner.nextLine();
        System.out.print("Geben Sie doctor name ein: ");
        String doctorName = scanner.nextLine();
        System.out.print("Geben Sie die Verabredung date (yyyy-mm-dd)ein: ");
        String date = scanner.nextLine();

        Patient patient = findPatient(patientName);
        Arzt doctor = findDoctor(doctorName);

        if (patient != null && doctor != null) {
            Termin appointment = new Termin(patient, doctor, date);
            termine.add(appointment);
            System.out.println("Der Termin wurde erfolgreich ausgemacht.");
        } else {
            System.out.println("Invalid patient oder doctor name.");
        }
    }

    private void viewAppointments() {
        if (termine.isEmpty()) {
            System.out.println("Keine Termine immer noch reserviert.");
        } else {
            System.out.println("Termine:");
            for (Termin appointment : termine) {
                System.out.println(appointment);
            }
        }
    }

    private Patient findPatient(String name) {
        for (Patient patient : patienten) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        return null;
    }

    private Arzt findDoctor(String name) {
        for (Arzt doctor : doctors) {
            if (doctor.getName().equals(name)) {
                return doctor;
            }
        }
        return null;
    }
}


