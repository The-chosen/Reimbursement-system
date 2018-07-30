package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;

public class IntegratedQuery {
    private Pane initialPane;
    private Pane pane1;
    private Pane pane2;
    private Pane pane3;

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

    }

    public void layoutPane1() {
        isPane1 = 0;

    }

    public void layoutPane2() {
        isPane2 = 0;
    }

    public void layoutPane3() {
        isPane3 = 0;
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
