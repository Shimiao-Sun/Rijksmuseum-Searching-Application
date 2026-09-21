package au.edu.sydney.soft3202.project.model;

import java.util.List;

public class EmailContentBuilder {

    private Database database;
    private List<String> favouriteList;

    public EmailContentBuilder(Database database, List<String> favouriteList) {
        this.database = database;
        this.favouriteList = favouriteList;
    }

    /**
     * buile long report as the email content.
     * @return the email content
     */
    public String contentBuilder() {
        String content = "";
        for (String element : favouriteList) {
            String longTitle = database.findFavouriteLongTitle(element);
            String yearEarly = String.valueOf(database.findFavouriteYear(element));
            String plaqueDescription = database.findFavouritePlaqueDescription(element);
            String principalMakerName = database.findFavouritePrincipalMakerName(element);
            if (longTitle == null) {
                longTitle = "no long title result.";
            }
            if (yearEarly == null) {
                longTitle = "no year result.";
            }
            if (plaqueDescription == null) {
                longTitle = "no description result.";
            }
            if (principalMakerName == null) {
                longTitle = "no maker name result.";
            }
            content = content + "Short Title: " + element + "\n"
                    + "Long Title: " + longTitle + "\n"
                    + "Year: " + yearEarly + "\n"
                    + "Description: " + plaqueDescription + "\n"
                    + "Principal Maker Name: " + principalMakerName + "\n"
                    + "\n";
        }
        return content;
    }
}
