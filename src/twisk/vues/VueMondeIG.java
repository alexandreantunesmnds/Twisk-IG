package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur{
    public VueMondeIG(MondeIG monde){
        super();
        monde.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
        this.getChildren().clear();
    }
}
