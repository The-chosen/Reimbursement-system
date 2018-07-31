package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class IntegratedQuery {
    private Pane initialPane;
    private Pane pane1;
    private Pane pane2;
    private Pane pane3;

    Person person;
    visitInfo visitInfo;

    private int isPane1 = 0;
    private int isPane2 = 0;
    private int isPane3 = 0;
    private int isNotFound;
    private BooleanProperty isChanged = new SimpleBooleanProperty();
    private ReadOnlyDoubleProperty widthProperty;
    private ReadOnlyDoubleProperty heightProperty;

    public IntegratedQuery(ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        initialPane = new Pane();
        pane1 = new Pane();
        pane2 = new Pane();
        pane3 = new Pane();
        this.widthProperty = widthProperty;
        this.heightProperty = heightProperty;
    }


    public void layoutInitialPane() {
        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        GridPane gridPane1 = new GridPane();
        gridPane1.setAlignment(Pos.CENTER);

        Label label = new Label("请输入个人编号:");
        label.setFont(new Font(20));
        TextField textField = new TextField();
        Button button = new Button("查找");


        textField.setMinHeight(20);
        button.setAlignment(Pos.CENTER);
        button.setMinWidth(270);
        button.setMinHeight(35);
        button.setOnMouseEntered(e -> {
            button.setStyle("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
        });
        button.setOnMouseExited(e -> {
            button.setStyle("-fx-effect: null");
        });
        StackPane sp = new StackPane();
        sp.getChildren().add(button);


        gridPane1.add(label, 0, 0);
        gridPane1.add(textField, 1, 0);
        gridPane1.add(sp, 0, 1, 2, 1);

        gridPane1.setVgap(50);
        gridPane1.setHgap(12);
        textField.setMinWidth(300);

        stackPane.getChildren().add(gridPane1);
        initialPane = stackPane;


        button.setOnMouseClicked(e -> {
            File file = new File("src/files/person.dat");
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
            for (int i = 0; i < linkedList.size(); i++) {
                if (((Person)(linkedList.get(i))).getPersonId().equals(textField.getText())){
                    person = (Person)(linkedList.get(i));
                }
            }




            if (person != null) {
                isPane1 = 1;
                isChanged.set(!(isChanged.get()));
            }
            else {
                NotFoundWindow notFoundWindow = new NotFoundWindow();
                Stage stage = new Stage();
                notFoundWindow.start(stage);
                stage.setOnCloseRequest(ee -> {
                    isNotFound = 1;
                    isChanged.set(!(isChanged.get()));
                });
            }
        });



    }


    public void layoutPane1() {
        isPane1 = 0;
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

        Button btn = new Button("查询");
        btn.setMinWidth(200);
        btn.setAlignment(Pos.CENTER);
        StackPane sp = new StackPane();
        sp.getChildren().add(btn);
        gridPane2.add(sp, 0, 6, 4,1 );
        gridPane2.setVgap(15);
        gridPane2.setHgap(15);

        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.getChildren().add(gridPane2);
        gridPane2.setAlignment(Pos.CENTER);
        gridPane2.setPadding(new Insets(20, 0, 20, 20));
        gridPane2.setHgap(50);
        gridPane2.setVgap(10);

        pane1 = stackPane;

        btn.setOnMouseClicked(e -> {
            isPane2 = 1;
            isChanged.set(!(isChanged.get()));
        });
    }

    public void layoutPane2() {
        isPane2 = 0;

        StackPane stackPane = new StackPane();
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        GridPane gridPane3 = new GridPane();
        gridPane3.setAlignment(Pos.CENTER);
        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        gridPane3.add(vBox, 0, 0);
        ArrayList<visitInfo> arrayList = person.getVisitInfoLs();

        vBox.setPadding(new Insets(20, 0, 20, 0));

        for (int i = 0; i < arrayList.size(); i++) {
            visitInfo = arrayList.get(i);

            Label lb1 = new Label("审批医疗类别:");
            Label lb2 = new Label("医院级别:");
            Label lb3 = new Label("开始日期:");
            Label lb4 = new Label("结束日期:");
            Label lb5 = new Label("就诊医疗机构ID:");
            Label lb6 = new Label("就诊医疗机构名称:");
            Label lb7 = new Label("出院原因:");

            Label lb8 = new Label("年:");
            Label lb9 = new Label("月:");
            Label lb10 = new Label("日:");
            Label lb11 = new Label("年:");
            Label lb12 = new Label("月:");
            Label lb13 = new Label("日:");

            Text t1 = new Text(visitInfo.getMedicalCategory());
            Text t2 = new Text(visitInfo.getInstitutionLevel());
            Text t3 = new Text(visitInfo.getInstitutionId());
            Text t4 = new Text(visitInfo.getInstitutionName());
            Text t5 = new Text(visitInfo.getDischargeReason());
            Text t6 = new Text(visitInfo.getAdmissionTime().getYear());
            Text t7 = new Text(visitInfo.getAdmissionTime().getMonth());
            Text t8 = new Text(visitInfo.getAdmissionTime().getDate());
            Text t9 = new Text(visitInfo.getDischargeTime().getYear());
            Text t10 = new Text(visitInfo.getDischargeTime().getMonth());
            Text t11 = new Text(visitInfo.getDischargeTime().getDate());

            GridPane gridPane = new GridPane();

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 2, 0);
            gridPane.add(lb3, 0, 1);
            gridPane.add(lb4, 0, 2);
            gridPane.add(lb5, 0, 3);
            gridPane.add(lb6, 2, 3);
            gridPane.add(lb7, 0, 4);

            HBox hBox1 = new HBox();
            HBox hBox2 = new HBox();
            HBox hBox3 = new HBox();
            HBox hBox4 = new HBox();
            HBox hBox5 = new HBox();
            HBox hBox6 = new HBox();

            hBox1.getChildren().addAll(t6, lb8);
            hBox2.getChildren().addAll(t7, lb9);
            hBox3.getChildren().addAll(t8, lb10);
            hBox4.getChildren().addAll(t9, lb11);
            hBox5.getChildren().addAll(t10, lb12);
            hBox6.getChildren().addAll(t11, lb13);

            gridPane.add(hBox1, 1, 1);
            gridPane.add(hBox2, 2, 1);
            gridPane.add(hBox3, 3, 1);
            gridPane.add(hBox4, 1, 2);
            gridPane.add(hBox5, 2, 2);
            gridPane.add(hBox6, 3, 2);

            gridPane.add(t1, 1, 0);
            gridPane.add(t2, 3, 0);
            gridPane.add(t3, 1, 3);
            gridPane.add(t4, 3, 3);
            gridPane.add(t5, 1, 4);

            gridPane.setId("visitInfo");

            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(50);
            gridPane.setVgap(10);

            vBox.getChildren().add(gridPane);

            gridPane.setOnMouseClicked(e -> {
                gridPane.setOnMouseClicked(ee -> {
                    isPane3 = 1;
                    isChanged.set(!(isChanged.get()));
                });
            });

            gridPane.setOnMouseEntered(e -> {
                gridPane.setStyle("-fx-background-color: cadetblue;");
            });
            gridPane.setOnMouseExited(e -> {
                gridPane.setStyle("-fx-background-color: lightcyan");
            });
        }


        stackPane.getChildren().add(gridPane3);

        pane2 = stackPane;

    }

    public void layoutPane3() {
        isPane3 = 0;

        StackPane stackPane = new StackPane();
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setId("sp");

        GridPane gridPane3 = new GridPane();

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);

        VBox vBox1 = new VBox();
        vBox1.setPadding(new Insets(10, 0, 10, 0));
        int num1 = visitInfo.getPrescriptionDetail().getMedicineLs().size();
        ArrayList<Medicine> medicineLs= visitInfo.getPrescriptionDetail().getMedicineLs();
        for (int i = 0; i < num1; i++) {
            Medicine medicine = medicineLs.get(i);
            GridPane gridPane = new GridPane();
            Label lb1 = new Label("药品价格:");
            Label lb2 = new Label("最高限价:");
            Label lb3 = new Label("药品类别:");
            Label lb4 = new Label("药品适用医院等级");
            Label lb5 = new Label("就诊医院等级");
            Label lb6 = new Label("药品是否在基本医疗保险费用目录里:");

            String hospitalPrice = medicine.getHospitalPrice();
            String centerPrice = medicine.getCeterPrice();
            String medicineCategory = medicine.getMedicineLevel();
            String hospitalLevel = medicine.getHospitalLevel();
            String institutionLevel = visitInfo.getInstitutionLevel();


            Text t1 = new Text(hospitalPrice);
            Text t2 = new Text(centerPrice);
            Text t3 = new Text(medicineCategory);
            Text t4 = new Text(hospitalLevel);
            Text t5 = new Text(institutionLevel);
            Text t6;
            if (medicine.isInCategory()) {
                t6 = new Text("在");
            }
            else {
                t6 = new Text("不在");
            }

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 0, 1);
            gridPane.add(lb3, 0, 2);
            gridPane.add(lb4, 0, 3);
            gridPane.add(lb5, 0, 4);
            gridPane.add(lb6, 0, 5);

            gridPane.add(t1, 1, 0);
            gridPane.add(t2, 1, 1);
            gridPane.add(t3, 1, 2);
            gridPane.add(t4, 1, 3);
            gridPane.add(t5, 1, 4);
            gridPane.add(t6, 1, 5);
            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(50);
            gridPane.setVgap(10);

            vBox1.getChildren().add(gridPane);
        }


        VBox vBox2 = new VBox();
        vBox1.setPadding(new Insets(10, 0, 10, 0));
        int num2  = visitInfo.getPrescriptionDetail().getTreatmentLs().size();
        ArrayList<Treatment> treatmentLs = visitInfo.getPrescriptionDetail().getTreatmentLs();
        for (int i = 0; i < num2; i++) {
            Treatment treatment = treatmentLs.get(i);
            GridPane gridPane = new GridPane();
            Label lb1 = new Label("诊疗价格:");
            Label lb2 = new Label("诊疗类别:");
            Label lb3 = new Label("诊疗适用医院等级:");
            Label lb4 = new Label("就诊医院等级");


            String treatmentPrice = treatment.getPrice();
            String treatmentLevel = treatment.getTreatmentLevel();
            String hospitalLevel = treatment.getHospitalLevel();
            String institutionLevel = visitInfo.getInstitutionLevel();

            Text t1 = new Text(treatmentPrice);
            Text t2 = new Text(treatmentLevel);
            Text t3 = new Text(hospitalLevel);
            Text t4 = new Text(institutionLevel);

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 0, 1);
            gridPane.add(lb3, 0, 2);
            gridPane.add(lb4, 0, 3);

            gridPane.add(t1, 1, 0);
            gridPane.add(t2, 1, 1);
            gridPane.add(t3, 1, 2);
            gridPane.add(t4, 1, 3);

            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(50);
            gridPane.setVgap(10);

            vBox2.getChildren().add(gridPane);
        }

        vBox.getChildren().addAll(vBox1, vBox2);
        gridPane3.add(vBox, 0, 0);
        stackPane.getChildren().add(gridPane3);
        gridPane3.setAlignment(Pos.CENTER);
        pane3 = stackPane;

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

    public Pane getPane1() {
        return pane1;
    }

    public void setPane1(Pane pane1) {
        this.pane1 = pane1;
    }

    public Pane getPane2() {
        return pane2;
    }

    public void setPane2(Pane pane2) {
        this.pane2 = pane2;
    }

    public Pane getPane3() {
        return pane3;
    }

    public void setPane3(Pane pane3) {
        this.pane3 = pane3;
    }

    public int getIsPane2() {
        return isPane2;
    }

    public void setIsPane2(int isPane2) {
        this.isPane2 = isPane2;
    }

    public int getIsPane3() {
        return isPane3;
    }

    public void setIsPane3(int isPane3) {
        this.isPane3 = isPane3;
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

    public int getIsNotFound() {
        return isNotFound;
    }

    public void setIsNotFound(int isNotFound) {
        this.isNotFound = isNotFound;
    }

    public int getIsPane1() {
        return isPane1;
    }

    public void setIsPane1(int isPane1) {
        this.isPane1 = isPane1;
    }

    public Pane getInitialPane() {
        return initialPane;
    }

    public void setInitialPane(Pane initialPane) {
        this.initialPane = initialPane;
    }
}
