package sample;

import javafx.beans.property.BooleanProperty;
import javafx.scene.layout.Pane;

public class MedicalTreatmentApproval {
    private Pane medicalTreatmentApprovalPane;
    private BooleanProperty isChanged;
    private Pane initialPane;

    public MedicalTreatmentApproval() {
        medicalTreatmentApprovalPane = new Pane();
        initialPane = new Pane();
    }
}
