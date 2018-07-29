package sample;

import javafx.beans.property.BooleanProperty;
import javafx.scene.layout.Pane;

public class MedicalInsuranceCenterReimbursement {
    private Pane medicalInsuranceCenterReimbursement;
    private BooleanProperty isCHanged;

    public MedicalInsuranceCenterReimbursement() {
        medicalInsuranceCenterReimbursement = new Pane();
    }

    public Pane getMedicalInsuranceCenterReimbursement() {
        return medicalInsuranceCenterReimbursement;
    }

    public void setMedicalInsuranceCenterReimbursement(Pane medicalInsuranceCenterReimbursement) {
        this.medicalInsuranceCenterReimbursement = medicalInsuranceCenterReimbursement;
    }

    public boolean isIsCHanged() {
        return isCHanged.get();
    }

    public BooleanProperty isCHangedProperty() {
        return isCHanged;
    }

    public void setIsCHanged(boolean isCHanged) {
        this.isCHanged.set(isCHanged);
    }
}
