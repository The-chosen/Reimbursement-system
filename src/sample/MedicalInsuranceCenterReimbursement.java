package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.Pane;

public class MedicalInsuranceCenterReimbursement {
    private BooleanProperty isChanged;
    private ReadOnlyDoubleProperty widthProperty;
    private ReadOnlyDoubleProperty heightProperty;

    private Pane initialPane;
    private Pane showPersonInfoPane;
    private Pane enterVisitInfoPane;
    private Pane enterPresciptionDetailPane;
    private Pane notApprovedPane;
    private Pane showCalculationPane;

    private int showPersonInfoPaneId;
    private int enterVisitInfoPaneId;
    private int enterPresciptionDetailPaneId;
    private int notApprovedPaneId;
    private int showCalculationPaneId;

    public MedicalInsuranceCenterReimbursement(ReadOnlyDoubleProperty widthProperty, ReadOnlyDoubleProperty heightProperty) {
        this.widthProperty = widthProperty;
        this.heightProperty = heightProperty;
        initialPane = new Pane();
        showPersonInfoPane = new Pane();
        enterVisitInfoPane = new Pane();
        enterPresciptionDetailPane = new Pane();
        notApprovedPane = new Pane();
        showCalculationPane = new Pane();

        showPersonInfoPaneId = 0;
        enterVisitInfoPaneId = 0;
        enterPresciptionDetailPaneId = 0;
        notApprovedPaneId = 0;
        showCalculationPaneId = 0;
    }

    public void layoutinitialPane() {

    }

    public void layoutshowPersonInfoPane() {
        showPersonInfoPaneId = 0;
    }

    public void layoutenterVisitInfoPane() {
        enterVisitInfoPaneId = 0;
    }

    public void layoutenterPresciptionDetailPane() {
        enterPresciptionDetailPaneId = 0;
    }

    public void layoutnotApprovedPane() {
        notApprovedPaneId = 0;
    }

    public void layoutshowCalculationPane() {
        showCalculationPaneId = 0;
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

    public Pane getEnterPresciptionDetailPane() {
        return enterPresciptionDetailPane;
    }

    public void setEnterPresciptionDetailPane(Pane enterPresciptionDetailPane) {
        this.enterPresciptionDetailPane = enterPresciptionDetailPane;
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

    public int getEnterPresciptionDetailPaneId() {
        return enterPresciptionDetailPaneId;
    }

    public void setEnterPresciptionDetailPaneId(int enterPresciptionDetailPaneId) {
        this.enterPresciptionDetailPaneId = enterPresciptionDetailPaneId;
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
}
