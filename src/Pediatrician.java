public class Pediatrician extends HealthProfessional {
    private String specializedAgeGroup;

    public Pediatrician() {
        super();
        this.specializedAgeGroup = "All Ages";
    }

    /**
     * @param id Doctor ID
     * @param name Name
     * @param field Professional field (fixed as "Pediatrics")
     * @param specializedAgeGroup Proficient in age groups
     */
    public Pediatrician(int id, String name, String field, String specializedAgeGroup) {
        super(id, name, field);
        this.specializedAgeGroup = specializedAgeGroup;
    }

    @Override
    public void printDetails() {
        System.out.println("=== Health Professional Type: Pediatrician ===");
        super.printDetails();
        System.out.println("Specialized Age Group: " + specializedAgeGroup);
        System.out.println("=============================================");
    }

    public String getSpecializedAgeGroup() {
        return specializedAgeGroup;
    }

    public void setSpecializedAgeGroup(String specializedAgeGroup) {
        this.specializedAgeGroup = specializedAgeGroup;
    }
}