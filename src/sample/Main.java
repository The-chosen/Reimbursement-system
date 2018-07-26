package sample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.WritableIntegerValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.util.Observable;

public class Main extends Application {
    Pane navigationPane;
    Pane sidebarPane;
    Pane topPane;
    Pane doPane;
    Pane pane;
    ReadOnlyDoubleProperty widthProperty;
    ReadOnlyDoubleProperty heightProperty;
    DoubleBinding sideBarProperty;
    IntegerProperty currentMode = new SimpleIntegerProperty();
    IntegerProperty currentMedicalMode = new SimpleIntegerProperty();
    IntegerProperty currentMedicalTreatmentMode = new SimpleIntegerProperty();


    public Main() {
        navigationPane = new Pane();
        sidebarPane = new Pane();
        topPane = new Pane();
        doPane = new Pane();
        pane = new VBox();
    }

    public void layoutMainPane() {
//        pane = new BorderPane();
//        VBox vBox = new VBox();
//        vBox.getChildren().addAll(topPane, navigationPane);
//        ((BorderPane)pane).setTop(vBox);
//        ((BorderPane)pane).setLeft(sidebarPane);
//        ((BorderPane)pane).setRight(doPane);
//
//        pane = new VBox();
        pane.getChildren().remove(0, pane.getChildren().size());
        pane.getChildren().add(topPane);
        pane.getChildren().add(navigationPane);
        HBox hBox = new HBox();
        hBox.getChildren().add(sidebarPane);
        hBox.getChildren().add(doPane);
        pane.getChildren().add(hBox);
    }

    public void layoutNavigationPane() {
        HBox hBox = new HBox();
        StackPane sp1 = new StackPane();
        sp1.setId("nsp1");
        StackPane sp2 = new StackPane();
        sp2.setId("nsp1");
        StackPane sp3 = new StackPane();
        sp3.setId("nsp1");
        StackPane sp4 = new StackPane();
        sp4.setId("nsp1");
        StackPane sp5 = new StackPane();
        sp5.setId("nsp1");
        StackPane sp = new StackPane();
        sp.setId("nsp");


        Text text1 = new Text("医疗基本信息");
        Text text2 = new Text("公共业务");
        Text text3 = new Text("医保中心报销");
        Text text4 = new Text("医疗待遇审批");
        Text text5 = new Text("综合查询");
        Text text = new Text("");
//        ImageView imageView = new ImageView("img/health.png");
//        imageView.fitWidthProperty().bind(widthProperty.divide(20));
//        imageView.fitHeightProperty().bind(heightProperty.divide(20));
        text1.setFont(new Font(20));
        text2.setFont(new Font(20));
        text3.setFont(new Font(20));
        text4.setFont(new Font(20));
        text5.setFont(new Font(20));

        sp1.getChildren().add(text1);
        sp2.getChildren().add(text2);
        sp3.getChildren().add(text3);
        sp4.getChildren().add(text4);
        sp5.getChildren().add(text5);
        sp.getChildren().add(text);
        hBox.getChildren().addAll(sp, sp1, sp2, sp3, sp4, sp5);

        sideBarProperty = widthProperty.subtract(sp1.prefWidthProperty().add(sp2.prefWidthProperty().
                        add(sp3.prefWidthProperty().add(sp4.prefWidthProperty().add(sp5.prefWidthProperty())))));
        sp.prefWidthProperty().bind(sideBarProperty);
        navigationPane = hBox;

        sp1.setOnMouseClicked(e -> {
            currentMode.set(1);
        });

        sp2.setOnMouseClicked(e -> {
            currentMode.set(2);
        });

        sp3.setOnMouseClicked(e -> {
            currentMode.set(3);
        });

        sp4.setOnMouseClicked(e -> {
            currentMode.set(4);
        });

        sp5.setOnMouseClicked(e -> {
            currentMode.set(5);
        });

    }

    public void layoutSidebarPane() {
        VBox vBox = new VBox();

        if (currentMode.get() == 1) {
            StackPane sp1 = new StackPane();
            sp1.setId("ssp1");
            StackPane sp2 = new StackPane();
            sp2.setId("ssp1");
            StackPane sp3 = new StackPane();
            sp3.setId("ssp1");
            StackPane sp4 = new StackPane();
            sp4.setId("ssp1");
            StackPane sp5 = new StackPane();
            sp5.setId("ssp1");
            StackPane sp = new StackPane();
            sp.setId("ssp");

            Text text1 = new Text("药物");
            Text text2 = new Text("诊疗");
            Text text3 = new Text("服务设施");
            Text text4 = new Text("定点医疗机构");
            Text text5 = new Text("医疗待遇计算参数");
            Text text = new Text("");
            text1.setFont(new Font(16));
            text2.setFont(new Font(16));
            text3.setFont(new Font(16));
            text4.setFont(new Font(16));
            text5.setFont(new Font(16));

            sp1.getChildren().add(text1);
            sp2.getChildren().add(text2);
            sp3.getChildren().add(text3);
            sp4.getChildren().add(text4);
            sp5.getChildren().add(text5);
            sp.getChildren().add(text);


            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.4));

            vBox.getChildren().addAll(sp1, sp2, sp3, sp4, sp5, sp);

            sp1.setOnMouseClicked(e -> {
                currentMedicalMode.set(1);
            });

            sp2.setOnMouseClicked(e -> {
                currentMedicalMode.set(2);
            });

            sp3.setOnMouseClicked(e -> {
                currentMedicalMode.set(3);
            });

            sp4.setOnMouseClicked(e -> {
                currentMedicalMode.set(4);
            });

            sp5.setOnMouseClicked(e -> {
                currentMedicalMode.set(5);
            });
        }

        else if (currentMode.get() == 2) {
            StackPane sp1 = new StackPane();
            sp1.setId("ssp1");
            StackPane sp = new StackPane();
            sp.setId("ssp");

            Text text1 = new Text("参保人信息");
            text1.setFont(new Font(16));
            Text text = new Text("");

            sp1.getChildren().add(text1);
            sp.getChildren().add(text);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.4));

            vBox.getChildren().addAll(sp1, sp);
        }

        else if (currentMode.get() == 3) {
            StackPane sp1 = new StackPane();
            sp1.setId("ssp1");
            StackPane sp = new StackPane();
            sp.setId("ssp");

            Text text1 = new Text("医保中心报销");
            text1.setFont(new Font(16));
            Text text = new Text("");

            sp1.getChildren().add(text1);
            sp.getChildren().add(text);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.4));

            vBox.getChildren().addAll(sp1, sp);
        }

        else if (currentMode.get() == 4) {
            StackPane sp1 = new StackPane();
            sp1.setId("ssp1");
            StackPane sp2 = new StackPane();
            sp2.setId("ssp1");
            StackPane sp = new StackPane();
            sp.setId("ssp");

            Text text1 = new Text("特检特治");
            text1.setFont(new Font(16));
            Text text2 = new Text("不同医保医院");
            text2.setFont(new Font(16));
            Text text = new Text("");

            sp1.getChildren().add(text1);
            sp2.getChildren().add(text2);
            sp.getChildren().add(text);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.4));

            vBox.getChildren().addAll(sp1, sp2, sp);

            sp1.setOnMouseClicked(e -> {
                currentMedicalTreatmentMode.set(1);
            });

            sp2.setOnMouseClicked(e -> {
                currentMedicalTreatmentMode.set(2);
            });
        }

        else if (currentMode.get() == 5) {
            StackPane sp1 = new StackPane();
            sp1.setId("ssp1");
            StackPane sp = new StackPane();
            sp.setId("ssp");

            Text text1 = new Text("综合查询");
            text1.setFont(new Font(16));
            Text text = new Text("");

            sp1.getChildren().add(text1);
            sp.getChildren().add(text);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.4));

            vBox.getChildren().addAll(sp1, sp);
        }

        else {
            ImageView imageView = new ImageView("img/logo.png");
            imageView.fitHeightProperty().bind(heightProperty.divide(7));
            imageView.fitWidthProperty().bind(widthProperty.divide(9.2));
            StackPane sp = new StackPane();
            sp.setId("ssp1");
            sp.getChildren().add(imageView);
            sp.setAlignment(Pos.BOTTOM_CENTER);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.35));
            vBox.getChildren().add(sp);
        }

        sidebarPane = vBox;

    }

    public void layoutTopPane() {
        Text text = new Text("医疗保险中心报销系统");
        text.setFont(new Font("微软雅黑", 30));
        text.setStroke(Color.WHITE);
        StackPane sp = new StackPane();
        sp.getChildren().add(text);
        sp.setId("topPaneStackPane");
        sp.setAlignment(Pos.BOTTOM_LEFT);
        topPane = sp;
    }

    public void layoutDoPane() {
        StackPane stackPane = new StackPane();
        stackPane.setId("welcomePane");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        ImageView imageView2 = new ImageView("img/welcome.png");
        imageView2.fitWidthProperty().bind(widthProperty.divide(2));
        imageView2.fitHeightProperty().bind(heightProperty.divide(1.5));
        stackPane.getChildren().add(imageView2);
        doPane = stackPane;

        if (currentMedicalMode.get() != 0) {

        }


        if (currentMedicalTreatmentMode.get() != 0) {

        }
    }

    public void listenMedicalInformation() {

    }

    public void listenPublicServiceTackle() {

    }

    public void listenMedicalInsuranceCenterReimbursement() {

    }

    public void listenMedicalTreatmentApproval() {

    }

    public void listenIntegratedQuery() {

    }








    public Pane getNavigationPane() {
        return navigationPane;
    }

    public void setNavigationPane(Pane navigationPane) {
        this.navigationPane = navigationPane;
    }

    public Pane getSidebarPane() {
        return sidebarPane;
    }

    public void setSidebarPane(Pane sidebarPane) {
        this.sidebarPane = sidebarPane;
    }

    public Pane getTopPane() {
        return topPane;
    }

    public void setTopPane(Pane topPane) {
        this.topPane = topPane;
    }

    public Pane getDoPane() {
        return doPane;
    }

    public void setDoPane(Pane doPane) {
        this.doPane = doPane;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }



    @Override
    public void start(Stage primaryStage) {
        widthProperty = primaryStage.widthProperty();
        heightProperty = primaryStage.heightProperty();
        currentMode.set(0);
        currentMedicalMode.set(0);
        currentMedicalTreatmentMode.set(0);
        layoutTopPane();
        layoutNavigationPane();
        layoutSidebarPane();
        layoutDoPane();
        layoutMainPane();


        currentMode.addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutSidebarPane();
                layoutMainPane();
                if (currentMode.get() == 1) {
                    currentMedicalTreatmentMode.set(0);
                }
                else if (currentMode.get() == 4) {
                    currentMedicalMode.set(0);
                }
            }
        });

        currentMedicalMode.addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });

        currentMedicalTreatmentMode.addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });


        Scene scene = new Scene(pane, 900, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().addAll(getClass().getResource("../css/Main.css").toExternalForm());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
