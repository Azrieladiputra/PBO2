package com.mycompany.minpro12;

import java.util.ArrayList;
import model.SportFacility;
import model.Facility;

// Final class to prevent subclassing
public final class SportFacilityService {
    private static final ArrayList<Facility> facilities = new ArrayList<>();  // Final to prevent reassignment

    // Method to add a new facility
    public static void addFacility(Facility facility) {
        facilities.add(facility);
        System.out.println("Facility added successfully!");
    }

    // Method to view all facilities
    public static void viewFacilities() {
        if (facilities.isEmpty()) {
            System.out.println("No facilities available.");
        } else {
            for (Facility facility : facilities) {
                facility.displayFacility();
            }
        }
    }

    // Method to update an existing facility by name
    public static void updateFacility(String name, String newName, String newType, int newCapacity) {
        boolean found = false;
        for (Facility facility : facilities) {
            if (facility instanceof SportFacility) {
                SportFacility sportFacility = (SportFacility) facility;
                if (sportFacility.getName().equalsIgnoreCase(name)) {
                    // SportFacility is a final class, so we update directly
                    sportFacility.setType(newType);
                    sportFacility.setCapacity(newCapacity);
                    System.out.println("Facility updated successfully!");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Facility not found.");
        }
    }

    // Method to delete a facility by name
    public static void deleteFacility(String name) {
        boolean found = false;
        for (Facility facility : facilities) {
            if (facility instanceof SportFacility) {
                SportFacility sportFacility = (SportFacility) facility;
                if (sportFacility.getName().equalsIgnoreCase(name)) {
                    facilities.remove(sportFacility);
                    System.out.println("Facility deleted successfully!");
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Facility not found.");
        }
    }
}
