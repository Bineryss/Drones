package management.ManagementSystems;

import management.Resources.Resource;
import specificexceptions.NotEnoughEnergyException;
import specificexceptions.NotEnoughResourceException;
import specificexceptions.NotEnoughStorageException;

public class ResourceManagement {

    private static final Resource energy = new Resource("Energy", 1000);
    private static final Resource resource = new Resource("Iron", 1000);


    public static Resource getResource() {
        return resource;
    }

    public static int removeResources(int cost) throws NotEnoughResourceException {
        resource.removeResources(cost);
        return cost;
    }

    public static void addResources(int added) throws NotEnoughStorageException {
        resource.addResources(added);
    }

    public static boolean hasResources(int count) {
        return resource.hasResources(count);
    }

    public static Resource getEnergy() {
        return energy;
    }

    public static void useEnergy(int ammount) throws NotEnoughEnergyException {
        try {
            energy.removeResources(ammount);
        } catch (NotEnoughResourceException e) {
            throw new NotEnoughEnergyException();
        }
    }

    public static void addEnergy(int ammount) throws NotEnoughStorageException {
        energy.addResources(ammount);
    }

    public static String resourceName() {
        return resource.getName();
    }

    public static String print() {
        return energy.toString() + resource.toString();
    }
}
