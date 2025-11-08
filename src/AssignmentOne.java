import java.util.ArrayList;
import java.util.List;

public class AssignmentOne {
    private static List<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // ======================================
        // Part 3 – Using classes and objects
        // ======================================
        System.out.println("========== Part 3: Using Classes and Objects ==========");

        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Emily Carter", "General Medicine", true);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Michael Brown", "General Medicine", false);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Sarah Davis", "General Medicine", true);

        Pediatrician peds1 = new Pediatrician(201, "Dr. Lisa Wilson", "Pediatrics", "0-3 Years");
        Pediatrician peds2 = new Pediatrician(202, "Dr. John Taylor", "Pediatrics", "4-12 Years");

        System.out.println("\n--- All Health Professionals ---");
        gp1.printDetails();
        gp2.printDetails();
        gp3.printDetails();
        peds1.printDetails();
        peds2.printDetails();

        System.out.println("\n------------------------------");

        // ======================================
        // Part 5 – Collection of appointments
        // ======================================
        System.out.println("========== Part 5: Collection of Appointments ==========");

        System.out.println("\n1. Creating Appointments...");
        try {
            createAppointment("Alice Smith", "0412345678", "09:00", gp1);
            createAppointment("Bob Johnson", "0423456789", "11:30", gp2);

            createAppointment("Charlie Lee", "0434567890", "14:00", peds1);
            createAppointment("Diana Miller", "0445678901", "16:30", peds2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating appointment: " + e.getMessage());
        }

        System.out.println("\n2. Existing Appointments After Creation:");
        printExistingAppointments();

        System.out.println("\n3. Canceling Appointment (Mobile: 0423456789)...");
        cancelBooking("0423456789");

        System.out.println("\n4. Existing Appointments After Cancellation:");
        printExistingAppointments();

        System.out.println("\n------------------------------");
    }

    /**
     * @param patientName Patient's name
     * @param patientMobile Patient's mobile phone number
     * @param timeSlot Appointment time
     * @param doctor Appointment with a doctor (supporting all subcategories such as general practice and pediatrics)
     */
    private static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        try {
            Appointment newAppt = new Appointment(patientName, patientMobile, timeSlot, doctor);
            appointmentList.add(newAppt);
            System.out.println("Successfully created appointment for " + patientName);
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to create appointment: " + e.getMessage());
        }
    }

    private static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No existing appointments.");
            return;
        }

        System.out.println("Total Appointments: " + appointmentList.size());
        for (Appointment appt : appointmentList) {
            appt.printAppointmentDetails(); // 调用预约的打印方法
        }
    }

    /**
     * @param patientMobile Patient's mobile phone number
     */
    private static void cancelBooking(String patientMobile) {
        boolean canceled = false;
        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment appt = appointmentList.get(i);
            if (appt.getPatientMobile().equals(patientMobile)) {
                appointmentList.remove(i);
                canceled = true;
                System.out.println("Successfully canceled appointment for mobile: " + patientMobile);
                break;
            }
        }

        if (!canceled) {
            System.out.println("Error: No appointment found for mobile: " + patientMobile);
        }
    }
}