package management.Resources;

/**
 * Resourcen Speicher
 *
 */
public class Storage extends Resource{


    public Storage(int maxCapacity) {
        super("Resource",maxCapacity);
    }

    public int empty() {
        int tmp = count;
        count = 0;
        return tmp;
    }
}
