package businesslogic;

// Interfaz para crear una instancia de BLFacade
public interface BLFacadeFactory {
    BLFacade createBLFacade();

    // Método estático para crear BLFacade en función de si es local o remoto
    static BLFacade createBusinessLogicFactory(boolean isLocal) {
        BLFacadeFactory factory;

        if (isLocal) {
            factory = new LocalBLFacade();
        } else {
            factory = new RemoteBLFacade();
        }

        return factory.createBLFacade();
    }
}
