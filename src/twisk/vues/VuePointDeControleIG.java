package twisk.vues;

import javafx.scene.shape.Circle;
import twisk.mondeIG.MondeIG;

public class VuePointDeControleIG extends Circle implements Observateur {
    public VuePointDeControleIG(MondeIG monde){
        super();
        monde.ajouterObservateur(this);
    }

    @Override
    public void reagir() {

    }
}
