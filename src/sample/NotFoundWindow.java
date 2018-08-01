package sample;

/*
 * 该类是显示未搜寻到相关信息的弹窗
 * author: 杨越
 * version: v1
 * */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class NotFoundWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /*
     * 未搜寻到相关信息的布局与点击事件处理
     * parameter: Stage primaryStage
     * return: void
     * */
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
