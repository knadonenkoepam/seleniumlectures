package diexample;

public class WebDriverInjector implements DriverInjector {
    @Override
    public DriverService getDriverService() {
        return new DriverManagerImpl();
    }
}
