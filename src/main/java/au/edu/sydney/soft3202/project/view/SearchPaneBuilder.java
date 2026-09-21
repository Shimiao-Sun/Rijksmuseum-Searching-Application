package au.edu.sydney.soft3202.project.view;

import au.edu.sydney.soft3202.project.model.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.media.MediaPlayer;
import java.util.*;

import java.util.ArrayList;

public class SearchPaneBuilder {

    private Service serviceImpl;
    private MailService mailServiceImpl;
    private Button showFavouriteList;
    private Button clearCacheButton;
    private Button submitButton;
    private Button sendLongReportButton;
    private Button musicPlay;
    private Button musicStop;
    private Button clearFavouriteList;
    private Button removeFavourite;
    private List<String> favouriteList;
    private Map<String, String> inputMap;
    private Database database;
    private ResultEntry resultEntry;

    private TextField name = new TextField();
    private TextField role = new TextField();
    private TextField qualification = new TextField();
    private TextField asian_art_school = new TextField();
    private TextField place = new TextField();
    private TextField what = new TextField();
    private TextField when = new TextField();
    private TextField where = new TextField();
    private TextField who = new TextField();
    private TextField title = new TextField();
    private TextField description = new TextField();
    private TextField object_type = new TextField();
    private TextField collection = new TextField();
    private TextField catalogue_title = new TextField();
    private TextField material = new TextField();
    private TextField technique = new TextField();
    private TextField object_number = new TextField();
    private TextField made_between_start = new TextField();
    private TextField made_between_end = new TextField();
    private TextField inscription_marks = new TextField();
    private TextField catalogue_reference = new TextField();
    private TextField acquisition_credits = new TextField();
    private TextField provenance_name = new TextField();

    public SearchPaneBuilder(Service serviceImpl, MailService mailService, Database database) {
        this.serviceImpl = serviceImpl;
        this.database = database;
        this.mailServiceImpl = mailService;
        showFavouriteList = new Button("Favourite List");
        clearCacheButton = new Button("clear cache");
        submitButton = new Button("Find!");
        sendLongReportButton = new Button("Send Long Report");
        musicPlay = new Button("Play BGM");
        musicStop = new Button("Stop BGM");
        clearFavouriteList = new Button("Clear Favourite List");
        removeFavourite = new Button("Remove Favourite");
        favouriteList = new ArrayList<>();
        inputMap = new HashMap<>();
    }

    /**
     * Search pane builder
     * @return a search pane UI platform
     */
    public GridPane searchPaneBuilder() {

        GridPane namePane = new GridPane();
        namePane.setVgap(10);
        namePane.setHgap(10);

        namePane.add(new Label("Maker"), 0, 0);
        namePane.add(new Label("name: "), 0, 2);
        namePane.add(new Label("Role: "), 0, 3);
        namePane.add(new Label("Qualification: "), 0, 4);
        namePane.add(new Label("Asian Art School: "), 0, 5);
        namePane.add(new Label("Place: "), 0, 6);
        namePane.add(name, 1, 2);
        namePane.add(role, 1, 3);
        namePane.add(qualification, 1, 4);
        namePane.add(asian_art_school, 1, 5);
        namePane.add(place, 1, 6);

        namePane.add(new Label("Subject"), 0, 8);
        namePane.add(new Label("What: "), 0, 10);
        namePane.add(new Label("When: "), 0, 11);
        namePane.add(new Label("Where: "), 0, 12);
        namePane.add(new Label("Who: "), 0, 13);
        namePane.add(what, 1, 10);
        namePane.add(when, 1, 11);
        namePane.add(where, 1, 12);
        namePane.add(who, 1, 13);

        namePane.add(new Label("Object"), 3, 0);
        namePane.add(new Label("Title: "), 3, 2);
        namePane.add(new Label("Description: "), 3, 3);
        namePane.add(new Label("Object type: "), 3, 4);
        namePane.add(new Label("Collection: "), 3, 5);
        namePane.add(new Label("Catalogue title: "), 3, 6);
        namePane.add(new Label("Material: "), 3, 7);
        namePane.add(new Label("Technique: "), 3, 8);
        namePane.add(new Label("Objectnumber: "), 3, 9);
        namePane.add(new Label("Made between: "), 3, 10);
        namePane.add(new Label("Inscription / marks: "), 3, 11);
        namePane.add(new Label("Catalogue reference: "), 3, 12);
        namePane.add(new Label("Acquisition credits: "), 3, 13);
        namePane.add(new Label("Provenance name: "), 3, 14);

        namePane.add(title, 4, 2);
        namePane.add(description, 4, 3);
        namePane.add(object_type, 4, 4);
        namePane.add(collection, 4, 5);
        namePane.add(catalogue_title, 4, 6);
        namePane.add(material, 4, 7);
        namePane.add(technique, 4, 8);
        namePane.add(object_number, 4, 9);
        namePane.add(made_between_start, 4, 10);
        namePane.add(inscription_marks, 4, 11);
        namePane.add(catalogue_reference, 4, 12);
        namePane.add(acquisition_credits, 4, 13);
        namePane.add(provenance_name, 4, 14);
        namePane.add(made_between_end, 5, 10);

        namePane.add(submitButton, 3, 17);
        namePane.add(showFavouriteList, 3, 19);
        namePane.add(sendLongReportButton, 5, 19);
        namePane.add(musicPlay, 0, 17);
        namePane.add(musicStop, 0, 19);
        namePane.add(removeFavourite, 4, 17);
        namePane.add(clearFavouriteList, 4, 19);
        if(serviceImpl.getStatus().equals("online")) {
            namePane.add(clearCacheButton, 5, 17);
        }

        MediaBuilder mediaBuilder = new MediaBuilder();
        MediaPlayer BGM = mediaBuilder.mediaBuilder();
        setMusicPlay(BGM);
        setMusicStop(BGM);
        setShowFavouriteList();
        setClearCacheButton();
        setSubmitButton(inputMap);
        setSendLongReportButton();
        setRemoveFavourite(favouriteList);
        setClearFavouriteList(favouriteList);

        namePane.setLayoutX(80);
        namePane.setLayoutY(20);

        return namePane;
    }

    /**
     * showList button event add.
     */
    private void setShowFavouriteList() {
        showFavouriteList.setOnAction(event -> {
            Alert showList = new Alert(Alert.AlertType.INFORMATION);
            showList.setTitle("Favourite List");
            showList.setHeaderText("Your Favourite List");
            showList.setContentText(favouriteList.toString());
            showList.show();
        });
    }

    /**
     * clear cache button event add.
     */
    private void setClearCacheButton() {
        clearCacheButton.setOnAction(event -> {
            database.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Clear Successful");
            alert.setContentText("Successfully clear all caches!");
            alert.setHeaderText("Clear Successful");
            alert.show();
        });
    }

    /**
     * input map builder, use for searching url.
     * @param inputMap
     */
    private void inputMapBuilder(Map<String, String> inputMap) {
        inputMap.put("involvedMaker", name.getText().replace(' ', '+'));
        inputMap.put("role", role.getText().replace(' ', '+'));
        inputMap.put("qualification", qualification.getText().replace(' ', '+'));
        inputMap.put("school", asian_art_school.getText().replace(' ', '+'));
        inputMap.put("place", place.getText().replace(' ', '+'));
        inputMap.put("title", title.getText().replace(' ', '+'));
        inputMap.put("text", description.getText().replace(' ', '+'));
        inputMap.put("type", object_type.getText().replace(' ', '+'));
        inputMap.put("collection", collection.getText().replace(' ', '+'));
        inputMap.put("cctitle", catalogue_title.getText().replace(' ', '+'));
        inputMap.put("material", material.getText().replace(' ', '+'));
        inputMap.put("technique", technique.getText().replace(' ', '+'));
        inputMap.put("objectnumber", object_number.getText().replace(' ', '+'));
        inputMap.put("yearfrom", made_between_start.getText().replace(' ', '+'));
        inputMap.put("yearto", made_between_end.getText().replace(' ', '+'));
        inputMap.put("inscription", inscription_marks.getText().replace(' ', '+'));
        inputMap.put("rpkref", catalogue_reference.getText().replace(' ', '+'));
        inputMap.put("credits", acquisition_credits.getText().replace(' ', '+'));
        inputMap.put("provenancenames", provenance_name.getText().replace(' ', '+'));
        inputMap.put("what", what.getText().replace(' ', '+'));
        inputMap.put("when", when.getText().replace(' ', '+'));
        inputMap.put("where", where.getText().replace(' ', '+'));
        inputMap.put("who", who.getText().replace(' ', '+'));

    }

    /**
     * search button event add
     * @param inputMap
     */
    private void setSubmitButton(Map<String, String> inputMap) {
        submitButton.setOnAction(event -> {
            inputMapBuilder(inputMap);
            resultEntry = new ResultEntry(inputMap, favouriteList, serviceImpl, database);
            ResultEntryPaneBuilder resultEntryPaneBuilder = new ResultEntryPaneBuilder(resultEntry);
            try {
                resultEntryPaneBuilder.resultPaneBuilder();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * send long report button event add.
     */
    private void setSendLongReportButton() {
        sendLongReportButton.setOnAction(event -> {
            String email = null;
            TextInputDialog emailAddress = new TextInputDialog();
            emailAddress.setTitle("Your Email Address");
            emailAddress.setHeaderText("Please input your email address: ");
            Optional<String> input = emailAddress.showAndWait();
            if(input.isPresent()) {
                email = input.get();
            }
            try {
                mailServiceImpl.sendMessage(email, "Your Favourite List", contentBuilder());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * sending email alert show and email content builder
     * @return the content of email for sending long report
     */
    private String contentBuilder() {
        Alert alert;
        if(favouriteList.size() == 0) {
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setHeaderText("No Favourite Error");
            alert.setContentText("You currently have no Favourite Entry!");
        } else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Email Sent");
            alert.setHeaderText("Email Sent");
            alert.setContentText("The long report has successfully sent to your email!");
        }
        alert.show();

        EmailContentBuilder emailContentBuilder = new EmailContentBuilder(database, favouriteList);
        return emailContentBuilder.contentBuilder();
    }

    /**
     * music play button event add
     * @param mediaPlayer the music mp3 object
     */
    private void setMusicPlay(MediaPlayer mediaPlayer) {
        musicPlay.setOnAction(event -> {
            mediaPlayer.play();
        });
    }

    /**
     * music pause button event add
     * @param mediaPlayer the music mp3 object
     */
    private void setMusicStop(MediaPlayer mediaPlayer) {
        musicStop.setOnAction(event -> {
            mediaPlayer.pause();
        });
    }

    /**
     * delete favourite entry button event add.
     * @param favouriteList the users favorite entry list
     */
    private void setRemoveFavourite(List<String> favouriteList) {
        removeFavourite.setOnAction(event -> {
            String title;
            ChoiceDialog<String> dialog = new ChoiceDialog<>("", favouriteList);
            dialog.setTitle("Remove Favourite");
            dialog.setHeaderText("Remove an entry from favourite list");
            dialog.setContentText("Please select a title:");
            Optional<String> result = dialog.showAndWait();
            if(result.isPresent()) {
                title = result.get();
                favouriteList.remove(title);
                Database.removeFavourite(title);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Remove Successful");
                alert.setContentText("Successfully removed an entry from your favourite list!");
                alert.setHeaderText("Remove Successful");
                alert.show();
            }
        });
    }

    /**
     * clear favourite entry button event add
     * @param favouriteList the user's favourite entry list
     */
    private void setClearFavouriteList(List<String> favouriteList) {
        clearFavouriteList.setOnAction(event -> {
            Database.clearFavourite();
            favouriteList.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Clear Successful");
            alert.setContentText("Successfully clear your favourite list!");
            alert.setHeaderText("Clear Successful");
            alert.show();
        });
    }
}
