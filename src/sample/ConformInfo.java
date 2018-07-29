package sample;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class ConformInfo extends Application {
    private BooleanProperty isClicked = new SimpleBooleanProperty();
    private boolean isDeleted = true;

    public void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane sp = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        Text text = new Text("您确定要删除该信息?");
        Button button1 = new Button("确认");
        Button button2 = new Button("取消");

        gridPane.add(text, 0, 0, 2, 1);
        gridPane.add(button1, 0,1);
        gridPane.add(button2, 1,1);

        sp.getChildren().add(gridPane);

        Scene scene = new Scene(sp, 300, 125);
        primaryStage.setTitle("确认删除?");
        primaryStage.setScene(scene);
        primaryStage.show();

        button1.setOnMouseClicked(e -> {
            isClicked.set(!(isClicked.get()));
            isDeleted = true;
            primaryStage.close();
        });

        button2.setOnMouseClicked(e -> {
            isClicked.set(!(isClicked.get()));
            isDeleted = false;
            primaryStage.close();
        });
    }

    public boolean isIsClicked() {
        return isClicked.get();
    }

    public BooleanProperty isClickedProperty() {
        return isClicked;
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked.set(isClicked);
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}