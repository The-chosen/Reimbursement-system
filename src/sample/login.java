package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Observable;


public class login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new BorderPane();
        GridPane gridPane = new GridPane();
        Scene scene = new Scene(pane, 500, 500);


        Text text = new Text("医保系统登陆");
        text.setTextAlignment(TextAlignment.JUSTIFY);
        text.setFont(new Font(40));
        text.setStroke(Color.BLUE);
        StackPane sp = toChange(text);
        sp.setPadding(new Insets(0, 0, 25, 0));


        Label label1 = new Label("用户名:");
        Label label2 = new Label("密码:");
        StackPane sp1 = toChange(label1);
        sp1.setPadding(new Insets(0, 0, 20, 0));
        StackPane sp4 = toChange(label2);
        sp4.setPadding(new Insets(0, 0, 20, 0));

        TextField textField = new TextField();
        textField.setStyle("-fx-text-fill: gray");
        textField.setAlignment(Pos.BASELINE_RIGHT);
        StackPane sp2 = toChange(textField);
        sp2.setPadding(new Insets(0, 0, 20, 0));


        PasswordField passwordField = new PasswordField();
        passwordField.setAlignment(Pos.BASELINE_RIGHT);
        StackPane sp3 = toChange(passwordField);
        sp3.setPadding(new Insets(0, 0, 20, 0));


        Button button = new Button("登陆");
        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
        });
        button.setOnMouseExited(e -> {
            button.setStyle("-fx-effect: null");
        });

        gridPane.add(sp, 0, 0, 2, 1);
        gridPane.add(sp1, 0, 2);
        gridPane.add(sp2, 1, 2);
        gridPane.add(sp4, 0, 3);
        gridPane.add(sp3, 1, 3);
        gridPane.add(toChange(button), 0, 4, 2, 1);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));



        ((BorderPane)pane).setCenter(gridPane);

        button.setOnMouseClicked(e -> {
            String name = textField.getText();
            String password = passwordField.getText();
            boolean isRight = isRight(name, password);
            if (isRight) {
            primaryStage.hide();
            Main main = new Main();
            main.start(new Stage());
            }
            else {
                Text warning = new Text("用户名或密码错误！请重新输入：");
                warning.setStroke(Color.RED);
                warning.setFont(new Font("等线", 15));
                gridPane.add(warning,0, 1, 2, 1);
            }
        });


        primaryStage.setTitle("医保系统");
        primaryStage.setScene(scene);
        scene.getStylesheets().addAll(getClass().getResource("../css/Login.css").toExternalForm());
        primaryStage.show();
    }

    public boolean isRight(String name, String password){
        if (name.equals("") && password.equals("")){
            return true;
        }
        return false;
    }

    public StackPane toChange(Node node) {
        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(node);
        return stackPane;
    }
}
