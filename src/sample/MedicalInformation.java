package sample;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.LinkedList;


public class MedicalInformation {
    private Pane medicinePane;
    private Pane treatmentPane;
    private Pane serviceFacilityPane;
    private Pane fixedMedicalInstitutionPane;
    private Pane medicalTreatmentCalculationParameterPane;
    private Pane initialPane;
    private int whichChoice;
    private int isSuccessful;
    private int isNotFound;
    private Pane successPane;
    private BooleanProperty isChanged = new SimpleBooleanProperty();
    private ReadOnlyDoubleProperty widthProperty;
    private ReadOnlyDoubleProperty heightProperty;

    public MedicalInformation(ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        medicinePane = new Pane();
        treatmentPane = new Pane();
        serviceFacilityPane = new Pane();
        fixedMedicalInstitutionPane = new Pane();
        medicalTreatmentCalculationParameterPane = new Pane();
        initialPane = new Pane();
        successPane = new Pane();
        whichChoice = 0;
        isSuccessful = 0;
        this.widthProperty = widthProperty;
        this.heightProperty = heightProperty;
        isChanged.set(true);
        isNotFound = 0;
    }

    public void layoutInitialPane() {
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        VBox v1 = new VBox();
        VBox v2 = new VBox();
        VBox v3 = new VBox();
        VBox v4 = new VBox();
        v1.setId("v1");
        v2.setId("v2");
        v3.setId("v3");
        v4.setId("v4");
        v1.setAlignment(Pos.CENTER);
        v2.setAlignment(Pos.CENTER);
        v3.setAlignment(Pos.CENTER);
        v4.setAlignment(Pos.CENTER);


        ImageView img1 = new ImageView("img/addIcon.png");
        ImageView imgt1 = new ImageView("img/addInfo.png");
        ImageView img2 = new ImageView("img/deleteIcon.png");
        ImageView imgt2 = new ImageView("img/deleteInfo.png");
        ImageView img3 = new ImageView("img/selectIcon.png");
        ImageView imgt3 = new ImageView("img/selectInfo.png");
        ImageView img4 = new ImageView("img/changeIcon.png");
        ImageView imgt4 = new ImageView("img/changeInfo.png");
        ImageView img = new ImageView("img/trueLogo.png");

        img1.fitWidthProperty().bind(widthProperty.divide(11));
        img1.fitHeightProperty().bind(heightProperty.divide(8.5));
        imgt1.fitWidthProperty().bind(widthProperty.divide(10));
        imgt1.fitHeightProperty().bind(heightProperty.divide(20));
        img2.fitWidthProperty().bind(widthProperty.divide(11));
        img2.fitHeightProperty().bind(heightProperty.divide(8.5));
        imgt2.fitWidthProperty().bind(widthProperty.divide(10));
        imgt2.fitHeightProperty().bind(heightProperty.divide(20));
        img3.fitWidthProperty().bind(widthProperty.divide(11));
        img3.fitHeightProperty().bind(heightProperty.divide(8.5));
        imgt3.fitWidthProperty().bind(widthProperty.divide(10));
        imgt3.fitHeightProperty().bind(heightProperty.divide(20));
        img4.fitWidthProperty().bind(widthProperty.divide(11));
        img4.fitHeightProperty().bind(heightProperty.divide(8.5));
        imgt4.fitWidthProperty().bind(widthProperty.divide(10));
        imgt4.fitHeightProperty().bind(heightProperty.divide(20));
        img.fitWidthProperty().bind(widthProperty.divide(5));
        img.fitHeightProperty().bind(heightProperty.divide(4));


        v1.getChildren().addAll(img1, imgt1);
        v2.getChildren().addAll(img2, imgt2);
        v3.getChildren().addAll(img3, imgt3);
        v4.getChildren().addAll(img4, imgt4);

        gridPane.add(v1, 1, 0);
        gridPane.add(v2, 2, 1);
        gridPane.add(v3, 1, 2);
        gridPane.add(v4, 0, 1);
        gridPane.add(img, 1, 1);

        stackPane.getChildren().add(gridPane);
        initialPane = stackPane;

        v1.setOnMouseClicked(e -> {
            whichChoice = 1;
            isChanged.set(!(isChanged.get()));
        });

        v2.setOnMouseClicked(e -> {
            whichChoice = 2;
            isChanged.set(!(isChanged.get()));
        });

        v3.setOnMouseClicked(e -> {
            whichChoice = 3;
            isChanged.set(!(isChanged.get()));
        });

        v4.setOnMouseClicked(e -> {
            whichChoice = 4;
            isChanged.set(!(isChanged.get()));
        });

    }

    public void layoutMedicinePane(int num) {
        whichChoice = 0;
        if (num == 1) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(10);
            gridPane.setVgap(8);

            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            TextField tf3 = new TextField();
            TextField tf4 = new TextField();
            TextField tf5 = new TextField();
            TextField tf6 = new TextField();
            TextField tf7 = new TextField();
            TextField tf8 = new TextField();
            TextField tf9 = new TextField();
            TextField tf10 = new TextField();
            TextField tf11 = new TextField();
            TextField tf12 = new TextField();
            TextField tf13 = new TextField();
            TextField tf14 = new TextField();
            TextField tf15 = new TextField();
            TextField tf16 = new TextField("若不在基本医疗保险目录中，则无需填写。");
            tf1.setMaxSize(150, 10);
            tf2.setMaxSize(170, 10);
            tf3.setMaxSize(170, 10);
            tf4.setMaxSize(170, 10);
            tf5.setMaxSize(170, 10);
            tf6.setMaxSize(170, 10);
            tf7.setMaxSize(170, 10);
            tf8.setMaxSize(170, 10);
            tf9.setMaxSize(170, 10);
            tf10.setMaxSize(170, 10);
            tf11.setMaxSize(170, 10);
            tf12.setMaxSize(170, 10);
            tf13.setMaxSize(170, 10);
            tf14.setMaxSize(170, 10);
            tf15.setMaxSize(170, 10);
            tf16.setMaxSize(170, 10);

            tf16.setOnMouseClicked(e -> {
                tf16.setText("");
            });

            RadioButton rb1 = new RadioButton("有");
            RadioButton rb2 = new RadioButton("没有");
            RadioButton rb3 = new RadioButton("在");
            RadioButton rb4 = new RadioButton("不在");
            ToggleGroup tg1 = new ToggleGroup();
            ToggleGroup tg2 = new ToggleGroup();
            rb1.setToggleGroup(tg1);
            rb2.setToggleGroup(tg1);
            rb3.setToggleGroup(tg2);
            rb4.setToggleGroup(tg2);
            TextArea ta = new TextArea();
            ta.setMaxSize(260, 30);

            Label lb1 = new Label("药品ID:");
            Label lb2 = new Label("药品等级:");
            Label lb3 = new Label("药品中文名字:");
            Label lb4 = new Label("药品英文名字:");
            Label lb5 = new Label("医院价格:");
            Label lb6 = new Label("中心价格:");
            Label lb7 = new Label("使用该药的医院等级:");
            Label lb8 = new Label("剂型:");
            Label lb9 = new Label("使用频次:");
            Label lb10 = new Label("用法:");
            Label lb11 = new Label("单位:");
            Label lb12 = new Label("规格:");
            Label lb13 = new Label("限定天数:");
            Label lb14 = new Label("药厂名称:");
            Label lb15 = new Label("产地:");

            Label lb16 = new Label("备注:");
            Label lb17 = new Label("是否有审核标签:");
            Label lb18 = new Label("是否在基本医疗保险费用里:");
            Label lb19 = new Label("基本医疗保险费用中的ID:");

            Button btn = new Button("确认提交本药物信息");

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 2, 0);
            gridPane.add(lb3, 0, 1);
            gridPane.add(lb4, 2, 1);
            gridPane.add(lb5, 0, 2);
            gridPane.add(lb6, 2, 2);
            gridPane.add(lb7, 0, 3);
            gridPane.add(lb8, 2, 3);
            gridPane.add(lb9, 0, 4);
            gridPane.add(lb10, 2, 4);
            gridPane.add(lb11, 0, 5);
            gridPane.add(lb12, 2, 5);
            gridPane.add(lb13, 0, 6);
            gridPane.add(lb14, 2, 6);
            gridPane.add(lb15, 0, 7);

            gridPane.add(lb16, 0, 11);
            gridPane.add(lb17, 2, 8, 2, 1);
            gridPane.add(lb18, 0, 8, 2, 1);
            gridPane.add(lb19, 0, 10);

            gridPane.add(tf1, 1, 0);
            gridPane.add(tf2, 3, 0);
            gridPane.add(tf3, 1, 1);
            gridPane.add(tf4, 3, 1);
            gridPane.add(tf5, 1, 2);
            gridPane.add(tf6, 3, 2);
            gridPane.add(tf7, 1, 3);
            gridPane.add(tf8, 3, 3);
            gridPane.add(tf9, 1, 4);
            gridPane.add(tf10, 3, 4);
            gridPane.add(tf11, 1, 5);
            gridPane.add(tf12, 3, 5);
            gridPane.add(tf13, 1, 6);
            gridPane.add(tf14, 3, 6);
            gridPane.add(tf15, 1, 7);
            gridPane.add(tf16, 1, 10);

            gridPane.add(ta, 0, 12, 2, 1);
            gridPane.add(rb3, 0, 9);
            gridPane.add(rb4, 1, 9);
            gridPane.add(rb1, 2, 9);
            gridPane.add(rb2, 3, 9);

            gridPane.add(btn, 0, 13, 2, 1);

            stackPane.getChildren().add(gridPane);

            medicinePane = stackPane;

            btn.setOnMouseClicked(e -> {
                String medicineId = tf1.getText();
                String medicineLevel = tf2.getText();
                String medicineNameCh = tf3.getText();
                String medicineNameEn = tf4.getText();
                String hospitalPrice = tf5.getText();
                String centerPrice = tf6.getText();
                String hospitalLevel = tf7.getText();
                String dosageForm = tf8.getText();
                String frequency = tf9.getText();
                String usageMethod = tf10.getText();
                String unit = tf11.getText();
                String size = tf12.getText();
                String restrictNumberOfDay = tf13.getText();
                String nameOfFactory = tf14.getText();
                String placeOfProduction = tf15.getText();

                boolean isInCategory;
                String idInCategory;
                if (rb3.isSelected()) {
                    isInCategory = true;
                    idInCategory = tf16.getText();
                }
                else {
                    isInCategory = false;
                    idInCategory = null;
                }

                boolean isLabeled = true;
                if (rb1.isSelected()) {
                    isLabeled = true;
                }
                else {
                    isLabeled = false;
                }

                String remark = ta.getText();

                Medicine medicine = new Medicine(medicineId, medicineNameCh, medicineNameEn,
                        medicineLevel, isLabeled, isInCategory,
                        idInCategory, hospitalPrice, hospitalLevel,
                        dosageForm, frequency, usageMethod,
                        unit, size, restrictNumberOfDay,
                        nameOfFactory, placeOfProduction, remark, centerPrice);

                File file = new File("src/files/medicine.dat");
                writeFile(file, medicine);

                whichChoice = 0;
                isSuccessful = 1;
                isChanged.set(!(isChanged.get()));
            });
        }

        else if (num == 2) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要删除的药物编号:");
            TextField textField = new TextField();
            Button button = new Button("删除");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane.add(label, 0, 0);
            gridPane.add(textField, 1, 0);
            gridPane.add(button, 1, 1);

            stackPane.getChildren().add(gridPane);
            medicinePane = stackPane;

            button.setOnMouseClicked(e -> {
                whichChoice = 0;
                ConformInfo conformInfo = new ConformInfo();
                Stage s = new Stage();
                conformInfo.start(s);
                (conformInfo.isClickedProperty()).addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        s.close();
                        if (conformInfo.isDeleted()) {
                            File file = new File("src/files/medicine.dat");

                            if (deleteInFile(file, "Medicine",textField.getText())) {
                                isSuccessful = 2;
                                isChanged.set(!(isChanged.get()));
                            }
                            else {
                                NotFoundWindow notFoundWindow = new NotFoundWindow();
                                Stage stage = new Stage();
                                notFoundWindow.start(stage);
                                stage.setOnCloseRequest(e -> {
                                    isNotFound = 1;
                                    isChanged.set(!(isChanged.get()));
                                });

                            }
                        }
                    }
                });
            });
        }

        else if (num == 3) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要查找的药物编号:");
            TextField textField = new TextField();
            Button button = new Button("查找");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            medicinePane = stackPane;


            button.setOnMouseClicked(e -> {
                File file = new File("src/files/medicine.dat");
                Medicine medicine = (Medicine)selectFromTheFile(file, textField.getText(), "Medicine");
                if (medicine != null) {
                    Label lb1 = new Label("药品ID:");
                    Label lb2 = new Label("药品等级:");
                    Label lb3 = new Label("药品中文名字:");
                    Label lb4 = new Label("药品英文名字:");
                    Label lb5 = new Label("医院价格:");
                    Label lb6 = new Label("中心价格:");
                    Label lb7 = new Label("使用该药的医院等级:");
                    Label lb8 = new Label("剂型:");
                    Label lb9 = new Label("使用频次:");
                    Label lb10 = new Label("用法:");
                    Label lb11 = new Label("单位:");
                    Label lb12 = new Label("规格:");
                    Label lb13 = new Label("限定天数:");
                    Label lb14 = new Label("药厂名称:");
                    Label lb15 = new Label("产地:");

                    Label lb16 = new Label("备注:");
                    Label lb17 = new Label("是否有审核标签:");
                    Label lb18 = new Label("是否在基本医疗保险费用里:");
                    Label lb19 = new Label("基本医疗保险费用中的ID:");

                    Text t1 = new Text(medicine.getMedicineId());
                    Text t2 = new Text(medicine.getMedicineLevel());
                    Text t3 = new Text(medicine.getMedicineNameCh());
                    Text t4 = new Text(medicine.getMedicineNameEn());
                    Text t5 = new Text(medicine.getHospitalPrice());
                    Text t6 = new Text(medicine.getCeterPrice());
                    Text t7 = new Text(medicine.getHospitalLevel());
                    Text t8 = new Text(medicine.getDosageForm());
                    Text t9 = new Text(medicine.getFrequency());
                    Text t10 = new Text(medicine.getUsageMethod());
                    Text t11 = new Text(medicine.getUnit());
                    Text t12 = new Text(medicine.getSize());
                    Text t13 = new Text(medicine.getRestrictNumberOfDay());
                    Text t14 = new Text(medicine.getNameOfFactory());
                    Text t15 = new Text(medicine.getPlaceOfProduction());
                    Text t16 = new Text(medicine.getRemark());

                    GridPane gridPane2 = new GridPane();

                    Text t17;
                    if (medicine.isLabeled()) {
                        t17 = new Text("有");
                    }
                    else {
                        t17 = new Text("没有");
                    }

                    Text t18;
                    Text t19;
                    if (medicine.isInCategory()) {
                        t18 = new Text("在");
                        t19 = new Text(medicine.getIdInCategory());
                        gridPane2.add(lb19, 0, 9);
                        gridPane2.add(t19, 1, 9);
                    }
                    else {
                        t18 = new Text("不在");
                    }


                    gridPane2.add(lb1, 0, 0);
                    gridPane2.add(lb2, 2, 0);
                    gridPane2.add(lb3, 0, 1);
                    gridPane2.add(lb4, 2, 1);
                    gridPane2.add(lb5, 0, 2);
                    gridPane2.add(lb6, 2, 2);
                    gridPane2.add(lb7, 0, 3);
                    gridPane2.add(lb8, 2, 3);
                    gridPane2.add(lb9, 0, 4);
                    gridPane2.add(lb10, 2, 4);
                    gridPane2.add(lb11, 0, 5);
                    gridPane2.add(lb12, 2, 5);
                    gridPane2.add(lb13, 0, 6);
                    gridPane2.add(lb14, 2, 6);
                    gridPane2.add(lb15, 0, 7);

                    gridPane2.add(lb16, 0, 10);
                    gridPane2.add(lb17, 2, 8);
                    gridPane2.add(lb18, 0, 8);



                    gridPane2.add(t1, 1, 0);
                    gridPane2.add(t2, 3, 0);
                    gridPane2.add(t3, 1, 1);
                    gridPane2.add(t4, 3, 1);
                    gridPane2.add(t5, 1, 2);
                    gridPane2.add(t6, 3, 2);
                    gridPane2.add(t7, 1, 3);
                    gridPane2.add(t8, 3, 3);
                    gridPane2.add(t9, 1, 4);
                    gridPane2.add(t10, 3, 4);
                    gridPane2.add(t11, 1, 5);
                    gridPane2.add(t12, 3, 5);
                    gridPane2.add(t13, 1, 6);
                    gridPane2.add(t14, 3, 6);
                    gridPane2.add(t15, 1, 7);
                    gridPane2.add(t16, 1, 10);

                    gridPane2.add(t17, 1, 8);
                    gridPane2.add(t18, 3, 8);

                    gridPane2.setVgap(15);
                    gridPane2.setHgap(15);

                    medicinePane = gridPane2;


                    whichChoice = 0;
                    isSuccessful = 3;
                    isChanged.set(!(isChanged.get()));
                }
                else {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(ex -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
            });
        }

        else if (num == 4) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要修改的药物编号:");
            TextField textField = new TextField();
            Button button = new Button("修改");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            medicinePane = stackPane;

            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/medicine.dat");
                Medicine medicine = (Medicine)selectFromTheFile(file, textField.getText(), "Medicine");

                if (medicine == null) {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
                else {
                    StackPane stackPane1 = new StackPane();
                    stackPane.setId("sp");
                    stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setPadding(new Insets(20, 0, 20, 20));
                    gridPane.setHgap(10);
                    gridPane.setVgap(8);

                    TextField tf1 = new TextField(medicine.getMedicineId());
                    TextField tf2 = new TextField(medicine.getMedicineLevel());
                    TextField tf3 = new TextField(medicine.getMedicineNameCh());
                    TextField tf4 = new TextField(medicine.getMedicineNameEn());
                    TextField tf5 = new TextField(medicine.getHospitalPrice());
                    TextField tf6 = new TextField(medicine.getCeterPrice());
                    TextField tf7 = new TextField(medicine.getHospitalLevel());
                    TextField tf8 = new TextField(medicine.getDosageForm());
                    TextField tf9 = new TextField(medicine.getFrequency());
                    TextField tf10 = new TextField(medicine.getUsageMethod());
                    TextField tf11 = new TextField(medicine.getUnit());
                    TextField tf12 = new TextField(medicine.getSize());
                    TextField tf13 = new TextField(medicine.getRestrictNumberOfDay());
                    TextField tf14 = new TextField(medicine.getNameOfFactory());
                    TextField tf15 = new TextField(medicine.getPlaceOfProduction());
                    TextField tf16 = new TextField("若不在基本医疗保险目录中，则无需填写。");
                    tf1.setMaxSize(150, 10);
                    tf2.setMaxSize(170, 10);
                    tf3.setMaxSize(170, 10);
                    tf4.setMaxSize(170, 10);
                    tf5.setMaxSize(170, 10);
                    tf6.setMaxSize(170, 10);
                    tf7.setMaxSize(170, 10);
                    tf8.setMaxSize(170, 10);
                    tf9.setMaxSize(170, 10);
                    tf10.setMaxSize(170, 10);
                    tf11.setMaxSize(170, 10);
                    tf12.setMaxSize(170, 10);
                    tf13.setMaxSize(170, 10);
                    tf14.setMaxSize(170, 10);
                    tf15.setMaxSize(170, 10);
                    tf16.setMaxSize(170, 10);

                    tf16.setOnMouseClicked(ex -> {
                        tf16.setText("");
                    });

                    RadioButton rb1 = new RadioButton("有");
                    RadioButton rb2 = new RadioButton("没有");
                    RadioButton rb3 = new RadioButton("在");
                    RadioButton rb4 = new RadioButton("不在");
                    ToggleGroup tg1 = new ToggleGroup();
                    ToggleGroup tg2 = new ToggleGroup();
                    rb1.setToggleGroup(tg1);
                    rb2.setToggleGroup(tg1);
                    rb3.setToggleGroup(tg2);
                    rb4.setToggleGroup(tg2);
                    TextArea ta = new TextArea(medicine.getRemark());
                    ta.setMaxSize(260, 30);

                    if (medicine.isInCategory()) {
                        rb3.setSelected(true);
                        tf16.setText(medicine.getIdInCategory());
                    }

                    if (medicine.isLabeled()) {
                        rb1.setSelected(true);
                    }

                    Label lb1 = new Label("药品ID:");
                    Label lb2 = new Label("药品等级:");
                    Label lb3 = new Label("药品中文名字:");
                    Label lb4 = new Label("药品英文名字:");
                    Label lb5 = new Label("医院价格:");
                    Label lb6 = new Label("中心价格:");
                    Label lb7 = new Label("使用该药的医院等级:");
                    Label lb8 = new Label("剂型:");
                    Label lb9 = new Label("使用频次:");
                    Label lb10 = new Label("用法:");
                    Label lb11 = new Label("单位:");
                    Label lb12 = new Label("规格:");
                    Label lb13 = new Label("限定天数:");
                    Label lb14 = new Label("药厂名称:");
                    Label lb15 = new Label("产地:");

                    Label lb16 = new Label("备注:");
                    Label lb17 = new Label("是否有审核标签:");
                    Label lb18 = new Label("是否在基本医疗保险费用里:");
                    Label lb19 = new Label("基本医疗保险费用中的ID:");

                    Button btn = new Button("确认提交本药物信息");

                    gridPane.add(lb1, 0, 0);
                    gridPane.add(lb2, 2, 0);
                    gridPane.add(lb3, 0, 1);
                    gridPane.add(lb4, 2, 1);
                    gridPane.add(lb5, 0, 2);
                    gridPane.add(lb6, 2, 2);
                    gridPane.add(lb7, 0, 3);
                    gridPane.add(lb8, 2, 3);
                    gridPane.add(lb9, 0, 4);
                    gridPane.add(lb10, 2, 4);
                    gridPane.add(lb11, 0, 5);
                    gridPane.add(lb12, 2, 5);
                    gridPane.add(lb13, 0, 6);
                    gridPane.add(lb14, 2, 6);
                    gridPane.add(lb15, 0, 7);

                    gridPane.add(lb16, 0, 11);
                    gridPane.add(lb17, 2, 8, 2, 1);
                    gridPane.add(lb18, 0, 8, 2, 1);
                    gridPane.add(lb19, 0, 10);

                    gridPane.add(tf1, 1, 0);
                    gridPane.add(tf2, 3, 0);
                    gridPane.add(tf3, 1, 1);
                    gridPane.add(tf4, 3, 1);
                    gridPane.add(tf5, 1, 2);
                    gridPane.add(tf6, 3, 2);
                    gridPane.add(tf7, 1, 3);
                    gridPane.add(tf8, 3, 3);
                    gridPane.add(tf9, 1, 4);
                    gridPane.add(tf10, 3, 4);
                    gridPane.add(tf11, 1, 5);
                    gridPane.add(tf12, 3, 5);
                    gridPane.add(tf13, 1, 6);
                    gridPane.add(tf14, 3, 6);
                    gridPane.add(tf15, 1, 7);
                    gridPane.add(tf16, 1, 10);

                    gridPane.add(ta, 0, 12, 2, 1);
                    gridPane.add(rb3, 0, 9);
                    gridPane.add(rb4, 1, 9);
                    gridPane.add(rb1, 2, 9);
                    gridPane.add(rb2, 3, 9);

                    gridPane.add(btn, 0, 13, 2, 1);

                    stackPane1.getChildren().add(gridPane);

                    medicinePane = stackPane1;

                    whichChoice = 0;
                    isSuccessful = 5;
                    isChanged.set(!(isChanged.get()));


                    btn.setOnMouseClicked(exx -> {
                        String medicineId = tf1.getText();
                        String medicineLevel = tf2.getText();
                        String medicineNameCh = tf3.getText();
                        String medicineNameEn = tf4.getText();
                        String hospitalPrice = tf5.getText();
                        String centerPrice = tf6.getText();
                        String hospitalLevel = tf7.getText();
                        String dosageForm = tf8.getText();
                        String frequency = tf9.getText();
                        String usageMethod = tf10.getText();
                        String unit = tf11.getText();
                        String size = tf12.getText();
                        String restrictNumberOfDay = tf13.getText();
                        String nameOfFactory = tf14.getText();
                        String placeOfProduction = tf15.getText();

                        boolean isInCategory;
                        String idInCategory;
                        if (rb3.isSelected()) {
                            isInCategory = true;
                            idInCategory = tf16.getText();
                        }
                        else {
                            isInCategory = false;
                            idInCategory = null;
                        }

                        boolean isLabeled = true;
                        if (rb1.isSelected()) {
                            isLabeled = true;
                        }
                        else {
                            isInCategory = false;
                        }

                        String remark = ta.getText();

                        Medicine medicine1 = new Medicine(medicineId, medicineNameCh, medicineNameEn,
                                medicineLevel, isLabeled, isInCategory,
                                idInCategory, hospitalPrice, hospitalLevel,
                                dosageForm, frequency, usageMethod,
                                unit, size, restrictNumberOfDay,
                                nameOfFactory, placeOfProduction, remark, centerPrice);

                        File file1 = new File("src/files/medicine.dat");
                        changeInFile(file1, textField.getText(), "Medicine", medicine1);

                        isSuccessful = 4;
                        isChanged.set(!(isChanged.get()));
                    });

                }

            });
        }
    }

    public void layoutTreatmentPane(int num) {
        if (num == 1) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(10);
            gridPane.setVgap(8);

            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            TextField tf3 = new TextField();
            TextField tf4 = new TextField();
            TextField tf5 = new TextField();


            tf1.setMaxSize(150, 10);
            tf2.setMaxSize(170, 10);
            tf3.setMaxSize(170, 10);
            tf4.setMaxSize(170, 10);
            tf5.setMaxSize(170, 10);

            RadioButton rb1 = new RadioButton("有");
            RadioButton rb2 = new RadioButton("没有");

            ToggleGroup tg1 = new ToggleGroup();

            rb1.setToggleGroup(tg1);
            rb2.setToggleGroup(tg1);

            TextArea ta = new TextArea();
            ta.setMaxSize(260, 30);

            Label lb1 = new Label("诊疗项目ID:");
            Label lb2 = new Label("诊疗项目名称:");
            Label lb3 = new Label("诊疗项目级别:");
            Label lb4 = new Label("医院级别:");
            Label lb5 = new Label("生产厂家:");


            Label lb16 = new Label("备注:");
            Label lb17 = new Label("是否有审核标签:");

            Button btn = new Button("确认提交本诊疗项目信息");

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 2, 0);
            gridPane.add(lb3, 0, 1);
            gridPane.add(lb4, 2, 1);
            gridPane.add(lb5, 0, 2);


            gridPane.add(lb16, 0, 5);
            gridPane.add(lb17, 0, 3, 2, 1);

            gridPane.add(tf1, 1, 0);
            gridPane.add(tf2, 3, 0);
            gridPane.add(tf3, 1, 1);
            gridPane.add(tf4, 3, 1);
            gridPane.add(tf5, 1, 2);

            gridPane.add(ta, 0, 6, 2, 1);
            gridPane.add(rb1, 0, 4);
            gridPane.add(rb2, 1, 4);

            gridPane.add(btn, 0, 7, 2, 1);

            stackPane.getChildren().add(gridPane);

            treatmentPane = stackPane;

            btn.setOnMouseClicked(e -> {
                whichChoice = 0;
                String treatmentId = tf1.getText();
                String treatmentName = tf2.getText();
                String treatmentLevel = tf3.getText();
                String hospitalLevel = tf4.getText();
                String manufacturer = tf5.getText();

                boolean isLabeled;
                if (rb1.isSelected()) {
                    isLabeled = true;
                }
                else {
                    isLabeled = false;
                }

                String remark = ta.getText();

                Treatment treatment = new Treatment(treatmentId, treatmentName, treatmentLevel,
                        hospitalLevel, isLabeled, manufacturer,remark);

                File file = new File("src/files/treatment.dat");
                writeFile(file, treatment);

                isSuccessful = 1;
                isChanged.set(!(isChanged.get()));
            });
        }

        else if (num == 2) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要删除的诊疗项目编号:");
            TextField textField = new TextField();
            Button button = new Button("删除");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane.add(label, 0, 0);
            gridPane.add(textField, 1, 0);
            gridPane.add(button, 1, 1);

            stackPane.getChildren().add(gridPane);
            treatmentPane = stackPane;

            button.setOnMouseClicked(ee -> {
                whichChoice = 0;
                ConformInfo conformInfo = new ConformInfo();
                Stage s = new Stage();
                conformInfo.start(s);
                (conformInfo.isClickedProperty()).addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        s.close();
                        if (conformInfo.isDeleted()) {
                            File file = new File("src/files/treatment.dat");

                            if (deleteInFile(file, "Treatment",textField.getText())) {
                                isSuccessful = 2;
                                isChanged.set(!(isChanged.get()));
                            }
                            else {
                                NotFoundWindow notFoundWindow = new NotFoundWindow();
                                Stage stage = new Stage();
                                notFoundWindow.start(stage);
                                stage.setOnCloseRequest(e -> {
                                    isNotFound = 1;
                                    isChanged.set(!(isChanged.get()));
                                });

                            }
                        }
                    }
                });
            });
        }

        else if (num == 3) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要查找的诊疗项目编号:");
            TextField textField = new TextField();
            Button button = new Button("查找");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            treatmentPane = stackPane;


            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/treatment.dat");
                Treatment treatment = (Treatment)selectFromTheFile(file, textField.getText(), "Treatment");
                if (treatment != null) {
                    Label lb1 = new Label("诊疗项目ID:");
                    Label lb2 = new Label("诊疗项目名称:");
                    Label lb3 = new Label("诊疗项目级别:");
                    Label lb4 = new Label("医院级别:");
                    Label lb5 = new Label("生产厂家:");


                    Label lb16 = new Label("备注:");
                    Label lb17 = new Label("是否有审核标签:");


                    Text t1 = new Text(treatment.getTreatmentId());
                    Text t2 = new Text(treatment.getTreatmentName());
                    Text t3 = new Text(treatment.getTreatmentLevel());
                    Text t4 = new Text(treatment.getHospitalLevel());
                    Text t5 = new Text(treatment.getManufacturer());
                    Text t6 = new Text(treatment.getRemark());


                    GridPane gridPane2 = new GridPane();

                    Text t17;
                    if (treatment.isLabeled()) {
                        t17 = new Text("有");
                    }
                    else {
                        t17 = new Text("没有");
                    }

                    gridPane2.add(lb1, 0, 0);
                    gridPane2.add(lb2, 2, 0);
                    gridPane2.add(lb3, 0, 1);
                    gridPane2.add(lb4, 2, 1);
                    gridPane2.add(lb5, 0, 2);

                    gridPane2.add(lb16, 0, 4);
                    gridPane2.add(lb17, 0, 3);


                    gridPane2.add(t1, 1, 0);
                    gridPane2.add(t2, 3, 0);
                    gridPane2.add(t3, 1, 1);
                    gridPane2.add(t4, 3, 1);
                    gridPane2.add(t5, 1, 2);
                    gridPane2.add(t6, 0, 5);

                    gridPane2.add(t17, 1, 3);

                    gridPane2.setVgap(15);
                    gridPane2.setHgap(15);

                    treatmentPane = gridPane2;


                    whichChoice = 0;
                    isSuccessful = 3;
                    isChanged.set(!(isChanged.get()));
                }
                else {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
            });
        }

        else if (num == 4) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要修改的诊疗项目编号:");
            TextField textField = new TextField();
            Button button = new Button("修改");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            treatmentPane = stackPane;

            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/treatment.dat");
                Treatment treatment = (Treatment)selectFromTheFile(file, textField.getText(), "Treatment");

                if (treatment == null) {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
                else {
                    StackPane stackPane1 = new StackPane();
                    stackPane.setId("sp");
                    stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setPadding(new Insets(20, 0, 20, 20));
                    gridPane.setHgap(10);
                    gridPane.setVgap(8);

                    TextField tf1 = new TextField(treatment.getTreatmentId());
                    TextField tf2 = new TextField(treatment.getTreatmentName());
                    TextField tf3 = new TextField(treatment.getTreatmentLevel());
                    TextField tf4 = new TextField(treatment.getHospitalLevel());
                    TextField tf5 = new TextField(treatment.getManufacturer());

                    tf1.setMaxSize(150, 10);
                    tf2.setMaxSize(170, 10);
                    tf3.setMaxSize(170, 10);
                    tf4.setMaxSize(170, 10);
                    tf5.setMaxSize(170, 10);

                    RadioButton rb1 = new RadioButton("有");
                    RadioButton rb2 = new RadioButton("没有");

                    ToggleGroup tg1 = new ToggleGroup();

                    rb1.setToggleGroup(tg1);
                    rb2.setToggleGroup(tg1);

                    TextArea ta = new TextArea(treatment.getRemark());
                    ta.setMaxSize(260, 30);

                    if (treatment.isLabeled()) {
                        rb1.setSelected(true);
                    }

                    Label lb1 = new Label("诊疗项目ID:");
                    Label lb2 = new Label("诊疗项目名称:");
                    Label lb3 = new Label("诊疗项目级别:");
                    Label lb4 = new Label("医院级别:");
                    Label lb5 = new Label("生产厂家:");


                    Label lb16 = new Label("备注:");
                    Label lb17 = new Label("是否有审核标签:");

                    Button btn = new Button("确认提交本诊疗项目信息");

                    gridPane.add(lb1, 0, 0);
                    gridPane.add(lb2, 2, 0);
                    gridPane.add(lb3, 0, 1);
                    gridPane.add(lb4, 2, 1);
                    gridPane.add(lb5, 0, 2);


                    gridPane.add(lb16, 0, 5);
                    gridPane.add(lb17, 0, 3, 2, 1);

                    gridPane.add(tf1, 1, 0);
                    gridPane.add(tf2, 3, 0);
                    gridPane.add(tf3, 1, 1);
                    gridPane.add(tf4, 3, 1);
                    gridPane.add(tf5, 1, 2);

                    gridPane.add(ta, 0, 6, 2, 1);
                    gridPane.add(rb1, 0, 4);
                    gridPane.add(rb2, 1, 4);

                    gridPane.add(btn, 0, 7, 2, 1);

                    stackPane1.getChildren().add(gridPane);

                    treatmentPane = stackPane1;

                    whichChoice = 0;
                    isSuccessful = 5;
                    isChanged.set(!(isChanged.get()));


                    btn.setOnMouseClicked(eee -> {
                        String treatmentId = tf1.getText();
                        String treatmentName = tf2.getText();
                        String treatmentLevel = tf3.getText();
                        String hospitalLevel = tf4.getText();
                        String manufacturer = tf5.getText();

                        boolean isLabeled;
                        if (rb1.isSelected()) {
                            isLabeled = true;
                        }
                        else {
                            isLabeled = false;
                        }

                        String remark = ta.getText();

                        Treatment treatment1 = new Treatment(treatmentId, treatmentName, treatmentLevel,
                                hospitalLevel, isLabeled, manufacturer,remark);

                        File file1 = new File("src/files/treatment.dat");
                        changeInFile(file1, textField.getText(), "Treatment", treatment1);

                        whichChoice = 0;
                        isSuccessful = 4;
                        isChanged.set(!(isChanged.get()));
                    });

                }

            });
        }
    }

    public void layoutServiceFacilityPane(int num) {
        if (num == 1) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(10);
            gridPane.setVgap(8);

            TextField tf1 = new TextField();
            TextField tf2 = new TextField();


            tf1.setMaxSize(150, 10);
            tf2.setMaxSize(170, 10);

            TextArea ta = new TextArea();
            ta.setMaxSize(260, 30);

            Label lb1 = new Label("服务设施ID:");
            Label lb2 = new Label("服务设施名称:");

            Label lb3 = new Label("备注:");

            Button btn = new Button("确认提交本服务设施项目信息");

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 2, 0);
            gridPane.add(lb3, 0, 1);

            gridPane.add(tf1, 1, 0);
            gridPane.add(tf2, 3, 0);
            gridPane.add(ta, 0, 2, 2, 1);


            gridPane.add(btn, 0, 3, 2, 1);

            stackPane.getChildren().add(gridPane);

            serviceFacilityPane = stackPane;

            btn.setOnMouseClicked(e -> {
                whichChoice = 0;
                String treatmentId = tf1.getText();
                String treatmentName = tf2.getText();

                String remark = ta.getText();

                ServiceFacility serviceFacility = new ServiceFacility(treatmentName, treatmentId, remark);

                File file = new File("src/files/serviceFacility.dat");
                writeFile(file, serviceFacility);

                isSuccessful = 1;
                isChanged.set(!(isChanged.get()));
            });
        }

        else if (num == 2) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要删除的服务设施项目编号:");
            TextField textField = new TextField();
            Button button = new Button("删除");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane.add(label, 0, 0);
            gridPane.add(textField, 1, 0);
            gridPane.add(button, 1, 1);

            stackPane.getChildren().add(gridPane);
            serviceFacilityPane = stackPane;

            button.setOnMouseClicked(ee -> {
                whichChoice = 0;
                ConformInfo conformInfo = new ConformInfo();
                Stage s = new Stage();
                conformInfo.start(s);
                (conformInfo.isClickedProperty()).addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        s.close();
                        if (conformInfo.isDeleted()) {
                            File file = new File("src/files/serviceFacility.dat");

                            if (deleteInFile(file, "ServiceFacility",textField.getText())) {
                                isSuccessful = 2;
                                isChanged.set(!(isChanged.get()));
                            }
                            else {
                                NotFoundWindow notFoundWindow = new NotFoundWindow();
                                Stage stage = new Stage();
                                notFoundWindow.start(stage);
                                stage.setOnCloseRequest(e -> {
                                    isNotFound = 1;
                                    isChanged.set(!(isChanged.get()));
                                });

                            }
                        }
                    }
                });
            });
        }

        else if (num == 3) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要查找的服务设施项目编号:");
            TextField textField = new TextField();
            Button button = new Button("查找");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            serviceFacilityPane = stackPane;


            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/serviceFacility.dat");
                ServiceFacility serviceFacility = (ServiceFacility)selectFromTheFile(file, textField.getText(), "ServiceFacility");
                if (serviceFacility != null) {
                    Label lb1 = new Label("服务设施ID:");
                    Label lb2 = new Label("服务设施名称:");

                    Label lb3 = new Label("备注:");

                    Text t1 = new Text(serviceFacility.getFacilityId());
                    Text t2 = new Text(serviceFacility.getFacilityName());
                    Text t3 = new Text(serviceFacility.getRemark());

                    GridPane gridPane2 = new GridPane();

                    gridPane2.add(lb1, 0, 0);
                    gridPane2.add(lb2, 2, 0);
                    gridPane2.add(lb3, 0, 1);

                    gridPane2.add(t1, 1, 0);
                    gridPane2.add(t2, 3, 0);
                    gridPane2.add(t3, 0, 2);


                    gridPane2.setVgap(15);
                    gridPane2.setHgap(15);

                    serviceFacilityPane = gridPane2;

                    whichChoice = 0;
                    isSuccessful = 3;
                    isChanged.set(!(isChanged.get()));
                }
                else {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
            });
        }

        else if (num == 4) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要修改的服务设施项目编号:");
            TextField textField = new TextField();
            Button button = new Button("修改");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            serviceFacilityPane = stackPane;

            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/serviceFacility.dat");
                ServiceFacility serviceFacility = (ServiceFacility)selectFromTheFile(file, textField.getText(), "ServiceFacility");

                if (serviceFacility == null) {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
                else {
                    StackPane stackPane1 = new StackPane();
                    stackPane.setId("sp");
                    stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setPadding(new Insets(20, 0, 20, 20));
                    gridPane.setHgap(10);
                    gridPane.setVgap(8);

                    TextField tf1 = new TextField(serviceFacility.getFacilityId());
                    TextField tf2 = new TextField(serviceFacility.getFacilityName());


                    tf1.setMaxSize(150, 10);
                    tf2.setMaxSize(170, 10);

                    TextArea ta = new TextArea(serviceFacility.getRemark());
                    ta.setMaxSize(260, 30);

                    Label lb1 = new Label("服务设施ID:");
                    Label lb2 = new Label("服务设施名称:");

                    Label lb3 = new Label("备注:");


                    Button btn = new Button("确认提交本服务设施项目信息");

                    gridPane.add(lb1, 0, 0);
                    gridPane.add(lb2, 2, 0);
                    gridPane.add(lb3, 0, 1);

                    gridPane.add(tf1, 1, 0);
                    gridPane.add(tf2, 3, 0);

                    gridPane.add(ta, 0, 2, 2, 1);

                    gridPane.add(btn, 0, 3, 2, 1);

                    stackPane1.getChildren().add(gridPane);

                    serviceFacilityPane = stackPane1;

                    whichChoice = 0;
                    isSuccessful = 5;
                    isChanged.set(!(isChanged.get()));


                    btn.setOnMouseClicked(exx -> {
                        String treatmentId = tf1.getText();
                        String treatmentName = tf2.getText();

                        String remark = ta.getText();

                        ServiceFacility serviceFacility1 = new ServiceFacility(treatmentName, treatmentId, remark);

                        File file1 = new File("src/files/serviceFacility.dat");
                        changeInFile(file1, textField.getText(), "ServiceFacility", serviceFacility1);

                        whichChoice = 0;
                        isSuccessful = 4;
                        isChanged.set(!(isChanged.get()));
                    });

                }

            });
        }
    }

    public void layoutFixedMedicalInstitutionPane(int num) {
        if (num == 1) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(10);
            gridPane.setVgap(8);

            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            TextField tf3 = new TextField();
            TextField tf4 = new TextField();
            TextField tf5 = new TextField();
            TextField tf6 = new TextField();
            TextField tf7 = new TextField();
            TextField tf8 = new TextField();
            TextField tf9 = new TextField();
            TextField tf10 = new TextField();


            tf1.setMaxSize(150, 10);
            tf2.setMaxSize(170, 10);
            tf3.setMaxSize(150, 10);
            tf4.setMaxSize(170, 10);
            tf5.setMaxSize(150, 10);
            tf6.setMaxSize(170, 10);
            tf7.setMaxSize(150, 10);
            tf8.setMaxSize(170, 10);
            tf9.setMaxSize(150, 10);
            tf10.setMaxSize(170, 10);

            TextArea ta = new TextArea();
            ta.setMaxSize(260, 30);

            Label lb1 = new Label("定点医疗机构编号:");
            Label lb2 = new Label("服务机构名称:");
            Label lb3 = new Label("医院等级:");
            Label lb4 = new Label("医疗机构类别:");
            Label lb5 = new Label("邮政编码:");
            Label lb6 = new Label("法人姓名:");
            Label lb7 = new Label("法人移动电话:");
            Label lb8 = new Label("联系人电话:");
            Label lb9 = new Label("联系人移动电话:");
            Label lb10 = new Label("地址:");
            Label lb11 = new Label("备注:");


            Button btn = new Button("确认提交本定点医疗机构信息");

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 2, 0);
            gridPane.add(lb3, 0, 1);
            gridPane.add(lb4, 2, 1);
            gridPane.add(lb5, 0, 2);
            gridPane.add(lb6, 2, 2);
            gridPane.add(lb7, 0, 3);
            gridPane.add(lb8, 2, 3);
            gridPane.add(lb9, 0, 4);
            gridPane.add(lb10, 2, 4);

            gridPane.add(lb11, 0, 5);

            gridPane.add(tf1, 1, 0);
            gridPane.add(tf2, 3, 0);
            gridPane.add(tf3, 1, 1);
            gridPane.add(tf4, 3, 1);
            gridPane.add(tf5, 1, 2);
            gridPane.add(tf6, 3, 2);
            gridPane.add(tf7, 1, 3);
            gridPane.add(tf8, 3, 3);
            gridPane.add(tf9, 1, 4);
            gridPane.add(tf10, 3, 4);
            gridPane.add(ta, 0, 6, 2, 1);


            gridPane.add(btn, 0, 7, 2, 1);

            stackPane.getChildren().add(gridPane);

            fixedMedicalInstitutionPane = stackPane;

            btn.setOnMouseClicked(e -> {
                whichChoice = 0;
                String institutionId = tf1.getText();
                String institutionName = tf2.getText();
                String institutionLevel = tf3.getText();
                String institutionCategory = tf4.getText();
                String zipCode = tf5.getText();
                String legalRepresentativeName = tf6.getText();
                String legalRepresentativePho = tf7.getText();
                String contadctorTele = tf8.getText();
                String contactorPho = tf9.getText();
                String address = tf10.getText();

                String remark = ta.getText();

                FixedMedicalInstitution fixedMedicalInstitution = new FixedMedicalInstitution(institutionId, institutionName, institutionLevel,
                        institutionCategory, zipCode, legalRepresentativeName,
                        legalRepresentativePho, contadctorTele, contactorPho,
                        address, remark);

                File file = new File("src/files/fixedMedicalInstitution.dat");
                writeFile(file, fixedMedicalInstitution);

                isSuccessful = 1;
                isChanged.set(!(isChanged.get()));
            });
        }

        else if (num == 2) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要删除的定点医疗机构编号:");
            TextField textField = new TextField();
            Button button = new Button("删除");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane.add(label, 0, 0);
            gridPane.add(textField, 1, 0);
            gridPane.add(button, 1, 1);

            stackPane.getChildren().add(gridPane);
            fixedMedicalInstitutionPane = stackPane;

            button.setOnMouseClicked(ee -> {
                whichChoice = 0;
                ConformInfo conformInfo = new ConformInfo();
                Stage s = new Stage();
                conformInfo.start(s);
                (conformInfo.isClickedProperty()).addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        s.close();
                        if (conformInfo.isDeleted()) {
                            File file = new File("src/files/fixedMedicalInstitution.dat");

                            if (deleteInFile(file, "FixedMedicalInstitution",textField.getText())) {
                                isSuccessful = 2;
                                isChanged.set(!(isChanged.get()));
                            }
                            else {
                                NotFoundWindow notFoundWindow = new NotFoundWindow();
                                Stage stage = new Stage();
                                notFoundWindow.start(stage);
                                stage.setOnCloseRequest(e -> {
                                    isNotFound = 1;
                                    isChanged.set(!(isChanged.get()));
                                });

                            }
                        }
                    }
                });
            });
        }

        else if (num == 3) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要查找的定点医疗机构编号:");
            TextField textField = new TextField();
            Button button = new Button("查找");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            fixedMedicalInstitutionPane = stackPane;


            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/fixedMedicalInstitution.dat");
                FixedMedicalInstitution fixedMedicalInstitution = (FixedMedicalInstitution) selectFromTheFile(file, textField.getText(), "FixedMedicalInstitution");
                if (fixedMedicalInstitution != null) {
                    Label lb1 = new Label("定点医疗机构编号:");
                    Label lb2 = new Label("服务机构名称:");
                    Label lb3 = new Label("医院等级:");
                    Label lb4 = new Label("医疗机构类别:");
                    Label lb5 = new Label("邮政编码:");
                    Label lb6 = new Label("法人姓名:");
                    Label lb7 = new Label("法人移动电话:");
                    Label lb8 = new Label("联系人电话:");
                    Label lb9 = new Label("联系人移动电话:");
                    Label lb10 = new Label("地址:");
                    Label lb11 = new Label("备注:");

                    Text t1 = new Text(fixedMedicalInstitution.getInstitutionId());
                    Text t2 = new Text(fixedMedicalInstitution.getInstitutionName());
                    Text t3 = new Text(fixedMedicalInstitution.getInstitutionLevel());
                    Text t4 = new Text(fixedMedicalInstitution.getInstitutionCategory());
                    Text t5 = new Text(fixedMedicalInstitution.getZipCode());
                    Text t6 = new Text(fixedMedicalInstitution.getLegalRepresentativeName());
                    Text t7 = new Text(fixedMedicalInstitution.getLegalRepresentativePho());
                    Text t8 = new Text(fixedMedicalInstitution.getContadctorTele());
                    Text t9 = new Text(fixedMedicalInstitution.getContactorPho());
                    Text t10 = new Text(fixedMedicalInstitution.getAddress());
                    Text t11 = new Text(fixedMedicalInstitution.getRemark());


                    GridPane gridPane2 = new GridPane();

                    gridPane2.add(lb1, 0, 0);
                    gridPane2.add(lb2, 2, 0);
                    gridPane2.add(lb3, 0, 1);
                    gridPane2.add(lb4, 2, 1);
                    gridPane2.add(lb5, 0, 2);
                    gridPane2.add(lb6, 2, 2);
                    gridPane2.add(lb7, 0, 3);
                    gridPane2.add(lb8, 2, 3);
                    gridPane2.add(lb9, 0, 4);
                    gridPane2.add(lb10, 2, 4);
                    gridPane2.add(lb11, 0, 5);



                    gridPane2.add(t1, 1, 0);
                    gridPane2.add(t2, 3, 0);
                    gridPane2.add(t3, 1, 1);
                    gridPane2.add(t4, 3, 1);
                    gridPane2.add(t5, 1, 2);
                    gridPane2.add(t6, 3, 2);
                    gridPane2.add(t7, 1, 3);
                    gridPane2.add(t8, 3, 3);
                    gridPane2.add(t9, 1, 4);
                    gridPane2.add(t10, 3, 4);
                    gridPane2.add(t11, 0, 6, 2, 1);


                    gridPane2.setVgap(15);
                    gridPane2.setHgap(15);

                    fixedMedicalInstitutionPane = gridPane2;

                    whichChoice = 0;
                    isSuccessful = 3;
                    isChanged.set(!(isChanged.get()));
                }
                else {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
            });
        }

        else if (num == 4) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要修改的定点医疗机构编号:");
            TextField textField = new TextField();
            Button button = new Button("修改");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            fixedMedicalInstitutionPane = stackPane;

            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/fixedMedicalInstitution.dat");
                FixedMedicalInstitution fixedMedicalInstitution = (FixedMedicalInstitution) selectFromTheFile(file, textField.getText(), "FixedMedicalInstitution");

                if (fixedMedicalInstitution == null) {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
                else {
                    StackPane stackPane1 = new StackPane();
                    stackPane.setId("sp");
                    stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setPadding(new Insets(20, 0, 20, 20));
                    gridPane.setHgap(10);
                    gridPane.setVgap(8);

                    TextField tf1 = new TextField(fixedMedicalInstitution.getInstitutionId());
                    TextField tf2 = new TextField(fixedMedicalInstitution.getInstitutionName());
                    TextField tf3 = new TextField(fixedMedicalInstitution.getInstitutionLevel());
                    TextField tf4 = new TextField(fixedMedicalInstitution.getInstitutionCategory());
                    TextField tf5 = new TextField(fixedMedicalInstitution.getZipCode());
                    TextField tf6 = new TextField(fixedMedicalInstitution.getLegalRepresentativeName());
                    TextField tf7 = new TextField(fixedMedicalInstitution.getLegalRepresentativePho());
                    TextField tf8 = new TextField(fixedMedicalInstitution.getContadctorTele());
                    TextField tf9 = new TextField(fixedMedicalInstitution.getContactorPho());
                    TextField tf10 = new TextField(fixedMedicalInstitution.getAddress());


                    tf1.setMaxSize(150, 10);
                    tf2.setMaxSize(170, 10);
                    tf3.setMaxSize(150, 10);
                    tf4.setMaxSize(170, 10);
                    tf5.setMaxSize(150, 10);
                    tf6.setMaxSize(170, 10);
                    tf7.setMaxSize(150, 10);
                    tf8.setMaxSize(170, 10);
                    tf9.setMaxSize(150, 10);
                    tf10.setMaxSize(170, 10);

                    TextArea ta = new TextArea(fixedMedicalInstitution.getRemark());
                    ta.setMaxSize(260, 30);

                    Label lb1 = new Label("定点医疗机构编号:");
                    Label lb2 = new Label("服务机构名称:");
                    Label lb3 = new Label("医院等级:");
                    Label lb4 = new Label("医疗机构类别:");
                    Label lb5 = new Label("邮政编码:");
                    Label lb6 = new Label("法人姓名:");
                    Label lb7 = new Label("法人移动电话:");
                    Label lb8 = new Label("联系人电话:");
                    Label lb9 = new Label("联系人移动电话:");
                    Label lb10 = new Label("地址:");
                    Label lb11 = new Label("备注:");

                    Button btn = new Button("确认提交本定点医疗机构信息");

                    gridPane.add(lb1, 0, 0);
                    gridPane.add(lb2, 2, 0);
                    gridPane.add(lb3, 0, 1);
                    gridPane.add(lb4, 2, 1);
                    gridPane.add(lb5, 0, 2);
                    gridPane.add(lb6, 2, 2);
                    gridPane.add(lb7, 0, 3);
                    gridPane.add(lb8, 2, 3);
                    gridPane.add(lb9, 0, 4);
                    gridPane.add(lb10, 2, 4);
                    gridPane.add(lb11, 0, 5);


                    gridPane.add(tf1, 1, 0);
                    gridPane.add(tf2, 3, 0);
                    gridPane.add(tf3, 1, 1);
                    gridPane.add(tf4, 3, 1);
                    gridPane.add(tf5, 1, 2);
                    gridPane.add(tf6, 3, 2);
                    gridPane.add(tf7, 1, 3);
                    gridPane.add(tf8, 3, 3);
                    gridPane.add(tf9, 1, 4);
                    gridPane.add(tf10, 3, 4);

                    gridPane.add(ta, 0, 6, 2, 1);

                    gridPane.add(btn, 0, 7, 2, 1);

                    stackPane1.getChildren().add(gridPane);

                    fixedMedicalInstitutionPane = stackPane1;

                    whichChoice = 0;
                    isSuccessful = 5;
                    isChanged.set(!(isChanged.get()));


                    btn.setOnMouseClicked(exx -> {
                        whichChoice = 0;
                        String institutionId = tf1.getText();
                        String institutionName = tf2.getText();
                        String institutionLevel = tf3.getText();
                        String institutionCategory = tf4.getText();
                        String zipCode = tf5.getText();
                        String legalRepresentativeName = tf6.getText();
                        String legalRepresentativePho = tf7.getText();
                        String contadctorTele = tf8.getText();
                        String contactorPho = tf9.getText();
                        String address = tf10.getText();

                        String remark = ta.getText();

                        FixedMedicalInstitution fixedMedicalInstitution1 = new FixedMedicalInstitution(institutionId, institutionName, institutionLevel,
                                institutionCategory, zipCode, legalRepresentativeName,
                                legalRepresentativePho, contadctorTele, contactorPho,
                                address, remark);

                        File file1 = new File("src/files/fixedMedicalInstitution.dat");
                        changeInFile(file1, textField.getText(), "FixedMedicalInstitution",fixedMedicalInstitution1);
                        isSuccessful = 4;
                        isChanged.set(!(isChanged.get()));
                    });

                }

            });
        }
    }

    public void layoutMedicalTreatmentCalculationParameterPane(int num) {
        if (num == 1) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(10);
            gridPane.setVgap(8);

            TextField tf1 = new TextField();
            TextField tf2 = new TextField();
            TextField tf3 = new TextField();
            TextField tf4 = new TextField();
            TextField tf5 = new TextField();
            TextField tf6 = new TextField();
            TextField tf7 = new TextField();
            TextField tf8 = new TextField();


            tf1.setMaxSize(150, 10);
            tf2.setMaxSize(170, 10);
            tf3.setMaxSize(150, 10);
            tf4.setMaxSize(170, 10);
            tf5.setMaxSize(150, 10);
            tf6.setMaxSize(170, 10);
            tf7.setMaxSize(150, 10);
            tf8.setMaxSize(170, 10);


            Label lb1 = new Label("参数id:");
            Label lb2 = new Label("医疗人员类别:");
            Label lb3 = new Label("医疗类别:");
            Label lb4 = new Label("起付费用:");
            Label lb5 = new Label("封顶线:");
            Label lb6 = new Label("上限金额:");
            Label lb7 = new Label("下限金额:");
            Label lb8 = new Label("报销比例:");


            Button btn = new Button("确认提交本医疗待遇计算参数信息");

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 2, 0);
            gridPane.add(lb3, 0, 1);
            gridPane.add(lb4, 2, 1);
            gridPane.add(lb5, 0, 2);
            gridPane.add(lb6, 2, 2);
            gridPane.add(lb7, 0, 3);
            gridPane.add(lb8, 2, 3);


            gridPane.add(tf1, 1, 0);
            gridPane.add(tf2, 3, 0);
            gridPane.add(tf3, 1, 1);
            gridPane.add(tf4, 3, 1);
            gridPane.add(tf5, 1, 2);
            gridPane.add(tf6, 3, 2);
            gridPane.add(tf7, 1, 3);
            gridPane.add(tf8, 3, 3);


            gridPane.add(btn, 0, 4, 2, 1);

            stackPane.getChildren().add(gridPane);

            medicalTreatmentCalculationParameterPane = stackPane;

            btn.setOnMouseClicked(e -> {
                whichChoice = 0;
                String parameterId = tf1.getText();
                String medicalPeopleCategory = tf2.getText();
                String medicalCategory = tf3.getText();
                double thresholdPrice = Double.parseDouble(tf4.getText());
                double cappingLine = Double.parseDouble(tf5.getText());
                double upperLine = Double.parseDouble(tf6.getText());
                double lowerLine = Double.parseDouble(tf7.getText());
                double proportionOfReimbursement = Double.parseDouble(tf8.getText());


                MedicalTreatmentCalculationParameter medicalTreatmentCalculationParameter =
                        new MedicalTreatmentCalculationParameter(parameterId, medicalPeopleCategory, medicalCategory,
                thresholdPrice, cappingLine, upperLine,
                lowerLine, proportionOfReimbursement);

                File file = new File("src/files/medicalTreatmentCalculationParameter.dat");
                writeFile(file, medicalTreatmentCalculationParameter);

                isSuccessful = 1;
                isChanged.set(!(isChanged.get()));
            });
        }

        else if (num == 2) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要删除的医疗待遇计算参数ID:");
            TextField textField = new TextField();
            Button button = new Button("删除");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane.add(label, 0, 0);
            gridPane.add(textField, 1, 0);
            gridPane.add(button, 1, 1);

            stackPane.getChildren().add(gridPane);
            medicalTreatmentCalculationParameterPane = stackPane;

            button.setOnMouseClicked(ee -> {
                whichChoice = 0;
                ConformInfo conformInfo = new ConformInfo();
                Stage s = new Stage();
                conformInfo.start(s);
                (conformInfo.isClickedProperty()).addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        s.close();
                        if (conformInfo.isDeleted()) {
                            File file = new File("src/files/medicalTreatmentCalculationParameter.dat");

                            if (deleteInFile(file, "MedicalTreatmentCalculationParameter",textField.getText())) {
                                isSuccessful = 2;
                                isChanged.set(!(isChanged.get()));
                            }
                            else {
                                NotFoundWindow notFoundWindow = new NotFoundWindow();
                                Stage stage = new Stage();
                                notFoundWindow.start(stage);
                                stage.setOnCloseRequest(e -> {
                                    isNotFound = 1;
                                    isChanged.set(!(isChanged.get()));
                                });
                            }
                        }
                    }
                });
            });
        }

        else if (num == 3) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要查找的医疗待遇计算参数ID:");
            TextField textField = new TextField();
            Button button = new Button("查找");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            medicalTreatmentCalculationParameterPane = stackPane;


            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/medicalTreatmentCalculationParameter.dat");
                MedicalTreatmentCalculationParameter medicalTreatmentCalculationParameter = (MedicalTreatmentCalculationParameter)selectFromTheFile(file, textField.getText(), "MedicalTreatmentCalculationParameter");
                if (medicalTreatmentCalculationParameter != null) {
                    Label lb1 = new Label("参数id:");
                    Label lb2 = new Label("医疗人员类别:");
                    Label lb3 = new Label("医疗类别:");
                    Label lb4 = new Label("起付费用:");
                    Label lb5 = new Label("封顶线:");
                    Label lb6 = new Label("上限金额:");
                    Label lb7 = new Label("下限金额:");
                    Label lb8 = new Label("报销比例:");


                    Text t1 = new Text(medicalTreatmentCalculationParameter.getParameterId());
                    Text t2 = new Text(medicalTreatmentCalculationParameter.getMedicalPeopleCategory() + "");
                    Text t3 = new Text(medicalTreatmentCalculationParameter.getMedicalCategory() + "");
                    Text t4 = new Text(medicalTreatmentCalculationParameter.getThresholdPrice() + "");
                    Text t5 = new Text(medicalTreatmentCalculationParameter.getCappingLine() + "");
                    Text t6 = new Text(medicalTreatmentCalculationParameter.getUpperLine() + "");
                    Text t7 = new Text(medicalTreatmentCalculationParameter.getLowerLine() + "");
                    Text t8 = new Text(medicalTreatmentCalculationParameter.getProportionOfReimbursement() + "");



                    GridPane gridPane2 = new GridPane();

                    gridPane2.add(lb1, 0, 0);
                    gridPane2.add(lb2, 2, 0);
                    gridPane2.add(lb3, 0, 1);
                    gridPane2.add(lb4, 2, 1);
                    gridPane2.add(lb5, 0, 2);
                    gridPane2.add(lb6, 2, 2);
                    gridPane2.add(lb7, 0, 3);
                    gridPane2.add(lb8, 2, 3);



                    gridPane2.add(t1, 1, 0);
                    gridPane2.add(t2, 3, 0);
                    gridPane2.add(t3, 1, 1);
                    gridPane2.add(t4, 3, 1);
                    gridPane2.add(t5, 1, 2);
                    gridPane2.add(t6, 3, 2);
                    gridPane2.add(t7, 1, 3);
                    gridPane2.add(t8, 3, 3);


                    gridPane2.setVgap(15);
                    gridPane2.setHgap(15);

                    medicalTreatmentCalculationParameterPane = gridPane2;

                    whichChoice = 0;
                    isSuccessful = 3;
                    isChanged.set(!(isChanged.get()));
                }
                else {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });
                }
            });
        }

        else if (num == 4) {
            StackPane stackPane = new StackPane();
            stackPane.setId("sp");
            stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);

            GridPane gridPane1 = new GridPane();
            gridPane1.setAlignment(Pos.CENTER);

            Label label = new Label("请输入您想要修改的医疗待遇计算参数ID:");
            TextField textField = new TextField();
            Button button = new Button("修改");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            medicalTreatmentCalculationParameterPane = stackPane;

            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/medicalTreatmentCalculationParameter.dat");
                MedicalTreatmentCalculationParameter medicalTreatmentCalculationParameter = (MedicalTreatmentCalculationParameter) selectFromTheFile(file, textField.getText(), "MedicalTreatmentCalculationParameter");

                if (medicalTreatmentCalculationParameter == null) {
                    NotFoundWindow notFoundWindow = new NotFoundWindow();
                    Stage stage = new Stage();
                    notFoundWindow.start(stage);
                    stage.setOnCloseRequest(e -> {
                        isNotFound = 1;
                        isChanged.set(!(isChanged.get()));
                    });

                }
                else {
                    StackPane stackPane1 = new StackPane();
                    stackPane.setId("sp");
                    stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setPadding(new Insets(20, 0, 20, 20));
                    gridPane.setHgap(10);
                    gridPane.setVgap(8);

                    TextField tf1 = new TextField(medicalTreatmentCalculationParameter.getParameterId());
                    TextField tf2 = new TextField(medicalTreatmentCalculationParameter.getMedicalPeopleCategory() + "");
                    TextField tf3 = new TextField(medicalTreatmentCalculationParameter.getMedicalCategory() + "");
                    TextField tf4 = new TextField(medicalTreatmentCalculationParameter.getThresholdPrice() + "");
                    TextField tf5 = new TextField(medicalTreatmentCalculationParameter.getCappingLine() + "");
                    TextField tf6 = new TextField(medicalTreatmentCalculationParameter.getUpperLine() + "");
                    TextField tf7 = new TextField(medicalTreatmentCalculationParameter.getLowerLine() + "");
                    TextField tf8 = new TextField(medicalTreatmentCalculationParameter.getProportionOfReimbursement() + "");



                    tf1.setMaxSize(150, 10);
                    tf2.setMaxSize(170, 10);
                    tf3.setMaxSize(150, 10);
                    tf4.setMaxSize(170, 10);
                    tf5.setMaxSize(150, 10);
                    tf6.setMaxSize(170, 10);
                    tf7.setMaxSize(150, 10);
                    tf8.setMaxSize(170, 10);


                    Label lb1 = new Label("参数id:");
                    Label lb2 = new Label("医疗人员类别:");
                    Label lb3 = new Label("医疗类别:");
                    Label lb4 = new Label("起付费用:");
                    Label lb5 = new Label("封顶线:");
                    Label lb6 = new Label("上限金额:");
                    Label lb7 = new Label("下限金额:");
                    Label lb8 = new Label("报销比例:");

                    Button btn = new Button("确认提交本医疗待遇计算参数");

                    gridPane.add(lb1, 0, 0);
                    gridPane.add(lb2, 2, 0);
                    gridPane.add(lb3, 0, 1);
                    gridPane.add(lb4, 2, 1);
                    gridPane.add(lb5, 0, 2);
                    gridPane.add(lb6, 2, 2);
                    gridPane.add(lb7, 0, 3);
                    gridPane.add(lb8, 2, 3);


                    gridPane.add(tf1, 1, 0);
                    gridPane.add(tf2, 3, 0);
                    gridPane.add(tf3, 1, 1);
                    gridPane.add(tf4, 3, 1);
                    gridPane.add(tf5, 1, 2);
                    gridPane.add(tf6, 3, 2);
                    gridPane.add(tf7, 1, 3);
                    gridPane.add(tf8, 3, 3);

                    gridPane.add(btn, 0, 4, 2, 1);

                    stackPane1.getChildren().add(gridPane);

                    medicalTreatmentCalculationParameterPane = stackPane1;

                    whichChoice = 0;
                    isSuccessful = 5;
                    isChanged.set(!(isChanged.get()));


                    btn.setOnMouseClicked(exx -> {
                        whichChoice = 0;
                        String parameterId = tf1.getText();
                        String medicalPeopleCategory = tf2.getText();
                        String medicalCategory = tf3.getText();
                        double thresholdPrice = Double.parseDouble(tf4.getText());
                        double cappingLine = Double.parseDouble(tf5.getText());
                        double upperLine = Double.parseDouble(tf6.getText());
                        double lowerLine = Double.parseDouble(tf7.getText());
                        double proportionOfReimbursement = Double.parseDouble(tf8.getText());


                        MedicalTreatmentCalculationParameter medicalTreatmentCalculationParameter1 =
                                new MedicalTreatmentCalculationParameter(parameterId, medicalPeopleCategory, medicalCategory,
                                        thresholdPrice, cappingLine, upperLine,
                                        lowerLine, proportionOfReimbursement);

                        File file1 = new File("src/files/medicalTreatmentCalculationParameter.dat");
                        changeInFile(file1, textField.getText(), "MedicalTreatmentCalculationParameter",medicalTreatmentCalculationParameter1);
                        isSuccessful = 4;
                        isChanged.set(!(isChanged.get()));
                    });

                }

            });
        }
    }







    public void layoutMedicineSuccessfulPane(int num) {
        isSuccessful = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ImageView img1 = new ImageView("img/successIcon.png");
        img1.fitWidthProperty().bind(widthProperty.divide(10));
        img1.fitHeightProperty().bind(heightProperty.divide(9));

        ImageView img2 = new ImageView();
        if (num == 1) {
            img2 = new ImageView("img/successEnterInfo.png");
        }
        else if (num == 2) {
            img2 = new ImageView("img/successDeleteInfo.png");
        }
        else if (num == 4) {
            img2 = new ImageView("img/successChangeInfo.png");
        }
        img2.fitWidthProperty().bind(widthProperty.divide(1.7));
        img2.fitHeightProperty().bind(heightProperty.divide(9));

        hBox.getChildren().addAll(img1, img2);
        stackPane.getChildren().add(hBox);
        successPane = stackPane;
        if (num == 3) {
            StackPane stackPane1 = new StackPane();
            GridPane gridPane = new GridPane();
            gridPane.add(medicinePane, 0, 0);
            gridPane.setAlignment(Pos.CENTER);
            stackPane1.setId("sp");
            stackPane1.prefWidthProperty().bind(widthProperty.divide(1.25));
            stackPane1.getChildren().add(gridPane);

            successPane = stackPane1;
        }

        if (num == 5) {
            successPane = medicinePane;
        }
    }

    public void layoutTreatmentSuccessfulPane(int num) {
        isSuccessful = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ImageView img1 = new ImageView("img/successIcon.png");
        img1.fitWidthProperty().bind(widthProperty.divide(10));
        img1.fitHeightProperty().bind(heightProperty.divide(9));

        ImageView img2 = new ImageView();
        if (num == 1) {
            img2 = new ImageView("img/successEnterInfo.png");
        }
        else if (num == 2) {
            img2 = new ImageView("img/successDeleteInfo.png");
        }
        else if (num == 4) {
            img2 = new ImageView("img/successChangeInfo.png");
        }
        img2.fitWidthProperty().bind(widthProperty.divide(1.7));
        img2.fitHeightProperty().bind(heightProperty.divide(9));

        hBox.getChildren().addAll(img1, img2);
        stackPane.getChildren().add(hBox);
        successPane = stackPane;
        if (num == 3) {
            StackPane stackPane1 = new StackPane();
            GridPane gridPane = new GridPane();
            gridPane.add(treatmentPane, 0, 0);
            gridPane.setAlignment(Pos.CENTER);
            stackPane1.setId("sp");
            stackPane1.prefWidthProperty().bind(widthProperty.divide(1.25));
            stackPane1.getChildren().add(gridPane);

            successPane = stackPane1;
        }

        if (num == 5) {
            successPane = treatmentPane;
        }
    }

    public void layoutServiceFacilitySuccessfulPane(int num) {
        isSuccessful = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ImageView img1 = new ImageView("img/successIcon.png");
        img1.fitWidthProperty().bind(widthProperty.divide(10));
        img1.fitHeightProperty().bind(heightProperty.divide(9));

        ImageView img2 = new ImageView();
        if (num == 1) {
            img2 = new ImageView("img/successEnterInfo.png");
        }
        else if (num == 2) {
            img2 = new ImageView("img/successDeleteInfo.png");
        }
        else if (num == 4) {
            img2 = new ImageView("img/successChangeInfo.png");
        }
        img2.fitWidthProperty().bind(widthProperty.divide(1.7));
        img2.fitHeightProperty().bind(heightProperty.divide(9));

        hBox.getChildren().addAll(img1, img2);
        stackPane.getChildren().add(hBox);
        successPane = stackPane;
        if (num == 3) {
            StackPane stackPane1 = new StackPane();
            GridPane gridPane = new GridPane();
            gridPane.add(serviceFacilityPane, 0, 0);
            gridPane.setAlignment(Pos.CENTER);
            stackPane1.setId("sp");
            stackPane1.prefWidthProperty().bind(widthProperty.divide(1.25));
            stackPane1.getChildren().add(gridPane);

            successPane = stackPane1;
        }

        if (num == 5) {
            successPane = serviceFacilityPane;
        }
    }

    public void layoutFixedMedicalInstitutionSuccessfulPane(int num) {
        isSuccessful = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ImageView img1 = new ImageView("img/successIcon.png");
        img1.fitWidthProperty().bind(widthProperty.divide(10));
        img1.fitHeightProperty().bind(heightProperty.divide(9));

        ImageView img2 = new ImageView();
        if (num == 1) {
            img2 = new ImageView("img/successEnterInfo.png");
        }
        else if (num == 2) {
            img2 = new ImageView("img/successDeleteInfo.png");
        }
        else if (num == 4) {
            img2 = new ImageView("img/successChangeInfo.png");
        }
        img2.fitWidthProperty().bind(widthProperty.divide(1.7));
        img2.fitHeightProperty().bind(heightProperty.divide(9));

        hBox.getChildren().addAll(img1, img2);
        stackPane.getChildren().add(hBox);
        successPane = stackPane;
        if (num == 3) {
            StackPane stackPane1 = new StackPane();
            GridPane gridPane = new GridPane();
            gridPane.add(fixedMedicalInstitutionPane, 0, 0);
            gridPane.setAlignment(Pos.CENTER);
            stackPane1.setId("sp");
            stackPane1.prefWidthProperty().bind(widthProperty.divide(1.25));
            stackPane1.getChildren().add(gridPane);

            successPane = stackPane1;
        }

        if (num == 5) {
            successPane = fixedMedicalInstitutionPane;
        }
    }

    public void layoutMedicalTreatmentCalculationParameterSuccessfulPane(int num) {
        isSuccessful = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ImageView img1 = new ImageView("img/successIcon.png");
        img1.fitWidthProperty().bind(widthProperty.divide(10));
        img1.fitHeightProperty().bind(heightProperty.divide(9));

        ImageView img2 = new ImageView();
        if (num == 1) {
            img2 = new ImageView("img/successEnterInfo.png");
        }
        else if (num == 2) {
            img2 = new ImageView("img/successDeleteInfo.png");
        }
        else if (num == 4) {
            img2 = new ImageView("img/successChangeInfo.png");
        }
        img2.fitWidthProperty().bind(widthProperty.divide(1.7));
        img2.fitHeightProperty().bind(heightProperty.divide(9));

        hBox.getChildren().addAll(img1, img2);
        stackPane.getChildren().add(hBox);
        successPane = stackPane;
        if (num == 3) {
            StackPane stackPane1 = new StackPane();
            GridPane gridPane = new GridPane();
            gridPane.add(medicalTreatmentCalculationParameterPane, 0, 0);
            gridPane.setAlignment(Pos.CENTER);
            stackPane1.setId("sp");
            stackPane1.prefWidthProperty().bind(widthProperty.divide(1.25));
            stackPane1.getChildren().add(gridPane);

            successPane = stackPane1;
        }

        if (num == 5) {
            successPane = medicalTreatmentCalculationParameterPane;
        }
    }

    public void writeFile(File file, Object obj){
        LinkedList<Object> linkedList = new LinkedList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            linkedList = (LinkedList<Object>)ois.readObject();
        }
        catch (Exception ex) {
            if (ex instanceof EOFException) {
                linkedList = new LinkedList<>();
            }
            else {
                System.out.println(ex);
                System.out.println("Exception when reading in medical information!");
                System.out.println(ex.getStackTrace());
            }
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))){
            linkedList.add(obj);
            oos.writeObject(linkedList);
        }
        catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Exception when writing in medical information!");
            System.out.println(ex.getStackTrace());
        }
    }

    public LinkedList<Object> readFile(File file) {
        LinkedList<Object> linkedList = new LinkedList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            linkedList = (LinkedList<Object>) ois.readObject();
        }
        catch (Exception ex) {
            if (ex instanceof EOFException) {
                System.out.println("Nothing written into the file now!");
            }
            else {
                System.out.println(ex);
                System.out.println("Exception when reading in medical information!");
                System.out.println(ex.getStackTrace());
            }

        }
        return linkedList;
    }

    public boolean deleteInFile(File file, String objName,String id) {
        LinkedList<Object> linkedList = readFile(file);
        boolean found = false;
        String theId;

        for (int i = 0; i < linkedList.size(); i++) {
            if (objName.equals("Medicine")) {
                theId = ((Medicine)(linkedList.get(i))).getMedicineId();
            }
            else if (objName.equals("Treatment")) {
                theId = ((Treatment)(linkedList.get(i))).getTreatmentId();
            }
            else if (objName.equals("ServiceFacility")) {
                theId = ((ServiceFacility)(linkedList.get(i))).getFacilityId();
            }
            else if (objName.equals("FixedMedicalInstitution")) {
                theId = ((FixedMedicalInstitution)(linkedList.get(i))).getInstitutionId();
            }
            else {
                theId = ((MedicalTreatmentCalculationParameter)(linkedList.get(i))).getParameterId();
            }

            if (theId.equals(id)){
                linkedList.remove(i);
                try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))){
                    oos.writeObject(linkedList);
                }
                catch (Exception ex) {
                    System.out.println(ex);
                    System.out.println("Exception when writing in medical information!");
                    System.out.println(ex.getStackTrace());
                }
                found = true;
            }
        }

        return found;
    }

    public Object selectFromTheFile(File file, String id, String objName) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            LinkedList<Object> linkedList = (LinkedList<Object>)ois.readObject();
            String theId;
            for (int i = 0; i < linkedList.size(); i++) {
                if (objName.equals("Medicine")) {
                    theId = ((Medicine)(linkedList.get(i))).getMedicineId();
                }
                else if (objName.equals("Treatment")) {
                    theId = ((Treatment)(linkedList.get(i))).getTreatmentId();
                }
                else if (objName.equals("ServiceFacility")) {
                    theId = ((ServiceFacility)(linkedList.get(i))).getFacilityId();
                }
                else if (objName.equals("FixedMedicalInstitution")) {
                    theId = ((FixedMedicalInstitution)(linkedList.get(i))).getInstitutionId();
                }
                else {
                    theId = ((MedicalTreatmentCalculationParameter)(linkedList.get(i))).getParameterId();
                }
                if (theId.equals(id)) {
                    return linkedList.get(i);
                }

            }

        }
        catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Exception when reading in medical information!");
            System.out.println(ex.getStackTrace());
        }
        return null;
    }

    public void changeInFile(File file, String id, String objName, Object obj) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            LinkedList<Object> linkedList = (LinkedList<Object>)ois.readObject();
            String theId;
            for (int i = 0; i < linkedList.size(); i++) {
                if (objName.equals("Medicine")) {
                    theId = ((Medicine)(linkedList.get(i))).getMedicineId();
                }
                else if (objName.equals("Treatment")) {
                    theId = ((Treatment)(linkedList.get(i))).getTreatmentId();
                }
                else if (objName.equals("ServiceFacility")) {
                    theId = ((ServiceFacility)(linkedList.get(i))).getFacilityId();
                }
                else if (objName.equals("FixedMedicalInstitution")) {
                    theId = ((FixedMedicalInstitution)(linkedList.get(i))).getInstitutionId();
                }
                else {
                    theId = ((MedicalTreatmentCalculationParameter)(linkedList.get(i))).getParameterId();
                }
                if (theId.equals(id)) {
                    linkedList.set(i, obj);
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))){
                        oos.writeObject(linkedList);
                    }
                    catch (Exception ex) {
                        System.out.println(ex);
                        System.out.println("Exception when reading in medical information!");
                        System.out.println(ex.getStackTrace());
                    }
                }

            }

        }
        catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Exception when reading in medical information!");
            System.out.println(ex.getStackTrace());
        }
    }


    public int getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(int isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public Pane getSuccessPane() {
        return successPane;
    }

    public void setSuccessPane(Pane successPane) {
        this.successPane = successPane;
    }

    public int getWhichChoice() {
        return whichChoice;
    }

    public void setWhichChoice(int whichChoice) {
        this.whichChoice = whichChoice;
    }

    public Pane getMedicinePane() {
        return medicinePane;
    }

    public void setMedicinePane(Pane medicinePane) {
        this.medicinePane = medicinePane;
    }

    public Pane getTreatmentPane() {
        return treatmentPane;
    }

    public void setTreatmentPane(Pane treatmentPane) {
        this.treatmentPane = treatmentPane;
    }

    public Pane getServiceFacilityPane() {
        return serviceFacilityPane;
    }

    public void setServiceFacilityPane(Pane serviceFacilityPane) {
        this.serviceFacilityPane = serviceFacilityPane;
    }

    public Pane getFixedMedicalInstitutionPane() {
        return fixedMedicalInstitutionPane;
    }

    public void setFixedMedicalInstitutionPane(Pane fixedMedicalInstitutionPane) {
        this.fixedMedicalInstitutionPane = fixedMedicalInstitutionPane;
    }

    public Pane getMedicalTreatmentCalculationParameterPane() {
        return medicalTreatmentCalculationParameterPane;
    }

    public void setMedicalTreatmentCalculationParameterPane(Pane medicalTreatmentCalculationParameterPane) {
        this.medicalTreatmentCalculationParameterPane = medicalTreatmentCalculationParameterPane;
    }

    public Pane getInitialPane() {
        return initialPane;
    }

    public void setInitialPane(Pane initialPane) {
        this.initialPane = initialPane;
    }

    public boolean isIsChanged() {
        return isChanged.get();
    }

    public BooleanProperty isChangedProperty() {
        return isChanged;
    }

    public void setIsChanged(boolean isChanged) {
        this.isChanged.set(isChanged);
    }

    public int getIsNotFound() {
        return isNotFound;
    }

    public void setIsNotFound(int isNotFound) {
        this.isNotFound = isNotFound;
    }

    public double getWidthProperty() {
        return widthProperty.get();
    }

    public ReadOnlyDoubleProperty widthPropertyProperty() {
        return widthProperty;
    }

    public double getHeightProperty() {
        return heightProperty.get();
    }

    public ReadOnlyDoubleProperty heightPropertyProperty() {
        return heightProperty;
    }
}
