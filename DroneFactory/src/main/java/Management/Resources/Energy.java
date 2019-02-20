package Management.Resources;

public class Energy extends Resource {
    private int energyUse;

    public Energy(int maxCapacity, int energyUse) {
        super("Energy", -1);

        this.maxCapacity = maxCapacity;
        this.energyUse = energyUse;
    }
    /**
     * Special Constructor for Drones only!
     *
     * @param maxCapacity
     * @param energyUse
     * @param count
     */
    public Energy(int maxCapacity, int energyUse, int count) {
        super("Energy", -1);

        this.maxCapacity = maxCapacity;
        this.count = maxCapacity;
        this.energyUse = energyUse;
    }

    public int loadEnergy(int amount) {
        if ((amount + count) > maxCapacity) {
            addResources(maxCapacity);
            return (amount - maxCapacity);
        } else {
            addResources(amount);
        }
        return 0;
    }

    public int useEnergy() {
        return useResources(energyUse);
    }

    public boolean hasEnergy() {
        return hasResources(energyUse);
    }

    public boolean hasMaxEnergy() {
        return count == maxCapacity;
    }

    public int availableEnergy() {
        return count;
    }

    public int maxCapacity() {
        return maxCapacity;
    }
}
