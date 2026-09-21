package au.edu.sydney.soft3202.project.model;

public class ServiceProxy {

    private static Service service;

    static {
        String mode = System.getProperty("mode");
        if ("ONLINE".equalsIgnoreCase(mode)) {
            service = new ServiceImpl();
        } else if ("OFFLINE".equalsIgnoreCase(mode)) {
            service = new DummyServiceImpl();
        }
    }

    public static Service getService() { return service; }
}
