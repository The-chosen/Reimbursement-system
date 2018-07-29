package sample;

import javafx.beans.property.BooleanProperty;
import javafx.scene.layout.Pane;

public class PublicServiceTackle {
    private Pane publicServiceTacklePane;
    private BooleanProperty isChanged;
    private Pane initialPane;

    public PublicServiceTackle() {
        publicServiceTacklePane = new Pane();
        initialPane = new Pane();
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
}
