package twisk.vues;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG implements  Observateur{
    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        HBox box = new HBox();
        this.getChildren().addAll(this.label,box);
    }
    public void reagir(){}
}
