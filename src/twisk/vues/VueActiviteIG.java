package twisk.vues;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG implements  Observateur{
    Label label;
    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        HBox box = new HBox(100);
        box.setPadding(new Insets(50, 5 , 5, 50));
        this.label = new Label();
        box.getChildren().addAll(this.label);
        label.relocate(100,100);
    }
    public void reagir(){}
}
