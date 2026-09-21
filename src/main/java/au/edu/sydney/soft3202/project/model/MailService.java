package au.edu.sydney.soft3202.project.model;

public interface MailService {

    void sendMessage(String toMailAddress, String subject, String text) throws Exception;
}
