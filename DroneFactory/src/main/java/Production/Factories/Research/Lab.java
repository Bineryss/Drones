package Production.Factories.Research;

import Production.Factories.Building;

/**
 * Kleines Labor
 *
 * ID: 2
 */
public class Lab extends Building{
    public final String ICON = "[*]-O";
    private static int cc = -1;


    public Lab() {
        super();
        cc++;
        id = 2;
        sid = cc;
    }

    public void update() {

    }

    public String toString() {
        return "[ " + ICON + " ]" + constructionStatus();
    }

}