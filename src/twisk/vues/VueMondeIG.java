package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.vues.ecouteurs.EcouteurDragDrop;
import twisk.vues.ecouteurs.EcouteurDragOver;

public class VueMondeIG extends Pane implements Observateur{
    private MondeIG monde;
    public VueMondeIG(MondeIG monde){
        super();
        this.monde = monde;
        for (EtapeIG etapes : this.monde){
            VueEtapeIG act = new VueActiviteIG(this.monde,etapes);
            act.relocate(etapes.getPosX(), etapes.getPosY());
            this.getChildren().add(act);
        }
        this.setOnDragOver(new EcouteurDragOver());
        this.monde.ajouterObservateur(this);
        this.setOnDragDropped(new EcouteurDragDrop(this.monde));
    }

    @Override
    public void reagir() {
        this.getChildren().clear();
        for (ArcIG arc : this.monde.iteratorArc()) {
            this.getChildren().add(new VueArcIG(this.monde,arc));
        }
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
