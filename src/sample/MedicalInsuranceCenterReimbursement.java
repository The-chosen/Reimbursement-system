package sample;


/*
 * 该类负责医保中心报销信息录入界面的布局和相关信息的录入
 * author: 杨越
 * version: v1
 * */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.sun.org.apache.bcel.internal.generic.LADD;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class MedicalInsuranceCenterReimbursement {
    private BooleanProperty isChanged = new SimpleBooleanProperty();
    private ReadOnlyDoubleProperty widthProperty;
    private ReadOnlyDoubleProperty heightProperty;

    private Person person;
    private visitInfo visitInfo;
    private int isEnteredOutpatientNumber = 0;

    private int isPersonApproved = 0;
    private int isSpecialSpectionApproved = 0;

    private Pane initialPane;
    private Pane showPersonInfoPane;
    private Pane enterVisitInfoPane;

    private int isNotFound = 0;
    private Pane enterMedicineDetailPane;
    private Pane enterTreatmentDetailPane;
    private Pane enterServiceFacilityDetailPane;

    private Pane notApprovedPane;
    private Pane showCalculationPane;
    private Pane choosePane;

    private int showPersonInfoPaneId;
    private int enterVisitInfoPaneId;

    private int enterMedicineDetailPaneId;
    private int enterTreatmentDetailPaneId;
    private int enterServiceFacilityDetailPaneId;

    private int notApprovedPaneId;
    private int showCalculationPaneId;
    private int choosePaneId;


    /*
    * 构造器
    * */
    public MedicalInsuranceCenterReimbursement(ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        this.widthProperty = widthProperty;
        this.heightProperty = heightProperty;
        initialPane = new Pane();
        showPersonInfoPane = new Pane();
        enterVisitInfoPane = new Pane();
        enterMedicineDetailPane = new Pane();
        notApprovedPane = new Pane();
        showCalculationPane = new Pane();

        showPersonInfoPaneId = 0;
        enterVisitInfoPaneId = 0;
        enterMedicineDetailPaneId = 0;
        enterTreatmentDetailPaneId = 0;
        notApprovedPaneId = 0;
        showCalculationPaneId = 0;
    }

    /*
     * 初始搜索界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutinitialPane() {
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
                showPersonInfoPaneId = 1;
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

    /*
     * 显示个人信息的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutshowPersonInfoPane() {
        showPersonInfoPaneId = 0;
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

        Button btn = new Button("录入参保人员就诊信息");
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


        showPersonInfoPane = stackPane;




        btn.setOnMouseClicked(e -> {
            enterVisitInfoPaneId = 1;
            isChanged.set(!(isChanged.get()));
        });
    }

    /*
     * 就诊信息录入界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutenterVisitInfoPane() {
        enterVisitInfoPaneId = 0;
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

        Button btn = new Button("确认提交本就诊信息");

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

        hBox1.getChildren().addAll(tf6, lb8);
        hBox2.getChildren().addAll(tf7, lb9);
        hBox3.getChildren().addAll(tf8, lb10);
        hBox4.getChildren().addAll(tf9, lb11);
        hBox5.getChildren().addAll(tf10, lb12);
        hBox6.getChildren().addAll(tf11, lb13);

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

        gridPane.add(btn, 0, 5, 2, 1);

        stackPane.getChildren().add(gridPane);

        enterVisitInfoPane = stackPane;

        btn.setOnMouseClicked(e -> {
            String medicalCategory = tf1.getText();
            String institutionLevel = tf2.getText();
            time admissionTime = new time(tf6.getText(), tf7.getText(), tf8.getText());
            time dischargeTime = new time(tf9.getText(), tf10.getText(), tf11.getText());
            String institutionId = tf3.getText();
            String institutionName = tf4.getText();
            String dischargeReason = tf5.getText();

            visitInfo visitInfo =
                    new visitInfo(person.getPersonId(), medicalCategory, institutionId,
                    institutionName, admissionTime, dischargeTime,
                    institutionLevel, dischargeReason);

            setVisitInfo(visitInfo);

            ArrayList<visitInfo> arrayList = person.getVisitInfoLs();
            arrayList.add(visitInfo);
            person.setVisitInfoLs(arrayList);

            choosePaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

    }

    /*
     * 处方明细中药物信息录入界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutenterMedicineDetailPane() {
        enterMedicineDetailPaneId = 0;
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

        enterMedicineDetailPane = stackPane;

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


            prescriptionDetail prescriptionDetail = visitInfo.getPrescriptionDetail();

            ArrayList<Medicine> arrayList;
            if (prescriptionDetail.getMedicineLs() == null) {
                arrayList = new ArrayList<>();
            }
            else {
                arrayList = prescriptionDetail.getMedicineLs();
            }

            arrayList.add(medicine);

            prescriptionDetail.setMedicineLs(arrayList);

            visitInfo.setPrescriptionDetail(prescriptionDetail);

            choosePaneId = 1;

            isChanged.set(!(isChanged.get()));
        });
    }

    /*
     * 处方明细中诊疗信息录入界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutenterTreatmentDetailPane() {
        enterTreatmentDetailPaneId = 0;
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
        Label lb5 = new Label("费用:");


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

        enterTreatmentDetailPane = stackPane;

        btn.setOnMouseClicked(e -> {
            String treatmentId = tf1.getText();
            String treatmentName = tf2.getText();
            String treatmentLevel = tf3.getText();
            String hospitalLevel = tf4.getText();
            String price = tf5.getText();

            boolean isLabeled;
            if (rb1.isSelected()) {
                isLabeled = true;
            }
            else {
                isLabeled = false;
            }

            String remark = ta.getText();

            Treatment treatment = new Treatment(treatmentId, treatmentName, treatmentLevel,
                    hospitalLevel, isLabeled, price,remark);

            prescriptionDetail prescriptionDetail = visitInfo.getPrescriptionDetail();

            ArrayList<Treatment> arrayList;
            if (prescriptionDetail.getTreatmentLs() == null) {
                arrayList = new ArrayList<>();
            }
            else {
                arrayList = prescriptionDetail.getTreatmentLs();
            }


            arrayList.add(treatment);

            prescriptionDetail.setTreatmentLs(arrayList);

            visitInfo.setPrescriptionDetail(prescriptionDetail);

            choosePaneId = 1;


            isChanged.set(!(isChanged.get()));
        });
    }

    /*
     * 处方明细中医疗项目信息录入界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutenterServiceFacilityDetailPane() {
        enterServiceFacilityDetailPaneId = 0;
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

        enterServiceFacilityDetailPane = stackPane;

        btn.setOnMouseClicked(e -> {
            String treatmentId = tf1.getText();
            String treatmentName = tf2.getText();

            String remark = ta.getText();

            ServiceFacility serviceFacility = new ServiceFacility(treatmentName, treatmentId, remark);



            prescriptionDetail prescriptionDetail = visitInfo.getPrescriptionDetail();

            ArrayList<ServiceFacility> arrayList;
            if (prescriptionDetail.getServiceFacilityLs() == null) {
                arrayList = new ArrayList<>();
            }
            else {
                arrayList = prescriptionDetail.getServiceFacilityLs();
            }


            arrayList.add(serviceFacility);

            prescriptionDetail.setServiceFacilityLs(arrayList);

            visitInfo.setPrescriptionDetail(prescriptionDetail);

            choosePaneId = 1;


            isChanged.set(!(isChanged.get()));
        });
    }


    /*
     * 处方信息录入的选择界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutchoosePane() {
        choosePaneId = 0;
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20, 0, 20, 0));

        HBox hBox = new HBox();
        Label label = new Label("门诊号");
        TextField textField = new TextField();
        hBox.getChildren().addAll(label, textField);

        Button btn1 = new Button("药物信息录入");
        Button btn2 = new Button("诊疗信息录入");
        Button btn3 = new Button("医疗项目信息录入");
        Button btn4 = new Button("校验审批信息");

        StackPane sp = new StackPane();
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        sp.setId("sp");
        sp.prefWidthProperty().bind(widthProperty.divide(1.25));



        if (isEnteredOutpatientNumber == 1) {
            vBox.getChildren().addAll(btn1, btn2, btn3, btn4);
            gridPane.add(vBox, 0, 0);
            sp.getChildren().add(gridPane);
            choosePane = vBox;
        }
        else {
            vBox.getChildren().addAll(hBox, btn1, btn2, btn3, btn4);
            gridPane.add(vBox, 0, 0);
            sp.getChildren().add(gridPane);
            choosePane = vBox;
        }


        btn1.setOnMouseClicked(e -> {
            enterMedicineDetailPaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

        btn2.setOnMouseClicked(e -> {
            enterTreatmentDetailPaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

        btn3.setOnMouseClicked(e -> {
            enterServiceFacilityDetailPaneId = 1;
            isChanged.set(!(isChanged.get()));
        });

        btn4.setOnMouseClicked(e -> {
            ArrayList<personVisitApprovalInfo> arrayList1 = person.getPersonVisitApprovalInfoLs();
            ArrayList<specialSpectionApproval> arrayList2 = person.getSpecialSpectionApprovaLs();

            String fixedInstitutionId = person.getDesignatedHospitalNumber();
            String nowInstitutionId = visitInfo.getInstitutionId();

            if (!(fixedInstitutionId.equals(nowInstitutionId))) {
                boolean isFound = false;
                for (int i = 0; i < arrayList1.size(); i++) {
                    if (nowInstitutionId.equals(arrayList1.get(i).getFixedHospitalId())) {
                        isFound = true;
                    }
                }

                if (!isFound) {
                    notApprovedPaneId = 1;
                    isChanged.set(!(isChanged.get()));
                }

            }
            else {
                ArrayList<Medicine> arrayList3 = visitInfo.getPrescriptionDetail().getMedicineLs();
                ArrayList<Treatment> arrayList4 = visitInfo.getPrescriptionDetail().getTreatmentLs();
                boolean isIn1;
                boolean isIn2;
                boolean isNotApproved1 = false;
                boolean isNotApproved2 = false;
                for (int i = 0; i < arrayList3.size(); i++) {
                    if (arrayList3.get(i).isLabeled()) {
                        isIn1 = false;
                        for (int j = 0; j < arrayList2.size(); j++) {
                            if (arrayList2.get(i).getPrescriptionId().equals(arrayList3.get(i).getMedicineId())){
                                isIn1 = true;
                            }
                        }
                        if (!isIn1) {
                            isNotApproved1 = true;
                        }
                    }
                }

                for (int i = 0; i < arrayList4.size(); i++) {
                    if (arrayList4.get(i).isLabeled()) {
                        isIn2 = false;
                        for (int j = 0; j < arrayList2.size(); j++) {
                            if (arrayList2.get(i).getPrescriptionId().equals(arrayList4.get(i).getTreatmentId())){
                                isIn2 = true;
                            }
                        }
                        if (!isIn2) {
                            isNotApproved2 = true;
                        }
                    }
                }

                if (isNotApproved1 || isNotApproved2) {
                    notApprovedPaneId = 2;
                    isChanged.set(!(isChanged.get()));
                }
                else {
                    showCalculationPaneId = 1;
                    isChanged.set(!(isChanged.get()));
                }
            }

        });

        isEnteredOutpatientNumber = 1;
    }

    /*
     * 审核未通过的界面布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutnotApprovedPane(int num) {
        notApprovedPaneId = 0;
//        不同医院审批未通过
        if (num == 1) {
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
            img2 = new ImageView("img/personVisitNotApproved.png");
            img2.fitWidthProperty().bind(widthProperty.divide(1.7));
            img2.fitHeightProperty().bind(heightProperty.divide(9));

            hBox.getChildren().addAll(img1, img2);
            stackPane.getChildren().add(hBox);
            notApprovedPane = stackPane;
        }
//        处方审批未通过
        if (num == 2) {
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
            img2 = new ImageView("img/specialSpectionNotApproved.png");
            img2.fitWidthProperty().bind(widthProperty.divide(1.7));
            img2.fitHeightProperty().bind(heightProperty.divide(9));

            hBox.getChildren().addAll(img1, img2);
            stackPane.getChildren().add(hBox);
            notApprovedPane = stackPane;
        }


        person = null;
        visitInfo = null;
        isEnteredOutpatientNumber = 0;
    }

    /*
     * 显示结算结果的界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutshowCalculationPane() {
        showCalculationPaneId = 0;
        int preparePrice = 0;
        StackPane stackPane = new StackPane();
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));
        stackPane.setId("sp");

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
            Label lb7 = new Label("该药品可给予的预结算费用:");

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


            String conclusion;
            if (Double.parseDouble(hospitalPrice) > Double.parseDouble(centerPrice)) {
                conclusion = centerPrice;
            }
            else {
                conclusion = hospitalPrice;
            }

            if (medicineCategory.equals("甲")){
            }
            else if (medicineCategory.equals("乙")){
                conclusion = 0.5 * Double.parseDouble(conclusion) + "";
            }
            else {
                conclusion = "0";
            }

            if (!(conclusion.equals("0"))) {
                if (Integer.parseInt(hospitalLevel) > Integer.parseInt(institutionLevel)) {
                    conclusion = "0";
                }
                if (!medicine.isInCategory()) {
                    conclusion = "0";
                }
            }

            preparePrice += Double.parseDouble(conclusion);

            Text t7 = new Text(conclusion);

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 0, 1);
            gridPane.add(lb3, 0, 2);
            gridPane.add(lb4, 0, 3);
            gridPane.add(lb5, 0, 4);
            gridPane.add(lb6, 0, 5);
            gridPane.add(lb7, 0, 6);

            gridPane.add(t1, 1, 0);
            gridPane.add(t2, 1, 1);
            gridPane.add(t3, 1, 2);
            gridPane.add(t4, 1, 3);
            gridPane.add(t5, 1, 4);
            gridPane.add(t6, 1, 5);
            gridPane.add(t7, 1, 6);


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
            Label lb5 = new Label("该诊疗可给予的预结算费用:");

            String treatmentPrice = treatment.getPrice();
            String treatmentLevel = treatment.getTreatmentLevel();
            String hospitalLevel = treatment.getHospitalLevel();
            String institutionLevel = visitInfo.getInstitutionLevel();

            Text t1 = new Text(treatmentPrice);
            Text t2 = new Text(treatmentLevel);
            Text t3 = new Text(hospitalLevel);
            Text t4 = new Text(institutionLevel);


            String conclusion;
            conclusion = treatmentPrice;

            if (treatmentLevel.equals("甲")){
            }
            else if (treatmentLevel.equals("乙")){
                conclusion = 0.5 * Double.parseDouble(conclusion) + "";
            }
            else {
                conclusion = "0";
            }

            if (!(conclusion.equals("0"))) {
                if (Integer.parseInt(hospitalLevel) > Integer.parseInt(institutionLevel)) {
                    conclusion = "0";
                }
            }

            Text t5 = new Text(conclusion);

            preparePrice += Double.parseDouble(conclusion);

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 0, 1);
            gridPane.add(lb3, 0, 2);
            gridPane.add(lb4, 0, 3);
            gridPane.add(lb5, 0, 4);

            gridPane.add(t1, 1, 0);
            gridPane.add(t2, 1, 1);
            gridPane.add(t3, 1, 2);
            gridPane.add(t4, 1, 3);
            gridPane.add(t5, 1, 4);



            gridPane.setPadding(new Insets(20, 0, 20, 20));
            gridPane.setHgap(50);
            gridPane.setVgap(10);

            vBox2.getChildren().add(gridPane);

        }


        GridPane gridPane = new GridPane();

        Label lb1 = new Label("起付费用:");
        Label lb2 = new Label("封顶费用:");
        Label lb3 = new Label("最终结算费用:");

        gridPane.setPadding(new Insets(20, 0, 20, 20));
        gridPane.setHgap(50);
        gridPane.setVgap(10);


        File file = new File("src/files/medicalTreatmentCalculationParameter.dat");
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

        MedicalTreatmentCalculationParameter medicalTreatmentCalculationParameter = (MedicalTreatmentCalculationParameter)linkedList.get(0);
        double thresholdPrice = medicalTreatmentCalculationParameter.getThresholdPrice();
        double cappingLine = medicalTreatmentCalculationParameter.getCappingLine();
        Text t1 = new Text(thresholdPrice + "");
        Text t2 = new Text(cappingLine + "");

        double totalPrice = person.getTotalPrice();
        double nowPrice = totalPrice + preparePrice - thresholdPrice;
        double finalPrice;
        if (nowPrice > cappingLine) {
            finalPrice = nowPrice - cappingLine;
        }
        else {
            finalPrice = nowPrice;
        }

        Text t3 = new Text(finalPrice + "");
        person.setTotalPrice(totalPrice + finalPrice);

        gridPane.add(lb1, 0, 0);
        gridPane.add(lb2, 0, 1);
        gridPane.add(lb3, 0, 2);
        gridPane.add(t1, 1, 0);
        gridPane.add(t2, 1, 1);
        gridPane.add(t3, 1, 2);



        vBox.getChildren().addAll(vBox1, vBox2, gridPane);
        vBox.setPadding(new Insets(8, 0, 8, 0));
        GridPane gridPane1 = new GridPane();
        gridPane1.add(vBox, 0, 0);
        gridPane1.setAlignment(Pos.CENTER);
        stackPane.getChildren().addAll(gridPane1);
        stackPane.setId("sp");
        stackPane.prefWidthProperty().bind(widthProperty.divide(1.25));

        showCalculationPane = stackPane;


        File file1 = new File("src/files/person.dat");

        LinkedList<Object> linkedList1 = new LinkedList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file1))){
            linkedList1 = (LinkedList<Object>)ois.readObject();
        }
        catch (Exception ex) {
            if (ex instanceof EOFException) {
                linkedList1 = new LinkedList<>();
            }
            else {
                System.out.println(ex);
                System.out.println("Exception when reading information!");
                System.out.println(ex.getStackTrace());
            }
        }

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file1, false))){
            linkedList1.add(person);
            oos.writeObject(linkedList1);
        }
        catch (Exception ex) {
            System.out.println(ex);
            System.out.println("Exception when writing information!");
            System.out.println(ex.getStackTrace());
        }

        person = null;
        visitInfo = null;
        isEnteredOutpatientNumber = 0;
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

    public Pane getInitialPane() {
        return initialPane;
    }

    public void setInitialPane(Pane initialPane) {
        this.initialPane = initialPane;
    }

    public Pane getShowPersonInfoPane() {
        return showPersonInfoPane;
    }

    public void setShowPersonInfoPane(Pane showPersonInfoPane) {
        this.showPersonInfoPane = showPersonInfoPane;
    }

    public Pane getEnterVisitInfoPane() {
        return enterVisitInfoPane;
    }

    public void setEnterVisitInfoPane(Pane enterVisitInfoPane) {
        this.enterVisitInfoPane = enterVisitInfoPane;
    }

    public Pane getNotApprovedPane() {
        return notApprovedPane;
    }

    public void setNotApprovedPane(Pane notApprovedPane) {
        this.notApprovedPane = notApprovedPane;
    }

    public Pane getShowCalculationPane() {
        return showCalculationPane;
    }

    public void setShowCalculationPane(Pane showCalculationPane) {
        this.showCalculationPane = showCalculationPane;
    }

    public int getShowPersonInfoPaneId() {
        return showPersonInfoPaneId;
    }

    public void setShowPersonInfoPaneId(int showPersonInfoPaneId) {
        this.showPersonInfoPaneId = showPersonInfoPaneId;
    }

    public int getEnterVisitInfoPaneId() {
        return enterVisitInfoPaneId;
    }

    public void setEnterVisitInfoPaneId(int enterVisitInfoPaneId) {
        this.enterVisitInfoPaneId = enterVisitInfoPaneId;
    }

    public int getNotApprovedPaneId() {
        return notApprovedPaneId;
    }

    public void setNotApprovedPaneId(int notApprovedPaneId) {
        this.notApprovedPaneId = notApprovedPaneId;
    }

    public int getShowCalculationPaneId() {
        return showCalculationPaneId;
    }

    public void setShowCalculationPaneId(int showCalculationPaneId) {
        this.showCalculationPaneId = showCalculationPaneId;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getIsNotFound() {
        return isNotFound;
    }

    public void setIsNotFound(int isNotFound) {
        this.isNotFound = isNotFound;
    }

    public Pane getEnterMedicineDetailPane() {
        return enterMedicineDetailPane;
    }

    public void setEnterMedicineDetailPane(Pane enterMedicineDetailPane) {
        this.enterMedicineDetailPane = enterMedicineDetailPane;
    }

    public Pane getEnterTreatmentDetailPane() {
        return enterTreatmentDetailPane;
    }

    public void setEnterTreatmentDetailPane(Pane enterTreatmentDetailPane) {
        this.enterTreatmentDetailPane = enterTreatmentDetailPane;
    }

    public Pane getEnterServiceFacilityDetailPane() {
        return enterServiceFacilityDetailPane;
    }

    public void setEnterServiceFacilityDetailPane(Pane enterServiceFacilityDetailPane) {
        this.enterServiceFacilityDetailPane = enterServiceFacilityDetailPane;
    }

    public Pane getChoosePane() {
        return choosePane;
    }

    public void setChoosePane(Pane choosePane) {
        this.choosePane = choosePane;
    }

    public int getEnterMedicineDetailPaneId() {
        return enterMedicineDetailPaneId;
    }

    public void setEnterMedicineDetailPaneId(int enterMedicineDetailPaneId) {
        this.enterMedicineDetailPaneId = enterMedicineDetailPaneId;
    }

    public int getEnterTreatmentDetailPaneId() {
        return enterTreatmentDetailPaneId;
    }

    public void setEnterTreatmentDetailPaneId(int enterTreatmentDetailPaneId) {
        this.enterTreatmentDetailPaneId = enterTreatmentDetailPaneId;
    }

    public int getEnterServiceFacilityDetailPaneId() {
        return enterServiceFacilityDetailPaneId;
    }

    public void setEnterServiceFacilityDetailPaneId(int enterServiceFacilityDetailPaneId) {
        this.enterServiceFacilityDetailPaneId = enterServiceFacilityDetailPaneId;
    }

    public int getChoosePaneId() {
        return choosePaneId;
    }

    public void setChoosePaneId(int choosePaneId) {
        this.choosePaneId = choosePaneId;
    }

    public sample.visitInfo getVisitInfo() {
        return visitInfo;
    }

    public void setVisitInfo(sample.visitInfo visitInfo) {
        this.visitInfo = visitInfo;
    }
}
