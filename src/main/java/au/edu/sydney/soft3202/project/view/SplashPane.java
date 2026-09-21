package au.edu.sydney.soft3202.project.view;

import javafx.animation.PauseTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SplashPane {

    private Stage loadingStage = new Stage();

    /**
     * Splash pane builder
     */
    public void showSplashPane(){
        Text textState = new Text();
        Pane loadingPane = new Pane();
        ProgressBar pb = new ProgressBar(0);
        ProgressIndicator pi = new ProgressIndicator(0);
        pb.indeterminateProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(newValue) {
                    textState.setText("calculating time");
                } else {
                    textState.setText("Going into Rijksmuseum...");
                    textState.setFill(Color.BLUE);
                }
            }
        });
        pb.progressProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(newValue.doubleValue() == 1) {
                    textState.setText("Welcome to Rijksmuseum!");
                    textState.setFill(Color.GREEN);
                }
            }
        });
        Task task = taskCreator();
        pb.progressProperty().unbind();
        pb.progressProperty().bind(task.progressProperty());
        pi.progressProperty().unbind();
        pi.progressProperty().bind(task.progressProperty());
        new Thread(task).start();

        Image loadingImage = new Image("https://live-production.wcms.abc-cdn.net.au/f168bc646568138af8ccc20264df2242?impolicy=wcms_crop_resize&cropH=1697&cropW=2543&xPos=228&yPos=0&width=862&height=575");
        ImageView loadingImageView = new ImageView();
        loadingImageView.setImage(loadingImage);
        VBox loadingVB = new VBox();
        HBox loadingHB = new HBox();
        loadingHB.setSpacing(20);
        loadingVB.setSpacing(20);
        loadingHB.getChildren().addAll(pb, pi, textState);
        loadingVB.getChildren().addAll(loadingImageView, loadingHB);
        loadingPane.getChildren().add(loadingVB);
        Scene loadingScene = new Scene(loadingPane, 862, 650);
        loadingStage.setScene(loadingScene);
        loadingStage.setTitle("Loading App");
        loadingStage.show();

        PauseTransition delay = new PauseTransition(Duration.seconds(15.5));
        delay.setOnFinished(event -> {
            loadingStage.close();
        });
        delay.play();
    }

    /**
     * 15s loading bar task.
     * @return task
     */
    private static Task taskCreator() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for(int i = 0; i < 15; i++) {
                    Thread.sleep(1000);
                    updateProgress(i+1, 15);
                }
                return true;
            }
        };
    }

}
