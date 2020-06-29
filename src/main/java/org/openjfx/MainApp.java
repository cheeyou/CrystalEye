package org.openjfx;

import java.awt.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.GridPane;


public class MainApp extends Application {

    private ScrollPane scrollPane;
    private VBox viewingContainer;
    private TextField userInput;
    private Button enterButton;
    private Scene scene;
    private SplitPane splitPane;
    private AnchorPane leftContainer;
    private AnchorPane rightContainer;
    private GridPane entryPane;

    @Override
    public void start(Stage stage) throws Exception {

        // Left side of screen: Entering transactions
        //entryPane = new GridPane(new Label("Left Control"));
        VBox testV = new VBox(new Label("Left Control"));
        leftContainer = new AnchorPane();
        leftContainer.getChildren().add(testV);

        leftContainer.setPrefSize(500, 600);

        // Right side of screen: viewing and info searching
        viewingContainer = new VBox();
        scrollPane = new ScrollPane();
        scrollPane.setContent(viewingContainer);
        userInput = new TextField();
        enterButton = new Button("Enter");
        rightContainer = new AnchorPane();
        rightContainer.getChildren().addAll(scrollPane, userInput, enterButton);

        scrollPane.setMinWidth(500);
        scrollPane.setMinHeight(575);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        scrollPane.setFitToHeight(true);
        scrollPane.setFitToWidth(true);
        scrollPane.setVvalue(1.0);

        userInput.setPrefWidth(425);
        enterButton.setPrefWidth(75.0);

        rightContainer.setPrefSize(500, 600);

        rightContainer.setTopAnchor(scrollPane, 1.0);
        ;
        rightContainer.setBottomAnchor(enterButton, 1.0);
        rightContainer.setRightAnchor(enterButton, 1.0);

        rightContainer.setLeftAnchor(userInput , 1.0);
        rightContainer.setBottomAnchor(userInput, 1.0);

        // Split pane to hold both sides
        splitPane = new SplitPane();
        splitPane.getItems().addAll(leftContainer, rightContainer);

        // An anchorpane to take in the SplitPane and other tool windows/panes, adjustable
        AnchorPane mainLayout = new AnchorPane();
        mainLayout.getChildren().addAll(splitPane);

        Scene scene = new Scene(mainLayout);
        scene.getStylesheets().add(getClass().getResource("/org.openjfx/styles.css").toExternalForm());

        stage.setTitle("CrystalEye");
        stage.setResizable(true);
        stage.setMinWidth(1000.0);
        stage.setMinHeight(600.0);

        stage.setScene(scene);
        stage.show();

        mainLayout.setPrefSize(1000.0, 600.0);

        //Handle user input
        enterButton.setOnMouseClicked((event) -> {
            //the action triggered by the event
        });

        userInput.setOnAction((event) -> {
            //the action triggered by the event
        });
    }

    private void handleUserInput() {

    }

    private String getResponse(String input) {
        return "test";
    }

    public static void main(String[] args) {
        launch(args);
    }

}
