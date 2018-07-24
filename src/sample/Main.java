package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane pane = new Pane();
        Circle circle = new Circle(50);
        circle.centerXProperty().bind(pane.widthProperty().divide(2));
        circle.centerYProperty().bind(pane.heightProperty().divide(2));
        pane.getChildren().add(circle);
        circle.setOnMouseClicked(e -> {
            pane.getChildren().remove(circle);
            Rectangle rectangle = new Rectangle(100, 100);
            pane.getChildren().add(rectangle);
                });

        Scene scene = new Scene(pane, 500, 500);


        primaryStage.setTitle("Reimbursement system");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
