package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurArc implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private ArcIG arc;
    public EcouteurArc (MondeIG monde,ArcIG arc){
        this.monde = monde;
        this.arc = arc;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.monde.selectionArcs(this.arc);
    }
}