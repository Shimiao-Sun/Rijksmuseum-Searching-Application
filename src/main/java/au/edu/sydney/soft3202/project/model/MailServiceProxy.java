package au.edu.sydney.soft3202.project.model;

/**
 * check online mode or offline mode of email service.
 */
public class MailServiceProxy {
    private static MailService mailService;

    static {
        String mailMode = System.getProperty("mail");
        if ("ONLINE".equalsIgnoreCase(mailMode)) {
            mailService = new MailServiceImpl();
        } else if ("OFFLINE".equalsIgnoreCase(mailMode)) {
            mailService = new DummyMailImpl();
        }
    }

    public static MailService getService() { return mailService; }
}
