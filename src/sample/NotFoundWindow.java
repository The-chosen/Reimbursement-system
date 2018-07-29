package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class NotFoundWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane stackPane = new StackPane();
        Text text = new Text("未搜寻到，请检查您所输入的编号!");

        stackPane.getChildren().add(text);

        Scene scene = new Scene(stackPane, 300, 125);
        primaryStage.setScene(scene);
        primaryStage.setTitle("未搜寻到!");
        primaryStage.show();
    }
}
