package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur{
    private MondeIG monde;
    public VueMondeIG(MondeIG monde){
        super();
        this.monde = monde;
        for (EtapeIG etapes : this.monde){
            VueActiviteIG act = new VueActiviteIG(this.monde,etapes);
            act.relocate(etapes.getPosX(), etapes.getPosY());
            this.getChildren().add(act);
            act.resize(etapes.getLarg(),etapes.getHaut());
        }
        monde.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
        this.getChildren().clear();
        for (EtapeIG etapes : this.monde){
            VueActiviteIG act = new VueActiviteIG(this.monde,etapes);
            act.relocate(etapes.getPosX(), etapes.getPosY());
            this.getChildren().add(act);
            for (PointDeControleIG point : etapes) {
                VuePointDeControleIG vuePoint = new VuePointDeControleIG(this.monde, point);
                this.getChildren().add(vuePoint);
            }
        }
    }
}
