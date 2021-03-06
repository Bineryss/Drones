package management.ManagementSystems;

import ImportandEnums.BuildingTypes;
import production.Factories.Building;

import java.util.HashMap;
import java.util.InputMismatchException;

/**
 * Speichert alle Fabriken, Labore, Energie dings in einer Liste.
 * Speichert alle Dronen Typen in einern Liste.
 */
public class BuildingManagement {
    private static class BuildingKey {
        final BuildingTypes type;
        static int number = 0;

        BuildingKey(BuildingTypes type) {
            this.type = type;
            number++;
        }
    }

    private static final HashMap<BuildingKey, Building> buildings = new HashMap<>();

    public static void addBuilding(Building... tmp) {
        for (Building building : tmp) {
            buildings.put(new BuildingKey(building.getBuildingType()), building);
        }
    }

    public static Building getBuilding(BuildingTypes type, int id) {
        for (BuildingKey key : buildings.keySet()) {
            if (key != null && key.type == type && buildings.get(key).getId() == id) {
                return buildings.get(key);
            }
        }
        throw new InputMismatchException("No such id found!");
    }

    public static void update() {
        //TODO: try catch temporally until user interface gets implemented!
        buildings.forEach((key, building) -> {
            try {
                building.update();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
