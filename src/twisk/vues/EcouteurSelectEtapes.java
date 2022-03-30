package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSelectEtapes implements EventHandler<MouseEvent> {
    private MondeIG monde;
    private EtapeIG etape;
    public EcouteurSelectEtapes(MondeIG monde,EtapeIG etape){
        this.monde = monde;
        this.etape = etape;
    }
    public void handle(MouseEvent mouseEvent){
        this.monde.selectionEtapes(this.etape);
    }
}
