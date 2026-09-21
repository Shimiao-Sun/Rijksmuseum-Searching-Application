package au.edu.sydney.soft3202.project.view;

import au.edu.sydney.soft3202.project.model.ResultEntry;
import au.edu.sydney.soft3202.project.model.pojo.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;

public class ResultEntryPaneBuilder {

    private ResultEntry resultEntry;

    public ResultEntryPaneBuilder(ResultEntry resultEntry) {
        this.resultEntry = resultEntry;
    }

    /**
     * result entry pane builder
     * @throws Exception
     */
    public void resultPaneBuilder() throws Exception {

        List<ArtObjects> results = resultEntry.getResults();

        Stage resultEntryStage = new Stage();
        VBox vb = new VBox();
        ScrollPane resultPane = new ScrollPane();
        ImageView artImageView;

        vb.setLayoutX(5);
        vb.setSpacing(10);

        Button buttonEntry;
        Button addAsFavourite;

        BufferedImage artImage;
        for(ArtObjects artObjects: results) {
            artImage = ImageIO.read(new URL(artObjects.getWebImage().getUrl()));
            artImageView = new ImageView(SwingFXUtils.toFXImage(artImage, null));
            artImageView.setFitHeight(160);
            artImageView.setFitWidth(240);
            vb.getChildren().add(artImageView);

            buttonEntry = new Button(artObjects.getTitle());
            addAsFavourite = new Button("Add as Favourite");

            buttonEntry.setOnAction(event -> {
                VBox vbDisplay = new VBox();
                vbDisplay.setLayoutX(5);
                vbDisplay.setSpacing(10);

                Boolean isExistEntry = null;
                try {
                    isExistEntry = resultEntry.isExistEntry(artObjects);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(isExistEntry) {
                    Alert cacheAlert = new Alert(Alert.AlertType.CONFIRMATION);
                    cacheAlert.setTitle("Cache Hit!");
                    cacheAlert.setContentText("cache hit for this data – use cache, or request fresh data from the API?");
                    Optional<ButtonType> resultCache = cacheAlert.showAndWait();
                    if(resultCache.isPresent() && resultCache.get() == ButtonType.OK) {
                        resultEntry.setUseCache(true);
                    } else {
                        resultEntry.setUseCache(false);
                    }
                }

                try {
                    resultEntry.cacheSet(artObjects, artObjects.getObjectNumber());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    ImageView fullSizeImageView = new ImageView(SwingFXUtils.toFXImage(ImageIO.read(new URL(artObjects.getWebImage().getUrl())), null));
                    vbDisplay.getChildren().add(fullSizeImageView);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // result page
                Stage detailedStage = new Stage();
                ScrollPane detailedPane = new ScrollPane();
                Label longTitleLabel = new Label(resultEntry.getLongTitle());
                vbDisplay.getChildren().add(longTitleLabel);
                Label makerName = new Label(resultEntry.getPrincipalMaker());
                vbDisplay.getChildren().add(makerName);
                Label dateYearEarly = new Label(String.valueOf(resultEntry.getYearEarly()));
                vbDisplay.getChildren().add(dateYearEarly);
                Label detailedDescription = new Label(resultEntry.getPlaqueDescriptionEnglish());
                vbDisplay.getChildren().add(detailedDescription);

                detailedPane.setContent(vbDisplay);
                detailedPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
                detailedPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
                Scene detailedScene = new Scene(detailedPane, 600, 400);
                detailedStage.setScene(detailedScene);
                detailedStage.show();

            });

            setAddAsFavouriteButton(addAsFavourite, artObjects);
            vb.getChildren().add(buttonEntry);
            vb.getChildren().add(addAsFavourite);
        }

        resultPane.setContent(vb);
        Scene resultScene = new Scene(resultPane, 400, 600);
        resultEntryStage.setScene(resultScene);
        resultEntryStage.show();

        if(results.size() == 0) {
            Alert noResultAlert = new Alert(Alert.AlertType.INFORMATION);
            noResultAlert.setTitle("No Result");
            noResultAlert.setContentText("There are no results found!");
            noResultAlert.show();
            resultEntryStage.close();
        }
    }

    /**
     * add favourite entry button event add
     * @param button addAsFavourite button
     * @param artObjects the entry of favourite
     */
    private void setAddAsFavouriteButton(Button button, ArtObjects artObjects) {
        button.setOnAction(event1 -> {
            boolean addFavourite = false;
            try {
                addFavourite = resultEntry.addFavouriteList(artObjects);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Alert addAlert;
            if(addFavourite) {
                addAlert = new Alert(Alert.AlertType.INFORMATION);
                addAlert.setContentText("Successfully add to favourite list!");
            } else {
                addAlert = new Alert(Alert.AlertType.ERROR);
                addAlert.setContentText("This element has been added into your favourite list!");
            }
            addAlert.show();
        });
    }

}
