package Production.Factories.Storage;

import Management.Type;
import Production.Factories.Building;

public class Vault extends Building {
    private static int cc = -1;


    public Vault() {
        super();
        type = Type.VAULT;
    }


    public void updateBuilding() {

    }
}