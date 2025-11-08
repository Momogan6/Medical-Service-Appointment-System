public class GeneralPractitioner extends HealthProfessional {
    private boolean provides24hService;

    public GeneralPractitioner() {
        super();
        this.provides24hService = false;
    }

    /**
     * @param id Doctor ID
     * @param name Name
     * @param field Professional field (fixed as "general practice")
     * @param provides24hService Do you provide 24-hour service
     */
    public GeneralPractitioner(int id, String name, String field, boolean provides24hService) {
        super(id, name, field);
        this.provides24hService = provides24hService;
    }

    @Override
    public void printDetails() {
        System.out.println("=== Health Professional Type: General Practitioner ===");
        super.printDetails();
        System.out.println("Provides 24-hour Emergency Service: " + (provides24hService ? "Yes" : "No"));
        System.out.println("======================================================");
    }

    public boolean isProvides24hService() {
        return provides24hService;
    }

    public void setProvides24hService(boolean provides24hService) {
        this.provides24hService = provides24hService;
    }
}