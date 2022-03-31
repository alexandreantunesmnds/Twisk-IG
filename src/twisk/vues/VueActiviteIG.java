package twisk.vues;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public class VueActiviteIG extends VueEtapeIG implements  Observateur{
    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        TailleComposants constante = TailleComposants.getInstance();
        HBox box = new HBox();
        box.setPrefSize(constante.getLargBox(), constante.getHautBox());
        if (etape.getSelected() == 1){
            this.setStyle("-fx-background-color: #619bdc;-fx-border-color: #ff0000; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
            box.setStyle("-fx-background-color: #c9c9c9;-fx-border-color: #ff0000; -fx-border-width: 2");
        }
        else{
            this.setStyle("-fx-background-color: #619bdc;-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
            box.setStyle("-fx-background-color: #c9c9c9;-fx-border-color: #3b69a6; -fx-border-width: 2");
        }
        this.setOnMouseClicked(new EcouteurSelectEtapes(monde,etape));
        this.setOnDragDetected(new EcouteurSources(box));
        this.getChildren().addAll(this.label,box);
    }
    public void reagir(){}
}
