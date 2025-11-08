import java.util.Objects;

public class Appointment {
    private String patientName;
    private String patientMobile;
    private String timeSlot;
    private HealthProfessional doctor;

    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "0000000000";
        this.timeSlot = "Unspecified";
        this.doctor = new HealthProfessional();
    }

    /**
     * @param patientName Patient name (not blank)
     * @param patientMobile Patient's mobile phone number (non empty, simplified verification)
     * @param timeSlot Appointment time (not empty)
     * @param doctor Appointment with a doctor (not empty, must be a HealthProfessional subclass object)
     * @throws IllegalArgumentException If the parameter is empty, throw an exception
     */
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        if (patientName == null || patientName.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be empty!");
        }
        if (patientMobile == null || patientMobile.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient mobile number cannot be empty!");
        }
        if (timeSlot == null || timeSlot.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment time slot cannot be empty!");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null!");
        }

        this.patientName = patientName;
        this.patientMobile = patientMobile;
        this.timeSlot = timeSlot;
        this.doctor = doctor;
    }

    public void printAppointmentDetails() {
        System.out.println("\n---------- Appointment Details ----------");
        System.out.println("Patient Name: " + patientName);
        System.out.println("Patient Mobile: " + patientMobile);
        System.out.println("Appointment Time: " + timeSlot);
        System.out.println("Doctor Assigned:");
        doctor.printDetails();
        System.out.println("-----------------------------------------");
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public HealthProfessional getDoctor() {
        return doctor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(patientMobile, that.patientMobile) && Objects.equals(timeSlot, that.timeSlot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientMobile, timeSlot);
    }
}