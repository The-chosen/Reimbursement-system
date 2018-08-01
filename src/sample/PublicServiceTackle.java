package sample;

/*
 * 该类负责诊疗信息录入界面的布局和相关信息的录入
 * author: 杨越
 * version: v1
 * */

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

public class PublicServiceTackle {
    private Pane publicServiceTacklePane;
    private BooleanProperty isChanged = new SimpleBooleanProperty();
    private Pane initialPane;
    private int whichChoice;
    private int isSuccessful;
    private int isNotFound;
    private Pane successPane;
    private ReadOnlyDoubleProperty widthProperty;
    private ReadOnlyDoubleProperty heightProperty;


    public PublicServiceTackle(ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        publicServiceTacklePane = new Pane();
        initialPane = new Pane();
        this.widthProperty = widthProperty;
        this.heightProperty = heightProperty;
        whichChoice = 0;
        isNotFound = 0;
        isSuccessful = 0;
    }

    /*
     * 初始选择界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
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

    /*
     * 诊疗信息录入界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutPublicServiceTacklePane(int num) {
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





            Button btn = new Button("确认提交本参保人信息");

            gridPane.add(lb1, 0, 0);
            gridPane.add(lb2, 2, 0);
            gridPane.add(lb3, 0, 1);
            gridPane.add(lb7, 2, 1);
            gridPane.add(lb5, 0, 2);
            gridPane.add(lb6, 2, 2);

            gridPane.add(lb8, 0, 4);
            gridPane.add(lb9, 2, 4);
            gridPane.add(lb10, 0, 5);

            HBox hBox = new HBox();
            hBox.getChildren().addAll(lb4, tf10, lb11, tf11, lb12, tf12, lb13);

            gridPane.add(hBox, 0, 3, 4, 1);


            gridPane.add(tf1, 1, 0);
            gridPane.add(tf2, 3, 0);
            gridPane.add(tf3, 1, 1);
            gridPane.add(tf4, 3, 1);
            gridPane.add(tf5, 1, 2);
            gridPane.add(tf6, 3, 2);
            gridPane.add(tf7, 1, 4);
            gridPane.add(tf8, 3, 4);
            gridPane.add(tf9, 1, 5);


            gridPane.add(btn, 0, 6, 2, 1);

            stackPane.getChildren().add(gridPane);

            publicServiceTacklePane = stackPane;

            btn.setOnMouseClicked(e -> {
                String personId = tf1.getText();
                String personName = tf2.getText();
                String gender = tf3.getText();
                String documentCategory = tf4.getText();
                String documentIdentity = tf5.getText();
                String nationality = tf6.getText();
                String livePlace = tf7.getText();
                String phoneNumber = tf8.getText();
                String designatedHospitalNumber = tf9.getText();

                String year = tf10.getText();
                String month = tf11.getText();
                String date = tf12.getText();

                time birthday = new time(year, month, date);

                ArrayList<visitInfo> visitInfoLs = new ArrayList<>();
                ArrayList<personVisitApprovalInfo> personVisitApprovalInfoArrayLs = new ArrayList<>();
                ArrayList<specialSpectionApproval> specialSpectionApprovaLs = new ArrayList<>();

                double totalPrice = 0;

                Person person = new Person(personId, personName, gender,
                        birthday, documentCategory, documentIdentity,
                        nationality, livePlace, phoneNumber,
                totalPrice, visitInfoLs, designatedHospitalNumber,
                        personVisitApprovalInfoArrayLs, specialSpectionApprovaLs);
                File file = new File("src/files/person.dat");
                writeFile(file, person);

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

            Label label = new Label("请输入您想要删除的参保人编号:");
            TextField textField = new TextField();
            Button button = new Button("删除");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane.add(label, 0, 0);
            gridPane.add(textField, 1, 0);
            gridPane.add(button, 1, 1);

            stackPane.getChildren().add(gridPane);
            publicServiceTacklePane = stackPane;

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
                            File file = new File("src/files/person.dat");

                            if (deleteInFile(file, textField.getText())) {
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

            Label label = new Label("请输入您想要查找的参保人编号:");
            TextField textField = new TextField();
            Button button = new Button("查找");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            publicServiceTacklePane = stackPane;


            button.setOnMouseClicked(e -> {
                File file = new File("src/files/person.dat");
                Person person = (Person)selectFromTheFile(file, textField.getText());
                if (person != null) {
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


                    gridPane2.setVgap(15);
                    gridPane2.setHgap(15);

                    publicServiceTacklePane = gridPane2;


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

            Label label = new Label("请输入您想要修改的参保人编号:");
            TextField textField = new TextField();
            Button button = new Button("修改");
            button.setAlignment(Pos.CENTER_RIGHT);
            gridPane1.add(label, 0, 0);
            gridPane1.add(textField, 1, 0);
            gridPane1.add(button, 1, 1);

            stackPane.getChildren().add(gridPane1);
            publicServiceTacklePane = stackPane;



            button.setOnMouseClicked(ee -> {
                File file = new File("src/files/person.dat");
                Person person = (Person) selectFromTheFile(file, textField.getText());

                if (person == null) {
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
                    stackPane1.setId("sp");
                    stackPane1.prefWidthProperty().bind(widthProperty.divide(1.25));
                    GridPane gridPane = new GridPane();
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.setPadding(new Insets(20, 0, 20, 20));
                    gridPane.setHgap(10);
                    gridPane.setVgap(8);

                    TextField tf1 = new TextField(person.getPersonId());
                    TextField tf2 = new TextField(person.getPersonName());
                    TextField tf3 = new TextField(person.getGender());
                    TextField tf4 = new TextField(person.getDocumentCategory());
                    TextField tf5 = new TextField(person.getDocumentIdentity());
                    TextField tf6 = new TextField(person.getNationality());
                    TextField tf7 = new TextField(person.getLivePlace());
                    TextField tf8 = new TextField(person.getPhoneNumber());
                    TextField tf9 = new TextField(person.getDesignatedHospitalNumber());
                    TextField tf10 = new TextField(person.getBirthday().getYear());
                    TextField tf11 = new TextField(person.getBirthday().getMonth());
                    TextField tf12 = new TextField(person.getBirthday().getDate());


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





                    Button btn = new Button("确认提交此参保人信息");

                    gridPane.add(lb1, 0, 0);
                    gridPane.add(lb2, 2, 0);
                    gridPane.add(lb3, 0, 1);
                    gridPane.add(lb7, 2, 1);
                    gridPane.add(lb5, 0, 2);
                    gridPane.add(lb6, 2, 2);

                    gridPane.add(lb8, 0, 4);
                    gridPane.add(lb9, 2, 4);
                    gridPane.add(lb10, 0, 5);

                    HBox hBox = new HBox();
                    hBox.getChildren().addAll(lb4, tf10, lb11, tf11, lb12, tf12, lb13);

                    gridPane.add(hBox, 0, 3, 4, 1);


                    gridPane.add(tf1, 1, 0);
                    gridPane.add(tf2, 3, 0);
                    gridPane.add(tf3, 1, 1);
                    gridPane.add(tf4, 3, 1);
                    gridPane.add(tf5, 1, 2);
                    gridPane.add(tf6, 3, 2);
                    gridPane.add(tf7, 1, 4);
                    gridPane.add(tf8, 3, 4);
                    gridPane.add(tf9, 1, 5);


                    gridPane.add(btn, 0, 6, 2, 1);

                    stackPane1.getChildren().add(gridPane);

                    publicServiceTacklePane = stackPane1;

                    whichChoice = 0;
                    isSuccessful = 5;
                    isChanged.set(!(isChanged.get()));

                    btn.setOnMouseClicked(e -> {
                        String personId = tf1.getText();
                        String personName = tf2.getText();
                        String gender = tf3.getText();
                        String documentCategory = tf4.getText();
                        String documentIdentity = tf5.getText();
                        String nationality = tf6.getText();
                        String livePlace = tf7.getText();
                        String phoneNumber = tf8.getText();
                        String designatedHospitalNumber = tf9.getText();

                        String year = tf10.getText();
                        String month = tf11.getText();
                        String date = tf12.getText();

                        time birthday = new time(year, month, date);

                        ArrayList<visitInfo> visitInfoLs = new ArrayList<>();
                        ArrayList<personVisitApprovalInfo> personVisitApprovalInfoArrayLs = new ArrayList<>();
                        ArrayList<specialSpectionApproval> specialSpectionApprovaLs = new ArrayList<>();

                        double totalPrice = 0;

                        Person person1 = new Person(personId, personName, gender,
                                birthday, documentCategory, documentIdentity,
                                nationality, livePlace, phoneNumber,
                                totalPrice, visitInfoLs, designatedHospitalNumber, personVisitApprovalInfoArrayLs,
                                specialSpectionApprovaLs);
                        File file1 = new File("src/files/person.dat");
                        changeInFile(file1, textField.getText(), person1);

                        whichChoice = 0;
                        isSuccessful = 4;
                        isChanged.set(!(isChanged.get()));
                    });

                }

            });
        }
    }

    /*
     * 诊疗信息录入成功界面的布局与点击事件处理
     * parameter: 无
     * return: void
     * */
    public void layoutPublicServiceTackleSuccessfulPane(int num) {
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
            gridPane.add(publicServiceTacklePane, 0, 0);
            gridPane.setAlignment(Pos.CENTER);
            stackPane1.setId("sp");
            stackPane1.prefWidthProperty().bind(widthProperty.divide(1.25));
            stackPane1.getChildren().add(gridPane);

            successPane = stackPane1;
        }

        if (num == 5) {
            successPane = publicServiceTacklePane;
        }
    }

    /*
     * 写入文件的方法
     * parameter: File file, Object object
     * return: void
     * */
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

    /*
     * 读取文件的方法
     * parameter: File file
     * return: LinkedList<Object>
     * */
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

    /*
     * 在文件中删除的方法
     * parameter: File file, String objName, String id
     * return: boolean
     * */
    public boolean deleteInFile(File file, String id) {
        LinkedList<Object> linkedList = readFile(file);
        boolean found = false;

        for (int i = 0; i < linkedList.size(); i++) {

            if (((Person)(linkedList.get(i))).getPersonId().equals(id)){
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


    /*
     * 在文件搜索的方法
     * parameter: File file, String id, String objName
     * return: Object
     * */
    public Object selectFromTheFile(File file, String id) {
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
            if (((Person)(linkedList.get(i))).getPersonId().equals(id)) {
                return linkedList.get(i);
            }
        }

        return null;
    }

    /*
     * 在文件改变某对象的方法
     * parameter: File file, String id, String objName, Object obj
     * return: void
     * */
    public void changeInFile(File file, String id, Object obj) {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            LinkedList<Object> linkedList = (LinkedList<Object>)ois.readObject();
            for (int i = 0; i < linkedList.size(); i++) {
                if (((Person)(linkedList.get(i))).getPersonId().equals(id)) {
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

    public Pane getPublicServiceTacklePane() {
        return publicServiceTacklePane;
    }

    public void setPublicServiceTacklePane(Pane publicServiceTacklePane) {
        this.publicServiceTacklePane = publicServiceTacklePane;
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

    public Pane getInitialPane() {
        return initialPane;
    }

    public void setInitialPane(Pane initialPane) {
        this.initialPane = initialPane;
    }

    public int getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(int isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public int getIsNotFound() {
        return isNotFound;
    }

    public void setIsNotFound(int isNotFound) {
        this.isNotFound = isNotFound;
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
}

