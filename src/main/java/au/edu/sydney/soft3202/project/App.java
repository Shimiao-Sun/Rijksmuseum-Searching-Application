package au.edu.sydney.soft3202.project;

import au.edu.sydney.soft3202.project.model.*;
import au.edu.sydney.soft3202.project.view.Window;
import javafx.animation.PauseTransition;
import javafx.stage.Stage;
import javafx.application.Application;

import javafx.util.Duration;

public class App extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Parameters p = this.getParameters();
        System.out.println("params = " + p.getRaw().get(0) + " " + p.getRaw().get(1));
        String serviceMode = p.getRaw().get(0);
        String mailMode = p.getRaw().get(1);
        System.setProperty("mode", serviceMode);
        System.setProperty("mail", mailMode);

        Service service = ServiceProxy.getService();
        MailService mailService = MailServiceProxy.getService();
        Window window = new Window(service, mailService, 960, 600);
        primaryStage.setTitle("Rijksmuseum");
        primaryStage.setScene(window.getScene());

        PauseTransition delay = new PauseTransition(Duration.seconds(15));
        delay.setOnFinished(event -> primaryStage.show());
        delay.play();

    }

}

