package Production.Factories.Connector;

import ImportandEnums.DroneTypes;
import ImportandEnums.Type;
import Management.ManagementSystems.*;
import Management.Resources.Storage;
import Production.Dronen.Drone;

/**
 * Die Grundanbindung, an das Resourcemanagement.
 *
 * Es benötigt eine Drone zum aufladen und entladen des Lagers
 *
 */
public class InternalStorage implements ResourceConnection {
    private Storage storage;
    private Drone transportDrone;

    public InternalStorage(Type type) {
        this.storage = new Storage(type.getMaxCapacity());
        this.transportDrone = null;
    }

    @Override
    public void storeResources(int amount) {
        if (transportDrone != null && !transportDrone.isDead()) {
            ResourceManagement.addResources(storage.empty());
            transportDrone.workEfficiency();
        } else {
            System.out.println("Keine Drone mehr!");
            transportDrone = null;
        }
    }

    public void loadResources(int amount) {
        if (storage.canStore(amount)) {
            storage.addResources(amount);
        } else {
            System.out.println("So viel kannst du nicht lagern!");
        }
    }


    public boolean isFull() {
        return storage.isFull();
    }

    @Override
    public boolean canStore(int amount) {
        return storage.canStore(amount);
    }

    @Override
    public void removeResources(int amount) {
        storage.removeResources(amount);
    }

    @Override
    public boolean hasResources(int amount) {
        return storage.hasResources(amount);
    }


    /**
     * Zieht eine Drone aus dem Dronemanagement
     *
     * @param drone: Typ der Drone
     */
    public void addTransportDrone(DroneTypes drone) {
        transportDrone = DroneManagement.getFullDrone(drone);
    }

    public String toString() {
        return storage + printDrone();
    }

    private String printDrone() {
        if (transportDrone != null) {
            return "(" + transportDrone.toString() + " )";
        } else {
            return "";
        }
    }
}
