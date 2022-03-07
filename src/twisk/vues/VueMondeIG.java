package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur{
    private MondeIG monde;
    public VueMondeIG(MondeIG monde){
        super();
        this.monde = monde;
        for (EtapeIG etapes : this.monde){
            VueActiviteIG act = new VueActiviteIG(this.monde,etapes);
            act.relocate(etapes.getPosX(), etapes.getPosY());
            act.resize(etapes.getLarg(),etapes.getHaut());
            this.getChildren().add(act);
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
        }
    }
}
