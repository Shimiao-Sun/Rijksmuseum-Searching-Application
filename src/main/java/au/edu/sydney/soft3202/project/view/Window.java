package au.edu.sydney.soft3202.project.view;

import au.edu.sydney.soft3202.project.model.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;

public class Window {

    private final int width;
    private final int height;
    private final Service serviceImpl;
    private final MailService mailService;
    private final Scene scene;
    private final Pane pane;
    private Database database;

    public Window(Service serviceImpl, MailService mailService, int width, int height) {
        this.serviceImpl = serviceImpl;
        this.mailService = mailService;
        this.width = width;
        this.height = height;
        pane = new Pane();
        scene = new Scene(pane, width, height);
        database = new Database();
        database.createDB();
        database.setupDB();

        SplashPane splashPane = new SplashPane();
        splashPane.showSplashPane();

        SearchPaneBuilder searchPaneBuilder = new SearchPaneBuilder(serviceImpl, mailService, database);
        pane.getChildren().add(searchPaneBuilder.searchPaneBuilder());

    }

    public Scene getScene() { return scene; }
}
