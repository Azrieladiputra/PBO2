package model;

public final class SportFacility extends BaseFacility {  // Final class to prevent subclassing
    private String type;

    // Constructor
    public SportFacility(String name, String type, int capacity) {
        super(name, capacity);  // Call to the parent class constructor
        this.type = type;
    }

    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null && !type.trim().isEmpty()) {
            this.type = type;
        } else {
            System.out.println("Invalid type. It cannot be null or empty.");
        }
    }

    // Implement abstract method from BaseFacility
    @Override
    public String getFacilityType() {
        return type;
    }

    // Override displayFacility to include type
    @Override
    public void displayFacility() {
        System.out.println("Name: " + getName() + ", Type: " + type + ", Capacity: " + getCapacity());
    }
}
