package Management.Resources;

public class Resource {
    public final String NAME;
    private final int ID;

    protected int maxCapacity;
    protected int count;


    public Resource(String name, int id) {
        NAME = name;
        this.ID = id;
        this.count = 0;
        //TODO: maxCapacity abhaengig von der anzahl an Lagern machen
        this.maxCapacity = 100000;
    }

    /**
     * Special Constructor for defining resource costs only!
     *
     * @param id
     * @param count
     */
    public Resource(int id, int count) {
        NAME = "";
        this.ID = id;
        this.count = count;
    }

    public int resources() {
        return count;
    }

    public void addResources(int count) {
        if (maxCapacity >= (this.count + count)) {
            this.count += count;
        } else {
            throw new IllegalArgumentException("So viel kannst du nicht lagern!");
        }
    }

    public int useResources(int count) {
        if (hasResources(count)) {
            this.count -= count;
            return count;
        } else {
            throw new IllegalArgumentException("So viele Resourcen hast du nicht!");
        }
    }

    public boolean hasResources(int count) {
        if (count <= this.count) {
            return true;
        } else {
            return false;
        }
    }

    public int getID() {
        return ID;
    }

    public String toString() {
        return "| " + NAME + ": " + count + " |";
    }
}
