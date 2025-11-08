public class HealthProfessional {
    private int id;
    private String name;
    private String field;

    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.field = "Unspecified";
    }

    /**
     * @param id Health Professional ID
     * @param name Name
     * @param field Professional field
     */
    public HealthProfessional(int id, String name, String field) {
        this.id = id;
        this.name = name;
        this.field = field;
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Professional Field: " + field);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getField() {
        return field;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setField(String field) {
        this.field = field;
    }
}