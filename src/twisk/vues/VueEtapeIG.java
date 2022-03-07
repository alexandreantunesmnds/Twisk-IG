package twisk.vues;

import javafx.geometry.Pos;
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
        this.label.setStyle("-fx-text-fill: white");
        this.setSpacing(10);
        this.setAlignment(Pos.CENTER);
    }
}
