package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.HashMap;

public class EcouteurDragDrop implements EventHandler<DragEvent> {
    private MondeIG monde;

    public EcouteurDragDrop(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(DragEvent dragEvent) {
        System.out.println("Coordonnées souris : X= " + dragEvent.getX() + "   Y= " + dragEvent.getY());
        Dragboard board = dragEvent.getDragboard();
        System.out.println("Identifiant destination : " + board.getString());

        EtapeIG etp = null;
        HashMap<String, EtapeIG> hash = this.monde.getHash();
        for (HashMap.Entry<String, EtapeIG> entry : hash.entrySet())
        {
            if (board.getString() == entry.getKey()) {
                etp = entry.getValue();
            }
        }
        this.monde.positionEtapes((int)dragEvent.getX(),(int)dragEvent.getY(),etp);

        dragEvent.setDropCompleted(true);
    }
}
