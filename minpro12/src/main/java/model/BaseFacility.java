package model;

// Abstract class defining common attributes for all facilities
public abstract class BaseFacility implements Facility {
    private final String name;  // Final to prevent name modification
    private int capacity;

    // Constructor
    public BaseFacility(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // Getter and setter methods
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
        } else {
            System.out.println("Invalid capacity. It must be greater than 0.");
        }
    }

    // Concrete method to display basic details
    public void displayFacility() {
        System.out.println("Name: " + name + ", Capacity: " + capacity);
    }

    // Abstract method to be implemented by subclasses
    public abstract String getFacilityType();
}
