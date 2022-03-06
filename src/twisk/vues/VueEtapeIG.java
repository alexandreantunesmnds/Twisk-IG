package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public abstract class VueEtapeIG extends VBox implements Observateur {
    EtapeIG etape;
    Label label;
    public VueEtapeIG(MondeIG monde,EtapeIG etape){
        this.label = new Label(etape.getNom());
        this.getChildren().add(label);

    }
}
