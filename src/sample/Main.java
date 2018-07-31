package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.BooleanProperty;
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
import javafx.util.Duration;


import java.util.Observable;

public class Main extends Application {
    private Pane navigationPane;
    private Pane sidebarPane;
    private Pane topPane;
    private Pane doPane;
    private Pane pane;
    private ReadOnlyDoubleProperty widthProperty;
    private ReadOnlyDoubleProperty heightProperty;
    private DoubleBinding sideBarProperty;
    private IntegerProperty currentMode = new SimpleIntegerProperty();
    private IntegerProperty currentMedicalMode = new SimpleIntegerProperty();
    private IntegerProperty currentPublicServiceTackleMode = new SimpleIntegerProperty();
    private IntegerProperty currentMedicalInsuranceCenterReimbursementMode = new SimpleIntegerProperty();
    private IntegerProperty currentMedicalTreatmentMode = new SimpleIntegerProperty();
    private IntegerProperty currentIntegratedQueryMode = new SimpleIntegerProperty();
    private MedicalInformation medicalInformation;
    private PublicServiceTackle publicServiceTackle;
    private MedicalInsuranceCenterReimbursement medicalInsuranceCenterReimbursement;
    private MedicalTreatmentApproval medicalTreatmentApproval;
    private IntegratedQuery integratedQuery;

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
            ImageView imageView = new ImageView("img/logo.png");
            imageView.fitHeightProperty().bind(heightProperty.divide(7));
            imageView.fitWidthProperty().bind(widthProperty.divide(9.2));
            StackPane sp = new StackPane();
            sp.setId("ssp1");
            sp.getChildren().add(imageView);
            sp.setAlignment(Pos.BOTTOM_CENTER);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.35));

            Text text1 = new Text("药物");
            Text text2 = new Text("诊疗");
            Text text3 = new Text("服务设施");
            Text text4 = new Text("定点医疗机构");
            Text text5 = new Text("医疗待遇计算参数");
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
            ImageView imageView = new ImageView("img/logo.png");
            imageView.fitHeightProperty().bind(heightProperty.divide(7));
            imageView.fitWidthProperty().bind(widthProperty.divide(9.2));
            StackPane sp = new StackPane();
            sp.setId("ssp1");
            sp.getChildren().add(imageView);
            sp.setAlignment(Pos.BOTTOM_CENTER);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.35));

            Text text1 = new Text("参保人信息");
            text1.setFont(new Font(16));

            sp1.getChildren().add(text1);

            vBox.getChildren().addAll(sp1, sp);

            sp1.setOnMouseClicked(e -> {
                currentPublicServiceTackleMode.set(1);
            });
        }

        else if (currentMode.get() == 3) {
            StackPane sp1 = new StackPane();
            sp1.setId("ssp1");
            ImageView imageView = new ImageView("img/logo.png");
            imageView.fitHeightProperty().bind(heightProperty.divide(7));
            imageView.fitWidthProperty().bind(widthProperty.divide(9.2));
            StackPane sp = new StackPane();
            sp.setId("ssp1");
            sp.getChildren().add(imageView);
            sp.setAlignment(Pos.BOTTOM_CENTER);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.35));

            Text text1 = new Text("医保中心报销");
            text1.setFont(new Font(16));

            sp1.getChildren().add(text1);

            vBox.getChildren().addAll(sp1, sp);

            sp1.setOnMouseClicked(e -> {
                currentMedicalInsuranceCenterReimbursementMode.set(1);
            });
        }

        else if (currentMode.get() == 4) {
            StackPane sp1 = new StackPane();
            sp1.setId("ssp1");
            StackPane sp2 = new StackPane();
            sp2.setId("ssp1");
            ImageView imageView = new ImageView("img/logo.png");
            imageView.fitHeightProperty().bind(heightProperty.divide(7));
            imageView.fitWidthProperty().bind(widthProperty.divide(9.2));
            StackPane sp = new StackPane();
            sp.setId("ssp1");
            sp.getChildren().add(imageView);
            sp.setAlignment(Pos.BOTTOM_CENTER);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.35));

            Text text1 = new Text("特检特治");
            text1.setFont(new Font(16));
            Text text2 = new Text("不同医保医院");
            text2.setFont(new Font(16));


            sp1.getChildren().add(text1);
            sp2.getChildren().add(text2);

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
            ImageView imageView = new ImageView("img/logo.png");
            imageView.fitHeightProperty().bind(heightProperty.divide(7));
            imageView.fitWidthProperty().bind(widthProperty.divide(9.2));
            StackPane sp = new StackPane();
            sp.setId("ssp1");
            sp.getChildren().add(imageView);
            sp.setAlignment(Pos.BOTTOM_CENTER);
            sp.prefHeightProperty().bind(heightProperty);
            sp.prefWidthProperty().bind(widthProperty.divide(5.35));

            Text text1 = new Text("综合查询");
            text1.setFont(new Font(16));


            sp1.getChildren().add(text1);

            vBox.getChildren().addAll(sp1, sp);

            sp1.setOnMouseClicked(e -> {
                currentIntegratedQueryMode.set(1);
            });
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
        ImageView imageView = new ImageView("img/title.png");
        imageView.fitHeightProperty().bind(heightProperty.divide(9));
        imageView.fitWidthProperty().bind(widthProperty.divide(1.8));
        StackPane sp = new StackPane();
        sp.getChildren().add(imageView);
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
            if (currentMedicalMode.get() == 1) {
                medicalInformation.layoutInitialPane();
                doPane = medicalInformation.getInitialPane();

                if (medicalInformation.getWhichChoice() != 0) {
                    medicalInformation.layoutMedicinePane(medicalInformation.getWhichChoice());
                    doPane = medicalInformation.getMedicinePane();
                }

                if (medicalInformation.getIsSuccessful() != 0) {
                    if (medicalInformation.getIsSuccessful() != 5) {
                        currentMedicalMode.set(0);
                    }
                    medicalInformation.layoutMedicineSuccessfulPane(medicalInformation.getIsSuccessful());
                    doPane = medicalInformation.getSuccessPane();
                }

                if (medicalInformation.getIsNotFound() == 1) {
                    currentMedicalMode.set(0);
                    medicalInformation.setIsNotFound(0);
                    medicalInformation.setWhichChoice(0);
                }
            }
            else if (currentMedicalMode.get() == 2) {
                medicalInformation.layoutInitialPane();
                doPane = medicalInformation.getInitialPane();

                if (medicalInformation.getWhichChoice() != 0) {
                    medicalInformation.layoutTreatmentPane(medicalInformation.getWhichChoice());
                    doPane = medicalInformation.getTreatmentPane();
                }

                if (medicalInformation.getIsSuccessful() != 0) {
                    if (medicalInformation.getIsSuccessful() != 5) {
                        currentMedicalMode.set(0);
                    }
                    medicalInformation.layoutTreatmentSuccessfulPane(medicalInformation.getIsSuccessful());
                    doPane = medicalInformation.getSuccessPane();
                }
                if (medicalInformation.getIsNotFound() == 1) {
                    currentMedicalMode.set(0);
                    medicalInformation.setIsNotFound(0);
                    medicalInformation.setWhichChoice(0);
                }

            }
            else if (currentMedicalMode.get() == 3) {
                medicalInformation.layoutInitialPane();
                doPane = medicalInformation.getInitialPane();

                if (medicalInformation.getWhichChoice() != 0) {
                    medicalInformation.layoutServiceFacilityPane(medicalInformation.getWhichChoice());
                    doPane = medicalInformation.getServiceFacilityPane();
                }

                if (medicalInformation.getIsSuccessful() != 0) {
                    if (medicalInformation.getIsSuccessful() != 5) {
                        currentMedicalMode.set(0);
                    }
                    medicalInformation.layoutServiceFacilitySuccessfulPane(medicalInformation.getIsSuccessful());
                    doPane = medicalInformation.getSuccessPane();
                }
                if (medicalInformation.getIsNotFound() == 1) {
                    currentMedicalMode.set(0);
                    medicalInformation.setIsNotFound(0);
                    medicalInformation.setWhichChoice(0);
                }
            }

            else if (currentMedicalMode.get() == 4) {
                medicalInformation.layoutInitialPane();
                doPane = medicalInformation.getInitialPane();

                if (medicalInformation.getWhichChoice() != 0) {
                    medicalInformation.layoutFixedMedicalInstitutionPane(medicalInformation.getWhichChoice());
                    doPane = medicalInformation.getFixedMedicalInstitutionPane();
                }

                if (medicalInformation.getIsSuccessful() != 0) {
                    if (medicalInformation.getIsSuccessful() != 5) {
                        currentMedicalMode.set(0);
                    }
                    medicalInformation.layoutFixedMedicalInstitutionSuccessfulPane(medicalInformation.getIsSuccessful());
                    doPane = medicalInformation.getSuccessPane();
                }
                if (medicalInformation.getIsNotFound() == 1) {
                    currentMedicalMode.set(0);
                    medicalInformation.setIsNotFound(0);
                    medicalInformation.setWhichChoice(0);
                }
            }
            else if (currentMedicalMode.get() == 5) {
                medicalInformation.layoutInitialPane();
                doPane = medicalInformation.getInitialPane();

                if (medicalInformation.getWhichChoice() != 0) {
                    medicalInformation.layoutMedicalTreatmentCalculationParameterPane(medicalInformation.getWhichChoice());
                    doPane = medicalInformation.getMedicalTreatmentCalculationParameterPane();
                }

                if (medicalInformation.getIsSuccessful() != 0) {
                    if (medicalInformation.getIsSuccessful() != 5) {
                        currentMedicalMode.set(0);
                    }
                    medicalInformation.layoutMedicalTreatmentCalculationParameterSuccessfulPane(medicalInformation.getIsSuccessful());
                    doPane = medicalInformation.getSuccessPane();
                }

                if (medicalInformation.getIsNotFound() == 1) {
                    currentMedicalMode.set(0);
                    medicalInformation.setIsNotFound(0);
                    medicalInformation.setWhichChoice(0);
                }
            }



        }



        if (currentPublicServiceTackleMode.get() != 0) {
            if (currentPublicServiceTackleMode.get() == 1) {
                publicServiceTackle.layoutInitialPane();
                doPane = publicServiceTackle.getInitialPane();

                if (publicServiceTackle.getWhichChoice() != 0) {
                    publicServiceTackle.layoutPublicServiceTacklePane(publicServiceTackle.getWhichChoice());
                    doPane = publicServiceTackle.getPublicServiceTacklePane();
                }

                if (publicServiceTackle.getIsSuccessful() != 0) {
                    if (publicServiceTackle.getIsSuccessful() != 5) {
                        currentPublicServiceTackleMode.set(0);
                    }
                    publicServiceTackle.layoutPublicServiceTackleSuccessfulPane(publicServiceTackle.getIsSuccessful());
                    doPane = publicServiceTackle.getSuccessPane();
                }

                if (publicServiceTackle.getIsNotFound() == 1) {
                    currentPublicServiceTackleMode.set(0);
                    publicServiceTackle.setIsNotFound(0);
                    publicServiceTackle.setWhichChoice(0);
                }
            }
        }





        if (currentMedicalInsuranceCenterReimbursementMode.get() != 0) {
            if (currentMedicalInsuranceCenterReimbursementMode.get() == 1) {
                medicalInsuranceCenterReimbursement.layoutinitialPane();
                doPane = medicalInsuranceCenterReimbursement.getInitialPane();

                if (medicalInsuranceCenterReimbursement.getShowPersonInfoPaneId() == 1) {
                    medicalInsuranceCenterReimbursement.layoutshowPersonInfoPane();
                    doPane = medicalInsuranceCenterReimbursement.getShowPersonInfoPane();
                }

                if (medicalInsuranceCenterReimbursement.getEnterVisitInfoPaneId() == 1) {
                    medicalInsuranceCenterReimbursement.layoutenterVisitInfoPane();
                    doPane = medicalInsuranceCenterReimbursement.getEnterVisitInfoPane();
                }

                if (medicalInsuranceCenterReimbursement.getEnterMedicineDetailPaneId() == 1) {
                    medicalInsuranceCenterReimbursement.layoutenterMedicineDetailPane();
                    doPane = medicalInsuranceCenterReimbursement.getEnterMedicineDetailPane();
                }

                if (medicalInsuranceCenterReimbursement.getEnterTreatmentDetailPaneId() == 1) {
                    medicalInsuranceCenterReimbursement.layoutenterTreatmentDetailPane();
                    doPane = medicalInsuranceCenterReimbursement.getEnterTreatmentDetailPane();
                }

                if (medicalInsuranceCenterReimbursement.getEnterServiceFacilityDetailPaneId() == 1) {
                    medicalInsuranceCenterReimbursement.layoutenterServiceFacilityDetailPane();
                    doPane = medicalInsuranceCenterReimbursement.getEnterServiceFacilityDetailPane();
                }

                if (medicalInsuranceCenterReimbursement.getChoosePaneId() == 1) {
                    medicalInsuranceCenterReimbursement.layoutchoosePane();
                    doPane = medicalInsuranceCenterReimbursement.getChoosePane();
                }

                if (medicalInsuranceCenterReimbursement.getNotApprovedPaneId() != 0) {
                    medicalInsuranceCenterReimbursement.layoutnotApprovedPane(medicalInsuranceCenterReimbursement.getNotApprovedPaneId());
                    doPane = medicalInsuranceCenterReimbursement.getNotApprovedPane();
                }

                if (medicalInsuranceCenterReimbursement.getShowCalculationPaneId() == 1) {
                    medicalInsuranceCenterReimbursement.layoutshowCalculationPane();
                    doPane = medicalInsuranceCenterReimbursement.getShowCalculationPane();
                }

                if (publicServiceTackle.getIsNotFound() == 1) {
                    currentMedicalInsuranceCenterReimbursementMode.set(0);
                    publicServiceTackle.setIsNotFound(0);
                }
            }
        }






        if (currentMedicalTreatmentMode.get() != 0) {
            if (currentMedicalTreatmentMode.get() == 1) {
                medicalTreatmentApproval.layoutSerchIdPane(currentMedicalTreatmentMode.get());
                doPane = medicalTreatmentApproval.getSerchIdPane();

                if (medicalTreatmentApproval.getPersonApprovalHasPaneId() == 1) {
                    medicalTreatmentApproval.layoutpersonApprovalHasPane();
                    doPane = medicalTreatmentApproval.getPersonApprovalHasPane();
                }

                if (medicalTreatmentApproval.getPersonApprovalNotPaneId() == 1) {
                    medicalTreatmentApproval.layoutpersonApprovalNotPane();
                    doPane = medicalTreatmentApproval.getPersonApprovalNotPane();
                }

                if (medicalTreatmentApproval.getPersonApprovalAddPaneId() == 1) {
                    medicalTreatmentApproval.layoutpersonApprovalAddPane();
                    doPane = medicalTreatmentApproval.getPersonApprovalAddPane();
                }

                if (medicalTreatmentApproval.getPersonApprovalDeletePaneId() == 1) {
                    medicalTreatmentApproval.layoutpersonApprovalDeletePane();
                    doPane = medicalTreatmentApproval.getPersonApprovalDeletePane();
                }

                if (medicalTreatmentApproval.getPersonApprovalChangePaneId() == 1) {
                    medicalTreatmentApproval.layoutpersonApprovalChangePane();
                    doPane = medicalTreatmentApproval.getPersonApprovalChangePane();
                }


                if (medicalTreatmentApproval.getChooseAPaneId() == 1) {
                    medicalTreatmentApproval.layoutPersonApprovalChoosePane();
                    doPane = medicalTreatmentApproval.getChooseAPane();
                }

                if (medicalTreatmentApproval.getChooseSPaneId() == 1) {
                    medicalTreatmentApproval.layoutSpecialSpectionChoosePane();
                    doPane = medicalTreatmentApproval.getChooseSPane();
                }

                if (medicalTreatmentApproval.getShowPersonApprovalId() == 1) {
                    medicalTreatmentApproval.layoutShowPersonApprovalPane();
                    doPane = medicalTreatmentApproval.getShowPersonApprovalPane();
                }

                if (medicalTreatmentApproval.getSuccessId() != 0) {
                    if (medicalTreatmentApproval.getSuccessId() != 5){
                        currentMedicalTreatmentMode.set(0);
                    }

                    medicalTreatmentApproval.layoutSuccessfulPane(medicalTreatmentApproval.getSuccessId());
                    doPane = medicalTreatmentApproval.getSuccessPane();
                }

                if (medicalTreatmentApproval.getIsNotFound() == 1) {
                    currentMedicalTreatmentMode.set(0);
                    medicalTreatmentApproval.setIsNotFound(0);
                }


            }
            else if (currentMedicalTreatmentMode.get() == 2) {
                medicalTreatmentApproval.layoutSerchIdPane(currentMedicalTreatmentMode.get());
                doPane = medicalTreatmentApproval.getSerchIdPane();

                if (medicalTreatmentApproval.getSpecialSpectionHasPaneId() == 1) {
                    medicalTreatmentApproval.layoutspecialSpectionHasPane();
                    doPane = medicalTreatmentApproval.getSpecialSpectionHasPane();
                }

                if (medicalTreatmentApproval.getSpecialSpectionNotPaneId() == 1) {
                    medicalTreatmentApproval.layoutspecialSpectionNotPane();
                    doPane = medicalTreatmentApproval.getSpecialSpectionNotPane();
                }

                if (medicalTreatmentApproval.getSpecialSpectionAddPaneId() == 1) {
                    medicalTreatmentApproval.layoutspecialSpectionAddPane();
                    doPane = medicalTreatmentApproval.getSpecialSpectionAddPane();
                }

                if (medicalTreatmentApproval.getSpecialSpectionDeletePaneId() == 1) {
                    medicalTreatmentApproval.layoutspecialSpectionDeletePane();
                    doPane = medicalTreatmentApproval.getSpecialSpectionDeletePane();
                }

                if (medicalTreatmentApproval.getSpecialSpectionChangePaneId() == 1) {
                    medicalTreatmentApproval.layoutspecialSpectionChangePane();
                    doPane = medicalTreatmentApproval.getSpecialSpectionChangePane();
                }

                if (medicalTreatmentApproval.getChooseAPaneId() == 1) {
                    medicalTreatmentApproval.layoutPersonApprovalChoosePane();
                    doPane = medicalTreatmentApproval.getChooseAPane();
                }

                if (medicalTreatmentApproval.getChooseSPaneId() == 1) {
                    medicalTreatmentApproval.layoutSpecialSpectionChoosePane();
                    doPane = medicalTreatmentApproval.getChooseSPane();
                }

                if (medicalTreatmentApproval.getSuccessId() != 0) {
                    if (medicalTreatmentApproval.getSuccessId() != 6){
                        currentMedicalTreatmentMode.set(0);
                    }

                    medicalTreatmentApproval.layoutSuccessfulPane(medicalTreatmentApproval.getSuccessId());
                    doPane = medicalTreatmentApproval.getSuccessPane();
                }

                if (medicalTreatmentApproval.getShowSpecialApprovalId() == 1) {
                    medicalTreatmentApproval.layoutShowSpecialApprovalPane();
                    doPane = medicalTreatmentApproval.getShowSpecialApprovalPane();
                }

                if (medicalTreatmentApproval.getIsNotFound() == 1) {
                    currentMedicalTreatmentMode.set(0);
                    medicalTreatmentApproval.setIsNotFound(0);
                }
            }
        }











        if (currentIntegratedQueryMode.get() != 0) {
            if (currentIntegratedQueryMode.get() == 1) {
                integratedQuery.layoutInitialPane();
                doPane = integratedQuery.getInitialPane();

                if (integratedQuery.getIsPane1() == 1) {
                    integratedQuery.layoutPane1();
                    doPane = integratedQuery.getPane1();
                }

                if (integratedQuery.getIsPane2() == 1) {
                    integratedQuery.layoutPane2();
                    doPane = integratedQuery.getPane2();
                }

                if (integratedQuery.getIsPane3() == 1) {
                    currentIntegratedQueryMode.set(0);
                    integratedQuery.layoutPane3();
                    doPane = integratedQuery.getPane3();
                }

                if (integratedQuery.getIsNotFound() == 1) {
                    currentIntegratedQueryMode.set(0);
                    integratedQuery.setIsNotFound(0);
                }
            }
        }
    }

    public void listenMedicalInformation() {
        (medicalInformation.isChangedProperty()).addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });
    }

    public void listenPublicServiceTackle() {
        (publicServiceTackle.isChangedProperty()).addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });
    }

    public void listenMedicalInsuranceCenterReimbursement() {
        (medicalInsuranceCenterReimbursement.isChangedProperty()).addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });
    }

    public void listenMedicalTreatmentApproval() {
        (medicalTreatmentApproval.isChangedProperty()).addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });
    }

    public void listenIntegratedQuery() {
        (integratedQuery.isChangedProperty()).addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });
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
        medicalInformation = new MedicalInformation(widthProperty, heightProperty);
        publicServiceTackle = new PublicServiceTackle(widthProperty, heightProperty);
        medicalInsuranceCenterReimbursement = new MedicalInsuranceCenterReimbursement(widthProperty, heightProperty);
        medicalTreatmentApproval = new MedicalTreatmentApproval(widthProperty, heightProperty);
        integratedQuery = new IntegratedQuery(widthProperty, heightProperty);

        currentMode.set(0);
        currentMedicalMode.set(0);
        currentPublicServiceTackleMode.set(0);
        currentMedicalInsuranceCenterReimbursementMode.set(0);
        currentMedicalTreatmentMode.set(0);
        currentIntegratedQueryMode.set(0);
        layoutTopPane();
        layoutNavigationPane();
        layoutSidebarPane();
        layoutDoPane();
        layoutMainPane();

        currentMode.addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                if (currentMode.get() != 1) {
                    currentMedicalMode.set(0);
                }

                if (currentMode.get() != 2) {
                    currentPublicServiceTackleMode.set(0);
                }

                if (currentMode.get() != 3) {
                    currentMedicalInsuranceCenterReimbursementMode.set(0);
                }

                if (currentMode.get() != 4) {
                    currentMedicalTreatmentMode.set(0);
                }

                if (currentMode.get() != 5) {
                    currentIntegratedQueryMode.set(0);
                }
                layoutSidebarPane();
                layoutDoPane();
                layoutMainPane();
            }
        });

        currentMedicalMode.addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });

        currentPublicServiceTackleMode.addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });

        currentMedicalInsuranceCenterReimbursementMode.addListener(new InvalidationListener() {
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

        currentIntegratedQueryMode.addListener(new InvalidationListener() {
            @Override
            public void invalidated(javafx.beans.Observable observable) {
                layoutDoPane();
                layoutMainPane();
            }
        });

        listenMedicalInformation();

        listenPublicServiceTackle();

        listenMedicalInsuranceCenterReimbursement();

        listenMedicalTreatmentApproval();

        listenIntegratedQuery();

        Scene scene = new Scene(pane, 900, 600);
        primaryStage.setScene(scene);
        scene.getStylesheets().addAll(getClass().getResource("../css/Main.css").toExternalForm(),
                getClass().getResource("../css/MedicalInformation.css").toExternalForm());
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
