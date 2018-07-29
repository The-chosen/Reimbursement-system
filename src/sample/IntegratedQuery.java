package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.scene.layout.Pane;

public class IntegratedQuery {
    private Pane integratedQueryPane;
    private BooleanProperty isChanged;

    public IntegratedQuery() {
        integratedQueryPane = new Pane();
    }
}
