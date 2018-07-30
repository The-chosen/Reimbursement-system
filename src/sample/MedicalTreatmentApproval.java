package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class MedicalTreatmentApproval {
    private BooleanProperty isChanged = new SimpleBooleanProperty();

    private Pane serchIdPane;
    private Pane personApprovalHasPane;
    private Pane specialSpectionHasPane;
    private Pane personApprovalNotPane;
    private Pane specialSpectionNotPane;
    private Pane personApprovalAddPane;
    private Pane personApprovalDeletePane;
    private Pane personApprovalChangePane;
    private Pane specialSpectionAddPane;
    private Pane specialSpectionDeletePane;
    private Pane specialSpectionChangePane;
    private Pane chooseAPane;
    private Pane chooseSPane;
    private Pane successPane;

    private int personApprovalHasPaneId;
    private int specialSpectionHasPaneId;
    private int personApprovalNotPaneId;
    private int specialSpectionNotPaneId;
    private int personApprovalAddPaneId;
    private int personApprovalDeletePaneId;
    private int personApprovalChangePaneId;
    private int specialSpectionAddPaneId;
    private int specialSpectionDeletePaneId;
    private int specialSpectionChangePaneId;
    private int successId;
    private int chooseAPaneId;
    private int chooseSPaneId;
    private int isNotFound;

    private Person person;

    private ReadOnlyDoubleProperty widthProperty;
    private ReadOnlyDoubleProperty heightProperty;

    public MedicalTreatmentApproval(ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        serchIdPane = new Pane();
        personApprovalHasPane = new Pane();
        specialSpectionHasPane = new Pane();
        personApprovalNotPane = new Pane();
        specialSpectionNotPane = new Pane();
        personApprovalAddPane = new Pane();
        personApprovalDeletePane = new Pane();
        personApprovalChangePane = new Pane();
        specialSpectionAddPane = new Pane();
        specialSpectionDeletePane = new Pane();
        specialSpectionChangePane = new Pane();
        successPane = new Pane();

        personApprovalHasPaneId = 0;
        specialSpectionHasPaneId = 0;
        personApprovalNotPaneId = 0;
        specialSpectionNotPaneId = 0;
        personApprovalAddPaneId = 0;
        personApprovalDeletePaneId = 0;
        personApprovalChangePaneId = 0;
        specialSpectionAddPaneId = 0;
        specialSpectionDeletePaneId = 0;
        specialSpectionChangePaneId = 0;
        successId = 0;
        isNotFound = 0;
        chooseAPaneId = 0;
        chooseSPaneId = 0;
        person = null;

        this.widthProperty = widthProperty;
        this.heightProperty = heightProperty;

        isChanged.set(false);
    }

    public void layoutSerchIdPane(int num) {
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);

        Label label = new Label("请输入个人编号:");
        TextField textField = new TextField();
        Button button = new Button("查找");
        button.setAlignment(Pos.CENTER_RIGHT);
        gridPane1.add(label, 0, 0);
        gridPane1.add(textField, 1, 0);
        gridPane1.add(button, 1, 1);

        stackPane.getChildren().add(gridPane1);
        serchIdPane = stackPane;

        File file = new File("src/files/person.dat");
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            LinkedList<Object> linkedList = (LinkedList<Object>)ois.readObject();
            for (int i = 0; i < linkedList.size(); i++) {
                if (((Person)linkedList.get(i)).getPersonId().equals(textField.getText())){
                    person = (Person)linkedList.get(i);
                }
            }
        }
        catch(Exception ex) {
            System.out.println(ex);
            System.out.println("Exception when reading file!");
        }





        if (person != null) {

            if (num == 1) {
                button.setOnMouseClicked(e -> {
                    personApprovalHasPaneId = 1;
                    isChanged.set(!(isChanged.get()));
                });
            }

            if (num == 2) {
                button.setOnMouseClicked(e -> {
                    specialSpectionHasPaneId = 1;
                    isChanged.set(!(isChanged.get()));
                });
            }

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

    public void layoutpersonApprovalHasPane() {
        personApprovalHasPaneId = 0;
        Label lb1 = new Label("参保人ID:");
        Label lb2 = new Label("参保人姓名:");
        Label lb3 = new Label("性别:");
        Label lb4 = new Label("出生日期:");
        Label lb5 = new Label("证件类型:");
        Label lb6 = new Label("证件号码:");
        Label lb7 = new Label("民族:");
        Label lb8 = new Label("户口所在地:");
        Label lb9 = new Label("电话:");
        Label lb10 = new Label("定点医疗机构编码:");

        Label lb11 = new Label("年");
        Label lb12 = new Label("月");
        Label lb13 = new Label("日");

        Text t1 = new Text(person.getPersonId());
        Text t2 = new Text(person.getPersonName());
        Text t3 = new Text(person.getGender());
        Text t4 = new Text(person.getDocumentCategory());
        Text t5 = new Text(person.getDocumentIdentity());
        Text t6 = new Text(person.getNationality());
        Text t7 = new Text(person.getLivePlace());
        Text t8 = new Text(person.getPhoneNumber());
        Text t9 = new Text(person.getDesignatedHospitalNumber());
        Text t10 = new Text(person.getBirthday().getYear());
        Text t11 = new Text(person.getBirthday().getMonth());
        Text t12 = new Text(person.getBirthday().getDate());


        GridPane gridPane2 = new GridPane();

        gridPane2.add(lb1, 0, 0);
        gridPane2.add(lb2, 2, 0);
        gridPane2.add(lb3, 0, 1);
        gridPane2.add(lb7, 2, 1);
        gridPane2.add(lb5, 0, 2);
        gridPane2.add(lb6, 2, 2);

        gridPane2.add(lb8, 0, 4);
        gridPane2.add(lb9, 2, 4);
        gridPane2.add(lb10, 0, 5);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(lb4, t10, lb11, t11, lb12, t12, lb13);

        gridPane2.add(hBox, 0, 3, 4, 1);



        gridPane2.add(t1, 1, 0);
        gridPane2.add(t2, 3, 0);
        gridPane2.add(t3, 1, 1);
        gridPane2.add(t4, 3, 1);
        gridPane2.add(t5, 1, 2);
        gridPane2.add(t6, 3, 2);
        gridPane2.add(t7, 1, 4);
        gridPane2.add(t8, 3, 4);
        gridPane2.add(t9, 1, 5);

        Button btn = new Button("查询人员就诊机构审批信息");
        gridPane2.add(btn, 1, 6, 2,1 );
        gridPane2.setVgap(15);
        gridPane2.setHgap(15);

        personApprovalHasPane = gridPane2;

        btn.setOnMouseClicked(e -> {
            if (person.getPersonVisitApprovalInfoLs().size() != 0){
                chooseAPaneId = 1;
                isChanged.set(!(isChanged.get()));
            }
            else {
                personApprovalNotPaneId = 1;
                isChanged.set(!(isChanged.get()));
            }
        });


    }

    public void layoutspecialSpectionHasPane() {
        specialSpectionHasPaneId = 0;
        Label lb1 = new Label("参保人ID:");
        Label lb2 = new Label("参保人姓名:");
        Label lb3 = new Label("性别:");
        Label lb4 = new Label("出生日期:");
        Label lb5 = new Label("证件类型:");
        Label lb6 = new Label("证件号码:");
        Label lb7 = new Label("民族:");
        Label lb8 = new Label("户口所在地:");
        Label lb9 = new Label("电话:");
        Label lb10 = new Label("定点医疗机构编码:");

        Label lb11 = new Label("年");
        Label lb12 = new Label("月");
        Label lb13 = new Label("日");

        Text t1 = new Text(person.getPersonId());
        Text t2 = new Text(person.getPersonName());
        Text t3 = new Text(person.getGender());
        Text t4 = new Text(person.getDocumentCategory());
        Text t5 = new Text(person.getDocumentIdentity());
        Text t6 = new Text(person.getNationality());
        Text t7 = new Text(person.getLivePlace());
        Text t8 = new Text(person.getPhoneNumber());
        Text t9 = new Text(person.getDesignatedHospitalNumber());
        Text t10 = new Text(person.getBirthday().getYear());
        Text t11 = new Text(person.getBirthday().getMonth());
        Text t12 = new Text(person.getBirthday().getDate());


        GridPane gridPane2 = new GridPane();

        gridPane2.add(lb1, 0, 0);
        gridPane2.add(lb2, 2, 0);
        gridPane2.add(lb3, 0, 1);
        gridPane2.add(lb7, 2, 1);
        gridPane2.add(lb5, 0, 2);
        gridPane2.add(lb6, 2, 2);

        gridPane2.add(lb8, 0, 4);
        gridPane2.add(lb9, 2, 4);
        gridPane2.add(lb10, 0, 5);

        HBox hBox = new HBox();
        hBox.getChildren().addAll(lb4, t10, lb11, t11, lb12, t12, lb13);

        gridPane2.add(hBox, 0, 3, 4, 1);



        gridPane2.add(t1, 1, 0);
        gridPane2.add(t2, 3, 0);
        gridPane2.add(t3, 1, 1);
        gridPane2.add(t4, 3, 1);
        gridPane2.add(t5, 1, 2);
        gridPane2.add(t6, 3, 2);
        gridPane2.add(t7, 1, 4);
        gridPane2.add(t8, 3, 4);
        gridPane2.add(t9, 1, 5);

        Button btn = new Button("查询特申特批审批信息");
        gridPane2.add(btn, 1, 6, 2,1 );
        gridPane2.setVgap(15);
        gridPane2.setHgap(15);

        specialSpectionHasPane = gridPane2;
        btn.setOnMouseClicked(e -> {
            if (person.getSpecialSpectionApprovaLs().size() != 0) {
                chooseSPaneId = 1;
                isChanged.set(!(isChanged.get()));
            }
            else {
                specialSpectionNotPaneId = 1;
                isChanged.set(!(isChanged.get()));
            }
        });
    }

    public void layoutPersonApprovalChoosePane() {
        chooseAPaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        VBox v1 = new VBox();
        VBox v2 = new VBox();
        VBox v4 = new VBox();
        v1.setId("v1");
        v2.setId("v2");

        v4.setId("v4");
        v1.setAlignment(Pos.CENTER);
        v2.setAlignment(Pos.CENTER);
        v4.setAlignment(Pos.CENTER);


        ImageView img1 = new ImageView("img/addIcon.png");
        ImageView imgt1 = new ImageView("img/addInfo.png");
        ImageView img2 = new ImageView("img/deleteIcon.png");
        ImageView imgt2 = new ImageView("img/deleteInfo.png");
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
        img4.fitWidthProperty().bind(widthProperty.divide(11));
        img4.fitHeightProperty().bind(heightProperty.divide(8.5));
        imgt4.fitWidthProperty().bind(widthProperty.divide(10));
        imgt4.fitHeightProperty().bind(heightProperty.divide(20));
        img.fitWidthProperty().bind(widthProperty.divide(5));
        img.fitHeightProperty().bind(heightProperty.divide(4));


        v1.getChildren().addAll(img1, imgt1);
        v2.getChildren().addAll(img2, imgt2);
        v4.getChildren().addAll(img4, imgt4);

        gridPane.add(v1, 1, 0);
        gridPane.add(v2, 2, 2);
        gridPane.add(v4, 0, 2);
        gridPane.add(img, 1, 1);

        stackPane.getChildren().add(gridPane);
        chooseAPane = stackPane;

        v1.setOnMouseClicked(e -> {
            personApprovalAddPaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

        v2.setOnMouseClicked(e -> {
            personApprovalDeletePaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

        v4.setOnMouseClicked(e -> {
            personApprovalChangePaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

    }

    public void layoutSpecialSpectionChoosePane() {
        chooseSPaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20, 20, 20, 20));
        VBox v1 = new VBox();
        VBox v2 = new VBox();
        VBox v4 = new VBox();
        v1.setId("v1");
        v2.setId("v2");

        v4.setId("v4");
        v1.setAlignment(Pos.CENTER);
        v2.setAlignment(Pos.CENTER);
        v4.setAlignment(Pos.CENTER);


        ImageView img1 = new ImageView("img/addIcon.png");
        ImageView imgt1 = new ImageView("img/addInfo.png");
        ImageView img2 = new ImageView("img/deleteIcon.png");
        ImageView imgt2 = new ImageView("img/deleteInfo.png");
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
        img4.fitWidthProperty().bind(widthProperty.divide(11));
        img4.fitHeightProperty().bind(heightProperty.divide(8.5));
        imgt4.fitWidthProperty().bind(widthProperty.divide(10));
        imgt4.fitHeightProperty().bind(heightProperty.divide(20));
        img.fitWidthProperty().bind(widthProperty.divide(5));
        img.fitHeightProperty().bind(heightProperty.divide(4));


        v1.getChildren().addAll(img1, imgt1);
        v2.getChildren().addAll(img2, imgt2);
        v4.getChildren().addAll(img4, imgt4);

        gridPane.add(v1, 1, 0);
        gridPane.add(v2, 2, 2);
        gridPane.add(v4, 0, 2);
        gridPane.add(img, 1, 1);

        stackPane.getChildren().add(gridPane);
        chooseSPane = stackPane;

        v1.setOnMouseClicked(e -> {
            specialSpectionAddPaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

        v2.setOnMouseClicked(e -> {
            specialSpectionDeletePaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

        v4.setOnMouseClicked(e -> {
            specialSpectionChangePaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

    }

    public void layoutpersonApprovalNotPane() {
        personApprovalNotPaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ImageView img1 = new ImageView("img/fail.png");
        img1.fitWidthProperty().bind(widthProperty.divide(10));
        img1.fitHeightProperty().bind(heightProperty.divide(9));

        ImageView img2 = new ImageView();
        img2 = new ImageView("img/personApprovalNot.png");
        img2.fitWidthProperty().bind(widthProperty.divide(1.7));
        img2.fitHeightProperty().bind(heightProperty.divide(9));

        hBox.getChildren().addAll(img1, img2);
        stackPane.getChildren().add(hBox);
        personApprovalNotPane = stackPane;
    }

    public void layoutspecialSpectionNotPane() {
        specialSpectionNotPaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setAlignment(Pos.CENTER);
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);

        ImageView img1 = new ImageView("img/fail.png");
        img1.fitWidthProperty().bind(widthProperty.divide(10));
        img1.fitHeightProperty().bind(heightProperty.divide(9));

        ImageView img2 = new ImageView();
        img2 = new ImageView("img/specialSpectionNot.png");
        img2.fitWidthProperty().bind(widthProperty.divide(1.7));
        img2.fitHeightProperty().bind(heightProperty.divide(9));

        hBox.getChildren().addAll(img1, img2);
        stackPane.getChildren().add(hBox);

        specialSpectionNotPane = stackPane;
    }



    public void layoutpersonApprovalAddPane(){
        specialSpectionAddPaneId = 0;
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

        Label lb1 = new Label("审批ID:");
        Label lb2 = new Label("人员ID:");
        Label lb3 = new Label("开始日期:");
        Label lb4 = new Label("结束日期:");
        Label lb5 = new Label("定点医疗机构ID:");
        Label lb6 = new Label("审批人:");
        Label lb7 = new Label("审批意见:");
        Label lb8 = new Label("审批时间:");
        Label lb9 = new Label("开始年:");
        Label lb10 = new Label("开始月:");
        Label lb11 = new Label("开始日:");
        Label lb12 = new Label("结束年:");
        Label lb13 = new Label("结束月:");
        Label lb14 = new Label("结束日:");

        Button btn = new Button("确认提交本人员就诊审批信息");

        gridPane.add(lb1, 0, 0);
        gridPane.add(lb2, 2, 0);
        gridPane.add(lb3, 0, 1);
        gridPane.add(lb4, 0, 2);
        gridPane.add(lb5, 0, 3);
        gridPane.add(lb6, 2, 3);
        gridPane.add(lb7, 0, 4);
        gridPane.add(lb8, 2, 4);

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();
        HBox hBox6 = new HBox();

        hBox1.getChildren().addAll(tf7, lb9);
        hBox2.getChildren().addAll(tf8, lb10);
        hBox3.getChildren().addAll(tf9, lb11);
        hBox4.getChildren().addAll(tf10, lb12);
        hBox5.getChildren().addAll(tf11, lb13);
        hBox6.getChildren().addAll(tf12, lb14);

        gridPane.add(hBox1, 1, 1);
        gridPane.add(hBox2, 2, 1);
        gridPane.add(hBox3, 3, 1);
        gridPane.add(hBox4, 1, 2);
        gridPane.add(hBox5, 2, 2);
        gridPane.add(hBox6, 3, 2);

        gridPane.add(tf1, 1, 0);
        gridPane.add(tf2, 3, 0);
        gridPane.add(tf3, 1, 3);
        gridPane.add(tf4, 3, 3);
        gridPane.add(tf5, 1, 4);
        gridPane.add(tf6, 3, 4);

        gridPane.add(btn, 0, 5, 2, 1);

        stackPane.getChildren().add(gridPane);

        specialSpectionAddPane = stackPane;

        btn.setOnMouseClicked(e -> {
            String approvalId = tf1.getText();
            String personId = tf2.getText();
            time beginTime = new time(tf7.getText(), tf8.getText(), tf9.getText());
            time endTime = new time(tf10.getText(), tf11.getText(), tf12.getText());
            String fixedHospitalId = tf3.getText();
            String approvalPerson = tf4.getText();
            String approvalSuggestion = tf5.getText();
            String approvalTime = tf6.getText();

            personVisitApprovalInfo personVisitApprovalInfo =
                    new personVisitApprovalInfo(approvalId, personId, beginTime,
                            endTime, fixedHospitalId, approvalPerson,
                            approvalSuggestion, approvalTime);

            ArrayList<personVisitApprovalInfo> arrayList = person.getPersonVisitApprovalInfoLs();
            arrayList.add(personVisitApprovalInfo);
            person.setPersonVisitApprovalInfoLs(arrayList);

            successId = 1;
            isChanged.set(!(isChanged.get()));
        });
    }

    public void layoutpersonApprovalDeletePane() {
        personApprovalDeletePaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        Label label = new Label("请输入您想要删除的人员就诊审批信息编号:");
        TextField textField = new TextField();
        Button button = new Button("删除");
        button.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(label, 0, 0);
        gridPane.add(textField, 1, 0);
        gridPane.add(button, 1, 1);

        stackPane.getChildren().add(gridPane);
        personApprovalDeletePane = stackPane;

        button.setOnMouseClicked(e -> {
            ConformInfo conformInfo = new ConformInfo();
            Stage s = new Stage();
            conformInfo.start(s);
            (conformInfo.isClickedProperty()).addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    s.close();
                    if (conformInfo.isDeleted()) {
                        ArrayList<personVisitApprovalInfo> arrayList = person.getPersonVisitApprovalInfoLs();
                        boolean isFound = false;
                        for (int i = 0; i < arrayList.size(); i++) {
                            if (arrayList.get(i).getApprovalId().equals(textField.getText())){
                                isFound = true;
                            }
                        }
                        if (isFound) {
                            successId = 2;
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

    public void layoutpersonApprovalChangePane() {
        personApprovalChangePaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);

        Label label = new Label("请输入您想要修改的人员就诊审批信息编号:");
        TextField textField = new TextField();
        Button button = new Button("修改");
        button.setAlignment(Pos.CENTER_RIGHT);
        gridPane1.add(label, 0, 0);
        gridPane1.add(textField, 1, 0);
        gridPane1.add(button, 1, 1);

        stackPane.getChildren().add(gridPane1);
        personApprovalChangePane = stackPane;

        button.setOnMouseClicked(ee -> {
            ArrayList<personVisitApprovalInfo> arrayList = person.getPersonVisitApprovalInfoLs();
            personVisitApprovalInfo personVisitApprovalInfo = null;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getApprovalId().equals(textField.getText())){
                    personVisitApprovalInfo = arrayList.get(i);
                }
            }

            if (personVisitApprovalInfo == null) {
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

                TextField tf1 = new TextField(personVisitApprovalInfo.getApprovalId());
                TextField tf2 = new TextField(personVisitApprovalInfo.getPersonId());
                TextField tf3 = new TextField(personVisitApprovalInfo.getFixedHospitalId());
                TextField tf4 = new TextField(personVisitApprovalInfo.getApprovalPerson());
                TextField tf5 = new TextField(personVisitApprovalInfo.getApprovalSuggestion());
                TextField tf6 = new TextField(personVisitApprovalInfo.getApprovalTime());

                TextField tf7 = new TextField(personVisitApprovalInfo.getBeginTime().getYear());
                TextField tf8 = new TextField(personVisitApprovalInfo.getBeginTime().getMonth());
                TextField tf9 = new TextField(personVisitApprovalInfo.getBeginTime().getDate());
                TextField tf10 = new TextField(personVisitApprovalInfo.getEndTime().getYear());
                TextField tf11 = new TextField(personVisitApprovalInfo.getEndTime().getMonth());
                TextField tf12 = new TextField(personVisitApprovalInfo.getEndTime().getDate());

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

                Label lb1 = new Label("审批ID:");
                Label lb2 = new Label("人员ID:");
                Label lb3 = new Label("开始日期:");
                Label lb4 = new Label("结束日期:");
                Label lb5 = new Label("定点医疗机构ID:");
                Label lb6 = new Label("审批人:");
                Label lb7 = new Label("审批意见:");
                Label lb8 = new Label("审批时间:");
                Label lb9 = new Label("开始年:");
                Label lb10 = new Label("开始月:");
                Label lb11 = new Label("开始日:");
                Label lb12 = new Label("结束年:");
                Label lb13 = new Label("结束月:");
                Label lb14 = new Label("结束日:");

                Button btn = new Button("确认提交本人员就诊审批信息");

                gridPane.add(lb1, 0, 0);
                gridPane.add(lb2, 2, 0);
                gridPane.add(lb3, 0, 1);
                gridPane.add(lb4, 0, 2);
                gridPane.add(lb5, 0, 3);
                gridPane.add(lb6, 2, 3);
                gridPane.add(lb7, 0, 4);
                gridPane.add(lb8, 2, 4);

                HBox hBox1 = new HBox();
                HBox hBox2 = new HBox();
                HBox hBox3 = new HBox();
                HBox hBox4 = new HBox();
                HBox hBox5 = new HBox();
                HBox hBox6 = new HBox();

                hBox1.getChildren().addAll(tf7, lb9);
                hBox2.getChildren().addAll(tf8, lb10);
                hBox3.getChildren().addAll(tf9, lb11);
                hBox4.getChildren().addAll(tf10, lb12);
                hBox5.getChildren().addAll(tf11, lb13);
                hBox6.getChildren().addAll(tf12, lb14);

                gridPane.add(hBox1, 1, 1);
                gridPane.add(hBox2, 2, 1);
                gridPane.add(hBox3, 3, 1);
                gridPane.add(hBox4, 1, 2);
                gridPane.add(hBox5, 2, 2);
                gridPane.add(hBox6, 3, 2);

                gridPane.add(tf1, 1, 0);
                gridPane.add(tf2, 3, 0);
                gridPane.add(tf3, 1, 3);
                gridPane.add(tf4, 3, 3);
                gridPane.add(tf5, 1, 4);
                gridPane.add(tf6, 3, 4);

                gridPane.add(btn, 0, 5, 2, 1);

                stackPane1.getChildren().add(gridPane);

                personApprovalChangePane = stackPane1;


                btn.setOnMouseClicked(exx -> {
                    String approvalId = tf1.getText();
                    String personId = tf2.getText();
                    time beginTime = new time(tf7.getText(), tf8.getText(), tf9.getText());
                    time endTime = new time(tf10.getText(), tf11.getText(), tf12.getText());
                    String fixedHospitalId = tf3.getText();
                    String approvalPerson = tf4.getText();
                    String approvalSuggestion = tf5.getText();
                    String approvalTime = tf6.getText();

                    personVisitApprovalInfo personVisitApprovalInfo1 =
                            new personVisitApprovalInfo(approvalId, personId, beginTime,
                                    endTime, fixedHospitalId, approvalPerson,
                                    approvalSuggestion, approvalTime);

                    ArrayList<personVisitApprovalInfo> arrayList1 = person.getPersonVisitApprovalInfoLs();
                    arrayList1.add(personVisitApprovalInfo1);
                    person.setPersonVisitApprovalInfoLs(arrayList1);

                    successId = 3;
                    isChanged.set(!(isChanged.get()));
                });

            }

        });
    }

    public void layoutspecialSpectionAddPane() {
        personApprovalAddPaneId = 0;
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

        Label lb1 = new Label("审批ID:");
        Label lb2 = new Label("人员ID:");
        Label lb3 = new Label("开始日期:");
        Label lb4 = new Label("结束日期:");
        Label lb5 = new Label("项目ID:");
        Label lb6 = new Label("审批人:");
        Label lb7 = new Label("审批意见:");
        Label lb8 = new Label("审批时间:");
        Label lb9 = new Label("开始年:");
        Label lb10 = new Label("开始月:");
        Label lb11 = new Label("开始日:");
        Label lb12 = new Label("结束年:");
        Label lb13 = new Label("结束月:");
        Label lb14 = new Label("结束日:");

        Button btn = new Button("确认提交本特申特批信息");

        gridPane.add(lb1, 0, 0);
        gridPane.add(lb2, 2, 0);
        gridPane.add(lb3, 0, 1);
        gridPane.add(lb4, 0, 2);
        gridPane.add(lb5, 0, 3);
        gridPane.add(lb6, 2, 3);
        gridPane.add(lb7, 0, 4);
        gridPane.add(lb8, 2, 4);

        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        HBox hBox4 = new HBox();
        HBox hBox5 = new HBox();
        HBox hBox6 = new HBox();

        hBox1.getChildren().addAll(tf7, lb9);
        hBox2.getChildren().addAll(tf8, lb10);
        hBox3.getChildren().addAll(tf9, lb11);
        hBox4.getChildren().addAll(tf10, lb12);
        hBox5.getChildren().addAll(tf11, lb13);
        hBox6.getChildren().addAll(tf12, lb14);

        gridPane.add(hBox1, 1, 1);
        gridPane.add(hBox2, 2, 1);
        gridPane.add(hBox3, 3, 1);
        gridPane.add(hBox4, 1, 2);
        gridPane.add(hBox5, 2, 2);
        gridPane.add(hBox6, 3, 2);

        gridPane.add(tf1, 1, 0);
        gridPane.add(tf2, 3, 0);
        gridPane.add(tf3, 1, 3);
        gridPane.add(tf4, 3, 3);
        gridPane.add(tf5, 1, 4);
        gridPane.add(tf6, 3, 4);

        gridPane.add(btn, 0, 5, 2, 1);

        stackPane.getChildren().add(gridPane);

        specialSpectionAddPane = stackPane;

        btn.setOnMouseClicked(e -> {
            String approvalId = tf1.getText();
            String personId = tf2.getText();
            time beginTime = new time(tf7.getText(), tf8.getText(), tf9.getText());
            time endTime = new time(tf10.getText(), tf11.getText(), tf12.getText());
            String prescriptionId = tf3.getText();
            String approvalPerson = tf4.getText();
            String approvalSuggestion = tf5.getText();
            String approvalTime = tf6.getText();

            specialSpectionApproval specialSpectionApproval =
                    new specialSpectionApproval(approvalId, personId, beginTime,
                            endTime, prescriptionId, approvalPerson,
                            approvalSuggestion, approvalTime);

            ArrayList<specialSpectionApproval> arrayList = person.getSpecialSpectionApprovaLs();
            arrayList.add(specialSpectionApproval);
            person.setSpecialSpectionApprovaLs(arrayList);

            successId = 1;
            isChanged.set(!(isChanged.get()));
        });
    }

    public void layoutspecialSpectionDeletePane() {
        specialSpectionDeletePaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        Label label = new Label("请输入您想要删除的特申特批信息编号:");
        TextField textField = new TextField();
        Button button = new Button("删除");
        button.setAlignment(Pos.CENTER_RIGHT);
        gridPane.add(label, 0, 0);
        gridPane.add(textField, 1, 0);
        gridPane.add(button, 1, 1);

        stackPane.getChildren().add(gridPane);
        specialSpectionDeletePane = stackPane;

        button.setOnMouseClicked(e -> {
            ConformInfo conformInfo = new ConformInfo();
            Stage s = new Stage();
            conformInfo.start(s);
            (conformInfo.isClickedProperty()).addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    s.close();
                    if (conformInfo.isDeleted()) {
                        ArrayList<specialSpectionApproval> arrayList = person.getSpecialSpectionApprovaLs();
                        boolean isFound = false;
                        for (int i = 0; i < arrayList.size(); i++) {
                            if (arrayList.get(i).getApprovalId().equals(textField.getText())){
                                isFound = true;
                            }
                        }
                        if (isFound) {
                            successId = 2;
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

    public void layoutspecialSpectionChangePane() {
        specialSpectionChangePaneId = 0;
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);

        Label label = new Label("请输入您想要修改的特申特批信息编号:");
        TextField textField = new TextField();
        Button button = new Button("修改");
        button.setAlignment(Pos.CENTER_RIGHT);
        gridPane1.add(label, 0, 0);
        gridPane1.add(textField, 1, 0);
        gridPane1.add(button, 1, 1);

        stackPane.getChildren().add(gridPane1);
        specialSpectionChangePane = stackPane;

        button.setOnMouseClicked(ee -> {
            ArrayList<specialSpectionApproval> arrayList = person.getSpecialSpectionApprovaLs();
            specialSpectionApproval specialSpectionApproval = null;
            for (int i = 0; i < arrayList.size(); i++) {
                if (arrayList.get(i).getApprovalId().equals(textField.getText())){
                    specialSpectionApproval = arrayList.get(i);
                }
            }

            if (specialSpectionApproval == null) {
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

                TextField tf1 = new TextField(specialSpectionApproval.getApprovalId());
                TextField tf2 = new TextField(specialSpectionApproval.getPersonId());
                TextField tf3 = new TextField(specialSpectionApproval.getPrescriptionId());
                TextField tf4 = new TextField(specialSpectionApproval.getApprovalPerson());
                TextField tf5 = new TextField(specialSpectionApproval.getApprovalSuggestion());
                TextField tf6 = new TextField(specialSpectionApproval.getApprovalTime());
                TextField tf7 = new TextField(specialSpectionApproval.getBeginTime().getYear());
                TextField tf8 = new TextField(specialSpectionApproval.getBeginTime().getMonth());
                TextField tf9 = new TextField(specialSpectionApproval.getBeginTime().getDate());
                TextField tf10 = new TextField(specialSpectionApproval.getEndTime().getYear());
                TextField tf11 = new TextField(specialSpectionApproval.getEndTime().getMonth());
                TextField tf12 = new TextField(specialSpectionApproval.getEndTime().getDate());

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

                Label lb1 = new Label("审批ID:");
                Label lb2 = new Label("人员ID:");
                Label lb3 = new Label("开始日期:");
                Label lb4 = new Label("结束日期:");
                Label lb5 = new Label("项目ID:");
                Label lb6 = new Label("审批人:");
                Label lb7 = new Label("审批意见:");
                Label lb8 = new Label("审批时间:");
                Label lb9 = new Label("开始年:");
                Label lb10 = new Label("开始月:");
                Label lb11 = new Label("开始日:");
                Label lb12 = new Label("结束年:");
                Label lb13 = new Label("结束月:");
                Label lb14 = new Label("结束日:");

                Button btn = new Button("确认提交本特申特批信息");

                gridPane.add(lb1, 0, 0);
                gridPane.add(lb2, 2, 0);
                gridPane.add(lb3, 0, 1);
                gridPane.add(lb4, 0, 2);
                gridPane.add(lb5, 0, 3);
                gridPane.add(lb6, 2, 3);
                gridPane.add(lb7, 0, 4);
                gridPane.add(lb8, 2, 4);

                HBox hBox1 = new HBox();
                HBox hBox2 = new HBox();
                HBox hBox3 = new HBox();
                HBox hBox4 = new HBox();
                HBox hBox5 = new HBox();
                HBox hBox6 = new HBox();

                hBox1.getChildren().addAll(tf7, lb9);
                hBox2.getChildren().addAll(tf8, lb10);
                hBox3.getChildren().addAll(tf9, lb11);
                hBox4.getChildren().addAll(tf10, lb12);
                hBox5.getChildren().addAll(tf11, lb13);
                hBox6.getChildren().addAll(tf12, lb14);

                gridPane.add(hBox1, 1, 1);
                gridPane.add(hBox2, 2, 1);
                gridPane.add(hBox3, 3, 1);
                gridPane.add(hBox4, 1, 2);
                gridPane.add(hBox5, 2, 2);
                gridPane.add(hBox6, 3, 2);

                gridPane.add(tf1, 1, 0);
                gridPane.add(tf2, 3, 0);
                gridPane.add(tf3, 1, 3);
                gridPane.add(tf4, 3, 3);
                gridPane.add(tf5, 1, 4);
                gridPane.add(tf6, 3, 4);

                gridPane.add(btn, 0, 5, 2, 1);

                stackPane1.getChildren().add(gridPane);

                specialSpectionChangePane = stackPane1;


                btn.setOnMouseClicked(exx -> {
                    String approvalId = tf1.getText();
                    String personId = tf2.getText();
                    time beginTime = new time(tf7.getText(), tf8.getText(), tf9.getText());
                    time endTime = new time(tf10.getText(), tf11.getText(), tf12.getText());
                    String prescriptionId = tf3.getText();
                    String approvalPerson = tf4.getText();
                    String approvalSuggestion = tf5.getText();
                    String approvalTime = tf6.getText();

                    specialSpectionApproval specialSpectionApproval1 =
                            new specialSpectionApproval(approvalId, personId, beginTime,
                                    endTime, prescriptionId, approvalPerson,
                                    approvalSuggestion, approvalTime);

                    ArrayList<specialSpectionApproval> arrayList1 = person.getSpecialSpectionApprovaLs();
                    arrayList1.add(specialSpectionApproval1);
                    person.setSpecialSpectionApprovaLs(arrayList1);

                    successId = 3;
                    isChanged.set(!(isChanged.get()));
                });

            }

        });
    }

    public void layoutSuccessfulPane(int num) {
        successId = 0;

        File file = new File("src/files/person.dat");
        LinkedList<Object> linkedList = new LinkedList<>();
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file, false))) {
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
            {
                linkedList = (LinkedList<Object>)ois.readObject();
            }
            catch (Exception ex) {
                System.out.println(ex);
                System.out.println("Exception when reading file!");
            }

            linkedList.add(person);
            oos.writeObject(linkedList);
        }
        catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Exception when writing file!");
        }

        person = null;


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

    public Pane getSerchIdPane() {
        return serchIdPane;
    }

    public void setSerchIdPane(Pane serchIdPane) {
        this.serchIdPane = serchIdPane;
    }

    public Pane getPersonApprovalHasPane() {
        return personApprovalHasPane;
    }

    public void setPersonApprovalHasPane(Pane personApprovalHasPane) {
        this.personApprovalHasPane = personApprovalHasPane;
    }

    public Pane getSpecialSpectionHasPane() {
        return specialSpectionHasPane;
    }

    public void setSpecialSpectionHasPane(Pane specialSpectionHasPane) {
        this.specialSpectionHasPane = specialSpectionHasPane;
    }

    public Pane getPersonApprovalNotPane() {
        return personApprovalNotPane;
    }

    public void setPersonApprovalNotPane(Pane personApprovalNotPane) {
        this.personApprovalNotPane = personApprovalNotPane;
    }

    public Pane getSpecialSpectionNotPane() {
        return specialSpectionNotPane;
    }

    public void setSpecialSpectionNotPane(Pane specialSpectionNotPane) {
        this.specialSpectionNotPane = specialSpectionNotPane;
    }

    public Pane getPersonApprovalAddPane() {
        return personApprovalAddPane;
    }

    public void setPersonApprovalAddPane(Pane personApprovalAddPane) {
        this.personApprovalAddPane = personApprovalAddPane;
    }

    public Pane getPersonApprovalDeletePane() {
        return personApprovalDeletePane;
    }

    public void setPersonApprovalDeletePane(Pane personApprovalDeletePane) {
        this.personApprovalDeletePane = personApprovalDeletePane;
    }

    public Pane getPersonApprovalChangePane() {
        return personApprovalChangePane;
    }

    public void setPersonApprovalChangePane(Pane personApprovalChangePane) {
        this.personApprovalChangePane = personApprovalChangePane;
    }

    public Pane getSpecialSpectionAddPane() {
        return specialSpectionAddPane;
    }

    public void setSpecialSpectionAddPane(Pane specialSpectionAddPane) {
        this.specialSpectionAddPane = specialSpectionAddPane;
    }

    public Pane getSpecialSpectionDeletePane() {
        return specialSpectionDeletePane;
    }

    public void setSpecialSpectionDeletePane(Pane specialSpectionDeletePane) {
        this.specialSpectionDeletePane = specialSpectionDeletePane;
    }

    public Pane getSpecialSpectionChangePane() {
        return specialSpectionChangePane;
    }

    public void setSpecialSpectionChangePane(Pane specialSpectionChangePane) {
        this.specialSpectionChangePane = specialSpectionChangePane;
    }

    public int getPersonApprovalHasPaneId() {
        return personApprovalHasPaneId;
    }

    public void setPersonApprovalHasPaneId(int personApprovalHasPaneId) {
        this.personApprovalHasPaneId = personApprovalHasPaneId;
    }

    public int getSpecialSpectionHasPaneId() {
        return specialSpectionHasPaneId;
    }

    public void setSpecialSpectionHasPaneId(int specialSpectionHasPaneId) {
        this.specialSpectionHasPaneId = specialSpectionHasPaneId;
    }

    public int getPersonApprovalNotPaneId() {
        return personApprovalNotPaneId;
    }

    public void setPersonApprovalNotPaneId(int personApprovalNotPaneId) {
        this.personApprovalNotPaneId = personApprovalNotPaneId;
    }

    public int getSpecialSpectionNotPaneId() {
        return specialSpectionNotPaneId;
    }

    public void setSpecialSpectionNotPaneId(int specialSpectionNotPaneId) {
        this.specialSpectionNotPaneId = specialSpectionNotPaneId;
    }

    public int getPersonApprovalAddPaneId() {
        return personApprovalAddPaneId;
    }

    public void setPersonApprovalAddPaneId(int personApprovalAddPaneId) {
        this.personApprovalAddPaneId = personApprovalAddPaneId;
    }

    public int getPersonApprovalDeletePaneId() {
        return personApprovalDeletePaneId;
    }

    public void setPersonApprovalDeletePaneId(int personApprovalDeletePaneId) {
        this.personApprovalDeletePaneId = personApprovalDeletePaneId;
    }

    public int getPersonApprovalChangePaneId() {
        return personApprovalChangePaneId;
    }

    public void setPersonApprovalChangePaneId(int personApprovalChangePaneId) {
        this.personApprovalChangePaneId = personApprovalChangePaneId;
    }

    public int getSpecialSpectionAddPaneId() {
        return specialSpectionAddPaneId;
    }

    public void setSpecialSpectionAddPaneId(int specialSpectionAddPaneId) {
        this.specialSpectionAddPaneId = specialSpectionAddPaneId;
    }

    public int getSpecialSpectionDeletePaneId() {
        return specialSpectionDeletePaneId;
    }

    public void setSpecialSpectionDeletePaneId(int specialSpectionDeletePaneId) {
        this.specialSpectionDeletePaneId = specialSpectionDeletePaneId;
    }

    public int getSpecialSpectionChangePaneId() {
        return specialSpectionChangePaneId;
    }

    public void setSpecialSpectionChangePaneId(int specialSpectionChangePaneId) {
        this.specialSpectionChangePaneId = specialSpectionChangePaneId;
    }

    public Pane getSuccessPane() {
        return successPane;
    }

    public void setSuccessPane(Pane successPane) {
        this.successPane = successPane;
    }

    public int getSuccessId() {
        return successId;
    }

    public void setSuccessId(int successId) {
        this.successId = successId;
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

    public Pane getChooseAPane() {
        return chooseAPane;
    }

    public void setChooseAPane(Pane chooseAPane) {
        this.chooseAPane = chooseAPane;
    }

    public Pane getChooseSPane() {
        return chooseSPane;
    }

    public void setChooseSPane(Pane chooseSPane) {
        this.chooseSPane = chooseSPane;
    }

    public int getChooseAPaneId() {
        return chooseAPaneId;
    }

    public void setChooseAPaneId(int chooseAPaneId) {
        this.chooseAPaneId = chooseAPaneId;
    }

    public int getChooseSPaneId() {
        return chooseSPaneId;
    }

    public void setChooseSPaneId(int chooseSPaneId) {
        this.chooseSPaneId = chooseSPaneId;
    }

    public int getIsNotFound() {
        return isNotFound;
    }

    public void setIsNotFound(int isNotFound) {
        this.isNotFound = isNotFound;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
