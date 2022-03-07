package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public abstract class VueEtapeIG extends VBox implements Observateur {
    protected MondeIG monde;
    protected EtapeIG etape;
    protected Label label;
    public VueEtapeIG(MondeIG monde,EtapeIG etape){
        super();
        this.monde = monde;
        this.etape = etape;
        this.label = new Label(this.etape.getNom() + " :  4 temps");
        this.setStyle("-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
    }
}
