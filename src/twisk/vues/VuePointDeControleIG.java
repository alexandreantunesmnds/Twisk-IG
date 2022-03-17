package twisk.vues;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

public class VuePointDeControleIG extends Circle implements Observateur {
    public VuePointDeControleIG(MondeIG monde, PointDeControleIG point) {
        super(point.getTaille());
        this.relocate(point.getPosX(), point.getPosY());
        monde.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
    }
}
