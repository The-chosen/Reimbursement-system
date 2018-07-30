package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.scene.layout.Pane;

public class MedicalTreatmentApproval {
    private BooleanProperty isChanged;

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

        this.widthProperty = widthProperty;
        this.heightProperty = heightProperty;
    }

    public void layoutSerchIdPane(int num) {
//        特检特治
        if (num == 1) {

        }

//        不同医保医院
        if (num == 2) {

        }
    }

    public void layoutpersonApprovalHasPane () {
        personApprovalHasPaneId = 0;
    }

    public void layoutspecialSpectionHasPane() {
        specialSpectionHasPaneId = 0;
    }

    public void layoutpersonApprovalNotPane() {
        personApprovalNotPaneId = 0;
    }

    public void layoutspecialSpectionNotPane() {
        specialSpectionNotPaneId = 0;
    }

    public void layoutpersonApprovalAddPane() {
        personApprovalAddPaneId = 0;
    }

    public void layoutpersonApprovalDeletePane() {
        personApprovalDeletePaneId = 0;
    }

    public void layoutpersonApprovalChangePane() {
        personApprovalChangePaneId = 0;
    }

    public void layoutspecialSpectionAddPane() {
        specialSpectionAddPaneId = 0;
    }

    public void layoutspecialSpectionDeletePane() {
        specialSpectionDeletePaneId = 0;
    }

    public void layoutspecialSpectionChangePane() {
        specialSpectionChangePaneId = 0;
    }

    public void layoutSuccessfulPane(int num) {
        successId = 0;

//        增加成功
        if (num == 1) {

        }

//        删除成功
        if (num == 2) {

        }

//        修改成功
        if (num == 3) {

        }
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
}
