package businesslogic;

import dataAccess.DataAccess;

public class LocalBLFacade implements BLFacadeFactory {
    @Override
    public BLFacade createBLFacade() {
        DataAccess da = new DataAccess();
        return new BLFacadeImplementation(da);
    }
}
