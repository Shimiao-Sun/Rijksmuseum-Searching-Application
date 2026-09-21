package au.edu.sydney.soft3202.project.model;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class MailServiceImpl implements MailService{

    private final String MAILGUN_API_FROM = System.getenv("MAILGUN_API_FROM");
    private final String MAILGUN_API_KEY = System.getenv("MAILGUN_API_KEY");

    private static final String state = "online";

    /**
     * MailGun API http call.
     * @param toMailAddress To user's email address
     * @param subject the subject of email
     * @param text the content of email
     * @throws Exception
     */
    @Override
    public void sendMessage(String toMailAddress, String subject, String text) throws Exception {
        com.mashape.unirest.http.HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + MAILGUN_API_FROM + "/messages")
                .basicAuth("api", MAILGUN_API_KEY)
                .queryString("from", "Excited User <YOU@" + MAILGUN_API_FROM + ">")
                .queryString("to", toMailAddress)
                .queryString("subject", subject)
                .queryString("text", text)
                .asJson();
    }

}
